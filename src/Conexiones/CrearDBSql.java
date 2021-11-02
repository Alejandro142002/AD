package Conexiones;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearDBSql {
	

	public static void main(String[] args) {
		
		File borrar =new File("D:\\2�DAM\\AD\\biblioteca.db");
		System.out.println(borrar.delete());
		
		String bd="biblioteca.db";
		
		Connection miCon=Conexion2.conectar(bd);
		String Libro="CREATE TABLE LIBRO (C�digo INT NOT NULL, Titulo VARCHAR(32) NULL, Autor VARCHAR(40), Editorial VARCHAR(40),"
				+ " A�o INT, ISBN VARCHAR(40) NOT NULL UNIQUE, N�meroEjemplares INT, N�meroP�ginas INT, PRIMARY KEY (C�digo))";
		
		String Socio="CREATE TABLE SOCIO (C�digo INT NOT NULL, Nombre VARCHAR(32) NULL, Apellidos VARCHAR(40), FechaNacimiento DATE,"
				+ " Domicilio VARCHAR(40), Tel�fono VARCHAR(12), PRIMARY KEY (C�digo))";
		
		String Prestamo="CREATE TABLE PR�STAMO (C�digoLibro INT NOT NULL ,C�digoSocio INT NOT NULL ,"
				+ "F_Inicio_Prestamo DATETIME ,F_Fin_Prestamo DATETIME ,FOREIGN KEY (C�digoLibro) REFERENCES LIBRO(C�digo),FOREIGN KEY (C�digoSocio) REFERENCES SOCIO(C�digo),PRIMARY KEY (C�digoLibro,C�digoSocio))";
		
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
