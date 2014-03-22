package base_de_datos;

import java.sql.SQLException;

import com.ws.servidor.dato.ListaAutorizadoS;
import com.ws.servidor.dato.ListaDocumentoS;
import com.ws.servidor.dato.ListaGeneradorS;
import com.ws.servidor.dato.RegistroEspeS;

public interface RegistroEspeDAO {
	
	void setRegistro(RegistroEspeS res,ListaDocumentoS d, ListaGeneradorS g, ListaAutorizadoS a)throws SQLException;
	String getRegistroEspe(String codGeneral) throws SQLException; 
	String getPasoAnte(String codGeneralAnte) throws SQLException;
	String getContratoTrabajador(String rol, String codGeneralAnte) throws SQLException;
	String getCodInterno(String codGeneral)throws SQLException;
}
