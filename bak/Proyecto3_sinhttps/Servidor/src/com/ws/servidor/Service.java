package com.ws.servidor;

import org.apache.axis2.context.MessageContext;
import base_de_datos.RegistroServidor;
import base_de_datos.Tratar;
import com.ws.servidor.Comprobar_IP;

public class Service {

	private Comprobar_IP ip = new Comprobar_IP();

	public String registro(RegistroServidor rs) {

		// Comprobar IP
		String ipAddress = (String) (MessageContext.getCurrentMessageContext())
				.getProperty(MessageContext.REMOTE_ADDR);
		// System.out.println("\n\n\n"+ipAddress+"\n\n\n");
		// Como pasar el fichero????
		if (ip.leerIP(ipAddress) || ipAddress.compareTo("127.0.0.1") == 0) {

			registrarDatos(rs);
			return "[Registro] " + " |" + " Cod. Interno " + rs.getCod() + " |"
					+ " Nombre " + rs.getNombre() + " | Email "
					+ rs.getCorreo() + "| Edad " + rs.getEdad() + "| URL "
					+ rs.getUrl();

		}
		return "\nACCESO DENEGADO\n";
	}

	private void registrarDatos(RegistroServidor rs) {
		// TODO Auto-generated method stub
		new Tratar(rs);
	}
}
