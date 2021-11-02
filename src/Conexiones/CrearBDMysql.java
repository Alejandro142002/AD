package Conexiones;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBDMysql {

	public static void main(String[] args) {
		
		String bd="biblioteca";
		
		Connection miCon=Conexion.conectar1();
		String consulta="CREATE DATABASE "+bd;
		try {
			Statement crearBD=miCon.createStatement();
			crearBD.execute(consulta);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
