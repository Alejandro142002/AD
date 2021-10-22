package ejs;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AlumnosHandler extends DefaultHandler {
	private ArrayList<Alumno>alumnos=new ArrayList<Alumno>();
	Alumno a;
	private StringBuilder buffer=new StringBuilder();
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		switch(qName) {

		case "alumno":
			a=new Alumno();
			break;
		case "nombre":

			break;
		case "edad":
			buffer.delete(0, buffer.length());
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		

		switch(qName) {

		case "alumno":
			alumnos.add(a);
			break;
		case "nombre":
			a.getNombre(buffer.toString());
			break;
		case "edad":
			a.getEdad(Integer.parseInt(buffer.toString()));
			break;
		}
	}
	

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
	}

	public ArrayList<Alumno> getAlumno() {
		// TODO Auto-generated method stub
		return null;
	}

}
