package com.ws.cliente.dato;

import java.util.List;

/**
 * Lista de Indicadores del Cliente.
 */
public class ListaIndicadorC {

	/** Un campo String. */
	private String codRegistro;

	/** Un campo String. */
	private String indicador = "";

	/**
	 * Constructor por defecto.
	 */
	public ListaIndicadorC() {
		super();
	}

	/**
	 * M�todo para almacenar las listas de indicadores y su c�digo.
	 * 
	 * @param codRegistro
	 *            Cadena con el c�digo de registro.
	 * @param listaIndicador
	 *            Lista con las listas de indicadores.
	 */
	public void ListaIndicador(String codRegistro, List<Object> listaIndicador) {
		this.codRegistro = codRegistro;
		this.indicador = "";
		for (int i = 0; i < listaIndicador.size(); i++) {
			this.indicador += (listaIndicador.get(i).toString()) + ";";
		}
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el c�digo de registro.
	 */
	public String getCodRegistro() {
		return codRegistro;
	}

	/**
	 * Sette.
	 * 
	 * @param codRegistro
	 *            Cadena con el c�digo de registro.
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
	
	/**
	 * M�todo que devuelve una cadena con los datos de la lista.
	 */
	public String toString(){
		String cad = "";
		
		cad += "\nLista Indicadores\nC�d. registro:\n" + codRegistro + "\nIndicador:\n" + indicador + "\n";    
		
		return cad;
	}
}
