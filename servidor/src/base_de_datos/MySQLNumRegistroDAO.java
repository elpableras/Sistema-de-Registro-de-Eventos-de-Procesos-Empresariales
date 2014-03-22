package base_de_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que implementa la interfaz de número de registro.
 */
public class MySQLNumRegistroDAO implements NumRegistroDAO {

	/**
	 * Método para almacenar el número de registro.
	 * 
	 * @param n
	 *            Entero con el número de registro a almacenar.
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	public void setRegistro(int n, String proce) throws SQLException {

		Connection conn = MySQLFactoriaDAO.crearConexion();

		PreparedStatement ps = conn
				.prepareStatement("REPLACE INTO numregistro VALUES (?,?)");

		ps.setInt(1, n);
		ps.setString(2, proce);

		ps.executeUpdate();

		ps.close();

		conn.close();
	}

	/**
	 * Método para obtener el número de registro.
	 * 
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @return Entero con el número del registro.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	public int getRegistros(String proce) throws SQLException {

		// Creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();
		int numR = -1;

		Statement stat = conn.createStatement();

		PreparedStatement ps = conn
				.prepareStatement("SELECT registro FROM numregistro WHERE proceso=?;");

		ps.setString(1, proce);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			numR = rs.getInt("registro");
		}

		rs.close();
		stat.close();
		conn.close();

		return numR;
	}
}
