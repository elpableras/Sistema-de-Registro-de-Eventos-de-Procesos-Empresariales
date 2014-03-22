package com.ws.servidor.dato;

public class ListaAutorizadoS {

	/** Un campo String */
	private String codigo;
	
	/** Un campo String */
	private String autorizado;
	
	
	public ListaAutorizadoS(){
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
	 * @return the autorizado
	 */
	public String getAutorizado() {
		return autorizado;
	}


	/**
	 * @param autorizado the autorizado to set
	 */
	public void setAutorizado(String autorizado) {
		this.autorizado = autorizado;
	}
}
