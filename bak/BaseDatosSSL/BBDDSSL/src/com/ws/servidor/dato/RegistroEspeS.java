package com.ws.servidor.dato;

import java.io.Serializable;

/**
 * Un dato serializable, para poder transportarlo por el servicio web.
 * 
 */
public class RegistroEspeS implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5411578361734559814L;

	/** Un campo String */
	private String c_Interno;
	
	/** Un campo String */
	private String c_Proce;
	
	/** Un campo String */
	private String c_Contra;
	
	/** Un campo String */
	private String indexacion;
	
	/** Un campo String */
	private String codGeneral;
	
	public RegistroEspeS(){
		super();
	}

	/**
	 * @return the c_Interno
	 */
	public String getC_Interno() {
		return c_Interno;
	}

	/**
	 * @param c_Interno the c_Interno to set
	 */
	public void setC_Interno(String c_Interno) {
		this.c_Interno = c_Interno;
	}

	/**
	 * @return the c_Proce
	 */
	public String getC_Proce() {
		return c_Proce;
	}

	/**
	 * @param c_Proce the c_Proce to set
	 */
	public void setC_Proce(String c_Proce) {
		this.c_Proce = c_Proce;
	}

	/**
	 * @return the c_Contra
	 */
	public String getC_Contra() {
		return c_Contra;
	}

	/**
	 * @param c_Contra the c_Contra to set
	 */
	public void setC_Contra(String c_Contra) {
		this.c_Contra = c_Contra;
	}
	
	/**
	 * @return the indexacion
	 */
	public String getIndexacion() {
		return indexacion;
	}

	/**
	 * @param indexacion the indexacion to set
	 */
	public void setIndexacion(String indexacion) {
		this.indexacion = indexacion;
	}
	
	/**
	 * @return the codGeneral
	 */
	public String getCodGeneral() {
		return codGeneral;
	}

	/**
	 * @param codGeneral the codGeneral to set
	 */
	public void setCodGeneral(String codGeneral) {
		this.codGeneral = codGeneral;
	}

	public String toString(){
		String cad = "";
		
		cad += "\n  Cód. Interno: \n" + c_Interno + "\n  Cód. Procedimiento: \n" + c_Proce + "\n  Cód. Contratacción: \n" + c_Contra + 
				"\n  Cód. Indexación: \n" + indexacion + "\n  Cód. General: \n" + codGeneral +"\n";
		
		return cad;
	}

}
