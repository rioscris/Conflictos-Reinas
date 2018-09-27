package conflictos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {

	/**
	 * Lectura del archivo de entrada de datos.
	 * Devuelve el tablero con las reinas ubicadas en su vector reinas[]
	 * en el orden en que se leen del archivo.
	 * @param path : Ruta en tipo String del archivo de entrada (absoluta o relativa).
	 * @return Tablero cargado con las reinas.
	 * @throws FileNotFoundException en caso de no haber encontrado el archivo.
	 */
	public Tablero leer(String path) throws FileNotFoundException {
		
		Reina reinas[]; // Vector que almacena todas las reinas del tablero.
		Tablero tablero; // Tablero actual donde se cargan las reinas y que se termina retornando. 
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);// ----->nose que hace / ------> yo tampoco :v
		
		int tamTablero = sc.nextInt(); // Lectura del tamaño del tablero
		int cantReinas = sc.nextInt(); // Lectura de la cantidad de reinas en el tablero
		
		reinas = new Reina[cantReinas]; // Dimensionamiento del vector de reinas
		for (int i = 0; i < cantReinas; i++) {
			// Se va creando y cargando cada Reina del archivo, con sus respectivas coordenadas y numero de reina (uno mayor al indice i).
			reinas[i] = new Reina(sc.nextInt(), sc.nextInt(), i+1);
		}
		
		// Creacion y carga del tablero
		tablero = new Tablero(reinas, cantReinas, tamTablero);
		
		sc.close();
		return tablero;
	}
	
	/**
	 * Escritura del tablero resolviendo los conflictos
	 * en el archivo especificado como path.
	 * @param path : Ruta del archivo de salida.
	 * @param tablero : Tablero a resolver donde se encuentran las reinas.
	 * @throws IOException : En caso de no haber podido escribir el archivo.
	 */
	public void escribir(String path, Tablero tablero) throws IOException {
		
		PrintWriter salida = new PrintWriter(new FileWriter(path));

		// Obtencion de las cadenas de texto con los conflictos resueltos
		String[] cadenas = tablero.resolverConflictos();
		
		// Escritura de todas las cadenas en el archivo de salida.
		for(int i=0; i<tablero.getCantReinas(); i++)
			salida.println(cadenas[i]);

		salida.close();
		
	}
}
