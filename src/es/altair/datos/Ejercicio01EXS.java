package es.altair.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio01EXS {
/*
 * /*Escribir un programa que dado un texto de un telegrama que termina en punto:
-contar la cantidad de palabras que posean mas de 10 letras
-la posocion inicial de la palabra mas larga
- reportar el porcentaje de espacios en blanco con respecto al total de caracteres
- cuantas palabras con una longitud entre 8 y 16 caracteres poseen mas de tres veces la vocal a
 */
	static int numMas10, numEspacios, numPalabrasA;
	static String larga;
	public static void main(String[] args) {
		File fich = new File("examen01.txt");
		if(fich.exists()) {
			leerFichero(fich);
		}else {
			System.out.println("No existe");
		}
	}

private static void leerFichero(File fich) {
	FileReader fr = null;
	BufferedReader br = null;
	String linea;
	
	try {
		fr = new FileReader(fich);
		br = new BufferedReader(fr);
		
		while ((linea = br.readLine())!=null) {
			comprobarFich(linea);
		}
	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (IOException e) {
		System.out.println(e.getMessage());
	}
	
	
}

private static void comprobarFich(String linea) {
	String [] datos = linea.split(" ");
	int num=0;
	larga = datos[0]; 
	for (int i = 0; i < datos.length; i++) {
		if(datos[i].length()>10)
			numMas10++;
		if(larga.length() < datos[i].length())
			larga = datos[i];
		if(datos[i].length()>=8 && datos[i].length()<=16)
			 cuentaA(datos[i], num);
			num=0;
			}
		
		
		
		int poslarga = linea.indexOf(larga);
//		-contar la cantidad de palabras que posean mas de 10 letras
		System.out.println("La cantidad de palabras con más de 10 letras: " + numMas10);
//		-la posocion inicial de la palabra mas larga
		System.out.println("La posición inicial de la palabra más larga: " + poslarga);
//		- reportar el porcentaje de espacios en blanco con respecto al total de caracteres		
		numEspacios=(linea.length() * datos.length-1) / 100;
		System.out.println("Porcentaje de espacios: "+ numEspacios+"%");
//		- cuantas palabras con una longitud entre 8 y 16 caracteres poseen mas de tres veces la vocal a
		System.out.println("Num palabras entre 8 y 16 caracteres que poseen más de 3 a: "+ numPalabrasA);
	}


private static void cuentaA(String pal, int num) {
	for (int i = 0; i < pal.length(); i++) {
		if(pal.charAt(i)=='a') {
			num++;
		}
	}
	if(num>3)
		numPalabrasA++;
	
}
	
}


