package base_de_datos;

import java.sql.SQLException;

/**
 * Interface que tiene los m�todos necesarios para obtener y almacenar los
 * roles.
 */
public interface RolDAO {

	/**
	 * M�todo para obtener el rol.
	 * 
	 * @param tipo
	 *            Cadena para diferenciar los roles de administrador con el del
	 *            resto de usuarios.
	 * @return Cadena con los roles y sus contrase�as.
	 * @throws SQLException
	 *             Excepci�n de tipo setencia SQL.
	 */
	String getRol(String tipo) throws SQLException;

	/**
	 * M�todo para alamcenar un nuevo rol con su contrase�a.
	 * 
	 * @param iden
	 *            Cadena con el identificador del rol.
	 * @param pass
	 *            Cadena con la constrase�a del rol.
	 * @param tipo
	 *            Cadena con el tipo de rol.
	 * @throws SQLException
	 *             Excepci�n de tipo setencia SQL.
	 */
	void setRol(String iden, String pass, String tipo) throws SQLException;
}
