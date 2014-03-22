package ws.cliente;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import java.util.Date;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import ws.servidor.EchoServiceStub;

/**
 * <p>
 * Test.java <br/>
 * Clase que prueba la invocacion a nuestro web service de echo
 * </p>
 * 
 * 
 * @author Ivan Garcia Puebla - www.autentia.com
 * @version 1.0
 */

public class Test {

	private static Registro reg = null;

	/**
	 * Metodo principal de la clase
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Utilizamos el stub generado a partir del wsdl que logran establecer
		 * la conexion con el web service proveedor.
		 */
		EchoServiceStub customer = null;
		EchoServiceStub.LeerRegistro request = null;
		EchoServiceStub.LeerRegistroResponse response = null;
//		Formulario f = new Formulario();
//
//		// para centrar la pantalla
//		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		Dimension frameSize = f.getSize();
//		if (frameSize.height > screenSize.height) {
//			frameSize.height = screenSize.height;
//		}
//		if (frameSize.width > screenSize.width) {
//			frameSize.width = screenSize.width;
//		}
//		f.setLocation((screenSize.width - frameSize.width) / 2,
//				(screenSize.height - frameSize.height) / 2);
//		
//		// Para que el aspecto sea según donde se abra, unix, mac....
//		try {
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		}catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		// para hacerla visible
//		f.setVisible(true);
//		
//		//Recuperar registro
//		reg = f.getFormulario();
		DatoC dato = new DatoC();
		reg = new Registro();
		dato.setNombre("Juan");
		dato.setCorreo("jashdgj@kasjf.com");
		dato.setEdad(14);
		dato.setUrl("www.dshsdh.com");
		reg.setDato(dato);
		reg.setNumRegistro(new Date());
		Object obj = new Objeto (dato.getNombre(), dato.getCorreo(), dato.getEdad(), dato.getUrl());
		try {

			// creamos el soporte y la peticion
			customer = new EchoServiceStub();
			request = new EchoServiceStub.LeerRegistro();

			// establecemos el parametro de la invocacion
			request.setObj(obj);

			// invocamos al web service
			response = customer.leerRegistro(request);

			// mostramos la respuesta
			System.out.println(response.get_return());

		} catch (RemoteException excepcionDeInvocacion) {
			System.err.println(excepcionDeInvocacion.toString());
		}

	}

	// FUTURA INTERFAZ
	/*private static String leerRegistro() {
		// TODO Auto-generated method stub
		File f = new File("fichero.txt");
		String datos = "";
		Scanner s;
		try {
			s = new Scanner(f);

			// lectura del fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				// Aquí el tratamiento de la línea
				datos += ",";
				datos += linea;
			}

			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return datos;
	}*/
}
