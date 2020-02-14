package codigo.cotas;

import codigo.Nodo;

public class CPEnvasePorObjeto extends CotaPesimista{

	@Override
	public int devuelveCalculo(Nodo nodo, int[] objetos) {
		return objetos.length - nodo.getK() + nodo.getNumEnvases();
	}

}
