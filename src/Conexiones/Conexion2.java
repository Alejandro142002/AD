package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion2 {

	
	
	private static String url="jdbc:sqlite:D:/2�DAM/AD/";
	//private static final String usuario="root";
	//private static final String clave="";
	
	public static Connection conectar(String bd) {
		
		Connection conexion= null;
		url=url+bd;
		
		try {
			conexion=DriverManager.getConnection(url);
			System.out.println("Conexi�n OK");
			
		}catch(SQLException e) {
			System.out.println("Error en la conexi�n"+e);
			
		}
		return conexion;
	}

	
	
	

}