package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMetaData {
	public static void main(String[] args) throws SQLException {
	
	
	Connection miCon=Conexion1.conectar();
	java.sql.DatabaseMetaData dbmd = miCon.getMetaData();
	System.out.println(dbmd.getDatabaseProductName());
	System.out.println(dbmd.getDatabaseProductVersion());
	
	System.out.println(dbmd.getUserName());
	}

	
}
