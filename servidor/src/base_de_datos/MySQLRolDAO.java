package base_de_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que implementa la interfaz de rol.
 */
public class MySQLRolDAO implements RolDAO {

	/**
	 * Método para obtener el rol.
	 * 
	 * @param tipo
	 *            Cadena para diferenciar los roles de administrador con el del
	 *            resto de usuarios.
	 * @return Cadena con los roles y sus contraseñas.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	public String getRol(String tipo) throws SQLException {

		// Creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();
		String rol = "";

		try {
			Statement stat = conn.createStatement();

			PreparedStatement ps = conn
					.prepareStatement("SELECT AES_DECRYPT(usuario, '@pass') AS usuario, AES_DECRYPT(password, '@pass') AS password FROM roles WHERE tipo=?;");

			ps.setString(1, tipo);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				rol += rs.getString("usuario") + "," + rs.getString("password")
						+ " ";
			}
			// cerramos rs
			rs.close();
			// cerramos el stat
			stat.close();
			// cerramos conexion
			conn.close();

		} catch (SQLException e) {
			throw new SQLException("ERROR EN MySQLRolDAO getRol()\n"
					+ e.getMessage());
		}
		return rol;
	}

	/**
	 * Método para alamcenar un nuevo rol con su contraseña.
	 * 
	 * @param iden
	 *            Cadena con el identificador del rol.
	 * @param pass
	 *            Cadena con la constraseña del rol.
	 * @param tipo
	 *            Cadena con el tipo de rol.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	public void setRol(String iden, String pass, String tipo)
			throws SQLException {

		try {
			Connection conn = MySQLFactoriaDAO.crearConexion();

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO roles VALUES (null, AES_ENCRYPT(?,'@pass'), AES_ENCRYPT(?,'@pass'),?);");

			ps.setString(1, iden);
			ps.setString(2, pass);
			ps.setString(3, tipo);

			ps.executeUpdate();

			ps.close();

			conn.close();

		} catch (Exception e) {
			throw new SQLException("ERROR EN MySQLRolDAO setRol()"
					+ e.getMessage());
		}
	}

}
