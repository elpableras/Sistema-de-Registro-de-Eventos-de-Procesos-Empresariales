package base_de_datos;

import java.sql.SQLException;

import com.ws.servidor.dato.ListaAutorizadoS;
import com.ws.servidor.dato.ListaGeneradorS;
import com.ws.servidor.dato.ListaCampoS;
import com.ws.servidor.dato.ListaDocumentoS;
import com.ws.servidor.dato.ListaIndicadorS;
import com.ws.servidor.dato.RegistroAdminS;


public interface RegistroAdminDAO {

	// Funciones a realizar
	String getProcedimiento() throws SQLException;
	
	void setRegistro(RegistroAdminS ras,ListaDocumentoS d, ListaCampoS c, ListaIndicadorS i, ListaGeneradorS g, ListaAutorizadoS a)throws SQLException;
	
	void setActualizar(RegistroAdminS ras,ListaDocumentoS d, ListaCampoS c, ListaIndicadorS i, ListaGeneradorS g, ListaAutorizadoS a)throws SQLException;
	
	String getRegistro(String proce)throws SQLException;
	
	String getListaRegistro(String proce)throws SQLException;

}
