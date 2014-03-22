package base_de_datos;

import java.sql.SQLException;

/**
 * Interface que tiene el m�todo necesario para obtener el usuario y la clave de
 * una cuenta de correo.
 */
public interface CorreoDAO {

	/**
	 * M�todo para obtener el usuario y la clave de la cuenta de correo.
	 * 
	 * @return Cadena con el usuario y la clave.
	 * @throws SQLException
	 *             Excepci�n de tipo setencia SQL.
	 */
	String getCuenta() throws SQLException;
}
