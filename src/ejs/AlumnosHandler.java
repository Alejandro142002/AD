package ejs;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AlumnosHandler extends DefaultHandler {
	private ArrayList<Alumno>alumnos=new ArrayList<Alumno>();
	private Alumno alumno;
	private StringBuilder buffer=new StringBuilder();
	
	public ArrayList<Alumno> getAlumnos(){
		return alumnos;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		
		buffer.append(ch,start,length);
	}
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		switch(qName) {

		
		case "alumno":
			alumno=new Alumno();
			alumnos.add(alumno);
			break;
		case "nombre": 
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

		
		case "nombre":
			alumno.setNombre(buffer.toString());
			break;
		case "edad":
			alumno.setEdad(Integer.parseInt(buffer.toString()));
			break;
		
		
		}
	}
	

	

	public ArrayList<Alumno> getAlumno() {
		// TODO Auto-generated method stub
		return null;
	}

}
