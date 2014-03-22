package com.ws.servidor.dato;


/**
 * Lista de Indicadores del Servidor.
 */
public class ListaIndicadorS {

	/** Un campo String. */
	private String codRegistro;

	/** Un campo String. */
	private String indicador = "";

	/**
	 * Constructor por defecto.
	 */
	public ListaIndicadorS() {
		super();
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el código de registro.
	 */
	public String getCodRegistro() {
		return codRegistro;
	}

	/**
	 * Sette.
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
	 * @return Cadena con el indicador.
	 */
	public String getIndicador() {
		return indicador;
	}

	/**
	 * Setter.
	 * 
	 * @param indicador
	 *            Cadena con el indicador.
	 */
	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}

}
