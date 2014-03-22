
/**
 * ServicioSeguroCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.5  Built on : May 28, 2011 (08:30:56 CEST)
 */

    package com.ws.servidor;

    /**
     *  ServicioSeguroCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ServicioSeguroCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ServicioSeguroCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ServicioSeguroCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for registro method
            * override this method for handling normal response from registro operation
            */
           public void receiveResultregistro(
                    com.ws.servidor.ServicioSeguroStub.RegistroResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from registro operation
           */
            public void receiveErrorregistro(java.lang.Exception e) {
            }
                


    }
    