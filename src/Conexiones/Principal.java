package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {

	public static void main(String[] args) {
		
		try {
			Connection miConexion=Conexion.conectar();
			PreparedStatement stnt= miConexion.prepareStatement("select* from personas where nombre like 'juan'");
			ResultSet r=stnt.executeQuery();
			while(r.next()) {
				System.out.println("Nombre: "+r.getString("nombre"));
				System.out.println("Edad: "+r.getString("edad"));
			}
		}catch(SQLException e) {
			System.out.println("Excepción "+e);
		}
		

	

	
	}

}
