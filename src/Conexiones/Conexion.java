package Conexiones;

import java.sql.*;

public class Conexion {
	//private static final String url="jdbc:mysql://serverame:puerto/nomBaseDatos";
	
	private static String url="jdbc:mysql://localhost:3306/";
	private static final String usuario="root";
	private static final String clave="";
	
	public static Connection conectar1() throws SQLException {
		
		Connection conexion= null;
		
		try {
			conexion=DriverManager.getConnection(url,usuario,clave);
			System.out.println("Conexi�n OK");
			
			
		}catch(SQLException e) {
			System.out.println("Error en la conexi�n");
			
		}
		conexion.close();
		return conexion;
	}

	
	

}
