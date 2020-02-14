//Raul Sanchez Montaño
package codigo;

public class SolEnvasado {
	
	private double tiempoSol;
	private int[] sol;
	private long numNodos;
	private int numEnvases;
	private int n;
	private double tiempoNodos;
	private String tipo;
	
	public SolEnvasado(double tiempoSol, int[] sol,long numNodos, int numEnvases, int n, int tipo) {
		this.tiempoSol = tiempoSol;
		this.numNodos = numNodos;
		this.numEnvases = numEnvases;
		this.n = n;
		this.sol = sol;
		this.tiempoNodos = tiempoSol/numNodos;
		switch(tipo){
		case 0:
			this.tipo = "Sin cotas";
			break;
		case 1:
			this.tipo = "Cotas malas";
			break;
		case 2:
			this.tipo = "Cotas buenas";
			break;
		}
	}
	
	public void print(){
		String mensaje = "Datos de la solucion encontrada con ramificacion y poda (" + tipo + "): \n Solucion encontrada:\n";
		
		for (int j = 0; j < n; j++) {
			mensaje += sol[j] + " ";
		}
		
		mensaje += "\n Tiempo medio de nodo: " + (this.tiempoNodos/this.numNodos) + "ms\n Tiempo total: " + this.tiempoSol + "ms\n Num nodos: " + this.numNodos + "\n Num envases: " + this.numEnvases + "\n Tamaño de la muestra: " + this.n;
	
		System.out.println(mensaje + "\n\n");
	}
	
}
