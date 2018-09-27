package conflictos;


public class Tablero {
	private Reina reinas[]; // Vector donde se encuentran todas las reinas del tablero.
	private int cantReinas; // Cantidad total de reinas del tablero.
	private int tablero; // Tamaño del tablero. Por ahora este atributo no tuvo uso.
	
	public Tablero(Reina[] reinas, int cantReinas, int tamTablero) {
		this.reinas = reinas;
		this.cantReinas = cantReinas;
		this.tablero = tamTablero;
	}

	public int getCantReinas() {
		return this.cantReinas;
	}
	
	
	/**
	 * Devuelve un vector de Strings, cada linea contiene los conflictos ordenados
	 * en el formato necesitado para la posterior escritura del archivo.
	 * Contiene tantas lineas como reinas hay.
	 * Cada linea se corresponde con una reina, segun su numReina.
	 * A su vez cada linea comienza con la cantidad de conflictos encontrados y
	 * continua con el numero de reina mas cercana con la que se tuvo un conflicto del mismo tipo (en el mismo angulo).
	 * Los conflictos (numeros de reinas) estan ordenados en orden ascendente.
	 * @return Vector de datos de tipo String.
	 */
	public String[] resolverConflictos()
	{
		String[] totalConflictos = new String[cantReinas]; // Vector de Strings que se retornara ya cargado.
		String aux = ""; // Cadena auxiliar que se usa para ir cargando los conflictos (solamente) de cada reina.
		int cantConflictos; // Cantidad de conflictos de cada reina en particular.
		double angulo; // Angulo entre dos reinas
		int auxReinaMasCercana, auxNumeroReinaAnterior, conflictoSegunAngulo, conflictoSegunAnguloOpuesto;
		/**
		 * conflictoSegunAngulo : indice en el vector "conflictos" en donde se guarda el numero de la reina en cuestion,
		 * con la que se tuvo un conflicto. El mismo se determina segun el angulo que haya tenido, siendo 8 los posibles angulos que generan conflicto.
		 * 
		 * conflictoSegunAnguloOpuesto: indice en el vector "conflictos" CONJUGADO a tomado para el anterior.
		 * (Angulos conjugados suman 360).
		 */
		int[] auxConflictos; // Vector de conflictos de cada reina, ya ordenado
		
		
		// Barrido mayor de todas las reinas (reina actual)
		for (int i=0; i<cantReinas; i++) 
		{
			// Barrido menor de todas las reinas desde la siguiente a la inicial de la secuencia mayor
			// (reina posterior)
			for(int j=i+1; j<cantReinas; j++)
			{
				angulo = this.reinas[i].anguloAReina(this.reinas[j]);
				
				if(angulo%45.0==0.0)
				{
					conflictoSegunAngulo = (int)(angulo/45.0);
					conflictoSegunAnguloOpuesto = (int)(((angulo+180.0)%360.0)/45.0);
					if(this.reinas[i].getConflicto(conflictoSegunAngulo) != 0)
					{
						auxNumeroReinaAnterior = this.reinas[i].getConflicto(conflictoSegunAngulo); 
						auxReinaMasCercana = this.reinas[i].numeroReinaMasCercana(this.reinas[auxNumeroReinaAnterior-1], this.reinas[j]); // Si esta mas cerca con la anterior que ya estaba (para tener el indice se le resta 1 al numero de reina) o con la nueva
						if(auxReinaMasCercana != auxNumeroReinaAnterior)
						{
							this.reinas[i].setConflicto(conflictoSegunAngulo, this.reinas[j].getNumReina());
							this.reinas[j].setConflicto(conflictoSegunAnguloOpuesto, this.reinas[i].getNumReina());
							
							this.reinas[auxNumeroReinaAnterior-1].setConflicto(conflictoSegunAnguloOpuesto, this.reinas[j].getNumReina());
							this.reinas[j].setConflicto(conflictoSegunAngulo, auxNumeroReinaAnterior);
						}
					}
					
					else
					{
						// Realizo a continuacion el empalme entre ambos
						this.reinas[i].setConflicto(conflictoSegunAngulo, this.reinas[j].getNumReina()); //Se guarda el orden de la reina segun el conflicto (el orden real, no el del vector)
						this.reinas[j].setConflicto(conflictoSegunAnguloOpuesto , this.reinas[i].getNumReina());
					}
						
				}
			}
			auxConflictos = this.reinas[i].ordenarConflictos();
			cantConflictos=0;
			aux="";
			for(int h=0;h<8;h++)
			{
				if(auxConflictos[h]!=0)
				{
					cantConflictos++;
					aux+=" " + auxConflictos[h];
				}
			}
			totalConflictos[i] = cantConflictos+aux; // Conforma la cadena final
		}
		
		return totalConflictos;
	}
}
