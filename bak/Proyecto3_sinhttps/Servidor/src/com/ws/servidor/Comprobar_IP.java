package com.ws.servidor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Comprobar_IP {

	public Comprobar_IP() {

	}

	public boolean leerIP(String IP) {
		// TODO Auto-generated method stub
		File f = new File("ip.txt");
		Scanner s;
		try {
			s = new Scanner(f);
			// lectura del fichero
			while (s.hasNextLine()) {
				String linea = s.nextLine();
				// Aquí el tratamiento de la línea
				if (IP.compareTo(linea) == 0) {
					return true;
				}
			}

			s.close();
		} catch (FileNotFoundException e) {
			System.out.println("\nFichero no encontrado\n" + e.getMessage());
			;
		}
		return false;
	}

}
