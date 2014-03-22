package servidor;



import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class DatoEnBaseDatos {

    /** Conexion con la base de datos */  
    private Connection conn;
    
    /** Un Registro serializable */
    //private Registro reg = null;

    //cadena para numeros solos sin espacios
    //private String a;
    
    /** Establece conexion, guarda Datos en base de datos y luego lo lee */
    public DatoEnBaseDatos(Object obj) {
        
    	conn = Conexion.crearConexion();
        //Registro r = (Registro) reg;
        insertaDato(obj);
        leeDato();
        
        Conexion.desconectar(conn);
    }
    
   /*private void sinBlancos(String c) {
		// TODO Auto-generated method stub
	   a = "";
	   String cad = " ";
	   char aux = cad.charAt(0);
		for (int i = 0; i < c.length(); i++) {
			if(c.charAt(i) != aux){
				a += Character.toString(c.charAt(i));
				for (int j = i+1; j < c.length()-i; j++) {
					if(c.charAt(j) == aux){
						return;
					}
					a += Character.toString(c.charAt(j));
				}
			}
		}
	}*/

/* public void salvar(String c, String n, String k) throws SQLException{
		
		if(conn!=null){
			try{
				PreparedStatement ps = conn.prepareStatement("INSERT INTO DATOS values(?,?,?)");
				ps.setString(1,c);
				ps.setString(2,n);
				ps.setString(3,k);
				//ps.setString(4,String.valueOf(s));
				conn.setAutoCommit(true);
				ps.execute();
				ps.close();
			}finally{
				Conexion.desconectar(conn);
			}
		}else{
			JOptionPane.showMessageDialog(null,"No Hay Coneccion");
		}
	}*/
    
    /**
     * Crea y rellena un Registro con sus datos.
     */
   /* private void rellenaDato(String i, String n, String e) {
        Dato dato = new Dato();
        reg = new Registro();
        sinBlancos(i);
        //dato.setId(Integer.parseInt(a));
        dato.setNombre(n);
        sinBlancos(e);
        dato.setEdad(Integer.parseInt(a));
        reg.setDato(dato);
        reg.setNumRegistro("5dsthsadj");
    }*/
    
    /**
     * Inserta un Registro en la base de datos.
     */
    private void insertaDato(Object obj) {
        try {
            // El insert
            PreparedStatement ps = conn
                    .prepareStatement("insert into registro values (null, ?)");
            // Se obtiene el array de bytes de la clase Dato
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArray);
            oos.writeObject(obj);

            // Se inserta en bd
            ps.setBytes(1, byteArray.toByteArray());
            ps.execute();
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null,"No se puede insertar el registro\n"+e.getMessage());
        }
    }

    /**
     * Lee de base de datos un Registro y saca su contenido por pantalla.
     */
    private void leeDato() {
        try {
            // La consulta y bucle para recorrer resultados
            PreparedStatement ps = conn
                    .prepareStatement("select * from registro");
            ResultSet rs = ps.executeQuery();
            
         // Se saca por pantalla
            System.out.println("Los siguientes registros se han insertado \n");
            while (rs.next()) {

                // Se obtiene el campo blob
                Blob blob = rs.getBlob("objeto");

                // Se reconstruye el objeto con un ObjectInputStream
                ObjectInputStream ois = new ObjectInputStream(blob
                        .getBinaryStream());
                Registro reg = (Registro) ois.readObject();
                
                System.out.println(reg.toString());
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null,"No se puede leer el registro\n"+e.getMessage());
        }
    }
}
