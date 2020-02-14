//Raul Sanchez Montaño
package codigo;

public class Main {
	
	private int[] setPrueba1 = {2,2,1,2,2};
	private int EPrueba1 = 5;
	
	private int[] setPrueba2 = {2,2,2,2,2,2,2,2,2,2};
	private int EPrueba2 = 4;
	
	
	private int[] set1 = {20,19,17,18,9,12,12,13,20,16,20,13,6,17,9,13,13,15,10,15};
	private int E1 = 30;
	
	private int[] set2 = {6,19,18,14,8,8,20,11,5,12,12,9,9,20,10};
	private int E2 = 30;
	
	private int[] set3 = {8,7,7,7,8,9,7,9,5,6,6,6,8,10};
	private int E3 = 20;
	
	private int[] set4 = {6,8,6,7,6,5,8,5,7,9,8,7,5,8,7,5,9,8,9};
	private int E4 = 15;
	
	
	public Main(){};
	
	
	public static void main(String[] args) {
		System.out.println("Tamaño de heap utilizado:" + Runtime.getRuntime().maxMemory()/1000000000f + " gb");
		Main m = new Main();
		m.ejecutar();
	}

	public void ejecutar(){
		
		Envasado algoritmo = new Envasado();
		SolEnvasado solucion;
		//Casos de prueba para ver el caracter optimo
		/*
		solucion = algoritmo.algoritmoCotasBuenas(EPrueba1, setPrueba1, 5);
		solucion.print();
		
		solucion = algoritmo.algoritmoCotasMalas(EPrueba1, setPrueba1, 5);
		solucion.print();
		
		solucion = algoritmo.algoritmoSinCotas(EPrueba1, setPrueba1, 5);
		solucion.print();
	
		solucion = algoritmo.algoritmoCotasBuenas(EPrueba2, setPrueba2, 10);
		solucion.print();
		
		solucion = algoritmo.algoritmoCotasMalas(EPrueba2, setPrueba2, 10);
		solucion.print();
		
		solucion = algoritmo.algoritmoSinCotas(EPrueba2, setPrueba2, 10);
		solucion.print();
		*/
		
		//Descomentar para probar el set1. No incluye el algoritmoSinCotas ya que llena el heap
		/*
		solucion = algoritmo.algoritmoCotasBuenas(E1, set1, 20);
		solucion.print();
		
		solucion = algoritmo.algoritmoCotasMalas(E1, set1, 20);
		solucion.print();
		*/
		
		//Descomentar para probar el set2.
		/*
		solucion = algoritmo.algoritmoCotasBuenas(E2, set2, 15);
		solucion.print();
		
		solucion = algoritmo.algoritmoCotasMalas(E2, set2, 15);
		solucion.print();
		
		solucion = algoritmo.algoritmoSinCotas(E2, set2, 15);
		solucion.print();
		*/
		
		//Descomentar para probar el set3.
		/*
		solucion = algoritmo.algoritmoCotasBuenas(E3, set3, 14);
		solucion.print();
		
		solucion = algoritmo.algoritmoCotasMalas(E3, set3, 14);
		solucion.print();
		
		solucion = algoritmo.algoritmoSinCotas(E3, set3, 14);
		solucion.print();
		*/
		
		//Descomentar para probar set4. No incluye el algoritmoSinCotas ya que llena el heap
		/*
		solucion = algoritmo.algoritmoCotasBuenas(E4, set4, 19);
		solucion.print();
		
		solucion = algoritmo.algoritmoCotasMalas(E4, set4, 19);
		solucion.print();
		*/
	}
}
