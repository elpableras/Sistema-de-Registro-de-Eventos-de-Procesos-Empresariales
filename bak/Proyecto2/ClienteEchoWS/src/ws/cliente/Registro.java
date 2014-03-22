package ws.cliente;

import java.util.Date;

/**
 * Un Registro que tiene a su vez dentro otra clase serializable.
 * 
 * 
 */
public class Registro {
	

	/** Otra clase serializable */
    private DatoC dato;

    /** Un valor Date */
    private Date numRegistro;


	/**
	 * @return the dato
	 */
	public DatoC getDato() {
		return dato;
	}





	/**
	 * @param dato the dato to set
	 */
	public void setDato(DatoC dato) {
		this.dato = dato;
	}





	/**
	 * @return the numRegistro
	 */
	public Date getNumRegistro() {
		return numRegistro;
	}





	/**
	 * @param numRegistro the numRegistro to set
	 */
	public void setNumRegistro(Date numRegistro) {
		this.numRegistro = numRegistro;
	}





	/**
     * Para poder sacar por pantalla rapidamente el contenido de la clase.
     */
    public String toString() {
        return dato.toString() + " " + numRegistro;
    }
}

