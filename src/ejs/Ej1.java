package ejs;

import java.io.File;

public class Ej1 {

	public static void main(String[] args) {
		
		File f1=new File("D:\\2ºDAM\\AD\\FILE\\src\\Ej1\\Carmelo.txt");
		File f2=new File("D:\\2ºDAM\\AD\\FILE\\src\\Ej1\\Carmelo1.txt");
		File d1=new File("D:\\2ºDAM\\AD\\FILE\\src\\Ej1\\Carmelo");
		File d2=new File("D:\\2ºDAM\\AD\\FILE\\src\\Ej1\\Carmelo");
		
		System.out.println("Este fichero existe? "+f1.exists()+" ¿es un fichero? "+f1.isFile());
		System.out.println("Este fichero existe? "+f2.exists()+" ¿es un fichero? "+f1.isFile());
		System.out.println("Este directorio existe? "+d1.exists()+" ¿es un directorio? "+f1.isDirectory());
		System.out.println("Este directorio existe? "+d2.exists()+" ¿es un directorio? "+f1.isDirectory());
		
	}

}
