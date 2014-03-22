package com.ws.cliente;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.Properties;

import javax.swing.UIManager;
import javax.xml.stream.XMLStreamException;


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
import org.apache.rampart.policy.model.CryptoConfig;
import org.apache.rampart.policy.model.RampartConfig;

import com.ws.servidor.ServicioSeguroStub;
import com.ws.servidor.ServicioSeguroStub.RegistroServidor;


public class Cliente {

	public static void main(String[] args) {
		
		//PARA EL CERTIFICADO, UTILIZANDO LA KEYSTORE
		System.setProperty("javax.net.ssl.trustStore", "key/servidor.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "proyecto");
		//System.setProperty("javax.net.ssl.trustStoreType", "JKS"); 

		Formulario f = new Formulario();

		// para centrar la pantalla
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = f.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		f.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);

		// Para que el aspecto sea según donde se abra, unix, mac....
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// para hacerla visible
		f.setVisible(true);

		/*
		 * Utilizamos el stub generado a partir del wsdl que logran establecer
		 * la conexion con el web service proveedor.
		 */
		
		String repo = "repo"; 
		String EPR = "https://localhost:8443/axis2/services/ServicioSeguro"; 
		String policyPath = "policy/policy.xml";
		
		try {
			// Rampart module should be in the repository
			ConfigurationContext ctx = ConfigurationContextFactory.createConfigurationContextFromFileSystem(repo, null);
			ServicioSeguroStub stub = new ServicioSeguroStub(ctx, EPR);
			ServiceClient sc = stub._getServiceClient();
			
			//Setting the properties to the service client.  
//			Options options = new Options(); 
//			options.setAction("urn:registro"); 
//			options.setTo(new EndpointReference(EPR)); 
//			options.setProperty(RampartMessageData.KEY_RAMPART_POLICY, loadPolicy(policyPath)); 
//			sc.setOptions(options); 

			// policy
			sc.getAxisService().applyPolicy(loadPolicy(policyPath));
			
			// engage modules
			sc.engageModule("rampart");
			//sc.engageModule("addressing"); 
			
			
			// set the username and password for requests which use them
	        Options options = sc.getOptions();
	        options.setUserName("servidor");
	        options.setPassword("proyecto");			
			
			
			
			ServicioSeguroStub.Registro request = null;
			ServicioSeguroStub.RegistroResponse response = null;
			
			// creamos el soporte y la peticion 
			request = new ServicioSeguroStub.Registro();

			// establecemos el parametro de la invocacion cogemos datos del
			// formulario
			RegistroServidor rs = new RegistroServidor();
			
			rs.setCod(f.getRC().getCod());
			rs.setNombre(f.getRC().getNombre());
			rs.setCorreo(f.getRC().getCorreo());
			rs.setEdad(f.getRC().getEdad());
			rs.setUrl(f.getRC().getUrl());
			
			
			request.setRs(rs);
			
			// invocamos al web service
			response = stub.registro(request);
			
			// mostramos la respuesta
			System.out.println(response.get_return());
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (RemoteException excepcionDeInvocacion) {
			System.err.println(excepcionDeInvocacion.toString());
		}	

	}
	
	/**
     * Load policy file from classpath.
     */	
	private static Policy loadPolicy(String p) {
		// TODO Auto-generated method stub
		RampartConfig rampartConfig = new RampartConfig();
		
		Properties merlinProp = new Properties();  
		merlinProp.put("org.apache.ws.security.crypto.merlin.keystore.type", "JKS");  
		merlinProp.put("org.apache.ws.security.crypto.merlin.file","key/cliente.jks");  
		merlinProp.put("org.apache.ws.security.crypto.merlin.keystore.password", "proyecto"); 
		
		CryptoConfig cryptoConfig = new CryptoConfig();  
		cryptoConfig.setProvider("org.apache.ws.security.components.crypto.Merlin");  
		cryptoConfig.setProp(merlinProp);
		
		rampartConfig.setUser("cliente"); 
		rampartConfig.setEncryptionUser("servidor");
		rampartConfig.setPwCbClass("com.ws.cliente.PWCBHandler");
		rampartConfig.setSigCryptoConfig(cryptoConfig); 
		rampartConfig.setEncrCryptoConfig(cryptoConfig);
		rampartConfig.setTimestampTTL("360");
		
		StAXOMBuilder builder;
		try {
			builder = new StAXOMBuilder(p);
			Policy policy = PolicyEngine.getPolicy(builder.getDocumentElement());
			policy.addAssertion(rampartConfig);
			return policy;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return null;
	}

//	private static Policy loadPolicy(String xmlPath){ 
//		try {
//			StAXOMBuilder builder = new StAXOMBuilder(xmlPath);
//			return PolicyEngine.getPolicy(builder.getDocumentElement());
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			System.err.println(e.getMessage());
//		} catch (XMLStreamException e) {
//			// TODO Auto-generated catch block
//			System.err.println(e.getMessage());
//		}
//		return null;		 
//	}

	private static Policy getRampartConfig(){
		
		RampartConfig rampartConfig = new RampartConfig();
		rampartConfig.setUser("cliente");
		rampartConfig.setEncryptionUser("servidor");
		rampartConfig.setPwCbClass("com.ws.cliente.PWCBHandler");
		
		CryptoConfig sigCrypto = new CryptoConfig();
		sigCrypto.setProvider("org.apache.ws.security.components.crypto.Merlin");

		Properties props = new Properties();
		props.setProperty("org.apache.ws.security.crypto.merlin.keystore.type", "JKS");
		props.setProperty("org.apache.ws.security.crypto.merlin.file","key/cliente.jks");
		props.setProperty("org.apache.ws.security.crypto.merlin.keystore.password", "proyecto");

		sigCrypto.setProp(props);

		rampartConfig.setSigCryptoConfig(sigCrypto);

		Policy policy = new Policy();
		policy.addAssertion(rampartConfig);	
		
		return policy;
	}
}
