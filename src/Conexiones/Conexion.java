package Conexiones;

import java.sql.*;

public class Conexion {
	//private static final String url="jdbc:mysql://serverame:puerto/nomBaseDatos";
	
	private static String url="jdbc:sqlite://localhost:3306/";
	private static final String usuario="root";
	private static final String clave="";
	
	public static Connection conectar1(String bd) {
		
		Connection conexion= null;
		url=url+bd;
		try {
			conexion=DriverManager.getConnection(url, usuario, clave);
			System.out.println("Conexión OK");
			
		}catch(SQLException e) {
			System.out.println("Error en la conexión");
			
		}
		return conexion;
	}

	
	
	

}
