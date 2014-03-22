package base_de_datos;

public interface RegistroDAO {

	// Funciones a realizar
	void insertarRegistro(RegistroServidor r);

	void actualizarRegistro(RegistroServidor r);

	void mostrar();
}
