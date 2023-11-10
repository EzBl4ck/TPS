package es;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Main {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		
		SAXParser parser = saxParserFactory.newSAXParser();
		MyHandler handler = new MyHandler();
		
		parser.parse(new File("src/es/libri.xml"), handler);
		List<Libro> libriList = handler.getLibri();
		
		for(Libro l : libriList) {
			System.out.println(l);
		}
		
	}
}
