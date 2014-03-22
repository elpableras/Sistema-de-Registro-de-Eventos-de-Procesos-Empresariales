package base_de_datos;

import java.sql.*;

public class MySQLFactoriaDAO extends FactoriaDAO {

	public static Connection crearConexion() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR MySQLFactoriaDAO crearConexion()\n"
					+ e.getMessage());
		}

		String url = "jdbc:mysql://localhost/proyecto";
		String username = "root";
		String password = "MYSQL";

		try {
			conn = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR MySQLFactoriaDAO crearConexion()\n"
					+ e.getMessage());
		}
		return conn;
	}

	// POR CADA CLASE
	public RegistroDAO getRegistroDAO() {
		return new MySQLRegistroDAO();
	}

	public CorreoDAO getCorreoDAO() {
		return new MySQLCorreoDAO();
	}

}
