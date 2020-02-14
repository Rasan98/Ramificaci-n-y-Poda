package codigo.cotas;

import codigo.Nodo;

public class COEnvasesYaUsados extends CotaOptimista{

	@Override
	public int devuelveCalculo(Nodo nodo, int[] objetos, int capacidadEnvase) {
		return nodo.getNumEnvases();
	
	}

}
