package es.altair.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EjercicioTratamientos01 {
// Elaborar un algoritmo que presente en pantalla un fichero de texto cualquiera.
	public static void main(String[] args) {
		File fich = new File("textoContar.txt");
		
		System.out.println("Vamos a prensentar en pantalla el fichero : " + fich );
		muestraPantalla(fich);
	}

private static void muestraPantalla(File fich) {
	FileReader fr = null;
	BufferedReader br = null;
	
	try {
		fr = new FileReader(fich);
		br = new BufferedReader(fr);
		
		String linea;
		while((linea = br.readLine())!=null) {
			System.out.println(linea);
		}
	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (IOException e) {
		System.out.println(e.getMessage());
	} finally {
		
		try {
			fr.close();
			br.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}

}
