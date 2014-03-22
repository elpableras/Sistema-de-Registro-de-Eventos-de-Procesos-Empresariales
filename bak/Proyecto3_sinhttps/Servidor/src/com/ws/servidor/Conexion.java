package com.ws.servidor;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	/**
     * Establece y devuelve la conexi�n con la base de datos.
     * 
     * @return la conexi�n
     */	
	 public static Connection crearConexion(){
		 Connection conn = null;
		 try {
			Class.forName("com.mysql.jdbc.Driver");
			
			//String url = "jdbc:oracle:thin:@156.35.94.99:1521:DESA";
			//String username = "UO173780";
			//String password = "18212";
			conn = DriverManager.getConnection(
                   "jdbc:mysql://localhost/proyecto", "root",
                   "MYSQL");
			//conn = DriverManager.getConnection(url,username,password);
			 
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"No se encuentra el driver\n"+ex.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"No hay conexi�n\n"+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		return conn;
	 }
	 
	 /**
	  * Cierra la conexi�n que se le pasa.
	  * 
	  * @param conexion
	  */
	 
	 public static void desconectar(Connection conn){
			
			try {	
				conn.close();
				System.out.println("\nDesconectado de MYSQL\n\n");
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"ERROR Cerrardo la conexi�n\n"+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
		}

}
