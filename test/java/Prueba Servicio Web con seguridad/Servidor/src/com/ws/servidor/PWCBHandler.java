package com.ws.servidor;

import org.apache.ws.security.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import java.io.IOException;

/**
 * Clase para identificar al servidor.
 */
public class PWCBHandler implements CallbackHandler {

	/**
	 * Método que comprueba el usuario y contraseña de quien se conecta al servidor para ofrecer las respuestas del servicio.
	 */
	public void handle(Callback[] callbacks) throws IOException,
			UnsupportedCallbackException {

		for (int i = 0; i < callbacks.length;) {

			// To use the private key to sign messages, we need to provide
			// the private key password
			WSPasswordCallback pwcb = (WSPasswordCallback) callbacks[i];

			if (pwcb.getIdentifier().equals("map-test")) {
				pwcb.setPassword("proyecto");
				return;
			} else {  
                throw new UnsupportedCallbackException(callbacks[i], "fallo de autenticación en SERVIDOR");  
            } 
		}
	}
}