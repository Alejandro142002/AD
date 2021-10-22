package ObjectOutput;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class LeerRevista  implements Serializable {
	
	//En esta clase lo que voy hacer va a ser leer las revistas que creado y he guardado en la clase Ej_Almacenar
	
	public static void main(String[] args) throws ClassNotFoundException ,IOException {
		FileInputStream fis;
		ObjectInputStream ois=null;
		
		try {
			//Muestro la ruta que quiero coger el fichero que quiero leer 
			File f =new File("D:\\2ºDAM\\AD\\ej\\src\\Revista2.dat");
			fis=new FileInputStream(f);
			//Cojo el fichero que quiero leer con el ObjectInputStream
			ois= new ObjectInputStream(fis);
			Revista RevistaNueva=(Revista) ois.readObject();
			//Muestro el dato que quiero que salga por pantalla
			System.out.println(RevistaNueva.getaño());
			
			
			
			}
		catch (FileNotFoundException e) {
			
		
		} catch (IOException e) {
			//Controlo la excepción en caso de que salga error
			System.out.println("Estas usando una versión antigüa del fichero, por eso sale error");
			
		}
		
	}

	}


