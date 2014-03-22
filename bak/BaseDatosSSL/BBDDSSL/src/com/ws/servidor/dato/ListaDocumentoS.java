package com.ws.servidor.dato;

public class ListaDocumentoS {

	/** Un campo String */
	private String codigo;

	/** Un campo String */
	private String enlace;
	
	/** Un campo String */
	private String tipoDescripcion;
	
	
	public ListaDocumentoS(){
		super();
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}


	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	/**
	 * @return the tipoDescripcion
	 */
	public String getTipoDescripcion() {
		return tipoDescripcion;
	}

	/**
	 * @param tipoDescripcion the tipoDescripcion to set
	 */
	public void setTipoDescripcion(String tipoDescripcion) {
		this.tipoDescripcion = tipoDescripcion;
	}
}
