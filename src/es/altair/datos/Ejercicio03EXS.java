package es.altair.datos;

import java.util.Scanner;

public class Ejercicio03EXS {
	/*Realizar un programa que lea una cadena de n caracteres e imprima el resultado que se obtiene
	 *  cada vez que se realiza una rotacion de un caracter a la derecha sobre dicha cadena.
	 *  El proceso finalizara cuando se haya obtenido nuevamente la cadena de caracteres original. 
	 *  Por ejemplo: HOLA AHOL LAHO OLAH HOLA*/
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Dime una cadena");
		String frases = sc.nextLine();
	
		String [] letras = frases.split("");
		
		for (int i = 0; i < letras.length; i++) {
			
			String aux = null;
			aux = letras[letras.length-1]; // Aquí guarda la última letras
			for (int j = letras.length-1; j >0; j--) {
				letras[j]=letras[j-1]; // cambio la última por la siguiente por la izquierda
				
			}
			letras[0]=aux;
			
			for (int j = 0; j < letras.length; j++) {
				System.out.print(letras[j]);
			}
			System.out.println();
		}

		
		sc.close();
	}

}
