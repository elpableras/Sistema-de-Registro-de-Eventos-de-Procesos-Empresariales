package base_de_datos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestConexión {

	private BBDD conexion;
	String msg = "";
	
	@Before
	public void setUp(){
		//Con esto aplastas los certificados del correo
		System.setProperty("javax.net.ssl.keyStore","C:/Users/Jose/Desktop/BaseDatosSSL/BBDDSSL/cert/keystore");
		System.setProperty("javax.net.ssl.keyStorePassword","proyecto");
		System.setProperty("javax.net.ssl.trustStore","C:/Users/Jose/Desktop/BaseDatosSSL/BBDDSSL/cert/truststore");
		System.setProperty("javax.net.ssl.trustStorePassword","proyecto");		
		conexion = new BBDD();
	}

	@Test
	public void testConexion() {		
		assertEquals("Correcto", conexion.crearConexion());
	}
	
	@Test
	public void testSetCorreo(){
		assertEquals("Correcto", conexion.setCorreo());
	}
	
	@Test
	public void testGetCorreo(){
		assertEquals("usuario", conexion.getCorreo());
	}
	
	@Test
	public void testBorrarCorreo(){
		assertEquals("Correcto", conexion.borrarCorreo());
	}
	
	@Test
	public void testMandarCorreo(){
		assertEquals("Correcto", conexion.mandarCorreo());
	}
}
