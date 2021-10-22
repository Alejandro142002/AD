/*Escribe un programa Java que lea el contenido de un fichero de texto con el fin de indicar cuántas veces aparece cada
 *  uno de los caracteres del código ASCII en el fichero.
 *  Utiliza un HashMap para almacenar la información antes de visualizarla.
 */
 

package ejs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Ej10 {

	public static void main(String[] args) {
		//Creo un HashMap para guardar todos los datos
		HashMap<String, Integer> numeroChars=new HashMap<String,Integer>();
		
		//Le paso la ruta del archivo que quiero leer
		File archivo=new File("caracteres.txt");
		
		contarLetras(numeroChars,archivo);
		
		muestraLetras(numeroChars);
		
	}
	//Con el método siguiente lo que hago es que me muestre el resultado de las letras y el número de veces que están escritas.
	public static void muestraLetras(HashMap<String, Integer>numeroChars) {
		
		for(String entrada:numeroChars.keySet()) {
			System.out.println("El cáracter  "+entrada+ "  Esta "+numeroChars.get(entrada)+" veces");

		}
		
			}
	//En este método lo que consigo es contar el número de veces que esta cada carácter
	public static void contarLetras(HashMap<String, Integer> cogerNum, File archivo) {
		try {
			
			int valor=0;
			//Le paso el FileReader para que lea el archivo
			FileReader fr= new FileReader(archivo);	
			
			//Creo el el while para recorrer el archivo
			
			while((valor=fr.read())!=-1) {
				String entradaKey=String.valueOf((char)valor);
				//Con este if lo que hago es que si el valor es menor que 32 no lo lea ya que solo quiero contar letras
				if(valor>32) {
					
				//Con este if miro que no este el carácter repetido y si no lo esta hago que alamcene una nueva entrada
				if(!cogerNum.containsKey(entradaKey)) {
					
					cogerNum.put(entradaKey, 1);
					}
				//Si ya estuviera la letra con el else hago que le sume uno 
				else {
					cogerNum.put(entradaKey,cogerNum.get(entradaKey)+1);
				}
				
			}
		}
	
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
