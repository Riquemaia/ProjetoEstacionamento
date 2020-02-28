package sort;

import java.util.Random;
import java.util.Scanner;

public class mega {

	public static void main(String[] args) {
		int aposta[] = new int[6];
		int sorteio[] = new int[6];
		int acertos = 0 ;
		
		aposta(aposta);
		sorteio(sorteio);
		apuracao(aposta, sorteio, acertos);
		cartela(aposta);
		
	}

	private static void aposta(int [] numeros) {
		Scanner teclado = new Scanner(System.in);
		

		for (int i = 0; i < numeros.length;) {
			System.out.print("Digite o " + (i + 1) + "º numero -> ");
			numeros[i] = teclado.nextInt();

			if(!verificar(numeros,i) && numeros[i] >= 1 && numeros[i] <= 60) i++;
		

		}
		
		System.out.println("--------------------Numeros Escolhidos-------------------");
		
		imprimiVetor(numeros);
		
		teclado.close();
	}
	
	private static void sorteio(int [] numeros) {
		Random gerador = new Random();
		int numeros1[] = new int[6];

		for (int i = 0; i < numeros1.length;) {
			numeros1[i] = gerador.nextInt(60)+1;
			
			if(!verificar(numeros1,i)) i++;

		}
		
		System.out.println("--------------------Numeros Sorteados-------------------");
		imprimiVetor(numeros1);

	}
	
	private static void apuracao(int [] aposta,int [] sorteio, int acertos) {
		for (int i = 0; i < sorteio.length; i++) {
			for (int j = 0; j < sorteio.length; j++) {
				if(aposta[i] == sorteio[j]) {
					acertos++;
					System.out.println(aposta[i] + "\t");
				}
			}
		}
		System.out.println("Você Acertou " + acertos + " Numeros");
	}
	
	private static void cartela(int [] vetor) {
	int aux = 1;
	boolean achou = false ;
	
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 10; j++) {
				
				for (int j2 = 0; j2 < vetor.length; j2++) {
					if(aux == vetor[j2]) {
						achou = true;
					}
				}
				
				if(achou) {
					System.out.print("X\t");
				}else {
					System.out.print(aux+"\t");
				}
				
				aux++;
				achou = false;
			}
			System.out.println();
		}
		
	}
	
	
	private static void imprimiVetor(int [] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i]+"\t");
		}
		System.out.println();
	}
	
	public static boolean verificar(int[] vetor, int i) {
		boolean achou = false;
		for (int j = 0; j < i; j++) if (vetor[j] == vetor[i]) achou = true;
		return achou;
	}
	

}