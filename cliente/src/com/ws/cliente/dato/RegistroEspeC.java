package com.ws.cliente.dato;

/**
 * Registro Espec�fico serializable del Cliente, para poder transportarlo por el servicio
 * web.
 */
public class RegistroEspeC {

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

	/** Un campo Boolean. */
	private boolean pulsado = false;

	/**
	 * Constructor por defecto.
	 */
	public RegistroEspeC() {
		super();
	}

	/**
	 * Constructor para almacenar los distintos tipos de campos para el registro
	 * espec�fico.
	 * 
	 * @param c_Interno
	 *            Cadena con el c�digo interno de registro.
	 * @param c_Proce
	 *            Cadena con el c�digo de ejecuci�n del procedimiento.
	 * @param c_Contra
	 *            Cadena con el c�digo de contrataci�n.
	 * @param indexacion
	 *            Cadena con el elemento de indexaci�n.
	 * @param codGeneral
	 *            Cadena con el c�digo del registro general.
	 */
	public RegistroEspeC(String c_Interno, String c_Proce, String c_Contra,
			String indexacion, String codGeneral) {

		this.c_Interno = c_Interno;
		this.c_Proce = c_Proce;
		this.c_Contra = c_Contra;
		this.indexacion = indexacion;
		this.codGeneral = codGeneral;

	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el c�d interno.
	 */
	public String getC_Interno() {
		return c_Interno;
	}

	/**
	 * Setter.
	 * 
	 * @param c_Interno
	 *            Cadena con el c�d. interno .
	 */
	public void setC_Interno(String c_Interno) {
		this.c_Interno = c_Interno;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el c�d de procedimiento.
	 */
	public String getC_Proce() {
		return c_Proce;
	}

	/**
	 * Setter.
	 * 
	 * @param c_Proce
	 *            Cadena del c�d. de procedimiento.
	 */
	public void setC_Proce(String c_Proce) {
		this.c_Proce = c_Proce;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena del c�d. de contrataci�n.
	 */
	public String getC_Contra() {
		return c_Contra;
	}

	/**
	 * Setter.
	 * 
	 * @param c_Contra
	 *            Cadena con el c�d. de contrataci�n.
	 */
	public void setC_Contra(String c_Contra) {
		this.c_Contra = c_Contra;
	}

	/**
	 * Getter.
	 * 
	 * @return Cadena con el elemento de la indexaci�n.
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
	 * @return Boolean pulsado.
	 */
	public boolean isPulsado() {
		return pulsado;
	}

	/**
	 * Setter.
	 * 
	 * @param pulsado
	 *            Booleano true o false de la acci�n de pulsado.
	 */
	public void setPulsado(boolean pulsado) {
		this.pulsado = pulsado;
	}

	/**
	 * M�todo que devuelve una cadena con los datos del registro.
	 */
	public String toString() {
		String cad = "";

		cad += "\nC�d. Interno:\n" + c_Interno + "\nC�d. Procedimiento:\n"
				+ c_Proce + "\nC�d. Contratacci�n:\n" + c_Contra
				+ "\nC�d. Indexaci�n:\n" + indexacion + "\nC�d. General:\n" + codGeneral + "\n";

		return cad;
	}

	/**
	 * M�todo sincronizado para despertar este hilo cuando se ha rellenado la
	 * informaci�n del registro.
	 */
	public synchronized void despertarHilo() {
		notify();
	}

	/**
	 * M�todo sincronizado para dormir este hilo cuando es llamado por Cliente
	 * para que espere a que se escriba la informaci�n en el registro.
	 */
	public synchronized void dormirHilo() {
		if (!isPulsado()) {
			try {
				wait();
				setPulsado(true);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
