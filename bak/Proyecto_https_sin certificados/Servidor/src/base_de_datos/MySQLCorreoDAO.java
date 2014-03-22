package base_de_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLCorreoDAO implements CorreoDAO {

	@Override
	public void insertarCorreo(Correo c) {

		// creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();

		try {

			PreparedStatement ps = conn
					.prepareStatement("insert into correo values (null, ?,?)");
			ps.setString(1, c.getUsuario());
			ps.setString(2, c.getPass());

			ps.executeUpdate();

			ps.close();

			// cerramos conexion
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR EN MySQLCorreoDAO insertarCorreoDAO()\n"
					+ e.getMessage());
		}
	}

	@Override
	public void actualizarCorreo(Correo c) {

		// creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();

		try {

			PreparedStatement ps = conn
					.prepareStatement("update correo set usuario=?, password=?");

			ps.setString(1, c.getUsuario());
			ps.setString(2, c.getPass());

			ps.executeUpdate();
			// cerramos el stat
			ps.close();

			// cerramos conexion
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR EN MySQLCorreoDAO actualizarCorreo()\n"
					+ e.getMessage());
		}

	}

	@Override
	public void borrarCorreo(Correo c) {
		// TODO Auto-generated method stub
		Connection conn = MySQLFactoriaDAO.crearConexion();

		try {

			PreparedStatement ps = conn
					.prepareStatement("delete from correo where usuario=? and password=?");

			ps.setString(1, c.getUsuario());
			ps.setString(2, c.getPass());

			ps.executeUpdate();
			// cerramos el stat
			ps.close();

			// cerramos conexion
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR EN MySQLCorreoDAO borrarCorreo()\n"
					+ e.getMessage());
		}

	}

	@Override
	public String escogerCuenta() {

		// Creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();
		String cuenta = "";
		try {
			Statement stat = conn.createStatement();

			PreparedStatement ps = conn.prepareStatement(" " + "Select * "
					+ "from correo ");

			ResultSet rs = ps.executeQuery();
			rs.next();
			cuenta = rs.getString("usuario")+" "+rs.getString("password");

			// cerramos rs
			rs.close();
			// cerramos el stat
			stat.close();
			// cerramos conexion
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR EN MySQLCorreoDAO escogerCuenta()\n"
					+ e.getMessage());
		}
		return cuenta;
	}

}
