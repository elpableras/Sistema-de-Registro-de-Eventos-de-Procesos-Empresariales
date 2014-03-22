package base_de_datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ws.servidor.dato.ListaAutorizadoS;
import com.ws.servidor.dato.ListaDocumentoS;
import com.ws.servidor.dato.ListaGeneradorS;
import com.ws.servidor.dato.RegistroEspeS;

public class MySQLRegistroEspeDAO implements RegistroEspeDAO {

	public void setRegistro(RegistroEspeS r,ListaDocumentoS d, ListaGeneradorS g, ListaAutorizadoS a) throws SQLException {

		// creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();

		try {

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO especifico VALUES (?,?,?,?,?,AES_ENCRYPT(?,'@pass'))");

			ps.setString(1, r.getC_Interno());
			ps.setString(2, r.getC_Proce());
			ps.setString(3, r.getC_Contra());
			ps.setString(4, r.getIndexacion());
			ps.setString(5, r.getCodGeneral());

			ps.setString(6, r.toString());

			ps.executeUpdate();

			ps.close();
			
					// INSERTAR DOCUMENTOS
					 PreparedStatement ps2 = conn.prepareStatement("INSERT INTO ldocumento_espe VALUES (?,?,?,?)");
					
					 ps2.setString(1, d.getCodigo());
					 ps2.setString(2, d.getEnlace());
					 ps2.setString(3, d.getTipoDescripcion());
					 ps2.setString(4, " ");
					
					 ps2.executeUpdate();
					
					 ps2.close();
					 
					// INSERTAR GENERADORES
					 PreparedStatement ps5 = conn.prepareStatement("INSERT INTO lgenerador_espe VALUES (?,?,?)");
					
					 ps5.setString(1, g.getCodigo());
					 ps5.setString(2, g.getGenerador());				
					 ps5.setString(3, " ");
					 
					
					 ps5.executeUpdate();
					
					 ps5.close();
					 
					// INSERTAR AUTORIZADOS
					 PreparedStatement ps6 = conn.prepareStatement("INSERT INTO lautorizado_espe VALUES (?,?,?)");
					
					 ps6.setString(1, a.getCodigo());
					 ps6.setString(2, a.getAutorizado());
					 ps6.setString(3, " ");
					
					 ps6.executeUpdate();
					
					 ps6.close();

			conn.close();
		} catch (SQLException e) {
			throw new SQLException(
					"ERROR EN MySQLRegistroEspeDAO setRegistro()\n"
							+ e.getMessage());
		}
	}
	
	public String getRegistroEspe(String codGeneral) throws SQLException {

		// Creamos la conexion
		Connection conn = MySQLFactoriaDAO.crearConexion();
		
		RegistroEspeS r = new RegistroEspeS();
		String reg = "";

		try {

			Statement stat = conn.createStatement();

			PreparedStatement ps = conn
					.prepareStatement("SELECT e.codInterno, e.codProcedimiento, e.codContratacion, e.indexacion, d.enlace, d.tipoDescripcion, gr.generador, a.autorizado FROM especifico e, ldocumento_espe d, lgenerador_espe gr, lautorizado_espe a WHERE e.codGeneral=? and d.borrado = ' ' and gr.borrado = ' ' and a.borrado = ' ' and e.codInterno = d.codigo and e.codInterno = gr.codigo and e.codInterno = a.codigo;");

			ps.setString(1, codGeneral);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				r.setC_Interno(rs.getString("e.codInterno"));
				r.setC_Proce(rs.getString("e.codProcedimiento"));
				r.setC_Contra(rs.getString("e.codContratacion"));
				r.setIndexacion(rs.getString("e.indexacion"));
				r.setCodGeneral(codGeneral);
				
				reg += r.toString() + "·" + rs.getString("d.enlace")+ "·"+ rs.getString("d.tipoDescripcion") + "·" + rs.getString("gr.generador") + "·" + rs.getString("a.autorizado") + "·";
			}

			
			rs.close();
			
			stat.close();
			
			conn.close();

		} catch (SQLException e) {
			throw new SQLException(
					"ERROR EN MySQLRegistroEspeDAO getRegistroEspe()\n"
							+ e.getMessage());
		}
		return reg;
	}
	
	// TODOS LOS CONTRATOS
	public String getPasoAnte(String codGeneralAnte) throws SQLException{
		
		Connection conn = MySQLFactoriaDAO.crearConexion();
		String reg = "";
		try {
			 
			Statement stat = conn.createStatement();

			PreparedStatement ps = conn
					.prepareStatement("SELECT codContratacion,indexacion FROM especifico WHERE codGeneral = ?;");

			ps.setString(1, codGeneralAnte);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				reg += rs.getString("codContratacion")+" "+rs.getString("indexacion")+",";
			}
		
			rs.close();
			
			stat.close();
			
			conn.close();
			
		} catch (SQLException e) {
			throw new SQLException(
					"ERROR EN MySQLRegistroEspeDAO getPasoAnte()\n"
							+ e.getMessage());
		}
		return reg;
	}
	
	
	// UNICO CONTRATO DE TRABAJADOR
	public String getContratoTrabajador(String rol, String codGeneralAnte) throws SQLException{
		
		Connection conn = MySQLFactoriaDAO.crearConexion();
		String codContratacion = "";
		
		try {
			 
			Statement stat = conn.createStatement();

			PreparedStatement ps = conn
					.prepareStatement("SELECT codContratacion FROM especifico WHERE indexacion = ? and codGeneral = ?;");

			ps.setString(1, rol);
			ps.setString(2, codGeneralAnte);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				codContratacion = rs.getString("codContratacion");
			}
		
			rs.close();
			
			stat.close();
			
			conn.close();
			
		} catch (SQLException e) {
			throw new SQLException(
					"ERROR EN MySQLRegistroEspeDAO getContratoTrabajador()\n"
							+ e.getMessage());
		}
		return codContratacion;
	}
	
	
	public String getCodInterno(String codGeneral) throws SQLException {

		Connection conn = MySQLFactoriaDAO.crearConexion();
		String codInterno = "";
		try {
			 
			Statement stat = conn.createStatement();

			PreparedStatement ps = conn
					.prepareStatement("SELECT codInterno FROM especifico WHERE codGeneral = ?;");

			ps.setString(1, codGeneral);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				codInterno += rs.getString("codInterno")+"-";
			}
		
			rs.close();
			
			stat.close();
			
			conn.close();
			
		} catch (SQLException e) {
			throw new SQLException(
					"ERROR EN MySQLRegistroEspeDAO getCodigoInterno()\n"
							+ e.getMessage());
		}
		return codInterno;
	}	
}
