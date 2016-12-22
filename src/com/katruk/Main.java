package com.katruk;

import com.katruk.controller.ControllerParser;

import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;

public class Main {

  public static void main(String[] args)
      throws ParserConfigurationException, XMLStreamException, SAXException, IOException {
    ControllerParser controllerParser = new ControllerParser();
    controllerParser.makeParse();
  }
}
