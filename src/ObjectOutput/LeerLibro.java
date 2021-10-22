package ObjectOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerLibro {
	//En esta clase lo que voy hacer va a ser leer los libros que creado y he guardado en la clase Ej_Almacenar

	public static void main(String[] args) throws ClassNotFoundException ,IOException {
		FileInputStream fis;
		ObjectInputStream ois=null;
		
		try {
			//Muestro la ruta que quiero coger el fichero que quiero leer 
			File f =new File("D:\\2ºDAM\\AD\\ej\\src\\Libro.dat");
			fis=new FileInputStream(f);
			//Cojo el fichero que quiero leer con el ObjectInputStream
			ois= new ObjectInputStream(fis);
			Libro LibroNuevo=(Libro) ois.readObject();
			//Muestro el dato que quiero que salga por pantalla
			System.out.println(LibroNuevo.getaño());
			
			
			
			}
		catch (FileNotFoundException e) {
			
		
		} catch (IOException e) {
			//Controlo la excepción en caso de que salga error
			System.out.println("Estas usando una versión antigüa del fichero, por eso sale error");
			
		}
		
	}

}
