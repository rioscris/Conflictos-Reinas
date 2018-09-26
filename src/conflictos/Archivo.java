package conflictos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {

	public Tablero leer(String path) throws FileNotFoundException {
		
		Reina reinas[];
		Tablero tablero;
		Scanner sc = new Scanner(new File(path));
		sc.useLocale(Locale.ENGLISH);// ----->nose que hace / ------> yo tampoco :v
		
		int tamTablero = sc.nextInt();
		int cantReinas = sc.nextInt();
		
		// inicializo los arrays con sus respectivos tamaños
		//matriz = new int[tamTablero][tamTablero];
		
		reinas = new Reina[cantReinas];
		for (int i = 0; i < cantReinas; i++) {
			//matriz[i][0]= sc.nextInt();
			//matriz[i][1]= sc.nextInt();
			
			reinas[i] = new Reina(sc.nextInt(), sc.nextInt(), i);
		}
		
		tablero = new Tablero(reinas, cantReinas, tamTablero);
		
		sc.close();
		return tablero;
	}
	
	public void escribir(String path, Tablero tablero) throws IOException {
		
		PrintWriter salida = new PrintWriter(new FileWriter(path));

		String[] cadenas = tablero.resolverConflictos();
		for(int i=0; i<tablero.getCantReinas(); i++)
			salida.println(cadenas[i]);

		salida.close();
		
	}
}




/*

public class ArchivoNegocio extends Vendedora {

	public Negocio leerArchivoNegocio(String nombreArchivo) throws FileNotFoundException {

		File archivo = new File(nombreArchivo);
		Scanner sc = new Scanner(archivo);
		sc.useLocale(Locale.ENGLISH);// NOSE QUE HACE

		int cantVendedoras = sc.nextInt();// OBTENGO LA CANTIDAD DE VENDEDORAS
		int cantComparaciones = 0;
		// System.out.println(cantVendedoras);
		
		Vendedora[] vendedora = new Vendedora[cantVendedoras];// INICIALIZO EL VECTOR VENDEDORA CON LA CANTIDAD DE VENDEDORAS
		for (int i = 0; i < cantVendedoras; i++) {

			vendedora[i] = new Vendedora(); //ESTOOOO
			int cantVentasVendedora = sc.nextInt(); // EL PRIMER NUMERO REFLEJA LA CANTIDAD DE VENTAS DE LA VENDEDORA
			int[] ventas = new int[cantVentasVendedora];
			//System.out.println(cantVentasVendedora);
			
			for (int j = 0; j < cantVentasVendedora; j++) {
				ventas[j] = sc.nextInt();
				// System.out.println(ventas[j]);
			}

			vendedora[i].setN_vendedora(i);
			vendedora[i].setVentas(ventas);

		}
		cantComparaciones = sc.nextInt();
		sc.close();// -------------------------------->cierro el archivo
		Negocio negocio = new Negocio(vendedora, cantComparaciones, cantVendedoras);
		// System.out.println(cantComparaciones);		
	return negocio;
	}

	public void escribirGanadora(Vendedora vendedora, String nombreDoc) throws IOException {

		PrintWriter salida = new PrintWriter(new FileWriter(nombreDoc));

		salida.println(vendedora.getN_vendedora());
		salida.print(vendedora.getVentasCons() + " ");
		salida.print(vendedora.getImporte());

		salida.close();
	}

}


*/