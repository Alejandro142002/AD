package ejs;

import java.util.HashMap;

public class PruebaHasMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<String,String>diccionario=new  HashMap<String, String>();
		diccionario.put("hola", "saludo com�n en Espa�a");
		diccionario.put("adios", "despedida com�n en Espa�a");
		diccionario.put("programaci�n", "divertido entretenimiento com�n en Espa�a");
		
		for(String entrada:diccionario.keySet()) {
			System.out.println("Entrada: "+entrada+"." + " Definici�n: "+diccionario.get(entrada));
			
		}
		
	}

}
