package es.altair.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioCONTAR {
//laborar un algoritmo que lea un fichero de texto en disco 
//y cuente el número de caracteres, el número de palabras 
//y el número de líneas que contiene el mismo, 
//presentado estos datos como resultado en pantalla.
//Para contar las palabras, considerar como una palabra cualquier sucesión de 
//caracteres separada por uno o más blancos, tabuladores, símbolos de puntuación o fin de línea.
	static int numCaracteres = 0, numPalabras = 0 , numFilas  = 0;
	private static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		System.out.println("Fichero: ");
		String nombre = sc.next();
		
		File fich = new File(nombre);
		if(fich.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			
			try {
				fr = new FileReader(fich);
				br = new BufferedReader(fr);
				
				String linea;
				
				try {
					while((linea = br.readLine())!=null) {
						numFilas++;
						String [] palabras = linea.split(" ");
						numPalabras += palabras.length;
						numCaracteres += linea.length() - (palabras.length -1);
					}
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					fr.close();
					br.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
				
			}
		} else {
			System.out.println("No existe");
		}
		
		System.out.println("Su fichero " + fich + " tiene " + numFilas + " filas");
		System.out.println("Su fichero " + fich + " tiene " + numPalabras + " palabras");
		System.out.println("Su fichero " + fich + " tiene " + numCaracteres + " caracteres");
		sc.close();
	}

}
