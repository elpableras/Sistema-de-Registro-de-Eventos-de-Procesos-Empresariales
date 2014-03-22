package com.ws.servidor.dato;

public class ListaIndicadorS {

	/** Un campo String */
	private String codRegistro;
	
	/** Un campo String */
	private String indicador = "";

	public ListaIndicadorS(){
		super();
	}

	/**
	 * @return the codRegistro
	 */
	public String getCodRegistro() {
		return codRegistro;
	}


	/**
	 * @param codRegistro the codRegistro to set
	 */
	public void setCodRegistro(String codRegistro) {
		this.codRegistro = codRegistro;
	}

	/**
	 * @return the indicador
	 */
	public String getIndicador() {
		return indicador;
	}

	/**
	 * @param indicador the indicador to set
	 */
	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}
}
