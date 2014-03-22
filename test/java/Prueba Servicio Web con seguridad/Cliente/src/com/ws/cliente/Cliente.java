package com.ws.cliente;

import java.rmi.RemoteException;

import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyEngine;
import org.apache.rampart.RampartMessageData;

import com.ws.servidor.ServicioStub;
import com.ws.servidor.ServicioStub.RegistroS;

public class Cliente {  
	
	private static ServicioStub stub;
	private static String repo = "repo";
	private static String EPR = "http://localhost:8080/axis2/services/Servicio";
	private static String policyPath = "policy/policy.xml";
	
	/**
	 * Carga los certificados, para conectarse al servidor.
	 */
	private static void cargarCertificados() {
		// PONER EL MISMO TAMBIEN PARA LA BASE DE DATOS
		// PARA EL CERTIFICADO, UTILIZANDO LA KEYSTORE, TRUSTSTORE
		System.setProperty("javax.net.ssl.trustStoreType", "JKS");
		System.setProperty("javax.net.ssl.trustStore",
				"C:/apache-tomcat-7.0.21/conf/truststore-proyecto2.jks");
		System.setProperty("javax.Vnet.ssl.trustStorePassword", "proyecto");
		System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
		System.setProperty("javax.net.ssl.keyStore",
				"C:/apache-tomcat-7.0.21/conf/cliente.p12");
		System.setProperty("javax.net.ssl.keyStorePassword", "proyecto");
	}
	
	/**
	 * Carga el fichero de politica desde el classpath.
	 * 
	 * @throws Exception
	 *             Genera una excepción genérica.
	 */
	private static Policy loadPolicy(String xmlPath) throws Exception {
		StAXOMBuilder builder = new StAXOMBuilder(xmlPath);
		return PolicyEngine.getPolicy(builder.getDocumentElement());
	}
	  
    public static String infoin(){  
    	
    	try {
			ConfigurationContext ctx = ConfigurationContextFactory
					.createConfigurationContextFromFileSystem(repo, null);
			stub = new ServicioStub(ctx, EPR);
			ServiceClient sc = stub._getServiceClient();
			
			// AJUSTAMOS LAS PROPIEDADES AL CLIENTE DEL SERVICIO
			Options options = new Options();
			options.setAction("urn:info");
			options.setTo(new EndpointReference(EPR));
			options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
					loadPolicy(policyPath));
			sc.setOptions(options);

			// CARGAMOS LOS MODULOS
			sc.engageModule("rampart");
			sc.engageModule("addressing");
			sc.engageModule("rahas");
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return e.getLocalizedMessage();
		}
      
        /* 
         * Utilizamos el stub generado a partir del wsdl que logran establecer 
         * la conexion con el web service proveedor. 
         */  
    	ServicioStub.Info request = null;  
    	ServicioStub.InfoResponse response = null;  
  
        try {  
            // creamos el soporte y la peticion    
            request = new ServicioStub.Info();  
  
            // establecemos el parametro de la invocacion  
            RegistroS r = new RegistroS();
            r.setId("666");
            r.setDescripcion("La vida de Baal Zebub");
            r.setPersona("Abraracurcix");  
          
            request.setR(r);  
              
            // invocamos al web service  
            response = stub.info(request);
  
            // mostramos la respuesta  
            return response.get_return();
            
  
        } catch (RemoteException excepcionDeInvocacion) {  
            return(excepcionDeInvocacion.toString());  
        }  
  
          
    }  
      
    public static String infout(){  
          
    	String msg = "";
        /* 
         * Utilizamos el stub generado a partir del wsdl que logran establecer 
         * la conexion con el web service proveedor. 
         */  
    	ServicioStub ts = null;  
    	ServicioStub.InfoRegistro request = null;  
    	ServicioStub.InfoRegistroResponse response = null;  
  
        try {  
            // creamos el soporte y la peticion  
            ts = new ServicioStub();  
            request = new ServicioStub.InfoRegistro();  
  
            // establecemos el parametro de la invocacion  
            request.setId("666");  
              
            // invocamos al web service  
            response = ts.infoRegistro(request);  
  
            RegistroS r = response.get_return();  
              
            if (r != null){  
              msg += "Con Id: " + r.getId() + " Tenemos: " + r.getDescripcion() + " " + r.getPersona();
              return msg;
            }  
            else {  
                return("No existe ese Registro");  
            }  
              
        } catch (RemoteException excepcionDeInvocacion) {  
            return(excepcionDeInvocacion.toString());  
        }  
    }   
    
    public static void main(String[] args) {  
    	// Carga Certificados
    	cargarCertificados();
        System.out.println("Primer Servicio: " + infoin () + "\n\n");  
        //System.out.println("Segundo Servicio: " + infout() + "\n\n");  
    }  
}  
