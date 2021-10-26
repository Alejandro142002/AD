package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class borrar {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		System.out.println("Introduce el nombre de la persona que quieres borrar");
		String nombre=s.next();
		
		try {
			Connection miConexion=Conexion1.conectar();
			PreparedStatement insertar=miConexion.prepareStatement("DELETE FROM `personas1` WHERE 'nombre'=(?)");
			borrar.setString(1,nombre);
			borrar.executeUpdate();
			
			
		}catch(SQLException e) {
			System.out.println("Excepcion "+e);

	}
	

	
		
	}

	static void executeUpdate() {
		// TODO Auto-generated method stub
		
	}

	static void setString(int i, String nombre) {
		// TODO Auto-generated method stub
		
	}

}
