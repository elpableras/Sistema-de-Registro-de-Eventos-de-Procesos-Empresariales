package base_de_datos;

public class RegistroS {  
	  
    private String id;  
    private String descripcion;  
    private String persona;  
      
    public RegistroS() {  
        super();  
    }  
  
    public String getId() {  
        return id;  
    }  
  
    public void setId(String id) {  
        this.id = id;  
    }  
  
    public String getDescripcion() {  
        return descripcion;  
    }  
  
    public void setDescripcion(String descripcion) {  
        this.descripcion = descripcion;  
    }  
  
    public String getPersona() {  
        return persona;  
    }  
  
    public void setPersona(String persona) {  
        this.persona = persona;  
    }  
    
    public String toString(){
    	String cad = "";
    	
    	cad += "[Registro]" + " Identificador: " + id + " Descripcion: " + descripcion + " Persona: " + persona;
    	return cad;
    }
}  
