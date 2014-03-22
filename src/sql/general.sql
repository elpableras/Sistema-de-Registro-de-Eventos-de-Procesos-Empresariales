CREATE TABLE general (nombre VARCHAR (90) NOT NULL, codGeneral VARCHAR(12) NOT NULL, PRIMARY KEY (codGeneral), descripcion TEXT NOT NULL, tipo VARCHAR(1) NOT NULL, 
codProcedimiento VARCHAR(6) NOT NULL, actividad VARCHAR (90) NOT NULL, frecuencia VARCHAR (90) NOT NULL, 
metodo TINYTEXT NOT NULL, archivo VARCHAR(25) NOT NULL, retencion VARCHAR(70) NOT NULL,
conservacion VARCHAR(50) NOT NULL, disposicion VARCHAR(65) NOT NULL, almacen VARCHAR(50) NOT NULL, general BLOB NOT NULL, 
FOREIGN KEY (codGeneral) REFERENCES procedimiento(codGeneral) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=InnoDB;