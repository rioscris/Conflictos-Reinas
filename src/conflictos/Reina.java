package conflictos;

public class Reina {
	int x,y;
	int numReina;
	
	
	public Reina(int x, int y, int numReina)
	{
		this.x = x;
		this.y = y;
		this.numReina = numReina+1;
		
	}
	/*
	public boolean estaMasCerca(Reina otraReina)
	{
		double distancia1 = Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y, 2));
		double distancia2 = Math.sqrt(Math.pow(otraReina.x, 2)+Math.pow(otraReina.y, 2));
		return distancia1<distancia2;
	}
	*/
	
	public double anguloAReina(Reina otraReina)
	{
		double angulo = Math.toDegrees(Math.atan2(otraReina.y-this.y, otraReina.x-this.x));
		return angulo>0?angulo:360+angulo;
	}
	
	public int numeroReinaMasCercana(Reina reina1, Reina reina2) {
		double distancia1 = Math.sqrt(Math.pow(this.x-reina1.x, 2)+Math.pow(this.y-reina1.y, 2));
		double distancia2 = Math.sqrt(Math.pow(this.x-reina2.x, 2)+Math.pow(this.y-reina2.y, 2));
		return distancia1<distancia2?reina1.numReina:reina2.numReina;
	}
	
}


