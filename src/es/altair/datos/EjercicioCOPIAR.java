package es.altair.datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioCOPIAR {
	static int numCaracteres;
	private static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		System.out.print("Texto a guardar: ");
		String texto = sc.nextLine();
		
		File fich1 = new File("textoCopiar.txt");
		if(!fich1.exists()){
			
			FileWriter fw = null;
			BufferedWriter bw = null;
			
			try {
				fw = new FileWriter(fich1);
				bw = new BufferedWriter(fw);
				escribeFichero(bw, texto);
				bw.flush();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					fw.close();
					bw.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("El fichero " + fich1 + fich1.hashCode());
			System.out.println("El fichero " + fich1 + " tiene " + numCaracteres + " caracteres sin contar espacios");
		}
		else {
			System.out.println("El fichero ya existe sorry");
		}
		
		
		if(fich1.exists()) {
			File copiar = new File("textoCopiado.txt");
			FileReader lector = null;
			FileWriter escribir = null;
			
			try {
				lector = new FileReader(fich1);
				escribir = new FileWriter(copiar);
				while(lector.read() != -1) {
				escribir.write((char)lector.read());
				}
				escribir.flush();
			} catch (FileNotFoundException e) {
				System.out.println(e.getMessage());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}	finally {
				System.out.println("Ya está su fichero copiado");
				try {
					lector.close();
					escribir.close();
				} catch (IOException e) {
					System.out.println(e.getMessage());				
					}
			}
			
		}else {
			System.out.println("El fichero no existe");
		}
		
	
		
		
		
		sc.close();
	}
	private static void escribeFichero(BufferedWriter bw, String texto) throws IOException {
		
		String [] tabla = texto.split(" ");
		for (int i = 0; i < tabla.length; i++) {
			String palabra = tabla[i];
			bw.write(tabla[i]+" ");
			System.out.println(tabla[i]);
			for (int j = 0; j < palabra.length(); j++) {
				numCaracteres+=1;
			}
		}
	}

}
