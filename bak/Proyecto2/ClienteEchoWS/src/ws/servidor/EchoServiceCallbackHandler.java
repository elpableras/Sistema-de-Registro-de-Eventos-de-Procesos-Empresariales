
/**
 * EchoServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.5  Built on : May 28, 2011 (08:30:56 CEST)
 */

    package ws.servidor;

    /**
     *  EchoServiceCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class EchoServiceCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public EchoServiceCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public EchoServiceCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for leerRegistro method
            * override this method for handling normal response from leerRegistro operation
            */
           public void receiveResultleerRegistro(
                    ws.servidor.EchoServiceStub.LeerRegistroResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from leerRegistro operation
           */
            public void receiveErrorleerRegistro(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for despedir method
            * override this method for handling normal response from despedir operation
            */
           public void receiveResultdespedir(
                    ws.servidor.EchoServiceStub.DespedirResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from despedir operation
           */
            public void receiveErrordespedir(java.lang.Exception e) {
            }
                


    }
    