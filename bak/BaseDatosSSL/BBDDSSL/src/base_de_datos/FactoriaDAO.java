package base_de_datos;

public abstract class FactoriaDAO {

	public static final int eXist = 1;
	public static final int MySQL = 2;
	public static final int psePro = 3;

	// INSERTAR POR CADA CLASE
	public abstract RegistroAdminDAO RegistroAdminDAO();
	
	public abstract RegistroEspeDAO RegistroEspeDAO();

	public abstract ContratoDAO ContratoDAO();
	
	public abstract NumRegistroDAO NumRegistroDAO();
	
	public abstract CorreoDAO CorreoDAO();
	
	public abstract RolDAO RolDAO();

	public static FactoriaDAO getFactoriaDAO(int factoria) {

		switch (factoria) {
		case eXist: // return new eXistFactoriaDAO();
		case MySQL:
			return new MySQLFactoriaDAO();
		case psePro: // return new pseProFactoriaDAO();
		default:
			return null;
		}

	}

}
