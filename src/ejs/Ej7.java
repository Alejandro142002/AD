package ejs;

	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Scanner;
public class Ej7 {

		public static void main(String[] args) {
			
			File almacen=new File("D:\\2ºDAM\\AD\\FILE\\src\\ola.txt");
			
			ArrayList<String> frases=new ArrayList<String>();
			System.out.println("Introduce frases para almacenar");
			LlenarArray(frases);
			GrabarFrases(almacen, frases);
			LeerFrases(almacen);

			}
		/* Con el método que viene a continuación lo que se hace es ir llenando el array de frases
		 con las frases que introduca el usuario.*/
		private static void  LlenarArray(ArrayList<String> frases){
			
			Scanner sc=new Scanner(System.in);
			String frase = "inicializado";
			frase=sc.nextLine();
			frases.add(frase);
			
			while(!frase.equals("fin")) {
				System.out.println("Escribe *fin* para finalizar");
				frase=sc.nextLine();
				
			
					if(frases.contains(frase)) {
						System.out.println("está repetida");
						frases.remove(frases.size()-1);
					}
					if(frase.contains("fin"))
							System.out.println("Se acabo el programa");
					else {
						frases.add(frase);
						
						System.out.println("Has grabado la frase: "+ frase);
					}	
			
			}
		}
		/* Para grabar las frases que introduce el usuario hago la clase file writer y voy recorriendo el array 
		 que he creado anteriormente y despues voy grabando las palabras una por una*/
		private static void GrabarFrases(File fichero,ArrayList<String>frases){
			
			try {
				FileWriter fw= new FileWriter(fichero);
				for(int x=0;x<frases.size();x++) {
					fw.write(frases.get(x));
					fw.write("\n");
					
				}
				fw.close();	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		/*Por último este método sirve para leer las frases que se han grabado dentro del array*/		
		private static void LeerFrases(File fichero) {
	
			try {
				FileReader fr=new FileReader(fichero);
				BufferedReader bf=new BufferedReader(fr);
				String aux;
				while((aux=bf.readLine())!=null)
					System.out.println(aux);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
