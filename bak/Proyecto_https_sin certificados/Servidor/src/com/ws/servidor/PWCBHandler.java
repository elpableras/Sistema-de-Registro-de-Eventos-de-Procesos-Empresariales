package com.ws.servidor;

import org.apache.ws.security.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import java.io.IOException;

public class PWCBHandler implements CallbackHandler {

    public void handle(Callback[] callbacks) throws IOException,
            UnsupportedCallbackException {

        for (int i = 0; i < callbacks.length; i++) {
            
            //When the server side need to authenticate the user
            WSPasswordCallback pwcb = (WSPasswordCallback)callbacks[i];
            
            // For plain text password scenarios
            if (pwcb.getUsage() == WSPasswordCallback.USERNAME_TOKEN_UNKNOWN) {
                if(pwcb.getIdentifer().equals("servidor") && pwcb.getPassword().equals("proyecto")) {
                    //If authentication successful, simply return
                    return;
                } else {
                    throw new UnsupportedCallbackException(callbacks[i], "check failed");
                }
                
            // For digested password scenarios    
            } else if (pwcb.getUsage() == WSPasswordCallback.USERNAME_TOKEN ) {
                if(pwcb.getIdentifer().equals("servidor") ) {
                    //We simply set the password, Username Token processor verifies the digest
                	pwcb.setPassword("proyecto");
                    return;
                }
            }
        }
    }

}
