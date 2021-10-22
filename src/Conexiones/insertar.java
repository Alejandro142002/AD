package Conexiones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;




public class insertar {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);

		System.out.println("Introduce el nombre de la persona que quieres introducir");
		String nombre=s.next();
		System.out.println("Introduce la edad de la persona que quieres introducir");
		String edad=s.next();
		
		
		try {
			Connection miConexion=Conexion.conectar();
			
			persona p =new persona(nombre,edad);
			PreparedStatement insertar=miConexion.prepareStatement("INSERT INTO `personas1`(`nombre`, `edad`) VALUES ('[value-1]','[value-2]')");
			insertar.setString(1, nombre);
			insertar.setString(2, edad);
			insertar.executeUpdate();
			
			p=new persona(nombre,edad);
			int i=1;
			insertar.setString(i++, p.getNombre());
			insertar.setString(i++,p.getEdad());
			insertar.executeUpdate();
		}catch(SQLException e) {
			System.out.println("Excecpión "+e);
		}

	}

}
