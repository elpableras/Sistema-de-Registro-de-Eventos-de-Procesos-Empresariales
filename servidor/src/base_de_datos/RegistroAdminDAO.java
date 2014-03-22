package base_de_datos;

import java.sql.SQLException;

import com.ws.servidor.dato.ListaAutorizadoS;
import com.ws.servidor.dato.ListaGeneradorS;
import com.ws.servidor.dato.ListaCampoS;
import com.ws.servidor.dato.ListaDocumentoS;
import com.ws.servidor.dato.ListaIndicadorS;
import com.ws.servidor.dato.RegistroAdminS;

/**
 * Interface que tiene los métodos necesarios para obtener y almacenar los
 * registros del administrador; obtener el procedimiento y la lista de códigos
 * generales de los registros y almacenar las actualizaciones de los registros
 * del administrador.
 */
public interface RegistroAdminDAO {

	// Funciones a realizar
	/**
	 * Método que obtiene el procedimeinto.
	 * 
	 * @return Cadena con el procedimiento.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	String getProcedimiento() throws SQLException;

	/**
	 * Método para almacenar el registro del administrador, que son los
	 * registros generales.
	 * 
	 * @param ras
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
	void setRegistro(RegistroAdminS ras, ListaDocumentoS d, ListaCampoS c,
			ListaIndicadorS i, ListaGeneradorS g, ListaAutorizadoS a)
			throws SQLException;

	/**
	 * Método para almacenar la actualización del registro del administrador,
	 * que son los registros generales.
	 * 
	 * @param ras
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
	void setActualizar(RegistroAdminS ras, ListaDocumentoS d, ListaCampoS c,
			ListaIndicadorS i, ListaGeneradorS g, ListaAutorizadoS a)
			throws SQLException;

	/**
	 * Método para obtener el registro general.
	 * 
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @return Cadena con los registros generales.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	String getRegistro(String proce) throws SQLException;

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
	String getListaRegistro(String proce) throws SQLException;

}
