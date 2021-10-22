package ejs;

import java.io.File;
import java.util.Scanner;

public class Ej2_2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		System.out.println("Dime la ruta del directoio");
		String r=s.next();
		System.out.println(r);

		File d1=new File(r);
		if (d1.exists()&&d1.isDirectory()) {
			String[] lista=d1.list();
			for(int x=0;x<lista.length;x++) {
			int pos=lista[x].lastIndexOf('.');
			String aux=lista[x].substring(pos+1);
			if (aux.contentEquals("java")) {
				System.out.println(lista[x]);
				
			}
			
			}
		}

	}

}


