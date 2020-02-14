//Raul Sanchez Montaño
package codigo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeneradorDePruebas {
	
	private final static int N = 20; //numSujetos
	private final static int CAPACIDAD_ENVASE = 15;
	private final static int MAX_TAM_OBJETO= 10;
	private final static int MIN_TAM_OBJETO = 5;
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		System.out.println("Comenzando");
		
		if (MAX_TAM_OBJETO < MIN_TAM_OBJETO || CAPACIDAD_ENVASE < MAX_TAM_OBJETO || MAX_TAM_OBJETO < 1 || MIN_TAM_OBJETO < 1){
			System.out.println("Conjunto de datos no válido");
			return;
		}
			
		
		Random r = new Random();
		
		FileWriter fichero = new FileWriter("prueba.txt");
		for (int i = 0; i < N; i++) {
			int num = r.nextInt(MAX_TAM_OBJETO - MIN_TAM_OBJETO + 1) + MIN_TAM_OBJETO;
			fichero.write(num + ",");
		}
		
		fichero.write("null " + CAPACIDAD_ENVASE + " " + N);
		
		fichero.close();
		
		System.out.println("Terminado");
		
	}
}
