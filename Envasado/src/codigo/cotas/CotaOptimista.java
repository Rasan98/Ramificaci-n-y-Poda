package codigo.cotas;

import codigo.Nodo;

public abstract class CotaOptimista {
	
	public abstract int devuelveCalculo(Nodo nodo, int[] objetos, int capacidadEnvase);

}
