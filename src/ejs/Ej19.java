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
		//Se le pasa la direccion del xml que se quiere leer
		File archivo=new File("D:\\2�DAM\\AD\\ej\\src\\alumnos.xml");
		//Se crea el SAX Factory
		SAXParserFactory saxPF=SAXParserFactory.newInstance();
		SAXParser saxParser= saxPF.newSAXParser();
		
		//Se crea el controlador para ir leyendo el xml nodo a nodo
		AlumnosHandler aHandler= new AlumnosHandler();
		saxParser.parse(archivo, aHandler);
		
		ArrayList<Alumno> alumnos= aHandler.getAlumnos();
		
		
		for(Alumno a:alumnos) {
			System.out.println(a.toString());
		}

	}

}
