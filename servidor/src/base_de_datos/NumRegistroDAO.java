package base_de_datos;

import java.sql.SQLException;

/**
 * Interface que tiene los m�todos necesarios para obtener y almacenar N�meros
 * de Registro.
 */
public interface NumRegistroDAO {
	/**
	 * M�todo para almacenar n�mero de registro.
	 * 
	 * @param n
	 *            Entero con el n�mero de registro a almacenar.
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @throws SQLException
	 *             Excepci�n de tipo setencia SQL.
	 */
	void setRegistro(int n, String proce) throws SQLException;

	/**
	 * M�todo para obtener el n�mero de registro.
	 * 
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @return Entero con el n�mero de registro.
	 * @throws SQLException
	 *             Excepci�n de tipo setencia SQL.
	 */
	int getRegistros(String proce) throws SQLException;

}