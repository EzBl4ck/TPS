package es3;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class Main extends DefaultHandler {
	
	private static final String CONSEGNA_AUTO = "consegna_auto";
	private static final String MESE = "mese";
	private static final String MODELLO = "modello";
	private static final String NOME = "nome";
	private static final String NUMERO_AUTO = "num";
	private StringBuilder builder;
	private String meseCorrente;
	private List<Auto> listaAutoMeseCorrente;
	private Map<String, List<Auto>> map;
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (qName) {
			case CONSEGNA_AUTO -> map = new HashMap<>();
			case MESE -> {
				meseCorrente = attributes.getValue(0);
				listaAutoMeseCorrente = new LinkedList<>();
				
			}
			case MODELLO -> listaAutoMeseCorrente.add(new Auto());
			case NOME, NUMERO_AUTO -> builder = new StringBuilder();
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
			case NOME -> listaAutoMeseCorrente.getLast().setNome(builder.toString());
			case NUMERO_AUTO -> listaAutoMeseCorrente.getLast().setNumeroAuto(Integer.parseInt(builder.toString()));
			case MESE -> {
				map.put(meseCorrente, listaAutoMeseCorrente);
				meseCorrente = null;
				listaAutoMeseCorrente = null;
			}
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
	
	public Map<String, List<Auto>> getMap() {
		return map;
	}
	
	public static void main(String[] args) throws Exception {
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		Main handler = new Main();
		parser.parse(new File("src/es3/consegna_auto.xml"), handler);
		Map<String, List<Auto>> map = handler.getMap();
	}
}
