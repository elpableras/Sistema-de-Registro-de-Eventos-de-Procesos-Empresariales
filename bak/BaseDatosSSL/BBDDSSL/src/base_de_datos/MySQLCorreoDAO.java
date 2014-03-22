package base_de_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLCorreoDAO implements CorreoDAO {

	public String getCuenta() throws SQLException {

		// Creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();
		String cuenta = "";
		try {
			Statement stat = conn.createStatement();

			PreparedStatement ps = conn.prepareStatement("SELECT AES_DECRYPT(usuario, '@pass') AS usuario, AES_DECRYPT(password, '@pass') AS password FROM correo;");

			ResultSet rs = ps.executeQuery();
			rs.next();
			cuenta = rs.getString("usuario") + " " + rs.getString("password");

			// cerramos rs
			rs.close();
			// cerramos el stat
			stat.close();
			// cerramos conexion
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SQLException("ERROR EN MySQLCorreoDAO getCuenta()\n"
					+ e.getMessage());
		}
		return cuenta;
	}

}
