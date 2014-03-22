package base_de_datos;

import java.sql.SQLException;

/**
 * Interface que tiene los métodos necesarios para obtener y almacenar los
 * roles.
 */
public interface RolDAO {

	/**
	 * Método para obtener el rol.
	 * 
	 * @param tipo
	 *            Cadena para diferenciar los roles de administrador con el del
	 *            resto de usuarios.
	 * @return Cadena con los roles y sus contraseñas.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	String getRol(String tipo) throws SQLException;

	/**
	 * Método para alamcenar un nuevo rol con su contraseña.
	 * 
	 * @param iden
	 *            Cadena con el identificador del rol.
	 * @param pass
	 *            Cadena con la constraseña del rol.
	 * @param tipo
	 *            Cadena con el tipo de rol.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	void setRol(String iden, String pass, String tipo) throws SQLException;
}
