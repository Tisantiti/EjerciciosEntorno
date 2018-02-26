package es.altair.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio02 {

	private static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) {
		System.out.println("Fichero: ");
		String nombre = sc.next();
		
		File fich = new File(nombre);
		
		if(fich.exists()) {
			leeFichero(fich);
			System.out.println("Se han creado los txt con los registros de cada fila del fichero: "
					+ nombre);
		}else {
			System.out.println("No existe");
		}
		
		
		
		sc.close();
	}
	private static void leeFichero(File fich) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(fich);
			br = new BufferedReader(fr);
			
			String linea;
			while((linea = br.readLine())!=null){
				String [] tabla = linea.split(";");
				escribeFichero(tabla);
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
	private static void escribeFichero(String[] tabla) {
		File fich2 = new File(tabla[0]+".txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		float media = 0;
		int num = 0;
		try {
			fw = new FileWriter(fich2);
			bw = new BufferedWriter(fw);
			
			bw.write("ID: "+tabla[0]);
			bw.newLine();
			bw.write("Nombre: " + tabla[1]);
			bw.newLine();
			bw.write("DNI: " + tabla[2]);
			bw.newLine();
			bw.write("MÓVIL: " + tabla[3]);
			bw.newLine();
			bw.write("NACIONALIDAD: " + tabla[4]);
			
			for (int i = 5; i < tabla.length; i++) {
				media += Float.parseFloat(tabla[i]);
				num++;
			}
			media = media / num;
			bw.newLine();
			bw.write("MEDIA :" + media);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		
		
	}

	
}
