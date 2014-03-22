package com.ws.cliente.dato;

import java.util.List;

/**
 * Lista de Generadores del Cliente.
 */
public class ListaGeneradorC {

	/** Un campo String. */
	private String codigo;

	/** Un campo String. */
	private String generador = "";

	/**
	 * Constructor por defecto.
	 */
	public ListaGeneradorC() {
		super();
	}

	/**
	 * M�todo para almacenar las listas de generadores y su c�digo.
	 * 
	 * @param codigo
	 *            Cadena con el c�digo.
	 * @param listaGenerador
	 *            Lista con las listas de generadores.
	 */
	public void ListaGenerador(String codigo, List<Object> listaGenerador) {
		this.codigo = codigo;
		this.generador = "";
		for (int i = 0; i < listaGenerador.size(); i++) {
			this.generador += (listaGenerador.get(i).toString()) + ";";
		}
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el c�digo.
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Setter.
	 * 
	 * @param codigo
	 *            Cadena con el c�digo.
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
	
	/**
	 * M�todo que devuelve una cadena con los datos de la lista.
	 */
	public String toString(){
		String cad = "";
		
		cad += "\nLista Generadores\nC�d. registro:\n" + codigo + "\nPersonas generadoras:\n" + generador + "\n";    
		
		return cad;
	}
}
