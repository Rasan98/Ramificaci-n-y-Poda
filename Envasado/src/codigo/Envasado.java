//Raul Sanchez Montaño
package codigo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import codigo.cotas.*;

public class Envasado {
	
	private Comparator<Nodo> cmp;
	
	public Envasado(){
		this.cmp  = new Comparator<Nodo>() {
            
			@Override
			public int compare(Nodo arg0, Nodo arg1) {
				if(arg0.getNumEnvases() < arg1.getNumEnvases())
					return -1;
				if(arg0.getNumEnvases() > arg1.getNumEnvases())
					return 1;
				return 0;
			}
        };
	}
	public SolEnvasado algoritmoCotasBuenas(int E, int[] V, int N){	
		long nodosExplorados = 0;
		double startTime, stopTime;
		CotaPesimista pes = new CPRellenaSolucion();
		CotaOptimista opt = new COObjetosFraccionados();
		
		startTime = System.currentTimeMillis();
		Nodo X, Y;
		PriorityQueue<Nodo> C = new PriorityQueue<Nodo>(cmp);
		boolean encontrada = false;
		int[] sol_mejor = null;
		int envases_mejor;
		int optima = opt.devuelveCalculo(null, V, E);
		
		//generamos el nodo raiz y lo insertamos en la cola
		int[] sol = new int[N];
		int[] cap = new int[N];
		cap[0] = E - V[0];
		for (int i = 1; i < N; i++) {
			cap[i] = E; 
		}
		sol[0] = 1; 
		Y = new Nodo(sol, cap, 1, 0);
		C.add(Y);
		envases_mejor = pes.devuelveCalculo(Y, V);
		//como la cota optimista es igual para todos los nodos, no lo puedo usar para la cola de prioridad.
		//Por ello, usamos el numero de envases
		while(!encontrada && !C.isEmpty() && C.peek().getNumEnvases() <= envases_mejor){
			
			Y = C.remove();
			nodosExplorados++;
			X = new Nodo(Y);
			int i = 0;
			
			//probamos cada envase utilizado
			while (i < Y.getNumEnvases() && !encontrada) {
				
				//si cabe, añadimos el objeto al envase
				if(X.getCapacidad()[i] >= V[X.getK()]){
					X.getSol()[X.getK()] = i + 1;
					X.getCapacidad()[i] -= V[X.getK()];
					/*si es solución la guardo directamente, porque si he dado otra vuelta en
					  el bucle es porque el num de envases era <= que la mejor solución, por lo que
					  al añadir el objeto a un envase sigue siendo mejor, porque el num de envases
					  no aumenta
					*/
					if(X.getK() + 1 == N){
						sol_mejor = X.getSol();
						envases_mejor = X.getNumEnvases();
						encontrada = (envases_mejor == optima);
						//Si he encontrado la optima, como es la mejor posible, paro.
						if (encontrada){
							//STOP TIMER
							stopTime = System.currentTimeMillis();
							return new SolEnvasado(stopTime - startTime, sol_mejor, nodosExplorados, envases_mejor, N, 2);
						}
					}
					else {
						C.add(X);
						int pesimista = pes.devuelveCalculo(X, V);
						envases_mejor = Math.min(pesimista, envases_mejor);
			
					}
					X = new Nodo(Y);
				}
				i++;
			}
			if (!encontrada){
				
				//probamos con un envase nuevo
				int nuevo = Y.getNumEnvases() + 1;
				X.getSol()[X.getK()] = nuevo;
				X.setNumEnvases(nuevo);
				X.getCapacidad()[nuevo - 1] = E - V[X.getK()];
				
				//si es mejor que la solucion actual
				if(X.getNumEnvases() <= envases_mejor){
					//si es solución la guardo, 
					if(X.getK() + 1 == N){
						sol_mejor = X.getSol();
						envases_mejor = X.getNumEnvases();
						encontrada = (envases_mejor == optima);
						//Si he encontrado la optima, como es la mejor posible, paro.
						if (encontrada){
							//STOP TIMER
							stopTime = System.currentTimeMillis();
							return new SolEnvasado(stopTime-startTime, sol_mejor, nodosExplorados, envases_mejor, N, 2);
						}
					}
					else {
						C.add(X);
						int pesimista = pes.devuelveCalculo(X, V);
						envases_mejor = Math.min(pesimista, envases_mejor);
					}
				}
			}	
		}
		//STOP TIMER
		stopTime = System.currentTimeMillis();
		return new SolEnvasado(stopTime-startTime, sol_mejor, nodosExplorados, envases_mejor, N, 2);
	}
	
	public SolEnvasado algoritmoCotasMalas(int E, int[] V, int N){	
		long nodosExplorados = 0;
		double startTime, stopTime;
		CotaPesimista pes = new CPEnvasePorObjeto();
		CotaOptimista opt = new COEnvasesYaUsados();
		
		startTime = System.currentTimeMillis();
		Nodo X, Y;
		PriorityQueue<Nodo> C = new PriorityQueue<Nodo>(cmp);
		int[] sol_mejor = null;
		int envases_mejor;
		
		//generamos el nodo raiz y lo insertamos en la cola
		int[] sol = new int[N];
		int[] cap = new int[N];
		cap[0] = E - V[0];
		for (int i = 1; i < N; i++) {
			cap[i] = E; 
		}
		sol[0] = 1; 
		Y = new Nodo(sol, cap, 1, 0);
		C.add(Y);
		envases_mejor = pes.devuelveCalculo(Y, V);
		//devuelveCalculo simplemente devuelve el numero de envases del nodo
		while(!C.isEmpty() && opt.devuelveCalculo(C.peek(), null, 0) <= envases_mejor){
			
			Y = C.remove();
			nodosExplorados++;
			X = new Nodo(Y);
			int i = 0;
			
			//probamos cada envase utilizado
			while (i < Y.getNumEnvases()) {
				
				//si cabe, añadimos el objeto al envase
				if(X.getCapacidad()[i] >= V[X.getK()]){
					X.getSol()[X.getK()] = i + 1;
					X.getCapacidad()[i] -= V[X.getK()];
					/*si es solución la guardo directamente, porque si he dado otra vuelta en
					  el bucle es porque el num de envases era <= que la mejor solución, por lo que
					  al añadir el objeto a un envase sigue siendo mejor, porque el num de envases
					  no aumenta
					*/
					if(X.getK() + 1 == N){
						sol_mejor = X.getSol();
						envases_mejor = X.getNumEnvases();
					}
					else {
						C.add(X);
						int pesimista = pes.devuelveCalculo(X, V);
						envases_mejor = Math.min(pesimista, envases_mejor);
			
					}
					X = new Nodo(Y);
				}
				i++;
			}
			
			//probamos con un envase nuevo
			int nuevo = Y.getNumEnvases() + 1;
			X.getSol()[X.getK()] = nuevo;
			X.setNumEnvases(nuevo);
			X.getCapacidad()[nuevo - 1] = E - V[X.getK()];
			
			//si es mejor que la solucion actual
			if(X.getNumEnvases() <= envases_mejor){
				//si es solución la guardo, 
				if(X.getK() + 1 == N){
					sol_mejor = X.getSol();
					envases_mejor = X.getNumEnvases();
				}
				else {
					C.add(X);
					int pesimista = pes.devuelveCalculo(X, V);
					envases_mejor = Math.min(pesimista, envases_mejor);
				}
			}
		}		
		//STOP TIMER
		stopTime = System.currentTimeMillis();
		return new SolEnvasado(stopTime-startTime, sol_mejor, nodosExplorados, envases_mejor, N, 1);
	}
	
	public SolEnvasado algoritmoSinCotas(int E, int[] V, int N){	
		long nodosExplorados = 0;
		double startTime, stopTime;
	
		startTime = System.currentTimeMillis();
		Nodo X, Y;
		List<Nodo> C = new LinkedList<Nodo>();
		int[] sol_mejor = null;
		//generamos el nodo raiz y lo insertamos en la co
		int[] sol = new int[N];
		int[] cap = new int[N];
		cap[0] = E - V[0];
		for (int i = 1; i < N; i++) {
			cap[i] = E; 
		}
		sol[0] = 1; 
		Y = new Nodo(sol, cap, 1, 0);
		C.add(Y);
		int envases_mejor = Integer.MAX_VALUE;
		while(!C.isEmpty()){
			
			Y = C.remove(0);
			nodosExplorados++;
			X = new Nodo(Y);
			int i = 0;
			
			//probamos cada envase utilizado
			while (i < Y.getNumEnvases()) {
				
				//si cabe, añadimos el objeto al envase
				if(X.getCapacidad()[i] >= V[X.getK()]){
					X.getSol()[X.getK()] = i + 1;
					X.getCapacidad()[i] -= V[X.getK()];
					
					if(X.getK() + 1 == N){
						//si es mejor que la solucion actual, la guardo.
						if(envases_mejor > X.getNumEnvases()){
							sol_mejor = X.getSol();
							envases_mejor = X.getNumEnvases();
						}
					}
					else {
						C.add(X);
					}
					X = new Nodo(Y);
				}
				i++;
			}
			
			//probamos con un envase nuevo
			int nuevo = Y.getNumEnvases() + 1;
			X.getSol()[X.getK()] = nuevo;
			X.setNumEnvases(nuevo);
			X.getCapacidad()[nuevo - 1] = E - V[X.getK()];
			
			
			//si es solución
			if(X.getK() + 1 == N){
				//si es mejor que la solucion actual, la guardo
				if(X.getNumEnvases() <= envases_mejor){
					sol_mejor = X.getSol();
					envases_mejor = X.getNumEnvases();
				}
			}
			else {
				C.add(X);
			}
		}		
		//STOP TIMER
		stopTime = System.currentTimeMillis();
		return new SolEnvasado(stopTime-startTime, sol_mejor, nodosExplorados, envases_mejor, N, 0);
	}
}