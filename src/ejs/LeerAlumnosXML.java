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

public class LeerAlumnosXML {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//fabricante parser
		DocumentBuilderFactory factory=  DocumentBuilderFactory.newInstance();
		factory.setIgnoringElementContentWhitespace(true);
		factory.setIgnoringComments(true);
	
		DocumentBuilder builder=factory.newDocumentBuilder();//parser
		
		File archivo =new File("D:\\2ºDAM\\AD\\ej\\src\\clientes.xml");
		
		Document docXML= null;
		
		docXML=builder.parse(archivo);
		docXML.getDocumentElement().normalize();
		System.out.println("ya esta parseado");
		//accedemos al primero nodo raiz
		Node nodoRaiz =docXML.getFirstChild();
		System.out.println(nodoRaiz.getNodeName());
		nodoRaiz=limpiarNodos(nodoRaiz);
		NodeList nodosHijos= nodoRaiz.getChildNodes();
		Node nodoHijos=null;
		NamedNodeMap atrHijo=null;
		
		for(int i=0;i<nodosHijos.getLength();i++) {
			nodoHijos=nodosHijos.item(i);
			nodoHijos=limpiarNodos(nodoHijos);
			//accedemos a los atributos del nodo
			atrHijo=nodoHijos.getAttributes();
			for(int k=0;k<atrHijo.getLength();k++) {
				System.out.println(atrHijo.item(k).getNodeName()+" :"+atrHijo.item(k).getNodeValue());
				
			}
			System.out.println(nodosHijos.item(i).getNodeName());
			NodeList nodosNietos=nodosHijos.item(i).getChildNodes();
				for(int j=0;j<nodosNietos.getLength();j++) {
					System.out.println("\t"+nodosNietos.item(j).getNodeName()
							+": "+nodosNietos.item(j).getTextContent());
						
						
					}
			}
				
		}
	static public Node limpiarNodos (Node nodeAux){
		if(nodeAux.hasChildNodes()) {
			NodeList listaHijos=nodeAux.getChildNodes();
			Node aux=null;
			for(int j=0;j<listaHijos.getLength();j++) {
				aux=listaHijos.item(j);
				if(aux.getNodeType()==3) {
					aux.setTextContent(aux.getTextContent().trim());
					if(aux.getTextContent().equals(""))
						aux.getParentNode().removeChild(aux);
				}
			}
		}
		return nodeAux;
		
	}
	
	}
	


