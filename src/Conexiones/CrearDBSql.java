package Conexiones;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
		
		String Prestamo="CREATE TABLE PRÉSTAMO (CódigoLibro INT NOT NULL ,CódigoSocio INT NOT NULL ,"
				+ "F_Inicio_Prestamo DATETIME ,F_Fin_Prestamo DATETIME ,FOREIGN KEY (CódigoLibro) REFERENCES LIBRO(Código),FOREIGN KEY (CódigoSocio) REFERENCES SOCIO(Código),PRIMARY KEY (CódigoLibro,CódigoSocio))";
		
		try {
			
			
			
			Statement crearBD=miCon.createStatement();
			Statement crearTablas=miCon.createStatement();
			crearTablas.execute(Libro);
			System.out.println(Libro);
			crearTablas.execute(Socio);
			System.out.println(Socio);
			crearTablas.execute(Prestamo);
			System.out.println(Prestamo);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

}
