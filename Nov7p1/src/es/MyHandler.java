package es;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
	
	private static final String LIBRI = "libri";
	private static final String LIBRO = "libro";
	private static final String TITOLO = "titolo";
	private static final String AUTORE = "autore";
	private StringBuilder builder;
	private ArrayList<Libro> libroList;
	
	@Override
	public void startDocument() throws SAXException {
		System.out.println("Inizio documento");
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("Fine documento");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (qName) {
			case LIBRI -> libroList = new ArrayList<>();
			case LIBRO -> {
				Libro l = new Libro();
				l.setId(Integer.parseInt(attributes.getValue(0)));
				libroList.add(l);
			}
			case TITOLO, AUTORE -> { builder = new StringBuilder(); }
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch(qName) {
			case TITOLO -> { libroList.getLast().setTitolo(builder.toString()); }
			case AUTORE -> { libroList.getLast().setAutore(builder.toString()); }
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (builder == null) {
			builder = new StringBuilder();
		} else {
			builder.append(ch, start, length);
		}
	}
	
	public ArrayList<Libro> getLibri() {
		return libroList;
	}
}
