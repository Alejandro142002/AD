package Conexiones;

import java.sql.*;

public class Conexion {
	//private static final String url="jdbc:mysql://serverame:puerto/nomBaseDatos";
	
	private static final String url="jdbc:mysql://localhost:3306/acceso";
	private static final String usuario="alejandro";
	private static final String clave="alumno";
	
	public static Connection conectar1() {
		
		Connection conexion= null;
		
		try {
			conexion=DriverManager.getConnection(url, usuario, clave);
			System.out.println("Conexión OK");
			
		}catch(SQLException e) {
			System.out.println("Error en la conexión");
			
		}
		return conexion;
	}
	
	

}
