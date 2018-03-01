package es.altair.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio02EXS {
	/*2. Se le debe pedir al usuario que ingrese el nombre de un archivo, leer l�nea a l�nea,
	 *  invertir cada una de las l�neas y guardar todo en un archivo cuyo nombre debe ingresar
	 *   el usuario.*/
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Dime nombre fich");
		String nombre = sc.next();
		
		File fich = new File(nombre+ ".txt");
		
		if(fich.exists()) {
			tratarFichero(fich);
		}else
			System.out.println("No existe");
		
		sc.close();

	}
	private static void tratarFichero(File fich) {
		System.out.println("Dime el fichero: ");
		String nombre = sc.next();
		File fich2 = new File (nombre+".txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		
		FileReader fr = null;
		BufferedReader br = null;
		String linea = "";
		try {
			
			fr = new FileReader(fich);
			br = new BufferedReader(fr);
			
			fw = new FileWriter(fich2);
			bw = new BufferedWriter(fw);
			
			while((linea=br.readLine())!=null) {
				StringBuffer inverso = new StringBuffer(linea);
				inverso = inverso.reverse();
				bw.write(String.valueOf(inverso));
				bw.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				br.close();
				fr.close();
				bw.close();
				fw.close();			
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}

}
