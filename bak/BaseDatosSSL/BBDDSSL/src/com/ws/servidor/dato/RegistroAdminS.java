package com.ws.servidor.dato;

import java.io.Serializable;

/**
 * Un dato serializable, para poder transportarlo por el servicio web.
 * 
 */
public class RegistroAdminS implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1278143646439847739L;
	
	
	// REGISTRO GENERAL 
	
	/** Un campo String */
	private String nombre;

	/** Un campo String */
	private String codGeneral;

	/** Un campo String */
	private String descri;

	/** Un campo String */
	private String tipo;

	/** Un campo String */
	private String codProce;
	
	/** Un campo String */
	private String acti;
	
	/** Un campo String */
	private String frecu;
	
	/** Un campo String */
	private String meto;
	
	
	// REGISTRO CICLO DE VIDA
	
	/** Un campo String */
	private String archivo;
	
	/** Un campo String */
	private String retencion;
	
	/** Un campo String */
	private String conservacion;
	
	/** Un campo String */
	private String dispo;
	
	/** Un campo String */
	private String almacen;
	
	/** Un campo Boolean */
	private boolean modi;

	

	public RegistroAdminS () {
		super();
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





	/**
	 * @return the descri
	 */
	public String getDescri() {
		return descri;
	}





	/**
	 * @param descri the descri to set
	 */
	public void setDescri(String descri) {
		this.descri = descri;
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
	 * @return the codProce
	 */
	public String getCodProce() {
		return codProce;
	}





	/**
	 * @param codProce the codProce to set
	 */
	public void setCodProce(String codProce) {
		this.codProce = codProce;
	}





	/**
	 * @return the acti
	 */
	public String getActi() {
		return acti;
	}





	/**
	 * @param acti the acti to set
	 */
	public void setActi(String acti) {
		this.acti = acti;
	}






	/**
	 * @return the frecu
	 */
	public String getFrecu() {
		return frecu;
	}





	/**
	 * @param frecu the frecu to set
	 */
	public void setFrecu(String frecu) {
		this.frecu = frecu;
	}





	/**
	 * @return the meto
	 */
	public String getMeto() {
		return meto;
	}





	/**
	 * @param meto the meto to set
	 */
	public void setMeto(String meto) {
		this.meto = meto;
	}





	/**
	 * @return the archivo
	 */
	public String getArchivo() {
		return archivo;
	}





	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}





	/**
	 * @return the retencion
	 */
	public String getRetencion() {
		return retencion;
	}





	/**
	 * @param retencion the retencion to set
	 */
	public void setRetencion(String retencion) {
		this.retencion = retencion;
	}





	/**
	 * @return the conservacion
	 */
	public String getConservacion() {
		return conservacion;
	}





	/**
	 * @param conservacion the conservacion to set
	 */
	public void setConservacion(String conservacion) {
		this.conservacion = conservacion;
	}





	/**
	 * @return the dispo
	 */
	public String getDispo() {
		return dispo;
	}





	/**
	 * @param dispo the dispo to set
	 */
	public void setDispo(String dispo) {
		this.dispo = dispo;
	}





	/**
	 * @return the almacen
	 */
	public String getAlmacen() {
		return almacen;
	}





	/**
	 * @param almacen the almacen to set
	 */
	public void setAlmacen(String almacen) {
		this.almacen = almacen;
	}
	
	
	
	/**
	 * @return the modi
	 */
	public boolean isModi() {
		return modi;
	}




	/**
	 * @param modi the modi to set
	 */
	public void setModi(boolean modi) {
		this.modi = modi;
	}





	/**
	 * Para poder sacar por pantalla rapidamente el contenido de la clase
	 */
	public String toString() {
		return "\n\nRegistro General\n   -Nombre: \n" + nombre + "\n  -Código General: \n" + codGeneral  + "\n  -Descripción: \n" + descri + "\n  -Tipo: \n" + tipo + 
				"\n  -Cód. Procedimiento: \n" + codProce + "\n  -Actividad: \n" + acti + "\n  -Frecuencia: \n" + frecu + "\n  -Método: \n" + meto + 
				"    \n\nRegistro Ciclo de Vida\n   -Archivo: \n" + archivo + "\n  -Retención: \n" + retencion + "\n  -Conservación: \n" + conservacion + "\n  -Disposición: \n" + dispo + 
				"\n  -Almacén: \n" + almacen + "\n\n    ";
	}
}
