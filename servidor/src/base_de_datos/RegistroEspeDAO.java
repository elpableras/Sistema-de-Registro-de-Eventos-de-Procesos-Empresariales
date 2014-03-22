package base_de_datos;

import java.sql.SQLException;

import com.ws.servidor.dato.ListaAutorizadoS;
import com.ws.servidor.dato.ListaDocumentoS;
import com.ws.servidor.dato.ListaGeneradorS;
import com.ws.servidor.dato.RegistroEspeS;

/**
 * Interface que tiene los métodos necesarios para obtener y almacenar los
 * registros específicos y para obtener los códigos internos, los códigos de
 * indexación y códigos de contratación de los registros específicos.
 */
public interface RegistroEspeDAO {

	/**
	 * Método para almacenar los registros específicos.
	 * 
	 * @param res
	 *            Objeto de tipo RegistroEspeS, que contiene los datos del
	 *            registro.
	 * @param d
	 *            Objeto de tipo ListaDocumentoS, que contiene los datos de la
	 *            lista de documentos.
	 * @param g
	 *            Objeto de tipo ListaGeneradorS, que contiene los datos de la
	 *            lista de generadores.
	 * @param a
	 *            Objeto de tipo ListaAutorizadoS, que contiene los datos de la
	 *            lista de autorizados.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	void setRegistro(RegistroEspeS res, ListaDocumentoS d, ListaGeneradorS g,
			ListaAutorizadoS a) throws SQLException;

	/**
	 * Método para obtener el registro específico.
	 * 
	 * @param codGeneral
	 *            Cadena con el código general.
	 * @return Cadena con el registo específico.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	String getRegistroEspe(String codGeneral) throws SQLException;

	/**
	 * Método para obtener el código de contratación e indexación del paso
	 * anterior.
	 * 
	 * @param codGeneralAnte
	 *            Cadena con el código general del paso anterior.
	 * @return Cadena con los códigos de contratación e indexación de todos los
	 *         registros que halla.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	String getPasoAnte(String codGeneralAnte) throws SQLException;

	/**
	 * Método para obtener el código de contratación.
	 * 
	 * @param rol
	 *            Cadena con el código de indexación.
	 * @param codGeneralAnte
	 *            Cadena con el código general del paso anterior.
	 * @return Cadena con el código de contratación.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	String getContratoTrabajador(String rol, String codGeneralAnte)
			throws SQLException;

	/**
	 * Método para obtener una lista con los códigos internos de los registros
	 * específicos.
	 * 
	 * @param codGeneral
	 *            Cadena con el código general.
	 * @return Cadena con los códigos internos de los registros alamacenados.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	String getCodInterno(String codGeneral) throws SQLException;
}
