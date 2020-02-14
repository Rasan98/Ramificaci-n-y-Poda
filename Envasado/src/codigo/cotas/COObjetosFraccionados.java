package codigo.cotas;

import codigo.Nodo;

public class COObjetosFraccionados extends CotaOptimista{
	
	private int calculo = -1; //Solo necesito hacer el calculo una vez
	@Override
	public int devuelveCalculo(Nodo nodo, int[] objetos, int capacidadEnvase) {
		if(calculo == -1){
			double suma = 0;
			for (int i = 0; i < objetos.length; i++) {
				suma += objetos[i];
			}
			calculo = (int)Math.ceil(suma/capacidadEnvase);
		}
		return calculo;
	}

}
