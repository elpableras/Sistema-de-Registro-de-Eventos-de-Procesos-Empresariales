package com.ws.cliente;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.rmi.RemoteException;
import javax.swing.UIManager;
import com.ws.servidor.ServicioRegistroStub;
import com.ws.servidor.ServicioRegistroStub.RegistroServidor;

public class Cliente {

	private static void registro() {

		Formulario f = new Formulario();

		// para centrar la pantalla
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = f.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		f.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);

		// Para que el aspecto sea según donde se abra, unix, mac....
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// para hacerla visible
		f.setVisible(true);

		/*
		 * Utilizamos el stub generado a partir del wsdl que logran establecer
		 * la conexion con el web service proveedor.
		 */
		ServicioRegistroStub customer = null;
		ServicioRegistroStub.Registro request = null;
		ServicioRegistroStub.RegistroResponse response = null;

		try {
			// creamos el soporte y la peticion
			customer = new ServicioRegistroStub();
			request = new ServicioRegistroStub.Registro();

			// establecemos el parametro de la invocacion cogemos datos del
			// formulario
			RegistroServidor rs = new RegistroServidor();
			
			rs.setCod(f.getRC().getCod());
			rs.setNombre(f.getRC().getNombre());
			rs.setCorreo(f.getRC().getCorreo());
			rs.setEdad(f.getRC().getEdad());
			rs.setUrl(f.getRC().getUrl());

			request.setRs(rs);

			// invocamos al web service
			response = customer.registro(request);

			// mostramos la respuesta
			System.out.println(response.get_return());

		} catch (RemoteException excepcionDeInvocacion) {
			System.err.println(excepcionDeInvocacion.toString());
		}

	}

	public static void main(String[] args) {
		registro();
	}
}
