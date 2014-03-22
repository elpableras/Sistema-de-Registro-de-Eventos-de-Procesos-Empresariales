package base_de_datos;

public interface CorreoDAO {

	// Funciones a realizar
	void insertarCorreo(Correo c);

	void actualizarCorreo(Correo c);

	void borrarCorreo(Correo c);

	String escogerCuenta();
}
