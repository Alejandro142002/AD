package ejs;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Ej19 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		File archivo=new File("D:\\2ºDAM\\AD\\ej\\src\\alumnos.xml");
		SAXParserFactory saxPF=SAXParserFactory.newInstance();
		SAXParser saxParser= saxPF.newSAXParser();
		AlumnosHandler aHandler= new AlumnosHandler();
		saxParser.parse(archivo, aHandler);
		
		ArrayList<Alumno> alumnos=new ArrayList<Alumno>();
		alumnos= aHandler.getAlumno();

	}

}
