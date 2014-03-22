package com.ws.cliente.dato;

import java.util.List;

/**
 * Lista de Informaci�n Resumen del Cliente.
 */
public class ListaCampoC {

	/** Un campo String. */
	private String codRegistro;

	/** Un campo String. */
	private String nombre = "";

	/** Un campo String. */
	private String descripcion = "";

	/** Un campo String. */
	private String tipo = "";

	/** Un campo String. */
	private String unidad = "";

	/** Un campo String. */
	private String enlace = "";

	/**
	 * Constructor por defecto.
	 */
	public ListaCampoC() {
		super();
	}

	/**
	 * M�todo para almacenar las listas de campos y su c�digo registro.
	 * 
	 * @param codRegistro
	 *            Cadena con el c�digo registro.
	 * @param listaCampo
	 *            Lista con los valores de la informaci�n resumen.
	 */
	public void ListaCampo(String codRegistro, List<Object> listaCampo) {
		this.codRegistro = codRegistro;
		this.nombre = "";
		this.descripcion = "";
		this.tipo = "";
		this.unidad = "";
		this.enlace = "";
		String aux = "";
		for (int i = 0; i < listaCampo.size(); i++) {
			aux = (listaCampo.get(i).toString());
			String[] campo = aux.split(" ");
			if (campo[0].compareTo("") == 0) {
				this.nombre += " ;";
				this.descripcion += " ;";
				this.tipo += " ;";
				this.unidad += " ;";
				this.enlace += " ;";
			} else {
				this.nombre += campo[0] + ";";
				this.descripcion += campo[1] + ";";
				this.tipo += campo[2] + ";";
				this.unidad += campo[3] + ";";
				this.enlace += campo[5] + ";";
			}
		}
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el codigo del registro.
	 */
	public String getCodRegistro() {
		return codRegistro;
	}

	/**
	 * Setter.
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
	 * @return Cadena con el nombre.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter.
	 * 
	 * @param nombre
	 *            Cadena con el nombre.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con la descripci�n.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Setter.
	 * 
	 * @param descripcion
	 *            Cadena con la descripci�n.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el tipo.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Setter.
	 * 
	 * @param tipo
	 *            Cadena con el tipo.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con la unidad.
	 */
	public String getUnidad() {
		return unidad;
	}

	/**
	 * Setter.
	 * 
	 * @param unidad
	 *            Cadena con la unidad.
	 */
	public void setUnidad(String unidad) {
		this.unidad = unidad;
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
	 * M�todo que devuelve una cadena con los datos de la lista.
	 */
	public String toString(){
		String cad = "";
		
		cad += "\nLista Campos\nC�d. Registro:\n" + codRegistro + "\nNombre:\n" + nombre + "\nDescripci�n:\n" + descripcion + 
				"\nTipo:\n" + tipo + "\nUnidad:\n" + unidad + "\nEnlace:\n" + enlace + "\n";    
		
		return cad;
	}
}
