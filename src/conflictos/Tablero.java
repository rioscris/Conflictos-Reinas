package conflictos;

import java.util.Arrays;

public class Tablero {
	private Reina reinas[];
	private int cantReinas;
	private int tablero; 
	
	public Tablero(Reina[] reinas, int cantReinas, int tamTablero) {
		this.reinas = reinas;
		this.cantReinas = cantReinas;
		this.tablero = tamTablero;
	}

	public int getCantReinas() {
		return this.cantReinas;
	}
	
	public String[] resolverConflictos()
	{
		int[] conflictos = new int[8];
		String[] totalConflictos = new String[cantReinas];
		String aux = "";
		int cantConflictos;
		double angulo;
		for (int i=0; i<cantReinas-1; i++)
		{
			for(int h=0;h<8;h++)
				conflictos[h]=0;	//Limpio el vector de conflictos
			
			for(int j=i+1; j<cantReinas; j++)
			{
				angulo = this.reinas[i].anguloAReina(this.reinas[j]);
				
				if(angulo%45.0==0.0)
				{
					if(conflictos[(int)(angulo/45.0)] != 0)
						conflictos[(int)(angulo/45.0)] = this.reinas[i].numeroReinaMasCercana(this.reinas[conflictos[(int)(angulo/45.0)]-1], this.reinas[j]);
					else
						conflictos[(int)(angulo/45.0)] = this.reinas[j].numReina; //Se guarda el orden de la reina segun el conflicto (el orden real, no el del vector)
				}
			}
			Arrays.sort(conflictos);
			cantConflictos=0;
			aux="";
			for(int h=0;h<8;h++)
			{
				if(conflictos[h]!=0)
				{
					cantConflictos++;
					aux+=" " + conflictos[h];
				}
			}
			totalConflictos[i] = cantConflictos+aux;
		}
		
		return totalConflictos;
	}
}
