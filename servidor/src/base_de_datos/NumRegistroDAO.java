package base_de_datos;

import java.sql.SQLException;

/**
 * Interface que tiene los métodos necesarios para obtener y almacenar Números
 * de Registro.
 */
public interface NumRegistroDAO {
	/**
	 * Método para almacenar número de registro.
	 * 
	 * @param n
	 *            Entero con el número de registro a almacenar.
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	void setRegistro(int n, String proce) throws SQLException;

	/**
	 * Método para obtener el número de registro.
	 * 
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @return Entero con el número de registro.
	 * @throws SQLException
	 *             Excepción de tipo setencia SQL.
	 */
	int getRegistros(String proce) throws SQLException;

}