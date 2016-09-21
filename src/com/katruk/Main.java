package com.katruk;

import com.katruk.controller.ControllerParser;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws ParserConfigurationException, XMLStreamException, SAXException, IOException {
		ControllerParser controllerParser = new ControllerParser();
		controllerParser.makeParse();
	}
}
