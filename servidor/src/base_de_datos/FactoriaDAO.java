package base_de_datos;

/**
 * Clase que crea la conexión con la base de datos según el tipo especificado.
 */
public abstract class FactoriaDAO {

	/**
	 * Variables globales que se le asigna a la base de datos. Estas variables
	 * son necesarias para elegir la conexión con la base de datos que se crea
	 * con el método "getFactoriaDAO".
	 */
	public static final int eXist = 1;
	public static final int MySQL = 2;
	public static final int psePro = 3;

	// INSERTAR POR CADA CLASE
	/**
	 * Devuelve un objeto heredado de RegistroAdminDAO, que manejará las
	 * operaciones con los registros del administrador. de la base de datos
	 * especificada.
	 * 
	 * @return Objeto derivado de RegistroAdminDAO.
	 */
	public abstract RegistroAdminDAO RegistroAdminDAO();

	/**
	 * Devuelve un objeto heredado de RegistroEspeDAO, que manejará las
	 * operaciones con los registros específicos. de la base de datos
	 * especificada.
	 * 
	 * @return Objeto derivado de RegistroEspeDAO.
	 */
	public abstract RegistroEspeDAO RegistroEspeDAO();

	/**
	 * Devuelve un objeto heredado de ContratoDAO, que manejará las operaciones
	 * con el código de contrato. de la base de datos especificada.
	 * 
	 * @return Objeto derivado de ContratoDAO.
	 */
	public abstract ContratoDAO ContratoDAO();

	/**
	 * Devuelve un objeto heredado de NumRegistroDAO, que manejará las
	 * operaciones con el número de registro. de la base de datos especificada.
	 * 
	 * @return Objeto derivado de NumRegistroDAO.
	 */
	public abstract NumRegistroDAO NumRegistroDAO();

	/**
	 * Devuelve un objeto heredado de CorreoDAO, que manejará la operación con
	 * la cuenta y la clave del correo. de la base de datos especificada.
	 * 
	 * @return Objeto derivado de CorreoDAO.
	 */
	public abstract CorreoDAO CorreoDAO();

	/**
	 * Devuelve un objeto heredado de RolDAO, que manejará las operaciones con
	 * los roles. de la base de datos especificada.
	 * 
	 * @return Objeto derivado de RolDAO.
	 */
	public abstract RolDAO RolDAO();

	/**
	 * Devuelve un objeto heredado de FactoriaDAO, que maneja la conexión con la
	 * base de datos. especificada por el parámetro.
	 * 
	 * @param factoria
	 *            Entero que determina el tipo de base de datos con la que se va
	 *            a crear la conexión.
	 * @return Objeto derivado de FactoriaDAO o null.
	 */

	public static FactoriaDAO getFactoriaDAO(int factoria) {

		switch (factoria) {
		case eXist: // return new eXistFactoriaDAO();
		case MySQL:
			return new MySQLFactoriaDAO();
		case psePro: // return new pseProFactoriaDAO();
		default:
			return null;
		}

	}
}
