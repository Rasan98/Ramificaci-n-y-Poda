//Raul Sanchez Montaño
package codigo;

public class Nodo{

	private int[] sol;
	private int[] capacidad;
	private int numEnvases;
	private int k;
	
	public Nodo(int[] sol, int[] capacidad, int numEnvases, int k) {
		super();
		this.sol = sol;
		this.capacidad = capacidad;
		this.numEnvases = numEnvases;
		this.k = k;
	}
	
	public Nodo(Nodo padre) {
		super();
		int N = padre.sol.length;
		
		this.sol = new int[N];
		this.capacidad = new int[N];
		for (int i = 0; i <= padre.k; i++) {
			this.sol[i] = padre.sol[i]; 
			this.capacidad[i] = padre.capacidad[i]; 
		}
		for (int i = padre.k + 1; i < N; i++)
			this.capacidad[i] = padre.capacidad[i];
		
		this.numEnvases = padre.numEnvases;
		this.k = padre.k + 1;
	}
	
	public int[] getSol() {
		return sol;
	}
	
	public int[] getCapacidad() {
		return capacidad;
	}
	
	public int getNumEnvases() {
		return numEnvases;
	}
	
	public void setNumEnvases(int valor) {
		numEnvases = valor;
	}
	
	public int getK() {
		return k;
	}


}
