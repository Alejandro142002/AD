package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion1 {
	private static final String url="jdbc:mysql://localhost:3306/acceso";
	private static final String usuario="alejandro1";
	private static final String clave="alumno";

public static Connection conectar() {
		
		Connection conexion= null;
		
		try {
			conexion=DriverManager.getConnection(url, usuario, clave);
			System.out.println("Conexi�n OK");
			
		}catch(SQLException e) {
			System.out.println("Error en la conexi�n");
			
		}
		return conexion;
}
}
