package base_de_datos;

import java.sql.*;

public class BBDD extends FactoriaDAO {
	
	private Connection conn = null;
	private CorreoDAO c = CorreoDAO();

	public String crearConexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			return("ERROR MySQLFactoriaDAO CONTROLADOR crearConexion()\n"
					+ e.getMessage());
		}

		//Verificar y usar SSL
		String url = "jdbc:mysql://localhost/proyecto"+ 
				"?verifyServerCertificate=true"+ 
				"&useSSL=true"+ 
				"&requireSSL=true";
		String username = "rootssl";
		String password = "proyecto";

		try {
			conn = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			return("ERROR MySQLFactoriaDAO LOGIN crearConexion()\n"
					+ e.getMessage());
		}
		return "Correcto";
	}
	
	public String setCorreo(){
		crearConexion();
		
		Correo correo = new Correo();
		correo.setUsuario("usuario");
		correo.setPass("pass");
		
		return c.insertarCorreo(correo, conn);
	}
	
	public String getCorreo(){
		crearConexion();
		
		return c.escogerCuenta(conn);
	}
	
	public String borrarCorreo(){
		crearConexion();
		
		Correo correo = new Correo();
		correo.setUsuario("usuario");
		correo.setPass("pass");
		return c.borrarCorreo(correo, conn);
	}
	
	public String mandarCorreo(){
		MandarCorreo mc = new MandarCorreo();
		return mc.correo("Test", "Prueba Test Correo", "pabloglezj@gmail.com", "71660136");
		
	}

	public CorreoDAO CorreoDAO() {
		return new MySQLCorreoDAO();
	}
}
