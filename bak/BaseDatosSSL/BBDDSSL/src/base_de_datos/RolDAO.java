package base_de_datos;

import java.sql.SQLException;

public interface RolDAO {

	String getRol(String tipo) throws SQLException;
	
	void setRol(String iden, String pass, String tipo) throws SQLException;
}
