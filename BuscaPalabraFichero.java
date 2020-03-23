package buscapalabrafichero;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BuscaPalabraFichero {

	
	public static void main (String[] args) {
		
		
		if (args.length != 3) {

			System.out.println("Introduce en el terminal (ejemplo entre parentesis) java BuscaPalabraFichero BuscaPalabraFichero.java (hola) palabra.txt");
			System.exit(-1);
		}
		
		
		try {
			
			BufferedReader br = new BufferedReader (new FileReader(args[0]));
			BufferedWriter bw = new BufferedWriter (new FileWriter(args[1]));
			
			String linea = "";
			boolean cont = false;
			int contadorLinea = 0;
			
			do {
				
				linea = br.readLine();
				
				if (linea == null) {
					
					break;
					
				}
				
				if (linea.contains(args[1])) {
					
					System.out.println(contadorLinea + ":");
					System.out.println(linea);
					cont = true;
					bw.write(contadorLinea + ": " + linea + "\n");
				}
				
				contadorLinea++;
				
				
			} while (linea != null);
			

			br.close();
			bw.close();
			
			if (!cont) {
				
				System.out.println("No se ha encontrado la palabra introducida");
				
				System.exit(0);
				
			}
			
			
		} catch (FileNotFoundException fnf) {
			
			System.out.println("No se ha encontrado el archivo");
			
		} catch (IOException ioe) {
			
			System.out.println("Error de lectura");
			
		}
	}
}
