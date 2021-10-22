package ejs;

import java.util.HashMap;

public class PruebaHasMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String,String>diccionario=new  HashMap<String, String>();
		diccionario.put("hola", "saludo común en España");
		diccionario.put("adios", "despedida común en España");
		diccionario.put("programación", "divertido entretenimiento común en España");
		
		for(String entrada:diccionario.keySet()) {
			System.out.println("Entrada: "+entrada+"." + " Definición: "+diccionario.get(entrada));
			
		}
		
	}

}
