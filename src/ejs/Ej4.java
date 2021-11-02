package ejs;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ej4 {

    public static void main(String[] args) {
    	Scanner s=new Scanner(System.in);
		
		System.out.println("Escribe unas cuantas frases");
		File f1=new File("D:\\2ºDAM\\ola.txt");
		
		try {
			FileWriter fw=new FileWriter(f1);
			String frase=s.nextLine();
			
			while(!frase.equals("fin")) {
				fw.write(frase+"\n");
				frase =s.nextLine();
				
				
			}
			
			fw.close();
		}
		catch(IOException e) {
			
		}
		
		
		try {
			FileReader fr=new FileReader(f1);
			int valor=fr.read();
			while(valor!=-1) {
				System.out.print((char)valor);
				valor=fr.read();
				
			}
			fr.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
    	 
  