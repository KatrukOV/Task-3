package com.katruk.model.parser;

import com.katruk.model.entity.ComponentsGroup;
import com.katruk.model.entity.Device;
import com.katruk.model.entity.Devices;
import com.katruk.model.entity.ObjectFactory;
import com.katruk.model.entity.Port;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SAXParser extends AbstractParser {

  /**
   * temp string for save value
   */
  private String temp;

  /**
   * devise
   */
  private Device device;

  /**
   * options
   */
  private Device.Options options;

  /**
   * flag true when in options
   */
  private boolean isOptions = false;

  /**
   * factory for entity
   */
  private ObjectFactory factory = new ObjectFactory();

  /**
   * all devices
   */
  private List<Device> deviceList = new ArrayList<>();

  /**
   * constructor
   *
   * @param name name of parser
   */
  public SAXParser(String name) {
    this.name = name;
  }

  @Override
  public Devices parse(String fileName) {
    try {
      XMLReader reader = XMLReaderFactory.createXMLReader();
      SaxHandler contentHandler = new SaxHandler();
      reader.setContentHandler(contentHandler);
      reader.parse(new InputSource(fileName));
    } catch (IOException | SAXException e) {
      Logger.getLogger(e.getMessage());
    }
    Devices devices = factory.createDevices();
    devices.setDevice(deviceList);
    return devices;
  }

  /**
   * inner class
   */
  class SaxHandler implements ContentHandler {

    @Override
    public void setDocumentLocator(Locator locator) {
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts)
        throws SAXException {
      temp = qName;
      if (DEVICE.equals(localName)) {
        device = factory.createDevice();
        device.setId(Integer.valueOf(atts.getValue(ID)));
      } else {
        if (OPTIONS.equals(localName)) {
          options = factory.createDeviceOptions();
          isOptions = true;
        }
      }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
      if (isOptions) {
        device.setOptions(options);
      }
      isOptions = false;
      temp = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
      switch (temp) {
        case NAME:
          device.setName(new String(ch, start, length));
          break;
        case PRICE:
          device.setPrice(Double.valueOf(new String(ch, start, length)));
          break;
        case ORIGIN:
          device.setOrigin(new String(ch, start, length));
          break;
        case COMPONENTS_GROUP:
          device.setComponentsGroup(ComponentsGroup.valueOf(new String(ch, start, length)));
          break;
        case PERIPHERALS:
          options.setPeripherals(Boolean.valueOf(new String(ch, start, length)));
          break;
        case ENERGY_CONSUMPTION:
          options.setEnergyConsumption(Integer.valueOf(new String(ch, start, length)));
          break;
        case PRESENT_COOLER:
          options.setPresenceCooler(Boolean.valueOf(new String(ch, start, length)));
          break;
        case PORTS:
          options.setPorts(Port.valueOf(new String(ch, start, length)));
          device.setOptions(options);
          break;
        case CRITICAL:
          device.setCritical(Boolean.valueOf(new String(ch, start, length)));
          deviceList.add(device);
          break;
      }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
    }
  }
}
