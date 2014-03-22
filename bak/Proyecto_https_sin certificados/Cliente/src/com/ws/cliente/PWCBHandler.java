package com.ws.cliente;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.ws.security.WSPasswordCallback;

public class PWCBHandler  implements CallbackHandler {

    public void handle(Callback[] callbacks) throws IOException,
            UnsupportedCallbackException {

        for (int i = 0; i < callbacks.length; i++) {
            
            // Client uses this callbackt o retrieve the password 
        	
            WSPasswordCallback pwcb = (WSPasswordCallback)callbacks[i];
         
            if(pwcb.getIdentifer().equals("servidor")) {
            	pwcb.setPassword("proyecto");
                return;
            }
        }
    }
}