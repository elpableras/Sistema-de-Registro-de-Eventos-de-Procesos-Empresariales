package base_de_datos;

import java.sql.SQLException;

import com.ws.servidor.dato.ListaAutorizadoS;
import com.ws.servidor.dato.ListaGeneradorS;
import com.ws.servidor.dato.ListaCampoS;
import com.ws.servidor.dato.ListaDocumentoS;
import com.ws.servidor.dato.ListaIndicadorS;
import com.ws.servidor.dato.RegistroAdminS;
import com.ws.servidor.dato.RegistroEspeS;


public class Registrar {

	private String usuario = "";
	private String pass = "";
	
	public Registrar(){
		
	}

	// ADMINISTRADOR
	
	public String setAdmin(RegistroAdminS ras, ListaDocumentoS d, ListaCampoS c, ListaIndicadorS i, ListaGeneradorS g, ListaAutorizadoS a) {
		
		String msg = "";
		
		// Utilización de MySQL
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);

		// POR CADA CLASE
		RegistroAdminDAO r = fd.RegistroAdminDAO();

		// insertar();
		if(ras.isModi()){
			msg += " Modificando información del proceso: " + ras.getCodGeneral() + "......";
			try {
				r.setActualizar(ras,d,c,i,g,a);
				msg += " CAMBIADO. ";
			} catch (SQLException e) {
				msg = "ERROR, " + e.getMessage();
			}
		} else{
			try {
				if(existeRegistro(r.getListaRegistro(ras.getCodProce()), ras.getCodGeneral())){
					msg += " Información Proceso Repetido. ";
				}else{
					r.setRegistro(ras,d,c,i,g,a);
					msg += " Información del Proceso Almacenado. ";
				}
			} catch (SQLException e) {
				msg = "ERROR, al almacenar proceso, " + e.getMessage();
			}
		}
		
		return msg;
	}
	
	
	public String getAdmin(String proce){
			
			// Utilización de MySQL
			FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);
	
			// POR CADA CLASE
			RegistroAdminDAO r = fd.RegistroAdminDAO();
	
			try {
				
				// recoger();
				return r.getRegistro(proce);
				
			} catch (SQLException e) {
				return "ERROR, al obtener proceso, " + e.getMessage();
			}	
	}
	
	
	
	
	
	// ESPECÍFICO
	
	public String setContrato(String proce) {
		// Utilización de MySQL
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);
		ContratoDAO c = fd.ContratoDAO();
		
		int numContrato = -1;
		String msg = "";
		
		try {
			numContrato = c.getContrato(proce);
			numContrato ++;			
			c.setContrato(numContrato,proce);
		} catch (SQLException e) {
			msg = "ERROR, al almacenar contrato, " + e.getMessage();
		}
		msg += " Contrato " + (numContrato-1) + " almacenado. ";
		return msg;
	}

	public int getContrato(String proce) throws Exception {
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);
		ContratoDAO r = fd.ContratoDAO();
		
		return r.getContrato(proce);
	}
	
	
	
	public String setEspecifico(RegistroEspeS res,ListaDocumentoS d, ListaGeneradorS g, ListaAutorizadoS a){
		String msg = "";
		
		//PONERLO CUANDO CLIENTE Y SERVIDOR ESTEN EN MAQUINAS DIFERENTES
//		System.setProperty("javax.net.ssl.keyStore","C:/Users/Jose/Desktop/pruebas/certMySQL/keystore");
//		System.setProperty("javax.net.ssl.keyStorePassword","proyecto");
//		System.setProperty("javax.net.ssl.trustStore","C:/Users/Jose/Desktop/pruebas/certMySQL/truststore");
//		System.setProperty("javax.net.ssl.trustStorePassword","proyecto");
		
		// Utilización de MySQL
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);

		// POR CADA CLASE
		RegistroEspeDAO r = fd.RegistroEspeDAO();
		CorreoDAO c = fd.CorreoDAO();
		
		try {
			// SOLO PUEDE HABER N CONTRATOS DEL REGISTRO 0 DEL RESTO 1
			if(existeRegistro(r.getCodInterno(res.getCodGeneral()), res.getC_Interno())){
				msg += " Ya existe proceso "+res.getC_Interno();
			}else if(res.getCodGeneral().compareTo("RH-2-r00")!=0 && compararContratacion(res)){
				msg += " Ya se ha realizado está tarea anteriormente.";
			}else{
				
				// insertar();
				r.setRegistro(res,d,g,a);
				String proceso = res.getC_Proce();
				String aux = "";
				boolean guion2 = false;
				for (int i = 0; i < proceso.length(); i++) {
					if(proceso.charAt(i) != '-'){
						aux += proceso.charAt(i);
					}else{
						if(!guion2){
							aux += proceso.charAt(i);
							guion2 = true;
						}else{
							break;
						}
					}
				}
				// Solo se aumneta el contrato si se ha almacenado un trabajador nuevo
				if(res.getCodGeneral().compareTo("RH-2-r00")==0){
					msg += setContrato(aux);
				}
				// Aumento en uno el numero de registros almacenados
				msg += setNumRegistro(aux);
				msg += " Registro Específico Almacenado. ";

				// Mandar correo con el registro registrado
				escogerCuenta(c);
				msg += new MandarCorreo().correo(" Registro Específico en Base de Datos. ", res.toString(),
						usuario, pass);	
			}
		} catch (Exception e) {
			msg = "ERROR, al almacenar proceso, "+e.getMessage();
		}
		return msg;
	}
	

	private boolean compararContratacion(RegistroEspeS res) throws Exception {
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);
		RegistroEspeDAO r = fd.RegistroEspeDAO();
		
		String pasoAnte = r.getPasoAnte(res.getCodGeneral());
		if(pasoAnte.compareTo("")!=0){
			String[] campo = pasoAnte.split(",");
			for (int i = 0; i < campo.length; i++) {
				String campos [] = campo[i].split(" ");
				String codigo = campos[0] + " " + campos[1];
				if(codigo.compareTo(res.getC_Contra())==0){
					return true;
				}
			}
		}
		return false;
	}

	public String getPasoAnte(String codGeneralAnte, String codGeneral) {
		
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);
		RegistroEspeDAO r = fd.RegistroEspeDAO();
		
		String reg = "";
		try {
			String [] datos = r.getPasoAnte(codGeneralAnte).split(",");
			if(datos[0].compareTo("")!=0){
				for (int i = 0; i < datos.length; i++) {
					String [] codigo = datos[i].split(" ");
					// CON EL ROL CODGENRAL MIRO SI YA EXISTE ESE REGISTRO SI ES ASI ES QUE YA SE COMPLETO
					if(r.getContratoTrabajador(codigo[2], codGeneral).compareTo("")==0){
						reg += codigo[0] + " " + codigo[1] + " " + codigo[2] + ",";
					}
				}
			}
			return reg;
		} catch (SQLException e) {
			return "ERROR, al obtener paso anteriror, " + e.getMessage();
		}
	}
	
	
	public String getContratoTrabajador(String rol, String codGeneralAnte) {
		
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);
		RegistroEspeDAO r = fd.RegistroEspeDAO();
		
		try {
			return r.getContratoTrabajador(rol,codGeneralAnte);
		} catch (SQLException e) {
			return "ERROR, al obtener contrato de trabajo, " + e.getMessage();
		}
	}
	
	
	private boolean existeRegistro(String codbase, String cod) {
		String [] campos = codbase.split("·");
		for (int i = 0; i < campos.length; i++) {
			if(campos[i] != null && campos[i].compareTo("")!=0 && campos[i].compareTo(cod)==0){
				return true;
			}
		}
	return false;
	}
	

	private void escogerCuenta(CorreoDAO c) throws Exception {
		String cuenta = c.getCuenta();
		
		// espacio cn posibilidad de más caracteres (expresión regular \\s)
		String[] campos = cuenta.split("\\s+");
		usuario = campos[0];
		pass = campos[1];
	}

	public String setNumRegistro(String proce) {
		// MySQL
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);
		NumRegistroDAO r = fd.NumRegistroDAO();
				
		int numRegistro = -1;
		
		try {
			numRegistro = r.getRegistros(proce);
			numRegistro ++;			
			r.setRegistro(numRegistro,proce);
		} catch (SQLException e) {
			return "ERROR, al almacenar número de registro, " + e.getMessage();
		}
		return " Añadido registro "+ (numRegistro-1) + ". ";
	}

	public int getNumRegistro(String proce) throws Exception {
		// MySQL
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);
		NumRegistroDAO r = fd.NumRegistroDAO();

		return r.getRegistros(proce);
		
	}
	
	
	
	
	// ROL
	public boolean comprobarRol(String iden, String pass, String tipo) throws Exception {
		// MySQL
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);

		// POR CADA CLASE
		RolDAO r = fd.RolDAO();
		
		String roles [] = r.getRol(tipo).split(" ");
		
		
		for (int i = 0; i < roles.length; i++) {
			if(roles[i] != null && roles[i].compareTo("")!=0){
				String campo [] = roles[i].split(",");
				if(campo[0].compareTo(iden)==0){
					if(campo[1].compareTo(pass)==0){
						// EXISTE ROL
						return true;
					}
				}
			}else{
				throw new Exception("ERROR, al comprobar el rol. ");
			}
		}
		// NO EXISTE
		return false;
	}
	
	public boolean setRol(String iden, String pass, String tipo) throws Exception{
		
		// MySQL
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);

		// POR CADA CLASE
		RolDAO r = fd.RolDAO();
		
		if(existeRol(r.getRol(tipo),iden) == false){
			r.setRol(iden, pass, tipo);
			return false;
		}else{
			return true;
		}
	}
	
	private boolean existeRol(String roles, String iden) throws Exception {
		String rol [] = roles.split(" ");
		for (int i = 0; i < rol.length; i++) {
			if(rol[i] != null && rol[i].compareTo("")!=0){
				String[] campos = rol[i].split(",");
				if(campos[0].compareTo(iden)==0){
					//EXISTE ROL
					return true;
				}
			}else{
				throw new Exception("ERROR, al comprobar la existencia del rol. ");
			}
		}
	// NO EXISTE ROL
	return false;
	}

	
	
	
	// VISOR DE EVENTOS
	
	public String getProcedimiento() {
		
	
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);

		RegistroAdminDAO r = fd.RegistroAdminDAO();
		
		try {
			return r.getProcedimiento();
		} catch (SQLException e) {
			return "ERROR, al obtener procedimiento, "+e.getMessage();
		}
	}

	public String getRegistroEspe(String codGeneral) {
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);

		RegistroEspeDAO r = fd.RegistroEspeDAO();
		try {
			return r.getRegistroEspe(codGeneral);
		} catch (SQLException e) {
			return "ERROR, al obtener proceso, "+e.getMessage();
		}
	}

	public String getListaCodGenerales(String proce) {
		FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);

		RegistroAdminDAO r = fd.RegistroAdminDAO();
		
		try {
			return r.getListaRegistro(proce);
		} catch (SQLException e) {
			return "ERROR, al obtener lista de cód. generales, " +e.getMessage();
		}
	}
}
