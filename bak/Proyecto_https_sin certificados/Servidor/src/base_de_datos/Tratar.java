package base_de_datos;

public class Tratar {

	private String usuario = "";
	private String pass = "";

	public Tratar(RegistroServidor reg) {
		// Utilización de MySQL
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);

		// POR CADA CLASE
		RegistroDAO r = fd.getRegistroDAO();
		CorreoDAO c = fd.getCorreoDAO();

		// insertar();
		r.insertarRegistro(reg);

		// Mandar correo con el registro registrado
		escogerCuenta(c);
		new mandarCorreo().correo("Registro en Base de Datos", reg.toString(),
				usuario, pass);

		// mostrar();
		r.mostrar();

		// // actualizar()
		// Registro r1 = new Registro("Pablo", "pgj@.com", 26, "www.com");
		// r.actualizarRegistro(r1);
		// r.mostrar();
	}

	private void escogerCuenta(CorreoDAO c) {
		// TODO Auto-generated method stub
		String cuenta = c.escogerCuenta();

		// espacio cn posibilidad de más caracteres (expresión regular \\s)
		String[] campos = cuenta.split("\\s+");
		usuario = campos[0];
		pass = campos[1];

	}

}
