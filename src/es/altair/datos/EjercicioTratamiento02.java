package es.altair.datos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class EjercicioTratamiento02 {
//	Dada una palabra, diremos que está “escondida” en un texto si está contenida en éste, 
//	no necesariamente de forma continua. Por ejemplo, la palabra “ana” está escondida en la frase “Juan estaba mirando por la ventana”.
//	El algoritmo tal que, dada una palabra leída por teclado, la busque en un texto almacenado en un fichero de texto. 
//	Como resultado el algoritmo deberá presentar el mensaje:  Palabra <palabra> no encontrada en el texto. 
//	O bien Palabra <palabra> encontrada escondida entre los <p> primeros caracteres del texto. En el ejemplo el resultado debería ser: 
//		Palabra ana encontrada escondida entre los 34 primeros caracteres del texto. 
	private static Scanner sc = new Scanner (System.in);
	static int caracteres = 0;
	public static void main(String[] args) {
		File fich = new File("textoContar.txt");
		System.out.println("Dime la palabra a buscar: ");
		String palabra = sc.nextLine();
		
		if(fich.exists()) {
			encuentraPalabra(fich, palabra);
		}else
			System.out.println("El fichero no existe");

		sc.close();
	}
	private static void encuentraPalabra(File fich, String palabra) {
		FileReader fr = null;
		BufferedReader br = null;
		String texto = "";
		String linea;
		try {
			fr = new FileReader(fich);
			br = new BufferedReader(fr);
			while((linea=br.readLine())!=null) {
				texto += linea+" ";
				
			}
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// Para calcular la palabra escondida basta con usar .indexOf
		// si encuentra la palabra guarda la posición de la primera ocurrencia
		// de la palabra
		System.out.println(texto);
		caracteres = texto.indexOf(palabra);
		// si es -1 es que no la ha encontrado
		if(caracteres != -1)
			System.out.println("Palabra "+ palabra +" encontrada escondida entre los "+ caracteres + " primeros caracteres del texto.");
		else
			System.out.println("No hemos encontrado la palabra : "+ palabra);
		
		
		
		
		
		
	}

}
