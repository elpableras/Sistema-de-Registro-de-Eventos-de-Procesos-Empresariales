package base_de_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLRegistroDAO implements RegistroDAO {

	@Override
	public void insertarRegistro(RegistroServidor r) {

		// creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();

		try {

			PreparedStatement ps = conn
					.prepareStatement("insert into registro values (null, ?,?,?,?,?)");
			ps.setString(1, r.getCod());
			ps.setString(2, r.getNombre());
			ps.setString(3, r.getCorreo());
			ps.setInt(4, r.getEdad());
			ps.setString(5, r.getUrl());

			ps.executeUpdate();

			ps.close();

			// cerramos conexion
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR EN MySQLRegistroDAO insertarRegistro()\n"
					+ e.getMessage());
		}
	}

	@Override
	public void actualizarRegistro(RegistroServidor r) {

		// creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();

		try {

			PreparedStatement ps = conn
					.prepareStatement("update registro set codigo=?, email=?, edad=?, url=? where nombre = ?");

			ps.setString(1, r.getCod());
			ps.setString(2, r.getCorreo());
			ps.setInt(3, r.getEdad());
			ps.setString(4, r.getUrl());
			ps.setString(5, r.getNombre());

			ps.executeUpdate();
			// cerramos el stat
			ps.close();

			// cerramos conexion
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out
					.println("ERROR EN MySQLRegistroDAO actualizarRegistro()\n"
							+ e.getMessage());
		}

	}

	@Override
	public void mostrar() {

		// Creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();

		try {
			Statement stat = conn.createStatement();

			PreparedStatement ps = conn.prepareStatement(" " + "Select * "
					+ "from registro ");

			ResultSet rs = ps.executeQuery();

			// Para sacar por pantalla
			while (rs.next()) {
				System.out.println("-------- Consulta --------");
				System.out.println("Código: " + rs.getString("codigo"));
				System.out.println("Nombre: " + rs.getString("nombre"));
				System.out.println("Correo: " + rs.getString("email"));
				System.out.println("Edad: " + rs.getInt("edad"));
				System.out.println("URL Docuemnto: " + rs.getString("url"));
				System.out.println("\n");
			}

			// cerramos rs
			rs.close();
			// cerramos el stat
			stat.close();
			// cerramos conexion
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ERROR EN MySQLRegistroDAO mostrar()\n"
					+ e.getMessage());
		}
	}
}
