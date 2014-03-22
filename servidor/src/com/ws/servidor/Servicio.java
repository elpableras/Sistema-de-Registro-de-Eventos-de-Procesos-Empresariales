package com.ws.servidor;

import com.ws.servidor.dato.ListaAutorizadoS;
import com.ws.servidor.dato.ListaGeneradorS;
import com.ws.servidor.dato.ListaCampoS;
import com.ws.servidor.dato.ListaDocumentoS;
import com.ws.servidor.dato.ListaIndicadorS;
import com.ws.servidor.dato.RegistroAdminS;
import com.ws.servidor.dato.RegistroEspeS;
import base_de_datos.Registrar;

/**
 * Clase donde recibe las operaciones del Servicio Web.
 */
public class Servicio {

	Registrar r = new Registrar();

	// ROLES
	/**
	 * M�todo que comprueba los roles.
	 * 
	 * @param iden
	 *            Cadena con el identificador del rol.
	 * @param pass
	 *            Cadena con la clave del rol.
	 * @param rol
	 *            Booleano para diferenciar la operacion de comprobar o
	 *            almacenar el rol.
	 * @param tipo
	 *            Cadena para diferenciar si es un rol de usuario o del
	 *            administrador.
	 * @return Un valor booleano dependiendo de como ha ido la operaci�n
	 * @throws Exception
	 *             Genera una excepci�n gen�rica.
	 */
	public boolean comprobarRol(String iden, String pass, boolean rol,
			String tipo) throws Exception {
		cargarCertificados();
		if (rol) {
			return r.setRol(iden, pass, tipo);
		} else {
			return r.comprobarRol(iden, pass, tipo);
		}
	}

	// AUTO
	/**
	 * M�todo para almacenar los registros autom�ticos.
	 * 
	 * @param reg
	 *            Cadena con el registro.
	 * @return Cadena con el mensaje de error o de confirmaci�n.
	 */
	public String setRegistroAuto(String reg) {
		cargarCertificados();
		return r.setAuto(reg);
	}

	// ADMINISTRADOR
	/**
	 * M�todo para almacenar los registros del administrador.
	 * 
	 * @param ras
	 *            Objeto de tipo RegistroAdminS, que contiene los datos del
	 *            registro.
	 * @param d
	 *            Objeto de tipo ListaDocumentoS, que contiene los datos de la
	 *            lista de documentos.
	 * @param c
	 *            Objeto de tipo ListaCampoS, que contiene los datos de la lista
	 *            de informaci�n resumen.
	 * @param i
	 *            Objeto de tipo ListaIndicadorS, que contiene los datos de la
	 *            lista de indicadores.
	 * @param g
	 *            Objeto de tipo ListaGeneradorS, que contiene los datos de la
	 *            lista de generadores.
	 * @param a
	 *            Objeto de tipo ListaAutorizadoS, que contiene los datos de la
	 *            lista de autorizados.
	 * @return Cadena con el mensaje de error o de confirmaci�n.
	 */
	public String setRegistroAdmin(RegistroAdminS ras, ListaDocumentoS d,
			ListaCampoS c, ListaIndicadorS i, ListaGeneradorS g,
			ListaAutorizadoS a) {
		cargarCertificados();
		return r.setAdmin(ras, d, c, i, g, a);
	}

	/**
	 * M�todo para obtener el registro general, seg�n el proceso solicitado.
	 * 
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @return Cadena con el mensaje de error o con el registro general.
	 */
	public String getRegistroAdmin(String proce) {
		cargarCertificados();
		return r.getAdmin(proce);
	}

	// ESPECIFICO
	/**
	 * M�todo para obtener el c�digo de contrato.
	 * 
	 * @param proce
	 *            Cadena con el n�mero de procedimiento.
	 * @return Cadena con el mensaje de error o el c�digo de contrato.
	 * @throws Exception
	 *             Genera una excepci�n gen�rica.
	 */
	public int getCodContrato(String proce) throws Exception {
		cargarCertificados();
		return r.getContrato(proce);
	}

	/**
	 * M�todo para obtener el n�mero de registro.
	 * 
	 * @param proce
	 *            Cadena con el n�mero de procedimiento.
	 * @return Cadena con el mensaje de error o el n�mero de registro.
	 * @throws Exception
	 *             Genera una excepci�n gen�rica.
	 */
	public int getNumRegistro(String proce) throws Exception {
		cargarCertificados();
		return r.getNumRegistro(proce);
	}

	/**
	 * M�todo para almacenar los registros espec�ficos.
	 * 
	 * @param res
	 *            Objeto de tipo RegistroEspeS, que contiene los datos del
	 *            registro.
	 * @param d
	 *            Objeto de tipo ListaDocumentoS, que contiene los datos de la
	 *            lista de documentos.
	 * @param g
	 *            Objeto de tipo ListaGeneradorS, que contiene los datos de la
	 *            lista de generadores.
	 * @param a
	 *            Objeto de tipo ListaAutorizadoS, que contiene los datos de la
	 *            lista de autorizados.
	 * @return Cadena con el mensaje de error o de confirmaci�n.
	 */
	public String setRegistroEspe(RegistroEspeS res, ListaDocumentoS d,
			ListaGeneradorS g, ListaAutorizadoS a) {
		cargarCertificados();
		return r.setEspecifico(res, d, g, a, false);
	}

	/**
	 * M�todo para obtener el c�digo de contrataci�n e indexaci�n del paso anterior.
	 * 
	 * @param codGeneralAnte
	 *            Cadena con el c�digo general del paso anterior.
	 * @param codGeneral
	 *            Cadena con el c�digo general del paso actual.
	 * @return Cadena con el mensaje de error o con el c�digo de contrataci�n
	 */
	public String getPasoAnte(String codGeneralAnte, String codGeneral) {
		cargarCertificados();
		return r.getPasoAnte(codGeneralAnte, codGeneral);
	}

	/**
	 * M�todo para obtener el c�digo de contrataci�n.
	 * 
	 * @param rol
	 *            Cadena con c�digo de indexaci�n.
	 * @param codGeneralAnte
	 *            Cadena con el c�digo general del paso anterior.
	 * @return Cadena con el mensaje de error o con el c�digo de contrataci�n.
	 */
	public String getContratoTrabajador(String rol, String codGeneralAnte) {
		cargarCertificados();
		return r.getContratoTrabajador(rol, codGeneralAnte);
	}

	// VISOR DE EVENTOS
	/**
	 * M�todo para obtener el procedimiento.
	 * 
	 * @return Cadena con el mensaje de error o con el procedimiento.
	 */
	public String getProcedimiento() {
		cargarCertificados();
		return r.getProcedimiento();
	}

	/**
	 * M�todo para obtener el registro espec�fico.
	 * 
	 * @param codGeneral
	 *            Cadena con el c�digo general.
	 * @return Cadena con el mensaje de error o con el registo espec�fico.
	 */
	public String getRegistroEspe(String codGeneral) {
		cargarCertificados();
		return r.getRegistroEspe(codGeneral);
	}

	/**
	 * M�todo para obtener la lista de c�digos generales.
	 * 
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @return Cadena con el mensaje de error o con una cadena con los c�digos
	 *         generales.
	 */
	public String getListaCodGenerales(String proce) {
		cargarCertificados();
		return r.getListaCodGenerales(proce);
	}
	
	private void cargarCertificados(){
		// PONERLO CUANDO CLIENTE Y SERVIDOR ESTEN EN MAQUINAS DIFERENTES
//		 System.setProperty("javax.net.ssl.keyStore","cert/keystore");
//		 System.setProperty("javax.net.ssl.keyStorePassword","proyecto");
//		 System.setProperty("javax.net.ssl.trustStore","cert/truststore");
//		 System.setProperty("javax.net.ssl.trustStorePassword","proyecto");
	}

}
