package com.ws.servidor.dato;

/**
 * Lista de Información Resumen del Servidor.
 */
public class ListaCampoS {

	/** Un campo String. */
	private String codRegistro;

	/** Un campo String. */
	private String nombre = "";

	/** Un campo String. */
	private String descripcion = "";

	/** Un campo String. */
	private String tipo = "";

	/** Un campo String. */
	private String unidad = "";

	/** Un campo String. */
	private String enlace = "";

	/**
	 * Constructor por defecto.
	 */
	public ListaCampoS() {
		super();
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el codigo del registro.
	 */
	public String getCodRegistro() {
		return codRegistro;
	}

	/**
	 * Setter.
	 * 
	 * @param codRegistro
	 *            Cadena con el código de registro.
	 */
	public void setCodRegistro(String codRegistro) {
		this.codRegistro = codRegistro;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter.
	 * 
	 * @param nombre
	 *            Cadena con el nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con la descripción.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Setter.
	 * 
	 * @param descripcion
	 *            Cadena con la descripción.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el tipo.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Setter.
	 * 
	 * @param tipo
	 *            Cadena con el tipo.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con la unidad.
	 */
	public String getUnidad() {
		return unidad;
	}

	/**
	 * Setter.
	 * 
	 * @param unidad
	 *            Cadena con la unidad.
	 */
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el enlace.
	 */
	public String getEnlace() {
		return enlace;
	}

	/**
	 * Setter.
	 * 
	 * @param enlace
	 *            Cadena con el enlace.
	 */
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
}
