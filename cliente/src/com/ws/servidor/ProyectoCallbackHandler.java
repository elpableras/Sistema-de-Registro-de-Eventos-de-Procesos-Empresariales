
/**
 * ProyectoCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.5  Built on : May 28, 2011 (08:30:56 CEST)
 */

    package com.ws.servidor;

    /**
     *  ProyectoCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ProyectoCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ProyectoCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ProyectoCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for getNumRegistro method
            * override this method for handling normal response from getNumRegistro operation
            */
           public void receiveResultgetNumRegistro(
                    com.ws.servidor.ProyectoStub.GetNumRegistroResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getNumRegistro operation
           */
            public void receiveErrorgetNumRegistro(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getCodContrato method
            * override this method for handling normal response from getCodContrato operation
            */
           public void receiveResultgetCodContrato(
                    com.ws.servidor.ProyectoStub.GetCodContratoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getCodContrato operation
           */
            public void receiveErrorgetCodContrato(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRegistroEspe method
            * override this method for handling normal response from getRegistroEspe operation
            */
           public void receiveResultgetRegistroEspe(
                    com.ws.servidor.ProyectoStub.GetRegistroEspeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRegistroEspe operation
           */
            public void receiveErrorgetRegistroEspe(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getPasoAnte method
            * override this method for handling normal response from getPasoAnte operation
            */
           public void receiveResultgetPasoAnte(
                    com.ws.servidor.ProyectoStub.GetPasoAnteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getPasoAnte operation
           */
            public void receiveErrorgetPasoAnte(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getContratoTrabajador method
            * override this method for handling normal response from getContratoTrabajador operation
            */
           public void receiveResultgetContratoTrabajador(
                    com.ws.servidor.ProyectoStub.GetContratoTrabajadorResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getContratoTrabajador operation
           */
            public void receiveErrorgetContratoTrabajador(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getListaCodGenerales method
            * override this method for handling normal response from getListaCodGenerales operation
            */
           public void receiveResultgetListaCodGenerales(
                    com.ws.servidor.ProyectoStub.GetListaCodGeneralesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getListaCodGenerales operation
           */
            public void receiveErrorgetListaCodGenerales(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getProcedimiento method
            * override this method for handling normal response from getProcedimiento operation
            */
           public void receiveResultgetProcedimiento(
                    com.ws.servidor.ProyectoStub.GetProcedimientoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getProcedimiento operation
           */
            public void receiveErrorgetProcedimiento(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for getRegistroAdmin method
            * override this method for handling normal response from getRegistroAdmin operation
            */
           public void receiveResultgetRegistroAdmin(
                    com.ws.servidor.ProyectoStub.GetRegistroAdminResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from getRegistroAdmin operation
           */
            public void receiveErrorgetRegistroAdmin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setRegistroAdmin method
            * override this method for handling normal response from setRegistroAdmin operation
            */
           public void receiveResultsetRegistroAdmin(
                    com.ws.servidor.ProyectoStub.SetRegistroAdminResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setRegistroAdmin operation
           */
            public void receiveErrorsetRegistroAdmin(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setRegistroAuto method
            * override this method for handling normal response from setRegistroAuto operation
            */
           public void receiveResultsetRegistroAuto(
                    com.ws.servidor.ProyectoStub.SetRegistroAutoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setRegistroAuto operation
           */
            public void receiveErrorsetRegistroAuto(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for comprobarRol method
            * override this method for handling normal response from comprobarRol operation
            */
           public void receiveResultcomprobarRol(
                    com.ws.servidor.ProyectoStub.ComprobarRolResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from comprobarRol operation
           */
            public void receiveErrorcomprobarRol(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for setRegistroEspe method
            * override this method for handling normal response from setRegistroEspe operation
            */
           public void receiveResultsetRegistroEspe(
                    com.ws.servidor.ProyectoStub.SetRegistroEspeResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from setRegistroEspe operation
           */
            public void receiveErrorsetRegistroEspe(java.lang.Exception e) {
            }
                


    }
    