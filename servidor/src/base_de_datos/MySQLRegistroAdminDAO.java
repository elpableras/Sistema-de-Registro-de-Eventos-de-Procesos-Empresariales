package base_de_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ws.servidor.dato.ListaAutorizadoS;
import com.ws.servidor.dato.ListaGeneradorS;
import com.ws.servidor.dato.ListaCampoS;
import com.ws.servidor.dato.ListaDocumentoS;
import com.ws.servidor.dato.ListaIndicadorS;
import com.ws.servidor.dato.RegistroAdminS;

/**
 * Clase que implementa la interfaz de registro del administrador.
 */
public class MySQLRegistroAdminDAO implements RegistroAdminDAO {

	/**
	 * Método que obtiene el procedimeinto.
	 * 
	 * @return Cadena con el procedimiento.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	public String getProcedimiento() throws SQLException {

		Connection conn = MySQLFactoriaDAO.crearConexion();
		String codProcedimientos = "";

		try {

			Statement stat = conn.createStatement();

			PreparedStatement ps = conn
					.prepareStatement("SELECT DISTINCT codProcedimiento FROM procedimiento;");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				codProcedimientos += rs.getString("codProcedimiento") + ",";
			}

			rs.close();

			stat.close();

			conn.close();

		} catch (SQLException e) {
			throw new SQLException(
					"ERROR EN MySQLRegistroAdminDAO getProcedimiento()\n"
							+ e.getMessage());
		}
		return codProcedimientos;
	}

	/**
	 * Método para almacenar el registro del administrador, que son los
	 * registros generales.
	 * 
	 * @param r
	 *            Objeto de tipo RegistroAdminS, que contiene los datos del
	 *            registro.
	 * @param d
	 *            Objeto de tipo ListaDocumentoS, que contiene los datos de la
	 *            lista de documentos.
	 * @param c
	 *            Objeto de tipo ListaCampoS, que contiene los datos de la lista
	 *            de información resumen.
	 * @param i
	 *            Objeto de tipo ListaIndicadorS, que contiene los datos de la
	 *            lista de indicadores.
	 * @param g
	 *            Objeto de tipo ListaGeneradorS, que contiene los datos de la
	 *            lista de generadores.
	 * @param a
	 *            Objeto de tipo ListaAutorizadoS, que contiene los datos de la
	 *            lista de autorizados.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	public void setRegistro(RegistroAdminS r, ListaDocumentoS d, ListaCampoS c,
			ListaIndicadorS i, ListaGeneradorS g, ListaAutorizadoS a)
			throws SQLException {

		// creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();

		try {
			PreparedStatement p = conn
					.prepareStatement("INSERT INTO procedimiento VALUES (?,?)");

			p.setString(1, r.getCodProce());
			p.setString(2, r.getCodGeneral());

			p.executeUpdate();

			p.close();

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO general VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,AES_ENCRYPT(?,'@pass'))");

			ps.setString(1, r.getNombre());
			ps.setString(2, r.getCodGeneral());
			ps.setString(3, r.getDescri());
			ps.setString(4, r.getTipo());
			ps.setString(5, r.getCodProce());
			ps.setString(6, r.getActi());

			ps.setString(7, r.getFrecu());
			ps.setString(8, r.getMeto());

			ps.setString(9, r.getArchivo());
			ps.setString(10, r.getRetencion());
			ps.setString(11, r.getConservacion());
			ps.setString(12, r.getDispo());
			ps.setString(13, r.getAlmacen());

			ps.setString(14, r.toString());

			ps.executeUpdate();

			ps.close();

			// INSERTAR DOCUMENTOS
			PreparedStatement ps2 = conn
					.prepareStatement("INSERT INTO ldocumento_gene VALUES (?,?,?,?)");

			ps2.setString(1, d.getCodigo());
			ps2.setString(2, d.getEnlace());
			ps2.setString(3, d.getTipoDescripcion());
			ps2.setString(4, " ");

			ps2.executeUpdate();

			ps2.close();

			// INSERTAR CAMPOS
			PreparedStatement ps3 = conn
					.prepareStatement("INSERT INTO lcampo VALUES (?,?,?,?,?,?,?)");

			ps3.setString(1, c.getCodRegistro());
			ps3.setString(2, c.getNombre());
			ps3.setString(3, c.getDescripcion());
			ps3.setString(4, c.getTipo());
			ps3.setString(5, c.getUnidad());
			ps3.setString(6, c.getEnlace());
			ps3.setString(7, " ");

			ps3.executeUpdate();

			ps3.close();

			// INSERTAR INDICADORES
			PreparedStatement ps4 = conn
					.prepareStatement("INSERT INTO lindicador VALUES (?,?,?)");

			ps4.setString(1, i.getCodRegistro());
			ps4.setString(2, i.getIndicador());
			ps4.setString(3, " ");

			ps4.executeUpdate();

			ps4.close();

			// INSERTAR GENERADORES
			PreparedStatement ps5 = conn
					.prepareStatement("INSERT INTO lgenerador_gene VALUES (?,?,?)");

			ps5.setString(1, g.getCodigo());
			ps5.setString(2, g.getGenerador());
			ps5.setString(3, " ");

			ps5.executeUpdate();

			ps5.close();

			// INSERTAR AUTORIZADOS
			PreparedStatement ps6 = conn
					.prepareStatement("INSERT INTO lautorizado_gene VALUES (?,?,?)");

			ps6.setString(1, a.getCodigo());
			ps6.setString(2, a.getAutorizado());
			ps6.setString(3, " ");

			ps6.executeUpdate();

			ps6.close();

			// cerramos conexion
			conn.close();
		} catch (SQLException e) {
			throw new SQLException(
					"ERROR EN MySQLRegistroAdminDAO setRegistro()\n"
							+ e.getMessage());
		}
	}

	/**
	 * Método para almacenar la actualización del registro del administrador,
	 * que son los registros generales.
	 * 
	 * @param r
	 *            Objeto de tipo RegistroAdminS, que contiene los datos del
	 *            registro.
	 * @param d
	 *            Objeto de tipo ListaDocumentoS, que contiene los datos de la
	 *            lista de documentos.
	 * @param c
	 *            Objeto de tipo ListaCampoS, que contiene los datos de la lista
	 *            de información resumen.
	 * @param i
	 *            Objeto de tipo ListaIndicadorS, que contiene los datos de la
	 *            lista de indicadores.
	 * @param g
	 *            Objeto de tipo ListaGeneradorS, que contiene los datos de la
	 *            lista de generadores.
	 * @param a
	 *            Objeto de tipo ListaAutorizadoS, que contiene los datos de la
	 *            lista de autorizados.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	public void setActualizar(RegistroAdminS r, ListaDocumentoS d,
			ListaCampoS c, ListaIndicadorS i, ListaGeneradorS g,
			ListaAutorizadoS a) throws SQLException {

		// creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();

		try {
			PreparedStatement p = conn
					.prepareStatement("REPLACE INTO procedimiento VALUES (?,?)");

			p.setString(1, r.getCodProce());
			p.setString(2, r.getCodGeneral());

			p.executeUpdate();

			p.close();

			PreparedStatement ps = conn
					.prepareStatement("REPLACE INTO general VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,AES_ENCRYPT(?,'@pass'))");

			ps.setString(1, r.getNombre());
			ps.setString(2, r.getCodGeneral());
			ps.setString(3, r.getDescri());
			ps.setString(4, r.getTipo());
			ps.setString(5, r.getCodProce());
			ps.setString(6, r.getActi());

			ps.setString(7, r.getFrecu());
			ps.setString(8, r.getMeto());

			ps.setString(9, r.getArchivo());
			ps.setString(10, r.getRetencion());
			ps.setString(11, r.getConservacion());
			ps.setString(12, r.getDispo());
			ps.setString(13, r.getAlmacen());

			ps.setString(14, r.toString());

			ps.executeUpdate();

			ps.close();

			// REMPLAZAR DOCUMENTOS
			PreparedStatement ps2 = conn
					.prepareStatement("REPLACE INTO ldocumento_gene VALUES (?,?,?,?)");

			ps2.setString(1, d.getCodigo());
			ps2.setString(2, d.getEnlace());
			ps2.setString(3, d.getTipoDescripcion());
			ps2.setString(4, " ");

			ps2.executeUpdate();

			ps2.close();

			// REMPLAZAR CAMPOS
			PreparedStatement ps3 = conn
					.prepareStatement("REPLACE INTO lcampo VALUES (?,?,?,?,?,?,?)");

			ps3.setString(1, c.getCodRegistro());
			ps3.setString(2, c.getNombre());
			ps3.setString(3, c.getDescripcion());
			ps3.setString(4, c.getTipo());
			ps3.setString(5, c.getUnidad());
			ps3.setString(6, c.getEnlace());
			ps3.setString(7, " ");

			ps3.executeUpdate();

			ps3.close();

			// REMPLAZAR INDICADORES
			PreparedStatement ps4 = conn
					.prepareStatement("REPLACE INTO lindicador VALUES (?,?,?)");

			ps4.setString(1, i.getCodRegistro());
			ps4.setString(2, i.getIndicador());
			ps4.setString(3, " ");

			ps4.executeUpdate();

			ps4.close();

			// REMPLAZAR GENERADORES
			PreparedStatement ps5 = conn
					.prepareStatement("REPLACE INTO lgenerador_gene VALUES (?,?,?)");

			ps5.setString(1, g.getCodigo());
			ps5.setString(2, g.getGenerador());
			ps5.setString(3, " ");

			ps5.executeUpdate();

			ps5.close();

			// REMPLAZAR AUTORIZADOS
			PreparedStatement ps6 = conn
					.prepareStatement("REPLACE INTO lautorizado_gene VALUES (?,?,?)");

			ps6.setString(1, a.getCodigo());
			ps6.setString(2, a.getAutorizado());
			ps6.setString(3, " ");

			ps6.executeUpdate();

			ps6.close();

			// cerramos conexion
			conn.close();
		} catch (SQLException e) {
			throw new SQLException(
					"ERROR EN MySQLRegistroAdminDAO setActualizar()\n"
							+ e.getMessage());
		}
	}

	/**
	 * Método para obtener el registro general.
	 * 
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @return Cadena con los registros generales.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	public String getRegistro(String proce) throws SQLException {

		// creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();

		RegistroAdminS r = new RegistroAdminS();

		String reg = "";

		try {

			Statement stat = conn.createStatement();

			PreparedStatement ps = conn
					.prepareStatement("SELECT g.nombre, g.codGeneral, g.descripcion, g.tipo, g.codProcedimiento, g.actividad, g.frecuencia, g.metodo, g.archivo, g.retencion, g.conservacion, g.disposicion, g.almacen, d.codGeneral, d.enlace, d.tipoDescripcion, c.codRegistro, c.nombre, c.descripcion, c.tipo, c.unidad, c.enlace, i.codRegistro, i.indicador, gr.codGeneral, gr.generador, a.codGeneral, a.autorizado FROM general g, ldocumento_gene d, lcampo c, lindicador i, lgenerador_gene gr, lautorizado_gene a WHERE g.codProcedimiento = ? and d.borrado = ' ' and c.borrado = ' ' and i.borrado = ' ' and gr.borrado = ' ' and a.borrado = ' ' and g.codGeneral = d.codGeneral and g.codGeneral = c.codRegistro and g.codGeneral = i.codRegistro and g.codGeneral = gr.codGeneral and g.codGeneral = a.codGeneral;");

			ps.setString(1, proce);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				r.setNombre(rs.getString("g.nombre"));
				r.setCodGeneral(rs.getString("g.codGeneral"));
				r.setDescri(rs.getString("g.descripcion"));
				r.setTipo(rs.getString("g.tipo"));
				r.setCodProce(rs.getString("g.codProcedimiento"));
				r.setActi(rs.getString("g.actividad"));
				r.setFrecu(rs.getString("g.frecuencia"));
				r.setMeto(rs.getString("g.metodo"));

				r.setArchivo(rs.getString("g.archivo"));
				r.setRetencion(rs.getString("g.retencion"));
				r.setConservacion(rs.getString("g.conservacion"));
				r.setDispo(rs.getString("g.disposicion"));
				r.setAlmacen(rs.getString("g.almacen"));

				reg += r.toString() + "·" + rs.getString("d.codGeneral") + "·"
						+ rs.getString("d.enlace") + "·"
						+ rs.getString("d.tipoDescripcion") + "·"
						+ rs.getString("c.codRegistro") + "·"
						+ rs.getString("c.nombre") + "·"
						+ rs.getString("c.descripcion") + "·"
						+ rs.getString("c.tipo") + "·"
						+ rs.getString("c.unidad") + "·"
						+ rs.getString("c.enlace") + "·"
						+ rs.getString("i.codRegistro") + "·"
						+ rs.getString("i.indicador") + "·"
						+ rs.getString("gr.codGeneral") + "·"
						+ rs.getString("gr.generador") + "·"
						+ rs.getString("a.codGeneral") + "·"
						+ rs.getString("a.autorizado") + "·";
			}

			// cerramos rs
			rs.close();
			// cerramos el stat
			stat.close();
			// cerramos conexion
			conn.close();

			return reg;

		} catch (SQLException e) {
			throw new SQLException(
					"ERROR EN MySQLRegistroAdminDAO getRegistro()\n"
							+ e.getMessage());
		}
	}

	/**
	 * Método para obtener las lista de códigos generales de los registros
	 * generales.
	 * 
	 * @param proce
	 *            Cadena con el procedimeinto.
	 * @return Cadena con la lsita de códigos.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	public String getListaRegistro(String proce) throws SQLException {

		// Creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();
		String codGeneral = "";

		try {

			Statement stat = conn.createStatement();

			PreparedStatement ps = conn
					.prepareStatement("SELECT codGeneral FROM general WHERE codProcedimiento=?;");

			ps.setString(1, proce);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				codGeneral += rs.getString("codGeneral") + "·";
			}

			// cerramos rs
			rs.close();
			// cerramos el stat
			stat.close();
			// cerramos conexion
			conn.close();

		} catch (SQLException e) {
			throw new SQLException(
					"ERROR EN MySQLRegistroAdminDAO getListaRegistro()\n"
							+ e.getMessage());
		}
		return codGeneral;
	}
}
