package com.ws.servidor.dato;

import java.io.Serializable;

/**
 * Registro General serializable del Servidor, para poder transportarlo por el
 * servicio web.
 */
public class RegistroAdminS implements Serializable {
	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 1278143646439847739L;

	// REGISTRO GENERAL

	/** Un campo String. */
	private String nombre;

	/** Un campo String. */
	private String codGeneral;

	/** Un campo String. */
	private String descri;

	/** Un campo String. */
	private String tipo;

	/** Un campo String. */
	private String codProce;

	/** Un campo String. */
	private String acti;

	/** Un campo String. */
	private String frecu;

	/** Un campo String. */
	private String meto;

	// REGISTRO CICLO DE VIDA

	/** Un campo String. */
	private String archivo;

	/** Un campo String. */
	private String retencion;

	/** Un campo String. */
	private String conservacion;

	/** Un campo String. */
	private String dispo;

	/** Un campo String. */
	private String almacen;

	/** Un campo Boolean. */
	private boolean modi;

	/**
	 * Constructor por defecto.
	 */
	public RegistroAdminS() {
		super();
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
	 * @return Cadena con el c�d. general.
	 */
	public String getCodGeneral() {
		return codGeneral;
	}

	/**
	 * Setter.
	 * 
	 * @param codGeneral
	 *            Cadena con el c�d. general.
	 */
	public void setCodGeneral(String codGeneral) {
		this.codGeneral = codGeneral;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con la descripci�n.
	 */
	public String getDescri() {
		return descri;
	}

	/**
	 * Setter.
	 * 
	 * @param descri
	 *            Cadena con la descripci�n.
	 */
	public void setDescri(String descri) {
		this.descri = descri;
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
	 * @return Cadena con el c�d. de procedimiento.
	 */
	public String getCodProce() {
		return codProce;
	}

	/**
	 * Setter.
	 * 
	 * @param codProce
	 *            Cadena con el c�d de procedimiento.
	 */
	public void setCodProce(String codProce) {
		this.codProce = codProce;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con la actividad.
	 */
	public String getActi() {
		return acti;
	}

	/**
	 * Setter.
	 * 
	 * @param acti
	 *            Cadena con la actividad.
	 */
	public void setActi(String acti) {
		this.acti = acti;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el frecuencia.
	 */
	public String getFrecu() {
		return frecu;
	}

	/**
	 * Setter.
	 * 
	 * @param frecu
	 *            Cadena con la frecuencia.
	 */
	public void setFrecu(String frecu) {
		this.frecu = frecu;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el m�todo.
	 */
	public String getMeto() {
		return meto;
	}

	/**
	 * Setter.
	 * 
	 * @param meto
	 *            Cadena con el m�todo.
	 */
	public void setMeto(String meto) {
		this.meto = meto;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el archivo.
	 */
	public String getArchivo() {
		return archivo;
	}

	/**
	 * Setter.
	 * 
	 * @param archivo
	 *            Cadena con el archivo.
	 */
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con la retenci�n.
	 */
	public String getRetencion() {
		return retencion;
	}

	/**
	 * Setter.
	 * 
	 * @param retencion
	 *            Cadena con la retenci�n.
	 */
	public void setRetencion(String retencion) {
		this.retencion = retencion;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con la conservaci�n.
	 */
	public String getConservacion() {
		return conservacion;
	}

	/**
	 * Setter.
	 * 
	 * @param conservacion
	 *            Cadena con la conservaci�n.
	 */
	public void setConservacion(String conservacion) {
		this.conservacion = conservacion;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el disposici�n.
	 */
	public String getDispo() {
		return dispo;
	}

	/**
	 * Setter.
	 * 
	 * @param dispo
	 *            Cadena con la disposici�n.
	 */
	public void setDispo(String dispo) {
		this.dispo = dispo;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el almac�n.
	 */
	public String getAlmacen() {
		return almacen;
	}

	/**
	 * Setter.
	 * 
	 * @param almacen
	 *            Cadena con el almacen.
	 */
	public void setAlmacen(String almacen) {
		this.almacen = almacen;
	}

	/**
	 * Getter.
	 * 
	 * @return Booleano con la modificaci�n true o false.
	 */
	public boolean isModi() {
		return modi;
	}

	/**
	 * Setter.
	 * 
	 * @param modi
	 *            Booleano true o false de modificado.
	 */
	public void setModi(boolean modi) {
		this.modi = modi;
	}

	/**
	 * Para poder sacar por pantalla rapidamente el contenido de la clase
	 */
	public String toString() {
		return "\n\nRegistro General\n   -Nombre: \n" + nombre
				+ "\n  -C�digo General: \n" + codGeneral
				+ "\n  -Descripci�n: \n" + descri + "\n  -Tipo: \n" + tipo
				+ "\n  -C�d. Procedimiento: \n" + codProce
				+ "\n  -Actividad: \n" + acti + "\n  -Frecuencia: \n" + frecu
				+ "\n  -M�todo: \n" + meto
				+ "    \n\nRegistro Ciclo de Vida\n   -Archivo: \n" + archivo
				+ "\n  -Retenci�n: \n" + retencion + "\n  -Conservaci�n: \n"
				+ conservacion + "\n  -Disposici�n: \n" + dispo
				+ "\n  -Almac�n: \n" + almacen + "\n\n    ";
	}
}
