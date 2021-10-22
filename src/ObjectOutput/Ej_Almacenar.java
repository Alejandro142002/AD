package ObjectOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ej_Almacenar {

	public static void main(String[] args) {
		// Creo una revista y un libro 
		
		Libro l1=new Libro("123", "Carmelo y sus super poderes", 2021);
		Revista r1=new Revista("321", "MotoGp", 2002, 4);
		
		GrabarLibro(l1);
		GrabarRevista(r1);

	}
	
	public static void GrabarLibro(Libro l1) {
		//Aquí almaceno los libros que he creado
		FileOutputStream fos;
		FileInputStream fis;
		try {
			//Utilizo el FileOutputStream para guardarlos
			fos = new FileOutputStream("D:\\2ºDAM\\AD\\ej\\src\\Libro.dat");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(l1);
			//Muestro en la consola que se ha guardado para asegurarme
			fis = new FileInputStream("D:\\2ºDAM\\AD\\ej\\src\\Libro.dat");
			ObjectInputStream ois =new ObjectInputStream(fis);
			Libro LibroDefinitivo=(Libro) ois.readObject();
			
			System.out.println(LibroDefinitivo.toString());
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void GrabarRevista(Revista r1) {
		//Aquí almaceno las revistas que he creado
		FileInputStream fis;
		FileOutputStream fos;
		try {
			//Utilizo el FileOutputStream para guardarlos
			fos = new FileOutputStream("D:\\2ºDAM\\AD\\ej\\src\\Revista2.dat");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(r1);
			//Muestro en la consola que se ha guardado para asegurarme, pero no hace falta para que se graben
			fis = new FileInputStream("D:\\2ºDAM\\AD\\ej\\src\\Revista2.dat");
			ObjectInputStream ois =new ObjectInputStream(fis);
			Revista RevistaDevifinitiva=(Revista) ois.readObject();
			
			System.out.println(RevistaDevifinitiva.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	


}
