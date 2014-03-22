package com.ws.servidor;


import com.ws.servidor.dato.ListaAutorizadoS;
import com.ws.servidor.dato.ListaGeneradorS;
import com.ws.servidor.dato.ListaCampoS;
import com.ws.servidor.dato.ListaDocumentoS;
import com.ws.servidor.dato.ListaIndicadorS;
import com.ws.servidor.dato.RegistroAdminS;
import com.ws.servidor.dato.RegistroEspeS;
import base_de_datos.Registrar;

public class Servicio {

	Registrar r = new Registrar();
	//PONERLO CUANDO CLIENTE Y SERVIDOR ESTEN EN MAQUINAS DIFERENTES
	//	System.setProperty("javax.net.ssl.keyStore","C:/Users/Jose/Desktop/BaseDatosSSL/BBDDSSL/cert/keystore");
	//	System.setProperty("javax.net.ssl.keyStorePassword","proyecto");
	//	System.setProperty("javax.net.ssl.trustStore","C:/Users/Jose/Desktop/BaseDatosSSL/BBDDSSL/cert/truststore");
	//	System.setProperty("javax.net.ssl.trustStorePassword","proyecto");
	
	// ROLES
	public boolean comprobarRol(String iden, String pass, boolean rol, String tipo) throws Exception{
		if(rol){
			return r.setRol(iden, pass, tipo);
		}else{
			return r.comprobarRol(iden, pass, tipo);
		}
	}
	
	
	
	// ADMINISTRADOR
	public String setRegistroAdmin(RegistroAdminS ras, ListaDocumentoS d, ListaCampoS c, ListaIndicadorS i, ListaGeneradorS g, ListaAutorizadoS a){	
		return r.setAdmin(ras,d,c,i,g,a);
	}
	
	public String getRegistroAdmin(String proce){
		return r.getAdmin(proce);
	}
	
	
	
	// ESPECIFICO
	public int getCodContrato(String proce) throws Exception{
		return r.getContrato(proce);
	}
	public int getNumRegistro(String proce) throws Exception{
		return r.getNumRegistro(proce);
	}
	
	
	
	public String setRegistroEspe(RegistroEspeS res, ListaDocumentoS d, ListaGeneradorS g, ListaAutorizadoS a){
		return r.setEspecifico(res,d,g,a);
	}
	public String getPasoAnte(String codGeneralAnte, String codGeneral){
		return r.getPasoAnte(codGeneralAnte, codGeneral);
	}	
	public String getContratoTrabajador(String rol, String codGeneralAnte) {
		return r.getContratoTrabajador(rol,codGeneralAnte);
	}
	
	
	
	
	
	// VISOR DE EVENTOS
	public String getProcedimiento(){
		return r.getProcedimiento();
	}
	
	public String getRegistroEspe(String codGeneral){
		return r.getRegistroEspe(codGeneral);
	}
	
	public String getListaCodGenerales(String proce){
		return r.getListaCodGenerales(proce);
	}
	
}
