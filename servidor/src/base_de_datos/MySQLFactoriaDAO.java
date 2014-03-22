package base_de_datos;

import java.sql.*;

/**
 * Clase que crea la conexión con una base de datos MySQL. Implementa el patrón
 * DAO.
 */
public class MySQLFactoriaDAO extends FactoriaDAO {

	/**
	 * Método que registra el driver y crea la conexión con la base de datos
	 * según los valores obtenidos del fichero de configuración.
	 * 
	 * @return Objeto de tipo Connection
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	public static Connection crearConexion() throws SQLException {
		/**
		 * Objeto que gestiona la conexión con la base de datos
		 */
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new SQLException(
					"ERROR MySQLFactoriaDAO CONTROLADOR crearConexion()\n"
							+ e.getMessage());
		}

		// Verificar y usar SSL
		// CAMBIAR LA IP salon de actos  156.35.94.94
		String url = "jdbc:mysql://localhost/proyecto"
				+ "?verifyServerCertificate=true" + "&useSSL=true"
				+ "&requireSSL=true";
		String username = "rootssl";
		String password = "proyecto";

		try {
			conn = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			throw new SQLException(
					"ERROR MySQLFactoriaDAO LOGIN crearConexion()\n"
							+ e.getMessage());
		}
		return conn;
	}

	// POR CADA CLASE
	/**
	 * Crea un objeto de tipo RegistroAdminDAO, particularizado para una base de
	 * datos MySQL.
	 * 
	 * @return Objeto de tipo MySQLRegistroAdminDAO (que hereda de
	 *         RegistroAdminDAO).
	 */
	public RegistroAdminDAO RegistroAdminDAO() {
		return new MySQLRegistroAdminDAO();
	}

	/**
	 * Crea un objeto de tipo RegistroEspeDAO, particularizado para una base de
	 * datos MySQL.
	 * 
	 * @return Objeto de tipo MySQLRegistroEspeDAO (que hereda de
	 *         RegistroEspeDAO).
	 */
	public RegistroEspeDAO RegistroEspeDAO() {
		return new MySQLRegistroEspeDAO();
	}

	/**
	 * Crea un objeto de tipo ContratoDAO, particularizado para una base de
	 * datos MySQL.
	 * 
	 * @return Objeto de tipo MySQLContratoDAO (que hereda de ContratoDAO).
	 */
	public ContratoDAO ContratoDAO() {
		return new MySQLContratoDAO();
	}

	/**
	 * Crea un objeto de tipo NumRegistroDAO, particularizado para una base de
	 * datos MySQL.
	 * 
	 * @return Objeto de tipo MySQLNumRegistroDAO (que hereda de
	 *         NumRegistroDAO).
	 */
	public NumRegistroDAO NumRegistroDAO() {
		return new MySQLNumRegistroDAO();
	}

	/**
	 * Crea un objeto de tipo RolDAO, particularizado para una base de datos
	 * MySQL.
	 * 
	 * @return Objeto de tipo MySQLRolDAO (que hereda de RolDAO).
	 */
	public RolDAO RolDAO() {
		return new MySQLRolDAO();
	}

	/**
	 * Crea un objeto de tipo CorreoDAO, particularizado para una base de datos
	 * MySQL.
	 * 
	 * @return Objeto de tipo MySQLCorreoDAO (que hereda de CorreoDAO).
	 */
	public CorreoDAO CorreoDAO() {
		return new MySQLCorreoDAO();
	}
}
