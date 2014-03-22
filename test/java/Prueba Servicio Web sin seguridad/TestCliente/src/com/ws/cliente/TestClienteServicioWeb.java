package com.ws.cliente;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestClienteServicioWeb {

	private TestCliente tc;
	
	@Before
	public void cargarDatos(){
		tc = new TestCliente();
	}
	
	@Test
	public void testGetCliente() {
		assertEquals("Correcto", tc.infoin());
		assertEquals("666 La vida de Baal Zebub Abraracurcix", tc.infout());
	}
	
	

}
