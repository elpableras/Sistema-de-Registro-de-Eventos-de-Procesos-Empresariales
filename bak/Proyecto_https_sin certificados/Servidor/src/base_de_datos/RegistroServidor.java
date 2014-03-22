package base_de_datos;

import java.io.Serializable;

/**
 * Un dato serializable, para poder insertarlo en base de datos.
 * 
 */
public class RegistroServidor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1278143646439847739L;

	/** Un campo String */
	private String cod;

	/**
	 * @return the cod
	 */
	public String getCod() {
		return cod;
	}

	/**
	 * @param cod
	 *            the cod to set
	 */
	public void setCod(String cod) {
		this.cod = cod;
	}

	/** Un campo String */
	private String nombre;

	/** Un campo String */
	private String correo;

	/** Un campo int */
	private int edad;

	/** Un campo String */
	private String url;

	public RegistroServidor() {
		super();
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo
	 *            the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad
	 *            the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Para poder sacar por pantalla rapidamente el contenido de la clase
	 */
	public String toString() {
		return "Nombre: " + nombre + "  Correo: " + correo + " Edad: " + edad
				+ " Documentos: " + url + " \n";
	}
}
