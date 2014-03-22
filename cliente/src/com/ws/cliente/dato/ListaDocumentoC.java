package com.ws.cliente.dato;

import java.util.List;

/**
 * Lista de documentos del Cliente.
 */
public class ListaDocumentoC {

	/** Un campo String. */
	private String codigo;

	/** Un campo String. */
	private String enlace = "";

	/** Un campo String. */
	private String tipoDescripcion = "";

	/**
	 * Constructor por defecto.
	 */
	public ListaDocumentoC() {
		super();
	}

	/**
	 * M�todo para almacenar las listas de documentos y su c�digo.
	 * 
	 * @param codigo
	 *            Cadena con el c�digo.
	 * @param listaDocumento
	 *            Lista con las listas de documentos.
	 */
	public void ListaDocumento(String codigo, List<Object> listaDocumento) {
		this.codigo = codigo;
		this.enlace = "";
		this.tipoDescripcion = "";
		String aux = "";
		for (int i = 0; i < listaDocumento.size(); i++) {
			aux = (listaDocumento.get(i).toString());
			String[] campo = aux.split(" / ");
			this.tipoDescripcion += campo[1] + ";";
			String[] enlaces = campo[0].split(",");
			for (int j = 0; j < enlaces.length; j++) {
				this.enlace += enlaces[j] + ";";
			}
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
	
	/**
	 * M�todo que devuelve una cadena con los datos de la lista.
	 */
	public String toString(){
		String cad = "";
		
		cad += "\nLista Documentos\nC�d. Documento:\n" + codigo + "\nEnlace:\n" + enlace + "\nTipo y descripci�n:\n" + tipoDescripcion + "\n";    
		
		return cad;
	}
}
