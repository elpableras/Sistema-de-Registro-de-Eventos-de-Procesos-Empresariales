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
	 * Método para almacenar las listas de generadores y su código.
	 * 
	 * @param codigo
	 *            Cadena con el código.
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
	
	/**
	 * Método que devuelve una cadena con los datos de la lista.
	 */
	public String toString(){
		String cad = "";
		
		cad += "\nLista Generadores\nCód. registro:\n" + codigo + "\nPersonas generadoras:\n" + generador + "\n";    
		
		return cad;
	}
}
