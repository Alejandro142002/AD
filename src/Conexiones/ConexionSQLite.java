package Conexiones;


import java.sql.Connection;
import java.sql.DriverManager;

 
public class ConexionSQLite {
 
   public static void main ( String args[] ){
 
      Connection connection = null;
 
      try{
         connection = DriverManager.getConnection( "jdbc:sqlite:data.sqlite" );
         if ( connection != null ){
            System.out.println("Conexión OK!");
         }
      }
      catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.out.println("Error en la conexión");
      }
   }
 
}