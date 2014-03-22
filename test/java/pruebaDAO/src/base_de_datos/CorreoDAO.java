package base_de_datos;

import java.sql.Connection;

public interface CorreoDAO {

	// Funciones a realizar
	String insertarCorreo(Correo c, Connection conn);

	String borrarCorreo(Correo c, Connection conn);

	String escogerCuenta(Connection conn);
}
