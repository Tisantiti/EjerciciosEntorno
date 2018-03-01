package es.altair.datos;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class EjercicioOrdenacionEnteros {
//Dado un fichero de texto, constituido únicamente por cadenas que representen valores enteros, elaborar
//un algoritmo que escriba en otro fichero los valores ordenados del fichero de partida. 
	static int contador;
	static int [] tabla;
	static String[] tabla2 ;
	public static void main(String[] args) {
		File fich = new File("numeros.txt");
		File fich2 = new File("numerosOrdenados.txt");
		
		
		
		
		if(fich.exists()) {
			leerFichero(fich);
			tabla = new int [tabla2.length];
			
			for (int i = 0; i < tabla.length; i++) {
				tabla[i]=Integer.parseInt(tabla2[i]);
			}
			Arrays.sort(tabla);
			escribeFichero(fich2);
			System.out.println("Ya has finalizado el ejercicio");
		}
		
		
	}

private static void escribeFichero(File fich2) {
	FileWriter fw = null;
	BufferedWriter bw = null;
		
	try {
		fw = new FileWriter(fich2);
		bw = new BufferedWriter(fw);
		
		for (int i = 0; i < tabla.length; i++) {
			bw.write(String.valueOf(tabla[i]));
			bw.newLine();
		}
		bw.flush();
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

private static void leerFichero(File fich) {
	FileReader fr = null;
	BufferedReader br = null;
	
	String linea;
	try {
		fr = new FileReader(fich);
		br = new BufferedReader(fr);
		
		String numeros = "";
		while((linea=br.readLine())!=null) {
			numeros+=linea+ " ";
		}
		tabla2 = numeros.split(" ");
		
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
	
}

}