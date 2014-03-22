package com.ws.cliente;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.UIManager;
import org.apache.axiom.om.impl.builder.StAXOMBuilder;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.ConfigurationContextFactory;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.neethi.Policy;
import org.apache.neethi.PolicyEngine;
import org.apache.rampart.RampartMessageData;

import com.ws.cliente.dato.ListaAutorizadoC;
import com.ws.cliente.dato.ListaCampoC;
import com.ws.cliente.dato.ListaDocumentoC;
import com.ws.cliente.dato.ListaGeneradorC;
import com.ws.cliente.dato.ListaIndicadorC;
import com.ws.cliente.dato.RegistroAdminC;
import com.ws.cliente.dato.RegistroEspeC;
import com.ws.cliente.form.Inicio;
import com.ws.cliente.form.PantallaAdmin;
import com.ws.cliente.form.PantallaGerente;
import com.ws.cliente.form.PantallaRRHH;
import com.ws.cliente.form.PantallaTrabajador;
import com.ws.cliente.form.VisorEventos;
import com.ws.servidor.ProyectoStub;
import com.ws.servidor.ProyectoStub.GetCodContrato;
import com.ws.servidor.ProyectoStub.GetCodContratoResponse;
import com.ws.servidor.ProyectoStub.GetContratoTrabajador;
import com.ws.servidor.ProyectoStub.GetContratoTrabajadorResponse;
import com.ws.servidor.ProyectoStub.GetListaCodGenerales;
import com.ws.servidor.ProyectoStub.GetListaCodGeneralesResponse;
import com.ws.servidor.ProyectoStub.GetNumRegistro;
import com.ws.servidor.ProyectoStub.GetNumRegistroResponse;
import com.ws.servidor.ProyectoStub.GetPasoAnte;
import com.ws.servidor.ProyectoStub.GetPasoAnteResponse;
import com.ws.servidor.ProyectoStub.GetProcedimientoResponse;
import com.ws.servidor.ProyectoStub.GetRegistroEspe;
import com.ws.servidor.ProyectoStub.GetRegistroEspeResponse;
import com.ws.servidor.ProyectoStub.ListaAutorizadoS;
import com.ws.servidor.ProyectoStub.ComprobarRol;
import com.ws.servidor.ProyectoStub.ComprobarRolResponse;
import com.ws.servidor.ProyectoStub.ListaGeneradorS;
import com.ws.servidor.ProyectoStub.GetRegistroAdmin;
import com.ws.servidor.ProyectoStub.ListaCampoS;
import com.ws.servidor.ProyectoStub.ListaDocumentoS;
import com.ws.servidor.ProyectoStub.ListaIndicadorS;
import com.ws.servidor.ProyectoStub.RegistroEspeS;
import com.ws.servidor.ProyectoStub.SetRegistroAdmin;
import com.ws.servidor.ProyectoStub.GetRegistroAdminResponse;
import com.ws.servidor.ProyectoStub.RegistroAdminS;
import com.ws.servidor.ProyectoStub.SetRegistroAdminResponse;
import com.ws.servidor.ProyectoStub.SetRegistroAuto;
import com.ws.servidor.ProyectoStub.SetRegistroAutoResponse;
import com.ws.servidor.ProyectoStub.SetRegistroEspe;
import com.ws.servidor.ProyectoStub.SetRegistroEspeResponse;

/**
 * Clase Principal.
 * 
 * @author Pablo González.
 */
public class Cliente {

	private String usuario = "";
	private boolean cerrar = false;
	private boolean pantalla = false;

	// Lista de Pantallas
	private Inicio i;
	private PantallaAdmin v1;
	private PantallaRRHH v2;
	private PantallaGerente v3;
	private PantallaTrabajador v4;
	private VisorEventos v5;

	// Lista de Procesos
	private RegistroAdminC rac = new RegistroAdminC();
	private RegistroEspeC rec = new RegistroEspeC();

	// Lista de Listas
	private ListaDocumentoC ldc = new ListaDocumentoC();
	private ListaCampoC lcc = new ListaCampoC();
	private ListaIndicadorC lic = new ListaIndicadorC();
	private ListaGeneradorC lgc = new ListaGeneradorC();
	private ListaAutorizadoC lac = new ListaAutorizadoC();

	// Servicio Web
	private ProyectoStub stub;
	private RegistroAdminS ras;
	private RegistroEspeS res;
	private ListaDocumentoS lds;
	private ListaCampoS lcs;
	private ListaIndicadorS lis;
	private ListaGeneradorS lgs;
	private ListaAutorizadoS las;

	private String repo = "repo";
	// CAMBIAR LA IP POR DONDE SE ENCUENTRE EL SERVIDOR salon de actos  156.35.94.94
	private String EPR = "https://localhost:8443/axis2/services/Proyecto";
	private String policyPath = "policy/policy.xml";

	/**
	 * Main.
	 * 
	 * @param args
	 *            Array de argumentos.
	 * @throws Exception
	 *             Se genera una excepción genérica.
	 */
	public static void main(String[] args) throws Exception {
		/**
		 * Constructor de un objeto no estático.
		 */
		new Cliente();
	}

	/**
	 * Cliente para test
	 */
	public Cliente(int test) {

	}

	/**
	 * Constructor por defecto.
	 */
	public Cliente() {

		// Carga Certificados
		cargarCertificados();

		do {
			this.usuario = "";
			// Carga Pantalla Inicial
			cargarInicio(this);
			
			// Según el usuario, carga su Pantalla
			cargarPanatallaRol();
			
			
			/**
			 * Dependiendo del rol, llama a un método o a otro y espera a que
			 * cierre la ventana.
			 */
			if(pantalla){				
				dormirHilo();
				if (usuario.compareTo("Admin") == 0 && !v1.isCerrar()) {
					setCerrar(false);
					do {
						setAdmin();
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						dormirHilo();
					} while (!cerrar);
	
				} else if (usuario.compareTo("RRHH") == 0 && !v2.isCerrar()) {
					setCerrar(false);
					do {
						setRegistroEspe(usuario);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						dormirHilo();
					} while (!cerrar);
	
				} else if (usuario.compareTo("Gerente") == 0 && !v3.isCerrar()) {
					setCerrar(false);
					do {
						setRegistroEspe(usuario);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						dormirHilo();
					} while (!cerrar);
	
				} else if ((usuario.compareTo("Admin") != 0)
						&& (usuario.compareTo("RRHH") != 0)
						&& (usuario.compareTo("Gerente") != 0)
						&& (usuario.compareTo("") != 0) && !v4.isCerrar()) {
					setCerrar(false);
					do {
						setRegistroEspe(usuario);
						try {
							Thread.sleep(2000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						dormirHilo();
					} while (!cerrar);
	
				}
			}// IF PANTALLAS
		} while (i.isCerrar() == false);
	}

	/**
	 * Carga la pantalla para elegir la opcion de Administrador o Aplicación.
	 * 
	 * @param c
	 *            Objeto Cliente.
	 */
	private void cargarInicio(Cliente c) {

		i = new Inicio(c);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = i.getSize();
		if (frameSize.height > screenSize.height)
			frameSize.height = screenSize.height;
		if (frameSize.width > screenSize.width)
			frameSize.width = screenSize.width;
		i.setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
		// Para que el aspecto sea según donde se abra, unix, mac....
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		// para hacerla visible
		i.setVisible(true);
	}

	/**
	 * Carga la pantalla según el usuario introducido.
	 */
	private void cargarPanatallaRol() {
		/**
		 * Administrador.
		 */
		if (getUsuario().compareTo("Admin") == 0) {
			v1 = new PantallaAdmin(this, this.rac, this.ldc, this.lcc,
					this.lic, this.lgc, this.lac);

			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension frameSize = v1.getSize();
			if (frameSize.height > screenSize.height)
				frameSize.height = screenSize.height;
			if (frameSize.width > screenSize.width)
				frameSize.width = screenSize.width;
			v1.setLocation((screenSize.width - frameSize.width) / 2,
					(screenSize.height - frameSize.height) / 2);

			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.pantalla = true;
			v1.setVisible(true);

			/**
			 * Recursos Humanos.
			 */
		} else if (usuario.compareTo("RRHH") == 0) {
			v2 = new PantallaRRHH(this, this.rec, this.ldc, this.lgc, this.lac);

			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension frameSize = v2.getSize();
			if (frameSize.height > screenSize.height)
				frameSize.height = screenSize.height;
			if (frameSize.width > screenSize.width)
				frameSize.width = screenSize.width;
			v2.setLocation((screenSize.width - frameSize.width) / 2,
					(screenSize.height - frameSize.height) / 2);

			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.pantalla = true;
			v2.setVisible(true);

			/**
			 * Gerente.
			 */
		} else if (usuario.compareTo("Gerente") == 0) {
			v3 = new PantallaGerente(this, this.rec, this.ldc, this.lgc,
					this.lac);

			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension frameSize = v3.getSize();
			if (frameSize.height > screenSize.height)
				frameSize.height = screenSize.height;
			if (frameSize.width > screenSize.width)
				frameSize.width = screenSize.width;
			v3.setLocation((screenSize.width - frameSize.width) / 2,
					(screenSize.height - frameSize.height) / 2);

			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.pantalla = true;
			v3.setVisible(true);

			/**
			 * Trabajador.
			 */
		} else if (usuario.compareTo("") != 0) {
			v4 = new PantallaTrabajador(this, this.usuario, this.rec, this.ldc,
					this.lgc, this.lac);

			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension frameSize = v4.getSize();
			if (frameSize.height > screenSize.height)
				frameSize.height = screenSize.height;
			if (frameSize.width > screenSize.width)
				frameSize.width = screenSize.width;
			v4.setLocation((screenSize.width - frameSize.width) / 2,
					(screenSize.height - frameSize.height) / 2);

			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			this.pantalla = true;
			v4.setVisible(true);
		}
	}

	/**
	 * Método para comprobar si existe o no un rol.
	 * 
	 * @param usuario
	 *            Cadena usuario.
	 * @param pass
	 *            Cadena contraseña.
	 * @param rol
	 *            Booleano para diferenciar la comprobación.
	 * @return un valor booleano.
	 */
	public String comprobarRol(String usuario, String pass, boolean rol,
			String tipo) {

		String msg = "";
		try {

			// QUITA LOS COMENTARIOS
			Logger.getRootLogger().setLevel(Level.OFF);
			ConfigurationContext ctx = ConfigurationContextFactory
					.createConfigurationContextFromFileSystem(repo, null);
			stub = new ProyectoStub(ctx, EPR);
			ServiceClient sc = stub._getServiceClient();

			// AJUSTAMOS LAS PROPIEDADES AL CLIENTE DEL SERVICIO
			Options options = new Options();
			options.setAction("urn:comprobarRol");
			options.setTo(new EndpointReference(EPR));
			options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
					loadPolicy(policyPath));
			sc.setOptions(options);

			// CARGAMOS LOS MODULOS
			sc.engageModule("rampart");
			sc.engageModule("addressing");
			sc.engageModule("rahas");

			/*
			 * Utilizamos el stub generado a partir del wsdl que logran
			 * establecer la conexion con el web service proveedor.
			 */

			ComprobarRol request = null;
			ComprobarRolResponse response = null;

			// CREAMOS LA PETICION
			request = new ComprobarRol();
			// ESTABLECEMOS LOS PARAMETROS DE LA INVOCACION
			request.setIden(usuario);
			request.setPass(pass);
			request.setRol(rol);
			request.setTipo(tipo);

			// INVOCAMOS AL WEB SERVICE
			response = stub.comprobarRol(request);

			// System.out.println("\n\nSOAP REQUEST: \n"
			// + stub.getSoapRequest().toString() + "\n\n");
			// System.out.println("SOAP RESPONSE: \n"
			// + stub.getSoapResponse().toString() + "\n\n");

			// MOSTRAMOS LA RESPUESTA
			msg = new Boolean(response.get_return()).toString();

		} catch (Exception e) {
			return "ERROR Servidor, " + e.getMessage();
		}
		return msg;
	}

	/**
	 * Método para almacenar los registros Generales en el servidor.
	 */
	public void setAdmin() {

		try {
			// QUITA LOS COMENTARIOS
			Logger.getRootLogger().setLevel(Level.OFF);
			ConfigurationContext ctx = ConfigurationContextFactory
					.createConfigurationContextFromFileSystem(repo, null);
			stub = new ProyectoStub(ctx, EPR);
			ServiceClient sc = stub._getServiceClient();

			// AJUSTAMOS LAS PROPIEDADES AL CLIENTE DEL SERVICIO
			Options options = new Options();
			options.setAction("urn:setRegistroAdmin");
			options.setTo(new EndpointReference(EPR));
			options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
					loadPolicy(policyPath));
			sc.setOptions(options);

			// CARGAMOS LOS MODULOS
			sc.engageModule("rampart");
			sc.engageModule("addressing");
			sc.engageModule("rahas");

			/*
			 * Utilizamos el stub generado a partir del wsdl que logran
			 * establecer la conexion con el web service proveedor.
			 */

			SetRegistroAdmin request = null;
			SetRegistroAdminResponse response = null;

			// CREAMOS LA PETICION
			request = new SetRegistroAdmin();

			// ESTABLECEMOS LOS PARAMETROS DE LA INVOCACION
			ras = new RegistroAdminS();

			rac.dormirHilo();
			ras.setNombre(rac.getNombre());
			ras.setCodGeneral(rac.getCodGeneral());
			ras.setDescri(rac.getDescri());
			ras.setTipo(rac.getTipo());
			ras.setCodProce(rac.getCodProce());
			ras.setActi(rac.getActi());
			ras.setFrecu(rac.getFrecu());
			ras.setMeto(rac.getMeto());
			ras.setArchivo(rac.getArchivo());
			ras.setRetencion(rac.getRetencion());
			ras.setConservacion(rac.getConservacion());
			ras.setDispo(rac.getDispo());
			ras.setAlmacen(rac.getAlmacen());
			ras.setModi(rac.isModi());

			request.setRas(ras);

			// LISTA DOCUMENTOS
			lds = new ListaDocumentoS();

			lds.setCodigo(ldc.getCodigo());
			lds.setEnlace(ldc.getEnlace());
			lds.setTipoDescripcion(ldc.getTipoDescripcion());

			request.setD(lds);

			// LISTA CAMPOS
			lcs = new ListaCampoS();

			lcs.setCodRegistro(lcc.getCodRegistro());
			lcs.setNombre(lcc.getNombre());
			lcs.setDescripcion(lcc.getDescripcion());
			lcs.setTipo(lcc.getTipo());
			lcs.setUnidad(lcc.getUnidad());
			lcs.setEnlace(lcc.getEnlace());

			request.setC(lcs);

			// LISTA INDICADORES
			lis = new ListaIndicadorS();

			lis.setCodRegistro(lic.getCodRegistro());
			lis.setIndicador(lic.getIndicador());

			request.setI(lis);

			// LISTA GENERADORES
			lgs = new ListaGeneradorS();

			lgs.setCodigo(lgc.getCodigo());
			lgs.setGenerador(lgc.getGenerador());

			request.setG(lgs);

			// LISTA AUTORIZADOS
			las = new ListaAutorizadoS();

			las.setCodigo(lac.getCodigo());
			las.setAutorizado(lac.getAutorizado());

			request.setA(las);

			rac.setPulsado(false);

			// INVOCAMOS AL WEB SERVICE
			response = stub.setRegistroAdmin(request);

			// System.out.println("\n\nSOAP REQUEST: \n"
			// + stub.getSoapRequest().toString() + "\n\n");
			// System.out.println("SOAP RESPONSE: \n"
			// + stub.getSoapResponse().toString() + "\n\n");

			// MOSTRAMOS LA RESPUESTA
			v1.getEstado().setText(response.get_return());

			// ACTUALIZAR LISTA DE REGISTROS IPSO FACTO
			v1.mostrarRegistros();

		} catch (Exception e) {
			// SI SE PRODUJO ALGÚN ERROR LO MUESTRA EN LA BARRA DE ESTADO DE LA
			// PANTALLA
			v1.getEstado().setText(
					"ERROR en conexión con servidor " + e.toString());
		}
	}

	/**
	 * Método que devuelve el registro general almacenado en el servidor.
	 * 
	 * @param proce
	 *            Cadena con número de procedimiento.
	 * @return Registro General almacenado en el servidor.
	 * @throws Exception
	 *             Genera una excepción genérica.
	 */
	public String getAdmin(String proce, boolean admin) throws Exception {

		String reg = "";
		// QUITA LOS COMENTARIOS
		Logger.getRootLogger().setLevel(Level.OFF);
		ConfigurationContext ctx = ConfigurationContextFactory
				.createConfigurationContextFromFileSystem(repo, null);
		stub = new ProyectoStub(ctx, EPR);
		ServiceClient sc = stub._getServiceClient();

		// AJUSTAMOS LAS PROPIEDADES AL CLIENTE DEL SERVICIO
		Options options = new Options();
		options.setAction("urn:getRegistroAdmin");
		options.setTo(new EndpointReference(EPR));
		options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
				loadPolicy(policyPath));
		sc.setOptions(options);

		// CARGAMOS LOS MODULOS
		sc.engageModule("rampart");
		sc.engageModule("addressing");
		sc.engageModule("rahas");

		try {

			/*
			 * Utilizamos el stub generado a partir del wsdl que logran
			 * establecer la conexion con el web service proveedor.
			 */

			GetRegistroAdmin request = null;
			GetRegistroAdminResponse response = null;

			request = new GetRegistroAdmin();
			request.setProce(proce);

			// INVOCAMOS AL WEB SERVICE
			response = stub.getRegistroAdmin(request);

			// MOSTRAMOS LA RESPUESTA
			reg = response.get_return();

		} catch (Exception e) {
			// SI SE PRODUJO ALGÚN ERROR LO MUESTRA EN LA BARRA DE ESTADO DE LA
			// PANTALLA
			v1.getEstado().setText(
					"ERROR en conexión con servidor " + e.toString());
		}
		// MOSTRAMOS QUE HA IDO BIEN, EN LA BARRA DE ESTADO DE LA PANTALLA
		if (admin) {
			Thread.sleep(1000);
			v1.getEstado().setText("Recibidos Datos del Registro del Servidor ");
			Thread.sleep(3000);
			v1.getEstado().setText("");
		}
		return reg;
	}

	/**
	 * Método que develve el número de contrato.
	 * 
	 * @param proce
	 *            Cadena con número de procedimiento.
	 * @return Entero con el último número de contratación.
	 * @throws Exception
	 *             Genera una excepción genérica.
	 */
	public int getCodContrato(String proce) throws Exception {

		int reg = -1;
		// QUITA LOS COMENTARIOS
		Logger.getRootLogger().setLevel(Level.OFF);
		ConfigurationContext ctx = ConfigurationContextFactory
				.createConfigurationContextFromFileSystem(repo, null);
		stub = new ProyectoStub(ctx, EPR);
		ServiceClient sc = stub._getServiceClient();

		// AJUSTAMOS LAS PROPIEDADES AL CLIENTE DEL SERVICIO
		Options options = new Options();
		options.setAction("urn:getCodContrato");
		options.setTo(new EndpointReference(EPR));
		options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
				loadPolicy(policyPath));
		sc.setOptions(options);

		// CARGAMOS LOS MODULOS
		sc.engageModule("rampart");
		sc.engageModule("addressing");
		sc.engageModule("rahas");

		try {

			/*
			 * Utilizamos el stub generado a partir del wsdl que logran
			 * establecer la conexion con el web service proveedor.
			 */

			GetCodContrato request = null;
			GetCodContratoResponse response = null;

			request = new GetCodContrato();
			request.setProce(proce);

			// INVOCAMOS AL WEB SERVICE
			response = stub.getCodContrato(request);

			// MOSTRAMOS LA RESPUESTA
			reg = response.get_return();

		} catch (Exception e) {
			// SI SE PRODUJO ALGÚN ERROR LO MUESTRA EN LA BARRA DE ESTADO DE LA
			// PANTALLA
			v2.getEstado().setText(
					"ERROR en conexión con servidor " + e.toString());
		}

		return reg;
	}

	/**
	 * Devuelve el número del último registro realizado.
	 * 
	 * @param proce
	 *            Cadena con el número de procedimiento.
	 * @return Entero con el número del último registro realizado.
	 * @throws Exception
	 *             Genera una excepción genérica.
	 */
	public int getNumRegistro(String proce) throws Exception {

		int reg = -1;

		// QUITA LOS COMENTARIOS
		Logger.getRootLogger().setLevel(Level.OFF);
		ConfigurationContext ctx = ConfigurationContextFactory
				.createConfigurationContextFromFileSystem(repo, null);
		stub = new ProyectoStub(ctx, EPR);
		ServiceClient sc = stub._getServiceClient();

		// AJUSTAMOS LAS PROPIEDADES AL CLIENTE DEL SERVICIO
		Options options = new Options();
		options.setAction("urn:getNumRegistro");
		options.setTo(new EndpointReference(EPR));
		options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
				loadPolicy(policyPath));
		sc.setOptions(options);

		// CARGAMOS LOS MODULOS
		sc.engageModule("rampart");
		sc.engageModule("addressing");
		sc.engageModule("rahas");

		try {

			/*
			 * Utilizamos el stub generado a partir del wsdl que logran
			 * establecer la conexion con el web service proveedor.
			 */

			GetNumRegistro request = null;
			GetNumRegistroResponse response = null;

			request = new GetNumRegistro();
			request.setProce(proce);

			// INVOCAMOS AL WEB SERVICE
			response = stub.getNumRegistro(request);

//			System.out.println("\n\nSOAP REQUEST: \n"
//					+ stub.getSoapRequest().toString() + "\n\n");
//			System.out.println("SOAP RESPONSE: \n"
//					+ stub.getSoapResponse().toString() + "\n\n");

			// MOSTRAMOS LA RESPUESTA
			reg = response.get_return();

		} catch (Exception e) {
			// SI SE PRODUJO ALGÚN ERROR LO MUESTRA EN LA BARRA DE ESTADO DE LA
			// PANTALLA
			v2.getEstado().setText(
					"ERROR en conexión con servidor " + e.toString());
			return reg;
		}

		return reg;
	}

	/**
	 * Cargamos la información de los registros Específicos.
	 * 
	 * @param rol
	 *            Cadena con el usuario.
	 */
	private void setRegistroEspe(String rol) {
		// ESTABLECEMOS LOS PARAMETROS DE LA INVOCACION
		res = new RegistroEspeS();

		rec.dormirHilo();
		res.setC_Interno(rec.getC_Interno());
		res.setC_Proce(rec.getC_Proce());
		res.setC_Contra(rec.getC_Contra());
		res.setIndexacion(rec.getIndexacion());
		res.setCodGeneral(rec.getCodGeneral());

		// LISTA DOCUMENTOS
		lds = new ListaDocumentoS();

		lds.setCodigo(ldc.getCodigo());
		lds.setEnlace(ldc.getEnlace());
		lds.setTipoDescripcion(ldc.getTipoDescripcion());

		// LISTA GENERADORES
		lgs = new ListaGeneradorS();

		lgs.setCodigo(lgc.getCodigo());
		lgs.setGenerador(lgc.getGenerador());

		// LISTA AUTORIZADOS
		las = new ListaAutorizadoS();

		las.setCodigo(lac.getCodigo());
		las.setAutorizado(lac.getAutorizado());

		rec.setPulsado(false);

		/**
		 * Recursos Humanos.
		 */
		if (rol.compareTo("RRHH") == 0) {
			// BORRAMOS MENSAJES ANTERIORES EN LA BARRA DE ESTADO
			v2.getEstado().setText("");
			// ESCRIBIMOS NUEVOS MENSAJES EN LA BARRA DE ESTADO
			v2.getEstado().setText(setEspecifico(res, lds, lgs, las));
			// ACTUALIZAR LISTA
			v2.mostrarContratos();

		}
		/**
		 * Gerente.
		 */
		else if (rol.compareTo("Gerente") == 0) {
			v3.getEstado().setText("");
			v3.getEstado().setText(setEspecifico(res, lds, lgs, las));
			// ACTUALIZAR LISTA
			v3.mostrarContratos();

		}
		/**
		 * Trabajador.
		 */
		else {
			v4.getEstado().setText("");
			v4.getEstado().setText(setEspecifico(res, lds, lgs, las));
		}
	}

	/**
	 * Método para almacenar los registros creados automáticamente.
	 * 
	 * @param reg
	 *            Cadena con el registro creado automáticamente.
	 */
	public String setRegistroAuto(String reg) {
		String msg = "";
		try {

			// QUITA LOS COMENTARIOS
			Logger.getRootLogger().setLevel(Level.OFF);
			ConfigurationContext ctx = ConfigurationContextFactory
					.createConfigurationContextFromFileSystem(repo, null);
			stub = new ProyectoStub(ctx, EPR);
			ServiceClient sc = stub._getServiceClient();

			// AJUSTAMOS LAS PROPIEDADES AL CLIENTE DEL SERVICIO
			Options options = new Options();
			options.setAction("urn:setRegistroAuto");
			options.setTo(new EndpointReference(EPR));
			options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
					loadPolicy(policyPath));
			sc.setOptions(options);

			// CARGAMOS LOS MODULOS
			sc.engageModule("rampart");
			sc.engageModule("addressing");
			sc.engageModule("rahas");

			/*
			 * Utilizamos el stub generado a partir del wsdl que logran
			 * establecer la conexion con el web service proveedor.
			 */

			SetRegistroAuto request = null;
			SetRegistroAutoResponse response = null;

			// CREAMOS LA PETICION
			request = new SetRegistroAuto();
			request.setReg(reg);

			// INVOCAMOS AL WEB SERVICE
			response = stub.setRegistroAuto(request);

			// MOSTRAMOS LA RESPUESTA
			msg = response.get_return();

		} catch (Exception e) {
			// MENSAJE DE ALGÚN ERROR
			msg = "ERROR en conexión con servidor " + e.getMessage();
		}
		// DEVUELVE EL MENSAJE
		return msg;
	}

	/**
	 * Método para almacenar en el servidor los registros Específicos.
	 * 
	 * @param res
	 *            Objeto con el registro específico del servidor.
	 * @param lds
	 *            Objeto con la lista de documentos del servidor.
	 * @param lgs
	 *            Objeto con la lista de personas generadoreas del registro del
	 *            servidor.
	 * @param las
	 *            Objeto con la lista de personas autorizadas para el registro
	 *            del servidor.
	 * 
	 * @return Una cadena de si ha ido correcto o del error que hubo.
	 */
	private String setEspecifico(RegistroEspeS res, ListaDocumentoS lds,
			ListaGeneradorS lgs, ListaAutorizadoS las) {
		String msg = "";
		try {

			// QUITA LOS COMENTARIOS
			Logger.getRootLogger().setLevel(Level.OFF);
			ConfigurationContext ctx = ConfigurationContextFactory
					.createConfigurationContextFromFileSystem(repo, null);
			stub = new ProyectoStub(ctx, EPR);
			ServiceClient sc = stub._getServiceClient();

			// AJUSTAMOS LAS PROPIEDADES AL CLIENTE DEL SERVICIO
			Options options = new Options();
			options.setAction("urn:setRegistroEspe");
			options.setTo(new EndpointReference(EPR));
			options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
					loadPolicy(policyPath));
			sc.setOptions(options);

			// CARGAMOS LOS MODULOS
			sc.engageModule("rampart");
			sc.engageModule("addressing");
			sc.engageModule("rahas");

			/*
			 * Utilizamos el stub generado a partir del wsdl que logran
			 * establecer la conexion con el web service proveedor.
			 */

			SetRegistroEspe request = null;
			SetRegistroEspeResponse response = null;

			// CREAMOS LA PETICION
			request = new SetRegistroEspe();

			request.setRes(res);
			request.setD(lds);
			request.setG(lgs);
			request.setA(las);

			// INVOCAMOS AL WEB SERVICE
			response = stub.setRegistroEspe(request);

			// MOSTRAMOS LA RESPUESTA
			msg = response.get_return();

		} catch (Exception e) {
			// MENSAJE DE ALGÚN ERROR
			return "ERROR en conexión con servidor " + e.getMessage();
		}
		// DEVUELVE EL MENSAJE
		return msg;
	}

	/**
	 * Recogemos una cadena de información del registro anterior.
	 * 
	 * @param codGeneralAnte
	 *            Cadena con el número del código general anterior.
	 * @param codGeneral
	 *            Cadena con el número del código actual.
	 * @return Una cadena con información del registro anterior.
	 * @throws Exception
	 *             Genera una excepción genérica.
	 */
	public String getPasoAnte(String codGeneralAnte, String codGeneral)
			throws Exception {

		// QUITA LOS COMENTARIOS
		Logger.getRootLogger().setLevel(Level.OFF);
		ConfigurationContext ctx = ConfigurationContextFactory
				.createConfigurationContextFromFileSystem(repo, null);
		stub = new ProyectoStub(ctx, EPR);
		ServiceClient sc = stub._getServiceClient();

		// AJUSTAMOS LAS PROPIEDADES AL CLIENTE DEL SERVICIO
		Options options = new Options();
		options.setAction("urn:getPasoAnte");
		options.setTo(new EndpointReference(EPR));
		options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
				loadPolicy(policyPath));
		sc.setOptions(options);

		// CARGAMOS LOS MODULOS
		sc.engageModule("rampart");
		sc.engageModule("addressing");
		sc.engageModule("rahas");

		/*
		 * Utilizamos el stub generado a partir del wsdl que logran establecer
		 * la conexion con el web service proveedor.
		 */

		GetPasoAnte request = null;
		GetPasoAnteResponse response = null;

		// CREAMOS LA PETICION
		request = new GetPasoAnte();
		request.setCodGeneralAnte(codGeneralAnte);
		request.setCodGeneral(codGeneral);

		// INVOCAMOS AL WEB SERVICE
		response = stub.getPasoAnte(request);

		// MOSTRAMOS LA RESPUESTA
		return response.get_return();
	}

	/**
	 * Método que devuelve el número de contrato del último alta realizado.
	 * 
	 * @param rol
	 *            Cadena con el usuario.
	 * @param codGeneralAnte
	 *            Cadena con el número de codigo general anterior.
	 * @return El contrato del último trabajador.
	 * @throws Exception
	 *             Genera una excepción genérica.
	 */
	public String getContratoTrabajador(String rol, String codGeneralAnte)
			throws Exception {
		String reg = "";

		// QUITA LOS COMENTARIOS
		Logger.getRootLogger().setLevel(Level.OFF);
		ConfigurationContext ctx = ConfigurationContextFactory
				.createConfigurationContextFromFileSystem(repo, null);
		stub = new ProyectoStub(ctx, EPR);
		ServiceClient sc = stub._getServiceClient();

		// AJUSTAMOS LAS PROPIEDADES AL CLIENTE DEL SERVICIO
		Options options = new Options();
		options.setAction("urn:getContratoTrabajador");
		options.setTo(new EndpointReference(EPR));
		options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
				loadPolicy(policyPath));
		sc.setOptions(options);

		// CARGAMOS LOS MODULOS
		sc.engageModule("rampart");
		sc.engageModule("addressing");
		sc.engageModule("rahas");

		try {

			/*
			 * Utilizamos el stub generado a partir del wsdl que logran
			 * establecer la conexion con el web service proveedor.
			 */

			GetContratoTrabajador request = null;
			GetContratoTrabajadorResponse response = null;

			request = new GetContratoTrabajador();
			request.setRol(rol);
			request.setCodGeneralAnte(codGeneralAnte);

			// INVOCAMOS AL WEB SERVICE
			response = stub.getContratoTrabajador(request);

			// MOSTRAMOS LA RESPUESTA
			reg = response.get_return();

		} catch (Exception e) {
			// SI SE PRODUJO ALGÚN ERROR LO MUESTRA EN LA BARRA DE ESTADO DE LA
			// PANTALLA
			v4.getEstado().setText(
					"ERROR en conexión con servidor " + e.toString());
		}
		return reg;
	}

	/**
	 * Método que devuelve el número de procedimiento
	 * 
	 * @param v5
	 *            Pantalla del visor
	 * @return Una cadena con el número de procedimiento
	 * @throws Exception
	 *             Genera una excepción genérica.
	 */
	public String getProcedimiento(VisorEventos v5) throws Exception {

		this.v5 = v5;

		String reg = "";

		// QUITA LOS COMENTARIOS
		Logger.getRootLogger().setLevel(Level.OFF);
		ConfigurationContext ctx = ConfigurationContextFactory
				.createConfigurationContextFromFileSystem(repo, null);
		stub = new ProyectoStub(ctx, EPR);
		ServiceClient sc = stub._getServiceClient();

		// AJUSTAMOS LAS PROPIEDADES AL CLIENTE DEL SERVICIO
		Options options = new Options();
		options.setAction("urn:getProcedimiento");
		options.setTo(new EndpointReference(EPR));
		options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
				loadPolicy(policyPath));
		sc.setOptions(options);

		// CARGAMOS LOS MODULOS
		sc.engageModule("rampart");
		sc.engageModule("addressing");
		sc.engageModule("rahas");

		try {

			/*
			 * Utilizamos el stub generado a partir del wsdl que logran
			 * establecer la conexion con el web service proveedor.
			 */

			GetProcedimientoResponse response = null;

			// INVOCAMOS AL WEB SERVICE
			response = stub.getProcedimiento();

			// MOSTRAMOS LA RESPUESTA
			reg = response.get_return();

		} catch (Exception e) {
			// SI SE PRODUJO ALGÚN ERROR LO MUESTRA EN LA BARRA DE ESTADO DE LA
			// PANTALLA
			v5.getEstado().setText(
					"ERROR en conexión con servidor " + e.toString());
		}
		// MOSTRAMOS QUE HA IDO BIEN, EN LA BARRA DE ESTADO DE LA PANTALLA
		Thread.sleep(1000);
		v5.getEstado().setText("Recibidos Datos del Registro del Servidor");
		Thread.sleep(3000);
		v5.getEstado()
				.setText("");
		return reg;
	}

	/**
	 * Método que devuelve un registro Específico
	 * 
	 * @param codGeneral
	 *            Cadena para identificar el registro
	 * @return Una cadena con el registro Específico
	 * @throws Exception
	 *             Genera una excepción genérica.
	 */
	public String getEspecifico(String codGeneral) throws Exception {
		String reg = "";

		// QUITA LOS COMENTARIOS
		Logger.getRootLogger().setLevel(Level.OFF);
		ConfigurationContext ctx = ConfigurationContextFactory
				.createConfigurationContextFromFileSystem(repo, null);
		stub = new ProyectoStub(ctx, EPR);
		ServiceClient sc = stub._getServiceClient();

		// AJUSTAMOS LAS PROPIEDADES AL CLIENTE DEL SERVICIO
		Options options = new Options();
		options.setAction("urn:getRegistroEspe");
		options.setTo(new EndpointReference(EPR));
		options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
				loadPolicy(policyPath));
		sc.setOptions(options);

		// CARGAMOS LOS MODULOS
		sc.engageModule("rampart");
		sc.engageModule("addressing");
		sc.engageModule("rahas");

		try {

			/*
			 * Utilizamos el stub generado a partir del wsdl que logran
			 * establecer la conexion con el web service proveedor.
			 */

			GetRegistroEspe request = null;
			GetRegistroEspeResponse response = null;

			request = new GetRegistroEspe();
			request.setCodGeneral(codGeneral);

			// INVOCAMOS AL WEB SERVICE
			response = stub.getRegistroEspe(request);

			// MOSTRAMOS LA RESPUESTA
			reg = response.get_return();

		} catch (Exception e) {
			// SI SE PRODUJO ALGÚN ERROR LO MUESTRA EN LA BARRA DE ESTADO DE LA
			// PANTALLA
			v5.getEstado().setText(
					"ERROR en conexión con servidor " + e.toString());
		}
		return reg;
	}

	/**
	 * Método que devuelve una lista con todos los códigos generales de un
	 * procedimiento
	 * 
	 * @param proce
	 *            Identifica procedimiento del cual se saca los códigos
	 * @return Una cadena con la lista de códigos
	 * @throws Exception
	 *             Genera una excepción genérica.
	 */
	public String getListaCodGenerales(String proce) throws Exception {
		String reg = "";

		// QUITA LOS COMENTARIOS
		Logger.getRootLogger().setLevel(Level.OFF);
		ConfigurationContext ctx = ConfigurationContextFactory
				.createConfigurationContextFromFileSystem(repo, null);
		stub = new ProyectoStub(ctx, EPR);
		ServiceClient sc = stub._getServiceClient();

		// AJUSTAMOS LAS PROPIEDADES AL CLIENTE DEL SERVICIO
		Options options = new Options();
		options.setAction("urn:getListaCodGenerales");
		options.setTo(new EndpointReference(EPR));
		options.setProperty(RampartMessageData.KEY_RAMPART_POLICY,
				loadPolicy(policyPath));
		sc.setOptions(options);

		// CARGAMOS LOS MODULOS
		sc.engageModule("rampart");
		sc.engageModule("addressing");
		sc.engageModule("rahas");

		try {

			/*
			 * Utilizamos el stub generado a partir del wsdl que logran
			 * establecer la conexion con el web service proveedor.
			 */

			GetListaCodGenerales request = null;
			GetListaCodGeneralesResponse response = null;

			request = new GetListaCodGenerales();
			request.setProce(proce);

			// INVOCAMOS AL WEB SERVICE
			response = stub.getListaCodGenerales(request);

			// MOSTRAMOS LA RESPUESTA
			reg = response.get_return();

		} catch (Exception e) {
			// SI SE PRODUJO ALGÚN ERROR LO MUESTRA EN LA BARRA DE ESTADO DE LA
			// PANTALLA
			v5.getEstado().setText(
					"ERROR en conexión con servidor " + e.toString());
		}
		// MOSTRAMOS QUE HA IDO BIEN, EN LA BARRA DE ESTADO DE LA PANTALLA
		Thread.sleep(1000);
		v5.getEstado().setText("Recibidos Datos del Registro del Servidor");
		Thread.sleep(3000);
		v5.getEstado().setText("");

		return reg;
	}

	/**
	 * Carga el fichero de politica desde el classpath.
	 * 
	 * @throws Exception
	 *             Genera una excepción genérica.
	 */
	private Policy loadPolicy(String xmlPath) throws Exception {
		StAXOMBuilder builder = new StAXOMBuilder(xmlPath);
		return PolicyEngine.getPolicy(builder.getDocumentElement());
	}

	/**
	 * Carga los certificados, para conectarse al servidor.
	 */
	private void cargarCertificados() {
		// PONER EL MISMO TAMBIEN PARA LA BASE DE DATOS
		// PARA EL CERTIFICADO, UTILIZANDO LA KEYSTORE, TRUSTSTORE
		System.setProperty("javax.net.ssl.trustStoreType", "JKS");
		System.setProperty("javax.net.ssl.trustStore",
				"certificados/truststore-proyecto2.jks");
		System.setProperty("javax.Vnet.ssl.trustStorePassword", "proyecto");
		System.setProperty("javax.net.ssl.keyStoreType", "PKCS12");
		System.setProperty("javax.net.ssl.keyStore",
				"certificados/cliente.p12");
		System.setProperty("javax.net.ssl.keyStorePassword", "proyecto");
	}

	/**
	 * Getter
	 * 
	 * @return El usuario
	 */
	public synchronized String getUsuario() {
		/**
		 * Este hilo se quedara bloqueado a la espera de que el usuario termine
		 * de escribir algo en una interface de usuario.
		 */
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	/**
	 * Setter
	 * 
	 * @param usuario
	 *            Cadena con el rol de usuario.
	 */
	public synchronized void setUsuario(String usuario) {
		this.usuario = usuario;
		/**
		 * Despierta el hilo cuando el usuario a introducido el rol
		 */
		notify();
	}

	/**
	 * @return cerrar Booleano de si la ventana se ha cerrado o no.
	 */
	public boolean isCerrar() {
		return cerrar;
	}

	/**
	 * @param cerrar
	 *            Booleano con el valor dependiendo de como se encuentre la
	 *            ventana.
	 */
	public void setCerrar(boolean cerrar) {
		this.cerrar = cerrar;
	}
	
	/**
	 * @param pantalla
	 *            Booleano con el valor dependiendo de la pantalla de los usuarios.
	 */
	public void setPantalla(boolean pantalla) {
		this.pantalla = pantalla;
	}

	/**
	 * Método sincronizado para dormir este hilo cuando es llamado por Cliente
	 * para que espere a que se escriba la información en el registro
	 */
	public synchronized void dormirHilo() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método sincronizado para despertar este hilo cuando se ha rellenado la
	 * información del registro
	 */
	public synchronized void despertarHilo() {
		notify();
	}
}