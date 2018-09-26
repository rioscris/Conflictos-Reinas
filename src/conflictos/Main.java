package conflictos;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		Archivo archivo = new Archivo();
		Tablero tablero = archivo.leer("reinas.in");
		archivo.escribir("reinas.out", tablero);
	}

}
