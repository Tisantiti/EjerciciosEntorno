package es.altair.datos;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioSensores {
/*
		En una fábrica de alimentos se han instalado sensores para monitorear la temperatura de
		distintos lugares de la fábrica en ciertos momentos de tiempo. La información tomada por estos
		sensores es almacenada en un archivo mediciones.txt que tiene el siguiente formato:
			5
			s2 9 10 11 9 9
			s23 8 8 7 10 6
			s211 9
			s12 8 7 6 9 9
			s14 10 10
		El primer número en el archivo indica el número de sensores que estuvieron registrando
		temperaturas (5 en el ejemplo), y las siguientes líneas almacenan las temperaturas registradas
		por cada sensor. Cada una de estas líneas tiene el identificador del sensor seguido por una
		lista de temperaturas. Por ejemplo, para el sensor con identificador s12 se registraron las
		temperaturas 8, 7, 6, 9 y 9.
		En este ejercicio usted debe crear las funciones necesarias para leer la información contenida
		en el archivo mediciones.txt, extraer para cada sensor la temperatura mínima que registró y
		almacenar esta información en el archivo medicionesmin.txt, que tiene el siguiente formato:
			s2 9
			s23 6
			s211 9
			s12 6
			s14 10

 */
	private static Scanner sc = new Scanner (System.in);
	static String [] tabla = new String [2];
	public static void main(String[] args) {
	
	File fich = new File("sensores.txt");
	
	if(fich.exists()) {
		lecturaFichero(fich);
		System.out.println("Has terminado, comprueba tu fichero");
	}
	else
		System.out.println("No existe");
		
		
		
		sc.close();
	}
	private static void lecturaFichero(File fich) {
		File fich2 = new File("medicionesmin.txt");
		
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(fich2);
			bw = new BufferedWriter(fw);
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		}
		
		
		
		
		FileReader fr = null;
		BufferedReader br = null;
		String linea;
		
		try {
			fr = new FileReader(fich);
			br = new BufferedReader(fr);
			
			while((linea=br.readLine())!=null) {
				String [] datos = linea.split(" ");
				guardaDatos(datos, fw,bw, fich2);
			}
				
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				br.close();
				fr.close();
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		try {
			
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void guardaDatos(String[] datos, FileWriter fw, BufferedWriter bw, File fich2) {
		
		String nombre;
		if(datos.length>1) {
			int num = Integer.parseInt(datos[1]);
			nombre = datos[0];
			
			for (int i = 2; i < datos.length; i++) {
				
				if(num > Integer.parseInt(datos[i])) {
					num = Integer.parseInt(datos[i]);
					
				}
			}
			
			try {
				
				bw.write(nombre+" -> "+num);
				bw.newLine();
				
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}		
		}
		
	}

}
