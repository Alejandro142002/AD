package ejs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		
		System.out.println("Dime la ruta del directoio");
		String r=s.next();
		
		File d1=new File(r);
		try {
			FileReader fr=new FileReader(d1);
			int valor=fr.read();
			while(valor!=-1) {
				System.out.print((char)valor);
				valor=fr.read();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
