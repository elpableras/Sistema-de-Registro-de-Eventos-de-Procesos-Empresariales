package com.ws.servidor.dato;

import java.io.Serializable;

/**
 * Un dato serializable, para poder insertarlo en base de datos.
 * 
 */
public class Correo implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = -8153646205570843202L;

	private String usuario = "";
	private String pass = "";

	public Correo() {
		super();
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass
	 *            the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * Para poder sacar por pantalla rapidamente el contenido de la clase
	 */
	public String toString() {
		return "Usuario: " + usuario + "  Password: " + pass + " \n";
	}

}
