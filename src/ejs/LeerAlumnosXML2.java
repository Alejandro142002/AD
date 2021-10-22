package ejs;



import java.io.File;

import java.io.IOException;
import java.nio.channels.NonWritableChannelException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;


import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerAlumnosXML2 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//fabricante parser
		DocumentBuilderFactory factory=  DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		factory.setIgnoringComments(true);
	
		DocumentBuilder builder=factory.newDocumentBuilder();//parser
		
		File archivo =new File("D:\\2ºDAM\\AD\\ej\\src\\alumnos.xml");
		
		Document docXML= null;
		
		docXML=builder.parse(archivo);
		docXML.getDocumentElement().normalize();
		System.out.println("ya esta parseado");
		NodeList nombres= docXML.getElementsByTagName("nombre");
		NodeList edad= docXML.getElementsByTagName("edad");
		String nombre=nombres.item(0).getTextContent();
		System.out.println(nombre);
	}
}
	

