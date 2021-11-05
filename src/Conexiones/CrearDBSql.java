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
		
		Date fecha=new Date(2000,05,18);
		Date fecha2=new Date(2002,12,31);
		
		Sextet<Integer, String, String, Date, String, String> auxSocio=new Sextet<Integer, String, String, Date, String, String>(02,"Carmelo","Buisac",fecha,"C/San Alberto","644532134");
		Sextet<Integer, String, String, Date, String, String> auxSocio1=new Sextet<Integer, String, String, Date, String, String> (005,"Alejandro","Vizcarra",fecha2,"Jaca","656456456");

		//Recorrer valores de los Socios introducido anteriormente
		ArrayList<Sextet>arraySocio =new ArrayList<Sextet>();
		arraySocio.add(auxSocio);
		arraySocio.add(auxSocio1);
		
		Date fechaI=new Date(2010,05,18);
		Date fechaF=new Date(2010,05,30);
		
		Date fechaI1=new Date(2006,06,18);
		Date fechaF1=new Date(2006,06,30);
		
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
			
				
			ResultSet rs= crearTablas.executeQuery("SELECT * FROM LIBRO");
			System.out.println(rs.getInt("Código"));
			System.out.println(rs.getString("Titulo"));
			
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
