package es.altair.datos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioInversion {
/*
 * Se le debe pedir al usuario que ingrese el nombre de un archivo,
 *  leer línea a línea, invertir cada una de las línea 
 * y guardar todo en un archivo cuyo nombre debe ingresar el usuario.
 */
	private static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		System.out.println("Dime el nombre del fichero");
		String nombreFich = sc.nextLine();
		
		System.out.println("Dime el nombre del archivo en el que se guardarán las líneas");
		String nombreFich2 = sc.nextLine();
		
		File fich1 = new File(nombreFich+ ".txt");
		File fich2 = new File(nombreFich2+ ".txt");
		if(fich1.exists()) {
			tratarFich(fich1, fich2);
		}else
			System.out.println("El fichero no existe");
		
		sc.close();
	}
	private static void tratarFich(File fich1, File fich2) {
		FileReader fr1 = null;
		BufferedReader br1 = null;
		FileWriter fr2 = null;
		BufferedWriter br2 = null;
		String linea;
		try {
			fr1 = new FileReader(fich1);
			br1 = new BufferedReader(fr1);
			fr2 = new FileWriter(fich2);
			br2 = new BufferedWriter(fr2);
			while((linea=br1.readLine())!=null) {
				StringBuffer aux = new StringBuffer(linea);
				br2.write(String.valueOf(aux.reverse()));
				br2.newLine();
				br2.flush();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				fr1.close();
				br1.close();
				fr2.close();
				br2.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}

}
