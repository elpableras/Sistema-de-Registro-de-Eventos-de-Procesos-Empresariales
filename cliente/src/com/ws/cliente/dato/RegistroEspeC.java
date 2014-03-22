package com.ws.cliente.dato;

/**
 * Registro Específico serializable del Cliente, para poder transportarlo por el servicio
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
	 * específico.
	 * 
	 * @param c_Interno
	 *            Cadena con el código interno de registro.
	 * @param c_Proce
	 *            Cadena con el código de ejecución del procedimiento.
	 * @param c_Contra
	 *            Cadena con el código de contratación.
	 * @param indexacion
	 *            Cadena con el elemento de indexación.
	 * @param codGeneral
	 *            Cadena con el código del registro general.
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
	 *            Booleano true o false de la acción de pulsado.
	 */
	public void setPulsado(boolean pulsado) {
		this.pulsado = pulsado;
	}

	/**
	 * Método que devuelve una cadena con los datos del registro.
	 */
	public String toString() {
		String cad = "";

		cad += "\nCód. Interno:\n" + c_Interno + "\nCód. Procedimiento:\n"
				+ c_Proce + "\nCód. Contratacción:\n" + c_Contra
				+ "\nCód. Indexación:\n" + indexacion + "\nCód. General:\n" + codGeneral + "\n";

		return cad;
	}

	/**
	 * Método sincronizado para despertar este hilo cuando se ha rellenado la
	 * información del registro.
	 */
	public synchronized void despertarHilo() {
		notify();
	}

	/**
	 * Método sincronizado para dormir este hilo cuando es llamado por Cliente
	 * para que espere a que se escriba la información en el registro.
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
