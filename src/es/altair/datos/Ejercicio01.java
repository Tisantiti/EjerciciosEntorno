package es.altair.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio01 {
private static Scanner sc= new Scanner(System.in);
	public static void main(String[] args) {
		/*Escribir un programa que dado un texto de un telegrama que termina en punto:
-contar la cantidad de palabras que posean mas de 10 letras
-la posocion inicial de la palabra mas larga
- reportar el porcentaje de espacios en blanco con respecto al total de caracteres
- cuantas palabras con una longitud entre 8 y 16 caracteres poseen m�s de tres veces la vocal �a�*/
		
		File telegrama = new File("telegrama.txt");
		FileReader fr = null;
		BufferedReader br=null;
		
		try {
			fr= new FileReader(telegrama);
			br = new BufferedReader(fr);
			
			String linea = null;
			try {
				linea = br.readLine();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			String [] palabras = linea.split(" ");
			int masDeDiez = 0, pos=0, espacios=0, aes=0, caracteres = 0, palabrasConAes=0, caracteresTotales=0;
			float porcentajeEspacios; 
			caracteresTotales=linea.length();
			for (int i = 0; i < palabras.length; i++) {
				if (palabras[i].length()>10)
					masDeDiez++;
				if (i!=0)
					if(palabras[i].length()>palabras[i-1].length())
						pos=i;
				caracteres+=palabras[i].length();
				
				if (palabras[i].length()>8 && palabras[i].length()<16){
					String[] aux=palabras[i].split("");
					for (int j = 0; j < aux.length; j++) {
						if (aux[j].equals("a"))
							aes++;
					}
					if (aes>=3)
						palabrasConAes++;
					
					aes=0;
				}
					
			}
			espacios=caracteresTotales-caracteres;
			porcentajeEspacios=(float)espacios/(float)caracteresTotales *100;
			
			
			System.out.println("Hay "+masDeDiez+ " palabras con mas de diez letras, la palabra mas larga es la numero "+(pos+1)+", el porcentaje de espacios en blanco respecto al total de caracteres es de "+porcentajeEspacios+"% y hay "+palabrasConAes+" con una longitud entre 8 y 16 caracteres que tengan al menos 3 'a'");
			
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}finally{
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		
		sc.close();
	

	}
	
}
