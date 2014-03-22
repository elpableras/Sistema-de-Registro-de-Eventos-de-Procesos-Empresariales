
/**
 * TestCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.5  Built on : May 28, 2011 (08:30:56 CEST)
 */

    package com.ws.servidor;

    /**
     *  TestCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class TestCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public TestCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public TestCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for infoRegistro method
            * override this method for handling normal response from infoRegistro operation
            */
           public void receiveResultinfoRegistro(
                    com.ws.servidor.TestStub.InfoRegistroResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from infoRegistro operation
           */
            public void receiveErrorinfoRegistro(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for info method
            * override this method for handling normal response from info operation
            */
           public void receiveResultinfo(
                    com.ws.servidor.TestStub.InfoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from info operation
           */
            public void receiveErrorinfo(java.lang.Exception e) {
            }
                


    }
    