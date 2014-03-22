package base_de_datos;

import java.sql.SQLException;

/**
 * Interface que tiene los m�todos necesarios para obtener y almacenar c�digos
 * de contrato.
 */
public interface ContratoDAO {
	/**
	 * M�todo para almacenar c�digo de contrato.
	 * 
	 * @param n
	 *            Entero con el c�digo de contrato a almacenar.
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @throws SQLException
	 *             Excepci�n de tipo setencia SQL.
	 */
	void setContrato(int n, String proce) throws SQLException;

	/**
	 * M�todo para obtener el c�digo de contrato.
	 * 
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @return Entero con el c�digo de contrato.
	 * @throws SQLException
	 *             Excepci�n de tipo setencia SQL.
	 */
	int getContrato(String proce) throws SQLException;
}
