package com.ws.servidor.dato;

public class ListaCampoS {

	/** Un campo String */
	private String codRegistro;
	
	/** Un campo String */
	private String nombre;
	
	/** Un campo String */
	private String descripcion;
	
	/** Un campo String */
	private String tipo;
	
	/** Un campo String */
	private String unidad;
	
	/** Un campo String */
	private String enlace;
	
	public ListaCampoS(){
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}


	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	/**
	 * @return the unidad
	 */
	public String getUnidad() {
		return unidad;
	}


	/**
	 * @param unidad the unidad to set
	 */
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}


	/**
	 * @return the enlace
	 */
	public String getEnlace() {
		return enlace;
	}


	/**
	 * @param enlace the enlace to set
	 */
	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}
}
