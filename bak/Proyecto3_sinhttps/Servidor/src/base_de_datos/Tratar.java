package base_de_datos;

public class Tratar {

	public Tratar(RegistroServidor reg) {
		// Utilización de MySQL
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);

		// POR CADA CLASE
		RegistroDAO r = fd.getRegistroDAO();

		// Convertir a registro desde de dato
		// Registro reg = new Registro(dato.getNombre(), dato.getCorreo(),
		// dato.getEdad(), dato.getUrl());

		// insertar();
		r.insertarRegistro(reg);

		// Mandar correo con el registro registrado
		new Correo().mandarCorreo("Registro en Base de Datos", reg.toString());

		// mostrar();
		r.mostrar();

		// // actualizar()
		// Registro r1 = new Registro("Pablo", "pgj@.com", 26, "www.com");
		// r.actualizarRegistro(r1);
		// r.mostrar();
	}
}
