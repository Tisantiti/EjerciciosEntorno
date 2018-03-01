package es.altair.datos;

import java.util.Scanner;

public class Ejercicio03 {
private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/*Realizar un programa que lea una cadena de n caracteres e imprima el resultado que se obtiene
		 *  cada vez que se realiza una rotaci�n de un car�cter a la derecha sobre dicha cadena.
		 *  El proceso finalizar� cuando se haya obtenido nuevamente la cadena de caracteres original. 
		 *  Por ejemplo: HOLA AHOL LAHO OLAH HOLA*/
		
		System.out.println("Introduzca una cadena: ");
		String linea =sc.nextLine();
		String [] tabla = linea.split("");
		
		
		for (int j = 0; j < tabla.length; j++) {
			
		
		String aux = null;
		aux = tabla[tabla.length-1];
		for (int i=tabla.length-1; i>0;i--) {
			
			tabla[i]=tabla[i-1];
			
		}
		tabla[0]=aux;
		
		for (int i = 0; i < tabla.length; i++) {
			System.out.print(tabla[i]);
			
		}
		System.out.println();
		}
		
		
		sc.close();
	}

}
