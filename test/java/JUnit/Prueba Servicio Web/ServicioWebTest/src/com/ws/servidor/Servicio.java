package com.ws.servidor;

public class Servicio {  
    
    public String info(Registro r){  
        return r.toString();  
    }  
      
    public Registro infoRegistro (String id){  
          
        Registro result = null;  
  
        if (id.toUpperCase().equals("666")){  
            result = new Registro();  
            result.setId("666");  
            result.setDescripcion("La vida de Baal Zebub");  
            result.setPersona("Abraracurcix");  
        }  
          
        return result;  
    }  
  
}  