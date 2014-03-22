package servidor;

import java.sql.SQLException;
//import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Echo {
	
	private DatoEnBaseDatos dbd = null;

	/**
	 * Metodo que implementa la funcionalidad de leer registro
	 * 
	 * @param registro
	 *            Datos desde la aplicación cliente
	 * @return Los datos del registro
	 */
	public String leerRegistro(Object obj) {
		try {
			registrarDatos(obj);
			return "\n Servidor Llegada de Datos";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"ERROR Salvar los datos\n"+e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
		//return registro + "\n Servidor Llegada de Datos";
		return null;
	}
	
	
	
	private void registrarDatos(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		dbd = new DatoEnBaseDatos(obj);
	}



	/*private void dividirReg(Registro reg) throws SQLException {
		// TODO Auto-generated method stub
		String campo [] = new String [3] ;
		int cam = 0;
		StringTokenizer tokens = new StringTokenizer(registro, ",");  
		while(tokens.hasMoreTokens()){
			campo [i] = tokens.nextToken();
			if(cam==2){
				//String fecha = String.valueOf(new Date());
				//campo[4] = fecha;
				dbd = new DatoEnBaseDatos(campo[0], campo[1], campo[i]);
				cam = -1;
				i = -1;
			}
			i++;
			cam++;
		}  
	}*/
	
	/**
	 * 
	 * Metodo que implementa la funcionalidad de despedida
	 * 
	 * @param nombre
	 *            Nombre de la persona que invoca el servicio
	 * @return Cadena de despedida
	 */
	public String despedir(String nombre) {

		return "Adios " + nombre;
	}

}
