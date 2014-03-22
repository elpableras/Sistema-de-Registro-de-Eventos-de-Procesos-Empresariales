package base_de_datos;

import java.sql.SQLException;

import com.ws.servidor.dato.ListaAutorizadoS;
import com.ws.servidor.dato.ListaDocumentoS;
import com.ws.servidor.dato.ListaGeneradorS;
import com.ws.servidor.dato.RegistroEspeS;

/**
 * Interface que tiene los m�todos necesarios para obtener y almacenar los
 * registros espec�ficos y para obtener los c�digos internos, los c�digos de
 * indexaci�n y c�digos de contrataci�n de los registros espec�ficos.
 */
public interface RegistroEspeDAO {

	/**
	 * M�todo para almacenar los registros espec�ficos.
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
	 *             Excepci�n de tipo setencia SQL.
	 */
	void setRegistro(RegistroEspeS res, ListaDocumentoS d, ListaGeneradorS g,
			ListaAutorizadoS a) throws SQLException;

	/**
	 * M�todo para obtener el registro espec�fico.
	 * 
	 * @param codGeneral
	 *            Cadena con el c�digo general.
	 * @return Cadena con el registo espec�fico.
	 * @throws SQLException
	 *             Excepci�n de tipo setencia SQL.
	 */
	String getRegistroEspe(String codGeneral) throws SQLException;

	/**
	 * M�todo para obtener el c�digo de contrataci�n e indexaci�n del paso
	 * anterior.
	 * 
	 * @param codGeneralAnte
	 *            Cadena con el c�digo general del paso anterior.
	 * @return Cadena con los c�digos de contrataci�n e indexaci�n de todos los
	 *         registros que halla.
	 * @throws SQLException
	 *             Excepci�n de tipo setencia SQL.
	 */
	String getPasoAnte(String codGeneralAnte) throws SQLException;

	/**
	 * M�todo para obtener el c�digo de contrataci�n.
	 * 
	 * @param rol
	 *            Cadena con el c�digo de indexaci�n.
	 * @param codGeneralAnte
	 *            Cadena con el c�digo general del paso anterior.
	 * @return Cadena con el c�digo de contrataci�n.
	 * @throws SQLException
	 *             Excepci�n de tipo setencia SQL.
	 */
	String getContratoTrabajador(String rol, String codGeneralAnte)
			throws SQLException;

	/**
	 * M�todo para obtener una lista con los c�digos internos de los registros
	 * espec�ficos.
	 * 
	 * @param codGeneral
	 *            Cadena con el c�digo general.
	 * @return Cadena con los c�digos internos de los registros alamacenados.
	 * @throws SQLException
	 *             Excepci�n de tipo setencia SQL.
	 */
	String getCodInterno(String codGeneral) throws SQLException;
}
