CREATE TABLE Registro_Admin (nombre BLOB, codGeneral VARCHAR(10) NOT NULL PRIMARY KEY, descripcion BLOB, tipo VARCHAR(2), codProcedimiento VARCHAR(5), 
					   actividad BLOB, docuVinculadosG BLOB, lCampos BLOB, frecuencia VARCHAR(100), metodo BLOB, lIndicadores VARCHAR(100), geneRegistroG VARCHAR(100), 
					   autoConsultaG VARCHAR(100), archivo VARCHAR(50), retencion VARCHAR(100), conservacion VARCHAR(50), disposicion VARCHAR(100), almacen VARCHAR(50), registro BLOB);
