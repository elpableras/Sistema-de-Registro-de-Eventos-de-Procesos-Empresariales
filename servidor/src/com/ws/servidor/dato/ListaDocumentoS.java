package com.ws.servidor.dato;


/**
 * Lista de documentos del Servidor.
 */
public class ListaDocumentoS {

	/** Un campo String. */
	private String codigo;

	/** Un campo String. */
	private String enlace = "";

	/** Un campo String. */
	private String tipoDescripcion = "";

	/**
	 * Constructor por defecto.
	 */
	public ListaDocumentoS() {
		super();
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el código.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Setter.
	 * 
	 * @param codigo
	 *            Cadena con el código.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	/**
	 * Getter.
	 * 
	 * @return Cadena con el tipoDescripcion.
	 */
	public String getTipoDescripcion() {
		return tipoDescripcion;
	}

	/**
	 * Setter.
	 * 
	 * @param tipoDescripcion
	 *            Cadena con el tipoDescripcion.
	 */
	public void setTipoDescripcion(String tipoDescripcion) {
		this.tipoDescripcion = tipoDescripcion;
	}
}
