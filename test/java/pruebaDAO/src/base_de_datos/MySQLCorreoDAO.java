package base_de_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLCorreoDAO implements CorreoDAO {

	@Override
	public String insertarCorreo(Correo c, Connection conn) {

		try {

			PreparedStatement ps = conn
					.prepareStatement("insert into correo values (?,?)");
			ps.setString(1, c.getUsuario());
			ps.setString(2, c.getPass());

			ps.executeUpdate();

			ps.close();

			// cerramos conexion
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return("ERROR EN MySQLCorreoDAO insertarCorreoDAO()\n"
					+ e.getMessage());
		}
		return "Correcto";
	}

	@Override
	public String borrarCorreo(Correo c, Connection conn) {

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
			return ("ERROR EN MySQLCorreoDAO borrarCorreo()\n"
					+ e.getMessage());
		}
		
		return "Correcto";
	}

	@Override
	public String escogerCuenta(Connection conn) {

		String usuario = "";
		try {
			Statement stat = conn.createStatement();

			PreparedStatement ps = conn.prepareStatement("Select usuario from correo where password='pass'");

			ResultSet rs = ps.executeQuery();
			
			rs.next();
			usuario = rs.getString("usuario");

			// cerramos rs
			rs.close();
			// cerramos el stat
			stat.close();
			// cerramos conexion
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return("ERROR EN MySQLCorreoDAO mostrar()\n"
					+ e.getMessage());
		}
		return usuario;
	}
}
