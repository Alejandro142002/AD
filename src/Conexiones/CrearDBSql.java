package Conexiones;

import java.io.File;
import org.javatuples.Octet;
import org.javatuples.Quartet;
import org.javatuples.Sextet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

public class CrearDBSql {
	

	public static void main(String[] args) {
		
		File borrar =new File("D:\\2ºDAM\\AD\\biblioteca.db");
		System.out.println(borrar.delete());
		
		String bd="biblioteca.db";
		
		Connection miCon=Conexion2.conectar(bd);
		String Libro="CREATE TABLE LIBRO (Código INT NOT NULL, Titulo VARCHAR(32) NULL, Autor VARCHAR(40), Editorial VARCHAR(40),"
				+ " Año INT, ISBN VARCHAR(40) NOT NULL UNIQUE, NúmeroEjemplares INT, NúmeroPáginas INT, PRIMARY KEY (Código))";
		
		String Socio="CREATE TABLE SOCIO (Código INT NOT NULL, Nombre VARCHAR(32) NULL, Apellidos VARCHAR(40), FechaNacimiento DATE,"
				+ " Domicilio VARCHAR(40), Teléfono VARCHAR(12), PRIMARY KEY (Código))";
		
		String Prestamo="CREATE TABLE PRESTAMO (CódigoLibro INT NOT NULL ,CódigoSocio INT NOT NULL ,"
				+ "F_Inicio_Prestamo DATETIME ,F_Fin_Prestamo DATETIME ,FOREIGN KEY (CódigoLibro) REFERENCES LIBRO(Código),FOREIGN KEY (CódigoSocio) REFERENCES SOCIO(Código),PRIMARY KEY (CódigoLibro,CódigoSocio))";
		
		
		//Inserta libros
		Octet<Integer,String, String,String,Integer,String,Integer,Integer> auxLibro= new Octet <Integer,String, String,String,Integer,String,Integer,Integer> (02,"Hola","Carmelo","Anaya",2021,"1234R",3,41);
		Octet <Integer,String,String,String,Integer,String,Integer,Integer> auxLibro1= new Octet <Integer,String,String,String,Integer,String,Integer,Integer> (03,"Pin y Pon","Vizcarra","Anaya", 2005,"123456123B",100,121);
		//Recorrer valores de los libros
		ArrayList<Octet>arrayLibro =new ArrayList<Octet>();
		arrayLibro.add(auxLibro);
		arrayLibro.add(auxLibro1);
		
		//Inserta Socios
		
		Date fecha=new Date(958993891000L);
		Date fecha2=new Date(1041333091000L);
		
		Sextet<Integer, String, String, Date, String, String> auxSocio=new Sextet<Integer, String, String, Date, String, String>(02,"Carmelo","Buisac",fecha,"C/San Alberto","644532134");
		Sextet<Integer, String, String, Date, String, String> auxSocio1=new Sextet<Integer, String, String, Date, String, String> (005,"Alejandro","Vizcarra",fecha2,"Jaca","656456456");

		//Recorrer valores de los Socios introducido anteriormente
		ArrayList<Sextet>arraySocio =new ArrayList<Sextet>();
		arraySocio.add(auxSocio);
		arraySocio.add(auxSocio1);
		
		
		//Fechas para el quartet
		
		Date fechaI=new Date(1273576291000L);
		Date fechaF=new Date(1274526691000L);
		
		Date fechaI1=new Date(1955790691000L);
		Date fechaF1=new Date(1956481891000L);
		
		Quartet<Integer, Integer, Date, Date> auxPrestamo=new Quartet<Integer, Integer, Date, Date>(02, 02, fechaI, fechaF);

		Quartet<Integer,Integer, Date, Date> auxPrestamo1=new Quartet<Integer, Integer, Date, Date>(03, 005, fechaI1, fechaF1);

		ArrayList<Quartet>arrayPrestamo =new ArrayList<Quartet>();
		arrayPrestamo.add(auxPrestamo);
		arrayPrestamo.add(auxPrestamo1);
		
		
		try {
			
			Statement crearTablas=miCon.createStatement();
			crearTablas.execute(Libro);
			System.out.println(Libro);
			crearTablas.execute(Socio);
			System.out.println(Socio);
			crearTablas.execute(Prestamo);
			System.out.println(Prestamo);
			
			PreparedStatement  insertarLibro=miCon.prepareStatement("INSERT INTO LIBRO VALUES(?,?,?,?,?,?,?,?)");
			//Sacar el valor de apartado de los libros
			for(int w=0;w<arrayLibro.size();w++) {
				int i=1;
				int j=0;
					insertarLibro.setInt(i, (int) arrayLibro.get(w).getValue(j));
					insertarLibro.setString(++i, (String) arrayLibro.get(w).getValue(++j));
					insertarLibro.setString(++i, (String) arrayLibro.get(w).getValue(++j));
					insertarLibro.setString(++i, (String) arrayLibro.get(w).getValue(++j));
					insertarLibro.setInt(++i, (int) arrayLibro.get(w).getValue(++j));
					insertarLibro.setString(++i, (String) arrayLibro.get(w).getValue(++j));
					insertarLibro.setInt(++i,(int) arrayLibro.get(w).getValue(++j));
					insertarLibro.setInt(++i, (int) arrayLibro.get(w).getValue(++j));
					insertarLibro.executeUpdate();
			}
			
			
			PreparedStatement  insertarSocio=miCon.prepareStatement("INSERT INTO SOCIO VALUES(?,?,?,?,?,?)");
			//Sacar el valor de apartado de los socios
			for(int w=0;w<arraySocio.size();w++) {
				int i=1;
				int j=0;
				insertarSocio.setInt(i, (int) arraySocio.get(w).getValue(j));
				insertarSocio.setString(++i, (String) arraySocio.get(w).getValue(++j));
				insertarSocio.setString(++i, (String) arraySocio.get(w).getValue(++j));
				insertarSocio.setDate(++i, (Date) arraySocio.get(w).getValue(++j));
				insertarSocio.setString(++i, (String) arraySocio.get(w).getValue(++j));
				insertarSocio.setString(++i, (String) arraySocio.get(w).getValue(++j));
				insertarSocio.executeUpdate();
			}
			
			PreparedStatement  insertarPrestamo=miCon.prepareStatement("INSERT INTO PRESTAMO VALUES(?,?,?,?)");
			//Sacar el valor de apartado de los socios
			for(int w=0;w<arraySocio.size();w++) {
				int i=1;
				int j=0;
				insertarPrestamo.setInt(i, (int) arrayPrestamo.get(w).getValue(j));
				insertarPrestamo.setInt(++i, (int) arrayPrestamo.get(w).getValue(++j));
				insertarPrestamo.setDate(++i, (Date) arrayPrestamo.get(w).getValue(++j));
				insertarPrestamo.setDate(++i, (Date) arrayPrestamo.get(w).getValue(++j));
				
				insertarPrestamo.executeUpdate();
			}
			
		
			// Listado de libros prestados actualmente.
			
			
			ResultSet rsFecha=crearTablas.executeQuery("SELECT * FROM PRESTAMO");
					
			while (rsFecha.next()) {	
				Date x=rsFecha.getDate("F_Fin_Prestamo");
				Calendar hoyaux=Calendar.getInstance();
				Date hoy=new Date(hoyaux.getTimeInMillis());
				if(x.compareTo(hoy)>0) {
					System.out.println("Libro prestado: Codigo: "+rsFecha.getInt("CódigoLibro")+"  Titulo: ");
					ResultSet rsTituloLibro=crearTablas.executeQuery("SELECT Titulo FROM LIBRO where Código= "+rsFecha.getInt("CódigoLibro"));
					System.out.println(rsTituloLibro.getString("Titulo"));
					rsTituloLibro.close();
				}
			}
			System.out.println("================================================================");
			
			//Número de libros prestamos a un socio determinado.


			ResultSet rsPrestar=crearTablas.executeQuery("SELECT * FROM PRESTAMO WHERE  CódigoSocio=2");

			int cantidad=0;
			while(rsPrestar.next()) {
				cantidad++;
			}
			System.out.println("La cantidad de libros prestados a este socio es : "+cantidad);
			rsPrestar.close();

			System.out.println("================================================================");

			//Libros que han superado la fecha de fin de préstamo.
			ResultSet rsFinPrestado=crearTablas.executeQuery("SELECT * FROM PRESTAMO");

			while (rsFinPrestado.next()) {	
				Date x=rsFinPrestado.getDate("F_Fin_Prestamo");
				Calendar hoyaux=Calendar.getInstance();
				Date hoy=new Date(hoyaux.getTimeInMillis());
				if(x.compareTo(hoy)<0) {
					System.out.println("Libros superando la fecha de prestamo son: Codigo: "+rsFinPrestado.getInt("CódigoLibro")+"  Titulo: ");
					ResultSet rsTituloLibro1=crearTablas.executeQuery("SELECT Titulo FROM LIBRO where Código= "+rsFinPrestado.getInt("CódigoLibro"));
					System.out.println(rsTituloLibro1.getString("Titulo"));
					rsTituloLibro1.close();
				}
			}
			System.out.println("================================================================");


			//  Socios que tienen libros que han superado la fecha de fin de préstamo.

			ResultSet rsSociosFin=crearTablas.executeQuery("SELECT * FROM PRESTAMO");

			while (rsSociosFin.next()) {	
				Date x=rsSociosFin.getDate("F_Fin_Prestamo");
				Calendar hoyaux=Calendar.getInstance();
				Date hoy=new Date(hoyaux.getTimeInMillis());
				if(x.compareTo(hoy)<0) {
					System.out.println("Socios que han superado la fecha limite de prestamo: Codigo: "+rsSociosFin.getInt("CódigoSocio"));
				}

			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}


}
