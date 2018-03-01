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
private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/*2. Se le debe pedir al usuario que ingrese el nombre de un archivo, leer l�nea a l�nea,
		 *  invertir cada una de las l�neas y guardar todo en un archivo cuyo nombre debe ingresar
		 *   el usuario.*/
		System.out.println("Introduzca el nombre del archivo a leer:");
		String nombre = sc.nextLine();
		System.out.println("Ahora el nombre del archivo a escribir:");
		String salida = sc.nextLine();
		
		
		File fichero =new File(nombre);
		File ficheroSalida = new File(salida);
		
		
		FileReader fr=null;
		BufferedReader br=null;
		
		FileWriter fw =null;
		BufferedWriter bw = null;
		
		try {
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);
			
			fw = new FileWriter(ficheroSalida);
			bw = new BufferedWriter(fw);
			
			
			String linea;
			String [] reverse = null;
			
			
			
			while ((linea=br.readLine())!=null){
				reverse=linea.split("");
				for (int i =reverse.length-1; i >=0 ; i--) {
					bw.write(reverse[i]);
				}
				bw.newLine();
				
			}
			
			bw.flush();
			fw.flush();
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				fr.close();
				br.close();
				
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		
		sc.close();
	}

}
