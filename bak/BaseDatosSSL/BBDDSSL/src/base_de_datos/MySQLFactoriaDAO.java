package base_de_datos;

import java.sql.*;

public class MySQLFactoriaDAO extends FactoriaDAO {

	public static Connection crearConexion() throws SQLException {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new SQLException("ERROR MySQLFactoriaDAO CONTROLADOR crearConexion()\n"
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
			throw new SQLException("ERROR MySQLFactoriaDAO LOGIN crearConexion()\n"
					+ e.getMessage());
		}
		return conn;
	}

	// POR CADA CLASE
	public RegistroAdminDAO RegistroAdminDAO() {
		return new MySQLRegistroAdminDAO();
	}
	
	public RegistroEspeDAO RegistroEspeDAO() {
		return new MySQLRegistroEspeDAO();
	}
	
	public ContratoDAO ContratoDAO() {
		return new MySQLContratoDAO();
	}
	
	public NumRegistroDAO NumRegistroDAO(){
		return new MySQLNumRegistroDAO();
	}
	
	public RolDAO RolDAO() {
		return new MySQLRolDAO();
	}

	public CorreoDAO CorreoDAO() {
		return new MySQLCorreoDAO();
	}
}
