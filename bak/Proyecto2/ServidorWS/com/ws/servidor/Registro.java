package ws.servidor;


import java.io.Serializable;

/**
 * Un Registro que tiene a su vez dentro otra clase serializable.
 * 
 * 
 */
public class Registro implements Serializable {
    
    /**
	 * serial uid
	 */
	private static final long serialVersionUID = -9178323075607774344L;
	

	/** Otra clase serializable */
    private DatoS dato;

    /** Un valor string */
    private String numRegistro;


    
    /**
	 * @return the dato
	 */
	public DatoS getDato() {
		return dato;
	}





	/**
	 * @param dato the dato to set
	 */
	public void setDato(DatoS dato) {
		this.dato = dato;
	}





	/**
	 * @return the numRegistro
	 */
	public String getNumRegistro() {
		return numRegistro;
	}





	/**
	 * @param numRegistro the numRegistro to set
	 */
	public void setNumRegistro(String numRegistro) {
		this.numRegistro = numRegistro;
	}





	/**
     * Para poder sacar por pantalla rapidamente el contenido de la clase.
     */
    public String toString() {
        return dato.toString() + " " + numRegistro;
    }
}
