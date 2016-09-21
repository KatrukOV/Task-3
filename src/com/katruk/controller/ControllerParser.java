package com.katruk.controller;

import com.katruk.model.entity.Devices;
import com.katruk.model.Key;
import com.katruk.model.XMLValidator;
import com.katruk.model.parser.Parser;
import com.katruk.model.parser.ParserFactory;
import com.katruk.model.parser.ParserType;
import com.katruk.veiw.Renderer;

import java.nio.file.Paths;
import java.util.Iterator;

public class ControllerParser implements Path, Key {

	/**
	 * parse, show and save to file
	 */
	public void makeParse() {
		Renderer renderer = new Renderer();
		String fileSeparator = System.getProperty(SEPARATOR);
		java.nio.file.Path path = Paths.get(FILE_PATH + FILE_NAME_XML).toAbsolutePath();
		Iterator<java.nio.file.Path> iterator = path.iterator();
		String resultPath = path.getRoot().toString();
		while (iterator.hasNext()){
			resultPath += fileSeparator + iterator.next();
		}

		java.nio.file.Path pathXSD = Paths.get(FILE_PATH + FILE_NAME_XSD).toAbsolutePath();
		Iterator<java.nio.file.Path> iteratorXSD = pathXSD.iterator();
		String resultPathXSD = pathXSD.getRoot().toString();
		while (iteratorXSD.hasNext()) {
			resultPathXSD += fileSeparator + iteratorXSD.next();
		}

		boolean validation = new XMLValidator().valid(resultPath, resultPathXSD);

		Parser parser;
		if (validation) {
			for (ParserType type : ParserType.values()) {
				parser = ParserFactory.getInstance().create(type);
				renderer.showLn(parser.name());

				Devices devices = parser.parse(resultPath);
				renderer.showDevises(devices);

				String fileName = FILE_PATH + parser.name() + RESULT;
				parser.createXML(fileName, devices);
			}
		}
	}
}
