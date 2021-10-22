package ejs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Ej11b {

	public static void main(String[] args) {

		copiaSeguriadad();
	}
	public static void copiaSeguriadad() {

		File directorio=new File("data");
		
		//Con el metodo SimpleDateFormat lo que hago es formatear la fecha ya que el símbolo de dos puntos no lo acepta como nombre del directori
		
		SimpleDateFormat formateo= new SimpleDateFormat("yyyy-MM-dd 'at' HH-mm-ss z");
		Date fecha =new Date(System.currentTimeMillis());
		
		File directorioCopia=new File("data\\dataBackup"+formateo.format(fecha));

		//Creo la carpeta si no esta creada.

		directorioCopia.mkdir(); 

		for(File archivo:directorio.listFiles()) {
			
			//Con el if que vemos a continuación sabemos si vamos a coger un archivo o otra cosa para meterlo en la carpeta backup
			
			if(archivo.isFile()) {

				String ruta=directorioCopia.getPath()+"\\"+archivo.getName();
				System.out.println(ruta);

				//Aqui metemos todo  en un FileInputStream para ir recogiendo los datos y saber cuanto espacio nos queda
				try {
					//Cojo el archivo que quiero introducir dentro de la carpeta nueva
					FileInputStream fis= new FileInputStream(archivo);
					
					//Le paso la ruta de donde lo quiero guardar
					FileOutputStream fos=new FileOutputStream(ruta);
					
					//Miro cuanto me va a ocupar y guardo el tamaño dentro del array
					byte[] array= fis.readAllBytes();

					//Lo escribo dentro de la carpeta de la copia de seguridad
					fos.write(array);	
					
					//Una vez escrito dentro de la carpeta cierro todo
					fos.close();
					fis.close();

				} 
				catch(FileNotFoundException e) {
					System.out.println("Error");
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}


