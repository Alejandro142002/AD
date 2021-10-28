package Conexiones;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.Statement;

public class CrearTabla {

	public static void main(String[] args) {
		
		Connection miCon=Conexion1.conectar();//me conecto a la base de datos
		String consulta="CREATE TABLE CLIENTES (DNI CHAR(9) NOT NULL, APELLIDOS VARCHAR(32) NOT NULL, CP CHAR(5), PRIMARY KEY (DNI))";
		try {
			Statement s=miCon.createStatement();
			s.execute(consulta);
			
		}catch(SQLException e){
			System.out.println("Error"+e);
		}

	}

}
