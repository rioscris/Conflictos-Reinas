package conflictos;

import java.util.Arrays;

public class Reina {
	private int x,y;
	private int numReina;
	/**
	 * Vector de tamaño 8 conformado por datos de tipo int.
	 * Cada posicion debe corresponderse con un angulo especifico
	 * a donde se encuentra la reina mas cercana con la que hay un conflicto.
	 * 0: a 0 o 360 grados.
	 * 1: a 45 grados.
	 * 2: a 90 grados.
	 * 3: a 135 grados.
	 * 4: a 180 grados.
	 * 5: a 225 grados.
	 * 6: a 270 grados.
	 * 7: a 315 grados.
	 */
	private int conflictos[];
	
	public int getNumReina() {
		return numReina;
	}

	public void setNumReina(int numReina) {
		this.numReina = numReina;
	}

	/**
	 * Devuelve el numero de la reina con la que tuvo cierto conflicto la reina llamadora.
	 * La primera se encuentra ubicada en el vector "conflictos" de la segunda, segun CUAL haya sido
	 * el angulo entre ellas.
	 * (8 angulos posibles, de 0 a 315 grados en saltos de 45).
	 * @param indiceConflicto : indice en el vector "conflictos" de la reina llamadora
	 * @return Numero de la reina que se encuentra en el indiceConflicto, en formato de tipo int.
	 */
	public int getConflicto(int indiceConflicto) {
		return this.conflictos[indiceConflicto];
	}

	/**
	 * Asigna a la posicion que se encuentra en el indiceConflicto del vector
	 * "conflictos" el numero de reina que se recibe como parametro.
	 * La posicion debe determinarse segun el angulo entre la reina llamadora
	 * y la de numero numReina.
	 * @param indiceConflicto : indice en el vector "conflictos" a escribir. 
	 * @param numReina : numero de la reina con la que se tiene un conflicto.
	 */
	public void setConflicto(int indiceConflicto, int numReina) {
		this.conflictos[indiceConflicto] = numReina;
	}

	/**
	 * Objeto Reina, con coordenadas (x;y) propias y numero de reina segun como venga
	 * en el archivo de entrada.
	 * @param x : coordenada X.
	 * @param y : coordenada Y.
	 * @param numReina : orden en que viene la reina en el archivo (comenzando en 1).
	 */
	public Reina(int x, int y, int numReina)
	{
		this.x = x;
		this.y = y;
		this.numReina = numReina;
		this.conflictos = new int[8]; // Vector de 8 posiciones, una por cada angulo posible a donde se puede encontrar una reina
	}
	
	/*
	public boolean estaMasCerca(Reina otraReina)
	{
		double distancia1 = Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y, 2));
		double distancia2 = Math.sqrt(Math.pow(otraReina.x, 2)+Math.pow(otraReina.y, 2));
		return distancia1<distancia2;
	}
	*/
	
	/**
	 * Devuelve el angulo sexagesimal del vector con inicio en la reina llamadora y 
	 * final en otraReina.
	 * Rango del angulo: [ 0 ; 360 )
	 * @param otraReina : reina hacia la cual determinar el angulo
	 * @return Angulo del vector en formato de tipo double.
	 */
	public double anguloAReina(Reina otraReina)
	{
		double angulo = Math.toDegrees(Math.atan2(otraReina.y-this.y, otraReina.x-this.x));
		return angulo>0?angulo:360+angulo;
	}
	
	/**
	 * Devuelve el numero de la reina, entre las dos recibidas como parametros,
	 * mas cercana a la reina llamadora.
	 * En caso de que se encuentren a la misma distancia devuelve el numero
	 * de la reina2, ya que este metodo no esta preparado para usarse en este caso
	 * (se lo usa cuando ambas reinas se encuentran en el mismo angulo, y si estuviesen
	 * a la misma distancia se trataria de dos reinas en el mismo casillero, situacion descartada de antemano)
	 * @param reina1 
	 * @param reina2 
	 * @return Numero de la reina mas cercana como tipo int.
	 */
	public int numeroReinaMasCercana(Reina reina1, Reina reina2) {
		double distancia1 = Math.sqrt(Math.pow(this.x-reina1.x, 2)+Math.pow(this.y-reina1.y, 2));
		double distancia2 = Math.sqrt(Math.pow(this.x-reina2.x, 2)+Math.pow(this.y-reina2.y, 2));
		return distancia1<distancia2?reina1.numReina:reina2.numReina;
	}
	
	/**
	 * Metodo de ordenamiento del vector "conflictos" de la reina llamadora.
	 * @return La referencia al vector ya ordenado.
	 */
	public int[] ordenarConflictos()
	{
		Arrays.sort(this.conflictos);
		return this.conflictos;
	}
	
}


