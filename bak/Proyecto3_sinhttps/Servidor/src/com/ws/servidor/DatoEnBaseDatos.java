package com.ws.servidor;



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
    
    /** Establece conexion, guarda Datos en base de datos y luego lo lee */
    public DatoEnBaseDatos(Dato dato) {
        
    	conn = Conexion.crearConexion();
    	
        insertaDato(dato);
        leeDato();
        
        Conexion.desconectar(conn);
    }
    
    
    /**
     * Inserta un Registro en la base de datos.
     */
    private void insertaDato(Dato dato) {
        try {
            // El insert
            PreparedStatement ps = conn
                    .prepareStatement("insert into registro values (null, ?)");
            // Se obtiene el array de bytes de la clase Dato
            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArray);
            oos.writeObject(dato);

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
                Dato dato = (Dato) ois.readObject();
                
                System.out.println(dato.toString());
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null,"No se puede leer el registro\n"+e.getMessage());
        }
    }
}
