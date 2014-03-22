package base_de_datos;

import java.sql.SQLException;

/**
 * Interface que tiene los métodos necesarios para obtener y almacenar códigos
 * de contrato.
 */
public interface ContratoDAO {
	/**
	 * Método para almacenar código de contrato.
	 * 
	 * @param n
	 *            Entero con el código de contrato a almacenar.
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	void setContrato(int n, String proce) throws SQLException;

	/**
	 * Método para obtener el código de contrato.
	 * 
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @return Entero con el código de contrato.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	int getContrato(String proce) throws SQLException;
}
