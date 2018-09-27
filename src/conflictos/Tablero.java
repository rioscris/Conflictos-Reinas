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
		
		String[] totalConflictos = new String[cantReinas];
		String aux = "";
		int cantConflictos;
		double angulo;
		int auxReinaMasCercana, auxNumeroReinaAnterior, conflictoSegunAngulo, conflictoSegunAnguloOpuesto;
		for (int i=0; i<cantReinas-1; i++)
		{

			for(int j=i+1; j<cantReinas; j++)
			{
				angulo = this.reinas[i].anguloAReina(this.reinas[j]);
				
				if(angulo%45.0==0.0)
				{
					conflictoSegunAngulo = (int)(angulo/45.0);
					conflictoSegunAnguloOpuesto = (int)(((angulo+180.0)%360.0)/45.0);
					if(this.reinas[i].getConflicto(conflictoSegunAngulo) != 0)
					{
						//conflictos[(int)(angulo/45.0)] = this.reinas[i].numeroReinaMasCercana(this.reinas[conflictos[(int)(angulo/45.0)]-1], this.reinas[j]);
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
						//conflictos[(int)(angulo/45.0)] = this.reinas[j].getNumReina(); //Se guarda el orden de la reina segun el conflicto (el orden real, no el del vector)
						// Realizo a continuacion el empalme entre ambos
						this.reinas[i].setConflicto(conflictoSegunAngulo, this.reinas[j].getNumReina()); //Se guarda el orden de la reina segun el conflicto (el orden real, no el del vector)
						this.reinas[j].setConflicto(conflictoSegunAnguloOpuesto , this.reinas[i].getNumReina());
					}
						
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
