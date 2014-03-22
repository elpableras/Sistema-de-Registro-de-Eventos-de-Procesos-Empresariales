package com.ws.servidor.dato;

import java.io.Serializable;

/**
 * Registro Específico serializable del Servidor, para poder transportarlo por
 * el servicio web.
 */
public class RegistroEspeS implements Serializable {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 5411578361734559814L;

	/** Un campo String. */
	private String c_Interno;

	/** Un campo String. */
	private String c_Proce;

	/** Un campo String. */
	private String c_Contra;

	/** Un campo String. */
	private String indexacion;

	/** Un campo String. */
	private String codGeneral;

	/**
	 * Constructor por defecto.
	 */
	public RegistroEspeS() {
		super();
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el cód interno.
	 */
	public String getC_Interno() {
		return c_Interno;
	}

	/**
	 * Setter.
	 * 
	 * @param c_Interno
	 *            Cadena con el cód. interno .
	 */
	public void setC_Interno(String c_Interno) {
		this.c_Interno = c_Interno;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el cód de procedimiento.
	 */
	public String getC_Proce() {
		return c_Proce;
	}

	/**
	 * Setter.
	 * 
	 * @param c_Proce
	 *            Cadena del cód. de procedimiento.
	 */
	public void setC_Proce(String c_Proce) {
		this.c_Proce = c_Proce;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena del cód. de contratación.
	 */
	public String getC_Contra() {
		return c_Contra;
	}

	/**
	 * Setter.
	 * 
	 * @param c_Contra
	 *            Cadena con el cód. de contratación.
	 */
	public void setC_Contra(String c_Contra) {
		this.c_Contra = c_Contra;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el elemento de la indexación.
	 */
	public String getIndexacion() {
		return indexacion;
	}

	/**
	 * Setter.
	 * 
	 * @param indexacion
	 *            Cadena con el elemento de la indexacion.
	 */
	public void setIndexacion(String indexacion) {
		this.indexacion = indexacion;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el cód. general.
	 */
	public String getCodGeneral() {
		return codGeneral;
	}

	/**
	 * Setter.
	 * 
	 * @param codGeneral
	 *            Cadena con el cód. general.
	 */
	public void setCodGeneral(String codGeneral) {
		this.codGeneral = codGeneral;
	}

	public String toString() {
		String cad = "";

		cad += "\n  Cód. Interno: \n" + c_Interno
				+ "\n  Cód. Procedimiento: \n" + c_Proce
				+ "\n  Cód. Contratacción: \n" + c_Contra
				+ "\n  Cód. Indexación: \n" + indexacion
				+ "\n  Cód. General: \n" + codGeneral + "\n";

		return cad;
	}

}
