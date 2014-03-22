package com.ws.servidor.dato;

/**
 * Lista de Autorizados del Servidor.
 */
public class ListaAutorizadoS {

	/** Un campo String. */
	private String codigo;

	/** Un campo String. */
	private String autorizado = "";

	/**
	 * Constructor por defecto.
	 */
	public ListaAutorizadoS() {
		super();
	}

	/**
	 * Getter.
	 * 
	 * @return Codigo.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Setter.
	 * 
	 * @param codigo
	 *            Cadena con el codigo.
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el autorizado.
	 */
	public String getAutorizado() {
		return autorizado;
	}

	/**
	 * Setter.
	 * 
	 * @param autorizado
	 *            Cadena con el autorizado.
	 */
	public void setAutorizado(String autorizado) {
		this.autorizado = autorizado;
	}
}
