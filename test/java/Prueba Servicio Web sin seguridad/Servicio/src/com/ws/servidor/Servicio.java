package com.ws.servidor;

import base_de_datos.RegistroS;

public class Servicio {  
    
    public String info(RegistroS r){  
        return r.toString();  
    }  
      
    public RegistroS infoRegistro (String id){  
          
        RegistroS result = null;  
  
        if (id.compareToIgnoreCase("666")==0){  
            result = new RegistroS();  
            result.setId("666");  
            result.setDescripcion("La vida de Baal Zebub");  
            result.setPersona("Abraracurcix");  
        }  
          
        return result;  
    }  
  
}  