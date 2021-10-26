package ejs;

import java.io.File;
import java.util.Scanner;

public class Ej2 {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("Dime la ruta del directorio");
		String r=s.next();
		System.out.println(r);
		
		File d1=new File(r);
		if (d1.exists()) {
			File[] lista=d1.listFiles();
			for(int x=0;x<lista.length;x++) {
				System.out.println(lista[x].getName());
			}
			
		}else {
			System.out.println("La ruta que se ha introducido no es un directorio, intentalo de nuevo");
		}

	}

}
