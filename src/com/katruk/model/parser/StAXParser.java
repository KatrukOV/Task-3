package com.katruk.model.parser;

import com.katruk.controller.ControllerFile;
import com.katruk.controller.EncodingText;
import com.katruk.model.entity.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Logger;

public class StAXParser extends AbstractParser{

	/**
	 * constructor
	 * @param name	name of parser
	 */
	public StAXParser(String name) {
		this.name = name;
	}

	@Override
	public Devices parse(String fileName) {
        ObjectFactory objectFactory = new ObjectFactory();
        String tempContent = null;
        Devices devices = null;
        Device device = null;
        Device.Options options = null;

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = null;
        ControllerFile controllerFile = new ControllerFile();

        String xmlAsString = null;
			try {
				xmlAsString = controllerFile.readFile(fileName, EncodingText.Utf8);
			} catch (IOException e) {
				Logger.getLogger(e.getMessage());
			}

			try {
				StringReader stringReader = new StringReader(xmlAsString);
				reader = factory.createXMLStreamReader(stringReader);
			} catch (XMLStreamException e) {
				Logger.getLogger(e.getMessage());
			}

        try {
                while (reader.hasNext()) {

                    int event = reader.next();

                    switch (event) {
                        case XMLStreamConstants.START_ELEMENT:
                            if (DEVICES.equals(reader.getLocalName())) {
                                devices = objectFactory.createDevices();
                            } else if (DEVICE.equals(reader.getLocalName())) {
                                device = objectFactory.createDevice();
                                device.setId(Integer.valueOf(reader.getAttributeValue(0)));
                                devices.getDevice().add(device);
                            } else if (OPTIONS.equals(reader.getLocalName())) {
                                    options = objectFactory.createDeviceOptions();
                                    device.setOptions(options);
                            }
                            break;

                        case XMLStreamConstants.CHARACTERS:
                            tempContent = reader.getText().trim();
                            break;

                        case XMLStreamConstants.END_ELEMENT:
                            switch (reader.getLocalName()) {
                                case NAME:
                                    assert device != null;
                                    device.setName(tempContent);                                        break;
                                case PRICE:
                                    device.setPrice(Double.valueOf(tempContent));                       break;
                                case ORIGIN:
                                    device.setOrigin(tempContent);                                      break;
                                case COMPONENTS_GROUP:
                                    device.setComponentsGroup(ComponentsGroup.valueOf(tempContent));	break;
                                case PERIPHERALS:
                                    options.setPeripherals(Boolean.valueOf(tempContent));				break;
                                case ENERGY_CONSUMPTION:
                                    options.setEnergyConsumption(Integer.valueOf(tempContent));		    break;
                                case PRESENT_COOLER:
                                    options.setPresenceCooler(Boolean.valueOf(tempContent));			break;
                                case PORTS:
                                    options.setPorts(Port.valueOf(tempContent));
                                    device.setOptions(options);											break;
                                case CRITICAL:
                                    device.setCritical(Boolean.valueOf(tempContent));                   break;
                            }
                            break;
                    }
                }
        } catch (XMLStreamException e) {
			Logger.getLogger(e.getMessage());
        }
        return devices;
    }
}

