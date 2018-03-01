package es.altair.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EjercicioSensores2 {
/*
 * /*
		En una f�brica de alimentos se han instalado sensores para monitorear la temperatura de
		distintos lugares de la f�brica en ciertos momentos de tiempo. La informaci�n tomada por estos
		sensores es almacenada en un archivo mediciones.txt que tiene el siguiente formato:
			5
			s2 9 10 11 9 9
			s23 8 8 7 10 6
			s211 9
			s12 8 7 6 9 9
			s14 10 10
		El primer n�mero en el archivo indica el n�mero de sensores que estuvieron registrando
		temperaturas (5 en el ejemplo), y las siguientes l�neas almacenan las temperaturas registradas
		por cada sensor. Cada una de estas l�neas tiene el identificador del sensor seguido por una
		lista de temperaturas. Por ejemplo, para el sensor con identificador s12 se registraron las
		temperaturas 8, 7, 6, 9 y 9.
		En este ejercicio usted debe crear las funciones necesarias para leer la informaci�n contenida
		en el archivo mediciones.txt, extraer para cada sensor la temperatura m�nima que registr� y
		almacenar esta informaci�n en el archivo medicionesmin.txt, que tiene el siguiente formato:
			s2 9
			s23 6
			s211 9
			s12 6
			s14 10

 */

	public static void main(String[] args) {
		File fich = new File("sensores.txt");
		
		if(fich.exists()) {
			leerFichero(fich);
		}else
			System.out.println("No existe");
	}

private static void leerFichero(File fich) {
	File fich2 = new File("medicionesmin.txt");
	
	FileWriter fw = null;
	BufferedWriter bw = null;
	
	
	FileReader fr = null;
	BufferedReader br = null;
	String linea;
	
	try {
		fr = new FileReader(fich);
		br = new BufferedReader(fr);
		fw = new FileWriter(fich2);
		bw = new BufferedWriter(fw);
		
		while((linea=br.readLine())!=null) {
			String [] datos = linea.split(" ");
			if(datos.length > 1) {
				int num = Integer.parseInt(datos[1]);
			for (int i = 2; i < datos.length; i++) {
				if(num > Integer.parseInt(datos[i])) 
					num = Integer.parseInt(datos[i]);					
			}
			bw.write(datos[0] +"->"+ num);
			bw.newLine();
			bw.flush();
			}
		}
		} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (IOException e) {
		System.out.println(e.getMessage());
	} finally {
		try {
			fr.close();
			br.close();
			fw.close();
			bw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}


}
