package base_de_datos;

import java.sql.SQLException;

import com.ws.servidor.dato.ListaAutorizadoS;
import com.ws.servidor.dato.ListaGeneradorS;
import com.ws.servidor.dato.ListaCampoS;
import com.ws.servidor.dato.ListaDocumentoS;
import com.ws.servidor.dato.ListaIndicadorS;
import com.ws.servidor.dato.RegistroAdminS;
import com.ws.servidor.dato.RegistroEspeS;

/**
 * Clase con las diferentes operaciones sobre la base de datos.
 */
public class Registrar {

	private String usuario = "";
	private String pass = "";

	// Utilizaci�n de MySQL
	private FactoriaDAO fd = FactoriaDAO.getFactoriaDAO(2);
	// Por cada clase
	private RegistroAdminDAO ra = fd.RegistroAdminDAO();
	private ContratoDAO c = fd.ContratoDAO();
	private RegistroEspeDAO re = fd.RegistroEspeDAO();
	private MandarCorreo mco = new MandarCorreo();
	private CorreoDAO co = fd.CorreoDAO();
	private NumRegistroDAO nr = fd.NumRegistroDAO();
	private RolDAO r = fd.RolDAO();

	// Convertir a registros admin
	private RegistroAdminS ras = new RegistroAdminS();
	private RegistroEspeS res = new RegistroEspeS();
	private ListaDocumentoS ldsg = new ListaDocumentoS();
	private ListaDocumentoS ldse = new ListaDocumentoS();
	private ListaCampoS lcsg = new ListaCampoS();
	private ListaIndicadorS lisg = new ListaIndicadorS();
	private ListaGeneradorS lgsg = new ListaGeneradorS();
	private ListaAutorizadoS lasg = new ListaAutorizadoS();
	private ListaGeneradorS lgse = new ListaGeneradorS();
	private ListaAutorizadoS lase = new ListaAutorizadoS();

	/**
	 * Constructor por defecto.
	 */
	public Registrar() {
	}

	// AUTOM�TICOS
	/**
	 * M�todo para almacenar los registros autom�ticos ya sean del administrador
	 * como del resto de los usuarios.
	 * 
	 * @param reg
	 *            Cadena con el registro.
	 * @return Cadena con el mensaje de error o de confirmaci�n.
	 */
	public String setAuto(String reg) {
		String msg = "";

		String[] camposIni = reg.split("_");

		// REGISTRO ADMIN

		if (camposIni[0].compareTo("Admin") == 0) {
			for (int i = 1; i < camposIni.length; i++) {

				String[] campos = camposIni[i].split(";");
				int j = 0;
				ras.setNombre(campos[j]);
				ras.setCodGeneral(campos[++j]);
				ras.setDescri(campos[++j]);
				ras.setTipo(campos[++j]);
				ras.setCodProce(campos[++j]);
				ras.setActi(campos[++j]);

				j -= 4;
				ldsg.setCodigo(campos[j]);
				j += 5;
				ldsg.setEnlace(campos[j]);
				ldsg.setTipoDescripcion(campos[j]);

				j -= 5;
				lcsg.setCodRegistro(campos[j]);
				j += 6;
				lcsg.setDescripcion(campos[j]);
				lcsg.setEnlace(campos[j]);
				lcsg.setNombre(campos[j]);
				lcsg.setTipo(campos[j]);
				lcsg.setUnidad(campos[j]);

				ras.setFrecu(campos[++j]);
				ras.setMeto(campos[++j]);

				j -= 8;
				lisg.setCodRegistro(campos[j]);
				j += 9;
				lisg.setIndicador(campos[j]);

				j -= 9;
				lgsg.setCodigo(campos[j]);
				j += 10;
				lgsg.setGenerador(campos[j]);

				j -= 10;
				lasg.setCodigo(campos[j]);
				j += 11;
				lasg.setAutorizado(campos[j]);

				ras.setArchivo(campos[++j]);
				ras.setRetencion(campos[++j]);
				ras.setConservacion(campos[++j]);
				ras.setDispo(campos[++j]);
				ras.setAlmacen(campos[++j]);
				ras.setModi(true);
				msg += "Registro General " + i + " de " + lgsg.getGenerador()
						+ "\n" + setAdmin(ras, ldsg, lcsg, lisg, lgsg, lasg)
						+ "\n\n";
			}// fin del for RegAdmin
		}// FIN ADMIN
		else {
			for (int i = 0; i < camposIni.length; i++) {
				String[] campos = camposIni[i].split("@");
				// regEspe +=
				// interno+"@"+procesoIni+"@"+codContra+"@"+indexacion+"@"+codGeneral+"@"+generador+"@"+autorizado+"@"+pass;
				// regEspe +=
				// interno+"@"+procesoIni+"@"+codContra+"@"+indexacion+"@"+codGeneral+"@"+generador+"@"+autorizado;
				// regEspe +=
				// interno+"@"+procesoIni+"@"+codContra+"@"+indexacion+"@"+codGeneral+"@"+generador+"@"+autorizado+"@"+descripcion+"@"+enlace;
				int j = 0;
				res.setC_Interno(campos[j]);
				res.setC_Proce(campos[++j]);
				res.setC_Contra(campos[++j]);
				res.setIndexacion(campos[++j]);
				String iden = campos[j];
				res.setCodGeneral(campos[++j]);

				j -= 4;
				lgse.setCodigo(campos[j]);
				j += 5;
				lgse.setGenerador(campos[j]);

				j -= 5;
				lase.setCodigo(campos[j]);
				j += 6;
				lase.setAutorizado(campos[j]);

				j -= 6;
				ldse.setCodigo(campos[j]);
				j += 7;
				if (j != campos.length) {
					// SOLO RRHH1
					if (campos[j].compareTo(res.getIndexacion()) == 0) {
						ldse.setEnlace("");
						ldse.setTipoDescripcion("");
						try {
							setRol(iden, campos[j], "P");
						} catch (Exception e) {
							msg += "Rol " + e.getMessage() + ". ";
						}
						// TRABAJADOR2, GERENTE Y RRHH2
					} else {
						ldse.setTipoDescripcion(campos[j]);
						ldse.setEnlace(campos[++j]);
					}
				} else {
					// SOLO TRABAJADOR1
					if (j == campos.length) {
						ldse.setEnlace("");
						ldse.setTipoDescripcion("");
					}
				}

				msg += "Registro Espec�fico " + i + " de "
						+ lgse.getGenerador() + "\n"
						+ setEspecifico(res, ldse, lgse, lase, true) + "\n\n";
			}// fin del FOR
		}// FIN del ELSE
		return msg;
	}

	// ADMINISTRADOR
	/**
	 * M�todo para almacenar los registros del administrador, que son los
	 * registros generales.
	 * 
	 * @param ras
	 *            Objeto de tipo RegistroAdminS, que contiene los datos del
	 *            registro.
	 * @param d
	 *            Objeto de tipo ListaDocumentoS, que contiene los datos de la
	 *            lista de documentos.
	 * @param c
	 *            Objeto de tipo ListaCampoS, que contiene los datos de la lista
	 *            de informaci�n resumen.
	 * @param i
	 *            Objeto de tipo ListaIndicadorS, que contiene los datos de la
	 *            lista de indicadores.
	 * @param g
	 *            Objeto de tipo ListaGeneradorS, que contiene los datos de la
	 *            lista de generadores.
	 * @param a
	 *            Objeto de tipo ListaAutorizadoS, que contiene los datos de la
	 *            lista de autorizados.
	 * @return Cadena con el mensaje de error o de confirmaci�n.
	 */
	public String setAdmin(RegistroAdminS ras, ListaDocumentoS d,
			ListaCampoS c, ListaIndicadorS i, ListaGeneradorS g,
			ListaAutorizadoS a) {

		String msg = "";

		// insertar();
		if (ras.isModi()) {
			msg += " Modificando informaci�n del proceso: "
					+ ras.getCodGeneral() + "......";
			try {
				ra.setActualizar(ras, d, c, i, g, a);
				msg += " CAMBIADO. ";
			} catch (SQLException e) {
				msg = e.getMessage();
			}
		} else {
			try {
				if (existeRegistro(ra.getListaRegistro(ras.getCodProce()),
						ras.getCodGeneral())) {
					msg += " Informaci�n Proceso Repetido. ";
				} else {
					ra.setRegistro(ras, d, c, i, g, a);
					msg += " Informaci�n del Proceso Almacenado. ";
				}
			} catch (SQLException e) {
				msg = "ERROR, al almacenar proceso, " + e.getMessage();
			}
		}

		return msg;
	}

	/**
	 * M�todo para obtener el registro general, seg�n el proceso solicitado.
	 * 
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @return Cadena con el mensaje de error o con el registro general.
	 */
	public String getAdmin(String proce) {

		try {
			// recoger();
			return ra.getRegistro(proce);

		} catch (SQLException e) {
			return "ERROR, al obtener proceso, " + e.getMessage();
		}
	}

	// ESPEC�FICO
	/**
	 * M�todo para almacenar el n�mero de contrato
	 * 
	 * @param proce
	 *            Cadena con el procedimiento
	 * @return Cadena con el mensaje de error o con el n�mero de contrato
	 *         almacenado.
	 */
	public String setContrato(String proce) {

		int numContrato = -1;
		String msg = "";

		try {
			numContrato = c.getContrato(proce);
			numContrato++;
			c.setContrato(numContrato, proce);
		} catch (SQLException e) {
			msg = "ERROR, al almacenar contrato, " + e.getMessage();
		}
		msg += " Contrato " + (numContrato - 1) + " almacenado. ";
		return msg;
	}

	/**
	 * M�todo para obtener el c�digo de contrato.
	 * 
	 * @param proce
	 *            Cadena con el n�mero de procedimiento.
	 * @return Cadena con el mensaje de error o el c�digo de contrato.
	 * @throws Exception
	 *             Genera una excepci�n gen�rica.
	 */
	public int getContrato(String proce) throws Exception {
		return c.getContrato(proce);
	}

	/**
	 * M�todo para almacenar los registros espec�ficos.
	 * 
	 * @param res
	 *            Objeto de tipo RegistroEspeS, que contiene los datos del
	 *            registro.
	 * @param d
	 *            Objeto de tipo ListaDocumentoS, que contiene los datos de la
	 *            lista de documentos.
	 * @param g
	 *            Objeto de tipo ListaGeneradorS, que contiene los datos de la
	 *            lista de generadores.
	 * @param a
	 *            Objeto de tipo ListaAutorizadoS, que contiene los datos de la
	 *            lista de autorizados.
	 * @param auto
	 *            Booleano , que identifica si es un registro espec�fico
	 *            autom�tico o manual.
	 * 
	 * @return Cadena con el mensaje de error o de confirmaci�n.
	 */
	public String setEspecifico(RegistroEspeS res, ListaDocumentoS d,
			ListaGeneradorS g, ListaAutorizadoS a, boolean auto) {
		String msg = "";

		try {
			// SOLO PUEDE HABER N CONTRATOS DEL REGISTRO 0 DEL RESTO 1
			if (existeRegistro(re.getCodInterno(res.getCodGeneral()),
					res.getC_Interno())) {
				msg += " Ya existe proceso " + res.getC_Interno();
			} else if (res.getCodGeneral().compareTo("RH-2-r00") != 0
					&& compararContratacion(res)) {
				msg += " Ya se ha realizado est� tarea anteriormente.";
			} else {

				// insertar();
				re.setRegistro(res, d, g, a);
				String proceso = res.getC_Proce();
				String aux = "";
				boolean guion2 = false;
				for (int i = 0; i < proceso.length(); i++) {
					if (proceso.charAt(i) != '-') {
						aux += proceso.charAt(i);
					} else {
						if (!guion2) {
							aux += proceso.charAt(i);
							guion2 = true;
						} else {
							break;
						}
					}
				}
				// Solo se aumenta el contrato si se ha almacenado un trabajador
				// nuevo
				if (res.getCodGeneral().compareTo("RH-2-r00") == 0) {
					msg += setContrato(aux);
				}
				// Aumento en uno el numero de registros almacenados
				msg += setNumRegistro(aux);
				msg += " Registro Espec�fico Almacenado. ";

				// para no ralentizar el proceso si es autom�tico no se envia el
				// correo con cada registro
				if (!auto) {
					// Mandar correo con el registro registrado
					escogerCuenta(co);
					mco = new MandarCorreo();
					msg += mco.correo(
							" Registro Espec�fico en Base de Datos. ",
							res.toString(), usuario, pass);
				}
			}
		} catch (Exception e) {
			msg = "ERROR, al almacenar proceso, " + e.getMessage();
		}
		return msg;
	}

	/**
	 * M�todo para comparar c�digos de contrataci�n y saber si ya se realizo.
	 * 
	 * @param res
	 *            Objeto de tipo RegistroEspeS, que contiene los datos del
	 *            registro espec�fico.
	 * @return Booleano, dependiendo si el c�digo de contrataci�n es el igual o
	 *         diferente.
	 * @throws Exception
	 *             Genera una excepci�n gen�rica.
	 */
	private boolean compararContratacion(RegistroEspeS res) throws Exception {

		String pasoAnte = re.getPasoAnte(res.getCodGeneral());
		if (pasoAnte.compareTo("") != 0) {
			String[] campo = pasoAnte.split(",");
			for (int i = 0; i < campo.length; i++) {
				String campos[] = campo[i].split(" ");
				String codigo = campos[0] + " " + campos[1];
				if (codigo.compareTo(res.getC_Contra()) == 0) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * M�todo para obtener c�digo de contrataci�n e indexaci�n del paso
	 * anterior.
	 * 
	 * @param codGeneralAnte
	 *            Cadena con el c�digo general del paso anterior.
	 * @param codGeneral
	 *            Cadena con el c�digo general del paso actual.
	 * @return Cadena con el mensaje de error o con el c�digo de contrataci�n
	 */
	public String getPasoAnte(String codGeneralAnte, String codGeneral) {

		String reg = "";
		try {
			String[] datos = re.getPasoAnte(codGeneralAnte).split(",");
			if (datos[0].compareTo("") != 0) {
				for (int i = 0; i < datos.length; i++) {
					String[] codigo = datos[i].split(" ");
					// CON EL ROL CODGENRAL MIRO SI YA EXISTE ESE REGISTRO SI ES
					// ASI ES QUE YA SE COMPLETO
					if (re.getContratoTrabajador(codigo[2], codGeneral)
							.compareTo("") == 0) {
						reg += codigo[0] + " " + codigo[1] + " " + codigo[2]
								+ ",";
					}
				}
			}
			return reg;
		} catch (SQLException e) {
			return "ERROR, al obtener paso anterior, " + e.getMessage();
		}
	}

	/**
	 * M�todo para obtener el c�digo de contrataci�n.
	 * 
	 * @param rol
	 *            Cadena con c�digo de indexaci�n.
	 * @param codGeneralAnte
	 *            Cadena con el c�digo general del paso anterior.
	 * @return Cadena con el mensaje de error o con el c�digo de contrataci�n.
	 */
	public String getContratoTrabajador(String rol, String codGeneralAnte) {

		try {
			return re.getContratoTrabajador(rol, codGeneralAnte);
		} catch (SQLException e) {
			return "ERROR, al obtener contrato de trabajo, " + e.getMessage();
		}
	}

	/**
	 * M�todo para comprobar si existe un mismo registro con el mismo c�digo
	 * interno.
	 * 
	 * @param codbase
	 *            Cadena con el c�digo interno a comparar.
	 * @param cod
	 *            Cadena con los c�digos internos almacenados en la base de
	 *            datos.
	 * @return Booleano dependiendo de si la comparaci�n ha resultado correcta
	 *         true sino false.
	 */
	private boolean existeRegistro(String codbase, String cod) {
		String[] campos = codbase.split("�");
		for (int i = 0; i < campos.length; i++) {
			if (campos[i] != null && campos[i].compareTo("") != 0
					&& campos[i].compareTo(cod) == 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * M�todo para escoger la cuenta de correo y clave para mandar el correo.
	 * 
	 * @param c
	 *            Objaeto de tipo CorreoDAO, para acceder a la interfaz del
	 *            correo en la base de datos.
	 * @throws Exception
	 *             Genera una excepci�n gen�rica.
	 */
	private void escogerCuenta(CorreoDAO c) throws Exception {
		String cuenta = c.getCuenta();

		// espacio cn posibilidad de m�s caracteres (expresi�n regular \\s)
		String[] campos = cuenta.split("\\s+");
		usuario = campos[0];
		pass = campos[1];
	}

	/**
	 * M�todo que almacena el n�mero de registro.
	 * 
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @return Cadena con el mensaje de error o con el n�mero de registro.
	 */
	public String setNumRegistro(String proce) {

		int numRegistro = -1;

		try {
			numRegistro = nr.getRegistros(proce);
			numRegistro++;
			nr.setRegistro(numRegistro, proce);
		} catch (SQLException e) {
			return "ERROR, al almacenar n�mero de registro, " + e.getMessage();
		}
		return " A�adido registro " + (numRegistro - 1) + ". ";
	}

	/**
	 * M�todo para obtener el n�mero de registro.
	 * 
	 * @param proce
	 *            Cadena con el n�mero de procedimiento.
	 * @return Cadena con el mensaje de error o el n�mero de registro.
	 * @throws Exception
	 *             Genera una excepci�n gen�rica.
	 */
	public int getNumRegistro(String proce) throws Exception {
		return nr.getRegistros(proce);
	}

	// ROL
	/**
	 * M�todo que comprueba los roles, para ver si existe al identificarse en el
	 * logon.
	 * 
	 * @param iden
	 *            Cadena con el identificador del rol.
	 * @param pass
	 *            Cadena con la clave del rol.
	 * @param tipo
	 *            Cadena para diferenciar si es un rol de usuario o del
	 *            administrador.
	 * @return Un valor booleano dependiendo de como ha ido la operaci�n
	 * @throws Exception
	 *             Genera una excepci�n gen�rica.
	 */
	public boolean comprobarRol(String iden, String pass, String tipo)
			throws Exception {

		String roles[] = r.getRol(tipo).split(" ");

		for (int i = 0; i < roles.length; i++) {
			if (roles[i] != null && roles[i].compareTo("") != 0) {
				String campo[] = roles[i].split(",");
				if (campo[0].compareTo(iden) == 0) {
					if (campo[1].compareTo(pass) == 0) {
						// EXISTE ROL
						return true;
					}
				}
			} else {
				throw new Exception("ERROR, al comprobar el rol. ");
			}
		}
		// NO EXISTE
		return false;
	}

	/**
	 * M�todo que almacena un nuevo rol en la base de datos, referente al nuevo
	 * trabajador dado de alta por el personal de RRHH.
	 * 
	 * @param iden
	 *            Cadena con el identificador del rol.
	 * @param pass
	 *            Cadena con la clave del rol.
	 * @param tipo
	 *            Cadena para diferenciar si es un rol de usuario o del
	 *            administrador.
	 * @return Un valor booleano dependiendo de como ha ido la operaci�n
	 * @throws Exception
	 *             Genera una excepci�n gen�rica.
	 */
	public boolean setRol(String iden, String pass, String tipo)
			throws Exception {
		if (existeRol(r.getRol(tipo), iden) == false) {
			r.setRol(iden, pass, tipo);
			return false;
		} else {
			return true;
		}
	}

	/**
	 * M�todo que comprueba si un rol existe ya o no en la base de datos.
	 * 
	 * @param roles
	 *            Cadena con los roles de la base de datos.
	 * @param iden
	 *            Cadena del identificador del rol a comparar con los de la base
	 *            de datos.
	 * @return Booleano true si existe ese identificador en la base de datos y
	 *         false si no.
	 * @throws Exception
	 *             Genera una excepci�n gen�rica.
	 */
	private boolean existeRol(String roles, String iden) throws Exception {
		String rol[] = roles.split(" ");
		for (int i = 0; i < rol.length; i++) {
			if (rol[i] != null && rol[i].compareTo("") != 0) {
				String[] campos = rol[i].split(",");
				if (campos[0].compareTo(iden) == 0) {
					// EXISTE ROL
					return true;
				}
			} else {
				throw new Exception(
						"ERROR, al comprobar la existencia del rol. ");
			}
		}
		// NO EXISTE ROL
		return false;
	}

	// VISOR DE EVENTOS
	/**
	 * M�todo para obtener el procedimiento.
	 * 
	 * @return Cadena con el mensaje de error o con el procedimiento.
	 */
	public String getProcedimiento() {

		try {
			return ra.getProcedimiento();
		} catch (SQLException e) {
			return "ERROR, al obtener procedimiento, " + e.getMessage();
		}
	}

	/**
	 * M�todo para obtener el registro espec�fico.
	 * 
	 * @param codGeneral
	 *            Cadena con el c�digo general.
	 * @return Cadena con el mensaje de error o con el registo espec�fico.
	 */
	public String getRegistroEspe(String codGeneral) {

		try {
			return re.getRegistroEspe(codGeneral);
		} catch (SQLException e) {
			return "ERROR, al obtener proceso, " + e.getMessage();
		}
	}

	/**
	 * M�todo para obtener la lista de c�digos generales.
	 * 
	 * @param proce
	 *            Cadena con el procedimiento.
	 * @return Cadena con el mensaje de error o con una cadena con los c�digos
	 *         generales.
	 */
	public String getListaCodGenerales(String proce) {

		try {
			return ra.getListaRegistro(proce);
		} catch (SQLException e) {
			return "ERROR, al obtener lista de c�d. generales, "
					+ e.getMessage();
		}
	}
}
