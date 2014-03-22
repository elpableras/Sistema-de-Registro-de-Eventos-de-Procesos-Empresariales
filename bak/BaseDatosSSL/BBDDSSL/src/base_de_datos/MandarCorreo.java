package base_de_datos;


import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Ejemplo de envio de un correo de texto con datos adjuntos con javamail
 * 
 * @author YOP
 * 
 */
public class MandarCorreo {
	/**
	 * @param args
	 * @throws Exception 
	 * 
	 */
	public String correo(String asunto, String correo, String usuario, String pass) throws Exception {
		try {
			// se obtiene el objeto Session. La configuración es para
			// una cuenta de gmail.
			Properties props = System.getProperties();
			// props.put("mail.smtp.host", "relay.uniovi.es");
			// NOMBRE DEL HOST DE CORREO
			props.put("mail.smtp.host", "smtp.gmail.com");
			// TLS SI ESTA DISPONIBLE
			props.setProperty("mail.smtp.starttls.enable", "true");
			// PUERTO PARA ENVIO
			props.setProperty("mail.smtp.port", "587");
			// NOMBRE DE USUARIO
			props.setProperty("mail.smtp.user", usuario);
			// SI REQUIERE O NO USUARIO Y PASSWORD
			props.setProperty("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props, null);
			// session.setDebug(true);

			// Se compone la parte del texto
			BodyPart texto = new MimeBodyPart();

			// Datos del cambio de rango
			texto.setText(correo);

			// Una MultiParte para agrupar texto e imagen.
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);

			// Se compone el correo, dando to, from, subject y el
			// contenido.
			MimeMessage message = new MimeMessage(session);
			// PUEDES MANDAR AL METODO LAS DIRECCIONES A LOS QUE QUIERES ENVIAR
			// utilizar metodo list()
			Address[] direcciones = new Address[] { new InternetAddress(usuario) };
			message.addRecipients(Message.RecipientType.TO, direcciones);
			message.setFrom(new InternetAddress(usuario, "Pablo"));
			message.setSubject(asunto);
			message.setContent(multiParte);

			// Se envia el correo.
			Transport t = session.getTransport("smtp");
			// CONECTARSE A GMAIL COGIENDO DATOS DE LA BASE DE DATOS
			t.connect(usuario, pass);
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			return (" Mensaje de Correo Enviado");
		} catch (Exception e) {
			throw new Exception(" ERROR MandarCorreo CORREO correo() "
					+ e.getMessage());
		}
	}
}
