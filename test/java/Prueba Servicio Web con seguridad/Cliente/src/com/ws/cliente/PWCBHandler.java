package com.ws.cliente;

import org.apache.ws.security.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import java.io.IOException;

/**
 * Clase para identificar al cliente.
 */
public class PWCBHandler implements CallbackHandler {

	/**
	 * M�todo que comprueba el usuario y contrase�a de quien se conecta al servidor para pedir las peticiones de servicio.
	 */
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {

		for (int i = 0; i < callbacks.length;) {

			//Autenticaci�n del usuario y contrase�a 
			WSPasswordCallback pwcb = (WSPasswordCallback) callbacks[i];

			//comprobaciones de usuario y contrase�a para acceso al servicio
			if (pwcb.getIdentifier().equals("cliente")){
					pwcb.setPassword("proyecto");
				//comprobaciones de usuario y contrase�a para acceso al servicio
				return;
			} else {  
                throw new UnsupportedCallbackException(callbacks[i], "fallo de autenticaci�n en CLIENTE");  
            }  

		}
	}
}