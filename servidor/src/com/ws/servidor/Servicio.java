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
	 * Método que comprueba los roles.
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
	 * @return Un valor booleano dependiendo de como ha ido la operación
	 * @throws Exception
	 *             Genera una excepción genérica.
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
	 * Método para almacenar los registros automáticos.
	 * 
	 * @param reg
	 *            Cadena con el registro.
	 * @return Cadena con el mensaje de error o de confirmación.
	 */
	public String setRegistroAuto(String reg) {
		cargarCertificados();
		return r.setAuto(reg);
	}

	// ADMINISTRADOR
	/**
	 * Método para almacenar los registros del administrador.
	 * 
	 * @param ras
	 *            Objeto de tipo RegistroAdminS, que contiene los datos del
	 *            registro.
	 * @param d
	 *            Objeto de tipo ListaDocumentoS, que contiene los datos de la
	 *            lista de documentos.
	 * @param c
	 *            Objeto de tipo ListaCampoS, que contiene los datos de la lista
	 *            de información resumen.
	 * @param i
	 *            Objeto de tipo ListaIndicadorS, que contiene los datos de la
	 *            lista de indicadores.
	 * @param g
	 *            Objeto de tipo ListaGeneradorS, que contiene los datos de la
	 *            lista de generadores.
	 * @param a
	 *            Objeto de tipo ListaAutorizadoS, que contiene los datos de la
	 *            lista de autorizados.
	 * @return Cadena con el mensaje de error o de confirmación.
	 */
	public String setRegistroAdmin(RegistroAdminS ras, ListaDocumentoS d,
			ListaCampoS c, ListaIndicadorS i, ListaGeneradorS g,
			ListaAutorizadoS a) {
		cargarCertificados();
		return r.setAdmin(ras, d, c, i, g, a);
	}

	/**
	 * Método para obtener el registro general, según el proceso solicitado.
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
	 * Método para obtener el código de contrato.
	 * 
	 * @param proce
	 *            Cadena con el número de procedimiento.
	 * @return Cadena con el mensaje de error o el código de contrato.
	 * @throws Exception
	 *             Genera una excepción genérica.
	 */
	public int getCodContrato(String proce) throws Exception {
		cargarCertificados();
		return r.getContrato(proce);
	}

	/**
	 * Método para obtener el número de registro.
	 * 
	 * @param proce
	 *            Cadena con el número de procedimiento.
	 * @return Cadena con el mensaje de error o el número de registro.
	 * @throws Exception
	 *             Genera una excepción genérica.
	 */
	public int getNumRegistro(String proce) throws Exception {
		cargarCertificados();
		return r.getNumRegistro(proce);
	}

	/**
	 * Método para almacenar los registros específicos.
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
	 * @return Cadena con el mensaje de error o de confirmación.
	 */
	public String setRegistroEspe(RegistroEspeS res, ListaDocumentoS d,
			ListaGeneradorS g, ListaAutorizadoS a) {
		cargarCertificados();
		return r.setEspecifico(res, d, g, a, false);
	}

	/**
	 * Método para obtener el código de contratación e indexación del paso anterior.
	 * 
	 * @param codGeneralAnte
	 *            Cadena con el código general del paso anterior.
	 * @param codGeneral
	 *            Cadena con el código general del paso actual.
	 * @return Cadena con el mensaje de error o con el código de contratación
	 */
	public String getPasoAnte(String codGeneralAnte, String codGeneral) {
		cargarCertificados();
		return r.getPasoAnte(codGeneralAnte, codGeneral);
	}

	/**
	 * Método para obtener el código de contratación.
	 * 
	 * @param rol
	 *            Cadena con código de indexación.
	 * @param codGeneralAnte
	 *            Cadena con el código general del paso anterior.
	 * @return Cadena con el mensaje de error o con el código de contratación.
	 */
	public String getContratoTrabajador(String rol, String codGeneralAnte) {
		cargarCertificados();
		return r.getContratoTrabajador(rol, codGeneralAnte);
	}

	// VISOR DE EVENTOS
	/**
	 * Método para obtener el procedimiento.
	 * 
	 * @return Cadena con el mensaje de error o con el procedimiento.
	 */
	public String getProcedimiento() {
		cargarCertificados();
		return r.getProcedimiento();
	}

	/**
	 * Método para obtener el registro específico.
	 * 
	 * @param codGeneral
	 *            Cadena con el código general.
	 * @return Cadena con el mensaje de error o con el registo específico.
	 */
	public String getRegistroEspe(String codGeneral) {
		cargarCertificados();
		return r.getRegistroEspe(codGeneral);
	}

	/**
	 * Método para obtener la lista de códigos generales.
	 * 
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @return Cadena con el mensaje de error o con una cadena con los códigos
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
