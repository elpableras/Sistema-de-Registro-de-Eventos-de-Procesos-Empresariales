CREATE TABLE especifico (codInterno VARCHAR (25) NOT NULL, codProcedimiento VARCHAR(15) NOT NULL, codContratacion VARCHAR(15) NOT NULL, 
indexacion TEXT NOT NULL, PRIMARY KEY(codInterno), codGeneral VARCHAR(25) NOT NULL, especifico BLOB NOT NULL,
FOREIGN KEY (codGeneral) REFERENCES general(codGeneral) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=InnoDB;