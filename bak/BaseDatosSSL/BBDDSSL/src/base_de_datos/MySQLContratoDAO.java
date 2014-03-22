package base_de_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLContratoDAO implements ContratoDAO {

	public void setContrato(int n, String proce) throws SQLException {

		// creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();

		try {

			PreparedStatement ps = conn
					.prepareStatement("REPLACE INTO codcontratacion VALUES (?,?)");
			
			ps.setInt(1, n);
			ps.setString(2, proce);
			
			
			ps.executeUpdate();

			ps.close();

			conn.close();

		} catch (SQLException e) {
			throw new SQLException("ERROR EN MySQLContratoDAO setContrato()\n"
					+ e.getMessage());
		}
	}
	
	public int getContrato(String proce) throws SQLException {

		// Creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();
		int contrato = -1;
		try {
			Statement stat = conn.createStatement();

			PreparedStatement ps = conn.prepareStatement("SELECT contrato FROM codcontratacion WHERE proceso=?;");
			
			ps.setString(1, proce);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
			contrato = rs.getInt("contrato");
			}
			// cerramos rs
			rs.close();
			// cerramos el stat
			stat.close();
			// cerramos conexion
			conn.close();

		} catch (SQLException e) {
			throw new SQLException("ERROR EN MySQLContratoDAO getContrato()\n"
					+ e.getMessage());
		}
		return contrato;
	}
}
