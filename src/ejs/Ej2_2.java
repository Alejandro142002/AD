package ejs;

import java.io.File;
import java.util.Scanner;

public class Ej2_2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
//pido la dirección del directorio
		System.out.println("Dime la ruta del directoio");
		String r=s.next();
		System.out.println(r);

		File d1=new File(r);
		
		
		//pido la extension del archivo que quiero mostrar
		System.out.println("Dime la extension que quieras");
		String extension=s.next();
		if (d1.exists()&&d1.isDirectory()) {
			String[] lista=d1.list();
			for(int x=0;x<lista.length;x++) {
			int pos=lista[x].lastIndexOf('.');
			String aux=lista[x].substring(pos+1);
			
			if (aux.contentEquals(extension)) {
				System.out.println(lista[x]);
				
			}
			
			}
		}

	}

}


