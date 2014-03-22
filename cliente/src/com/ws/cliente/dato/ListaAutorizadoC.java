package com.ws.cliente.dato;

import java.util.List;

/**
 * Lista de Autorizados del Cliente.
 */
public class ListaAutorizadoC {

	/** Un campo String. */
	private String codigo;

	/** Un campo String. */
	private String autorizado = "";

	/**
	 * Constructor por defecto.
	 */
	public ListaAutorizadoC() {
		super();
	}

	/**
	 * Método para almacenar las listas de autorizados y sus códigos.
	 * 
	 * @param codigo
	 *            Cadena con codigo.
	 * @param listaAutorizado
	 *            Lista con la lista de autorizados.
	 */
	public void ListaAutorizado(String codigo, List<Object> listaAutorizado) {
		this.codigo = codigo;
		this.autorizado = "";
		for (int i = 0; i < listaAutorizado.size(); i++) {
			this.autorizado += (listaAutorizado.get(i).toString()) + ";";
		}
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
	
	/**
	 * Método que devuelve una cadena con los datos de la lista.
	 */
	public String toString(){
		String cad = "";
		
		cad += "\nLista Autorizados\nCód. registro:\n" + codigo + "\nPersonas autorizadas:\n" + autorizado + "\n";    
		
		return cad;
	}
}
