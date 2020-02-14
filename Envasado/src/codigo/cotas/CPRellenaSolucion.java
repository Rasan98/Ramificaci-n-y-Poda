package codigo.cotas;

import codigo.Nodo;

public class CPRellenaSolucion extends CotaPesimista{

	public int devuelveCalculo(Nodo nodo, int[] objetos) {
		
		int pes = nodo.getNumEnvases(); 
		int[] capacidad_aux = new int[objetos.length];
		System.arraycopy(nodo.getCapacidad(), 0, capacidad_aux, 0, objetos.length);
		
	
		for (int i = nodo.getK() + 1; i < objetos.length; i++) {
			int j = 0;
			while(objetos[i] > capacidad_aux[j])
				j++;
			capacidad_aux[j] -= objetos[i];
			pes = Math.max(pes, j + 1);
		}	
		return pes;
	}

}
