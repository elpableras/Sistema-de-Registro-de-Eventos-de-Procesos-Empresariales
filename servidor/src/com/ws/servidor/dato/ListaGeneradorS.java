package com.ws.servidor.dato;


/**
 * Lista de Generadores del Servidor.
 */
public class ListaGeneradorS {

	/** Un campo String. */
	private String codigo;

	/** Un campo String. */
	private String generador = "";

	/**
	 * Constructor por defecto.
	 */
	public ListaGeneradorS() {
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
	 * @return Cadena con el generador.
	 */
	public String getGenerador() {
		return generador;
	}

	/**
	 * Setter.
	 * 
	 * @param generador
	 *            Cadena con el generador.
	 */
	public void setGenerador(String generador) {
		this.generador = generador;
	}
	
}
