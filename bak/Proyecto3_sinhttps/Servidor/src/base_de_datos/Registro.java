package base_de_datos;

public class Registro {

	protected String nombre;
	protected String correo;
	protected int edad;
	protected String url;

	public Registro(String nombre, String correo, int edad, String url) {
		this.nombre = nombre;
		this.correo = correo;
		this.edad = edad;
		this.url = url;
	}

}
