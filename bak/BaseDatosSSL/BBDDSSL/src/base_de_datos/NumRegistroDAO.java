package base_de_datos;

import java.sql.SQLException;

public interface NumRegistroDAO {
	
	void setRegistro(int n,String proce)throws SQLException;
	int getRegistros(String proce)throws SQLException;

}