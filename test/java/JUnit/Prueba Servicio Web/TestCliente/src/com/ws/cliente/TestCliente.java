package com.ws.cliente;

import java.rmi.RemoteException;

import com.ws.servidor.TestStub;
import com.ws.servidor.TestStub.Registro;

public class TestCliente {  
	  
    public String infoin(){  
      
        /* 
         * Utilizamos el stub generado a partir del wsdl que logran establecer 
         * la conexion con el web service proveedor. 
         */  
        TestStub ts = null;  
        TestStub.Info request = null;  
        TestStub.InfoResponse response = null;  
  
        try {  
            // creamos el soporte y la peticion  
            ts = new TestStub();  
            request = new TestStub.Info();  
  
            // establecemos el parametro de la invocacion  
            Registro r = new Registro();
            r.setId("666");
            r.setDescripcion("La vida de Baal Zebub");
            r.setPersona("Abraracurcix");  
          
            request.setR(r);  
              
            // invocamos al web service  
            response = ts.info(request);
  
            // mostramos la respuesta  
            return "Correcto";
            
  
        } catch (RemoteException excepcionDeInvocacion) {  
            return(excepcionDeInvocacion.toString());  
        }  
  
          
    }  
      
    public String infout(){  
          
    	String msg = "";
        /* 
         * Utilizamos el stub generado a partir del wsdl que logran establecer 
         * la conexion con el web service proveedor. 
         */  
    	TestStub ts = null;  
    	TestStub.InfoRegistro request = null;  
    	TestStub.InfoRegistroResponse response = null;  
  
        try {  
            // creamos el soporte y la peticion  
            ts = new TestStub();  
            request = new TestStub.InfoRegistro();  
  
            // establecemos el parametro de la invocacion  
            request.setId("666");  
              
            // invocamos al web service  
            response = ts.infoRegistro(request);  
  
            Registro r = response.get_return();  
              
            if (r != null){  
              msg += r.getId() + " " + r.getDescripcion() + " " + r.getPersona();
              return msg;
            }  
            else {  
                return("No existe ese Registro");  
            }  
              
        } catch (RemoteException excepcionDeInvocacion) {  
            return(excepcionDeInvocacion.toString());  
        }  
  
          
    }   
}  
