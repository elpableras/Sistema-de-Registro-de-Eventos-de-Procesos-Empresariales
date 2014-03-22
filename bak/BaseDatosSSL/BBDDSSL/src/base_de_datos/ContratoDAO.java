package base_de_datos;

import java.sql.SQLException;

public interface ContratoDAO {
	
	void setContrato(int n,String proce)throws SQLException;
	int getContrato(String proce)throws SQLException;
}
