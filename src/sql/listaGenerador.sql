CREATE TABLE lGenerador_Espe (codigo VARCHAR(25) NOT NULL PRIMARY KEY, generador TEXT NOT NULL, borrado VARCHAR(1) NOT NULL,
FOREIGN KEY (codigo) REFERENCES especifico(codInterno) ON DELETE CASCADE ON UPDATE CASCADE) ENGINE=InnoDB;