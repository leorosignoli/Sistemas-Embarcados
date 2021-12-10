package main;

import java.util.Arrays;

public class EDF {
	/*def hiper_periodo(processos, qnt):
    # Hiper Periodo é o maior periodo dentre todos os processos
    temp = 0
    for i in range(qnt):
        if processos[i][3] > temp:
            temp = processos[i][3]
    return temp
*/
	public int hiper_periodo(int[][] processos, int qnt) {
		int temp = 0;
		for (int i=0 ; i < qnt ; i++) {
			if (processos[i][3] > temp)
				temp = processos[i][3];
		}
		return temp;
	}
	
	/*def escolher_menor_deadline(processos, qnt, deadlines):
    menor_deadline = 10000
    escolhido = -1
    for i in range(qnt):
        if deadlines[i] < menor_deadline:
            menor_deadline = deadlines[i]
            escolhido = i
    return escolhido
	 */
	public static int escolher_menor_deadline(int[][] processos, int qnt,int[] deadlines) {
		int menor_deadline = 10000;
		int	    escolhido = -1;
		for (int i=0 ; i < qnt ; i++) {
			if (deadlines[i] < menor_deadline){
	            menor_deadline = deadlines[i];
	            escolhido = i;
	            }
		}
		return escolhido;
	}
	
	/*def edf(processos, qnt):
    relogio = 0
    deadlines = [0] * qnt
    for i in range(qnt):
        deadlines[i] = processos[i][2]
    periodos = [0] * qnt
    for i in range(qnt):
        periodos[i] = processos[i][3]
    print(f"Processos: {processos}")
    print(f"Deadlines: {deadlines}")
    print(f"Periodos: {periodos}\n")
    contador = [0] * qnt

    while True:
        escolhido = escolher_menor_deadline(processos, qnt, deadlines)
        print(f"Processo Escolhido: {escolhido}")
        if periodos[escolhido] >= relogio:
            relogio += processos[escolhido][1]
            print(f"Processo: P{escolhido} executando...")
            print(f"Relogio: {relogio}")
            print(f"Burst Time do Processo P{escolhido}: processos[escolhido][1]")

            print(f"Deadline ANTERIOR do Processo : {deadlines[escolhido]}")
            deadlines[escolhido] += processos[escolhido][3]
            print(f"Deadline do Processo P{escolhido} Atualizada: {deadlines[escolhido]}")
            
            print(f"Periodo ANTERIOR do Processo: {periodos[escolhido]}")
            periodos[escolhido] += processos[escolhido][3]
            print(f"Periodo do Processo P{escolhido} Atualizado: {periodos[escolhido]}\n")
            contador[escolhido] += 1
        if relogio >= 20:
            break

    for i in range(qnt):
        print(f"O Processo P{i} Executou {contador[i]} vezes")
*/
	public static void edf(int processos[][], int qnt) {
		
		int relogio = 0;
		int[] deadlines = new int[qnt];
		for (int i=0 ;i<qnt ; i++) {
			deadlines[i]=0;
		}
		/*for i in range(qnt):
        deadlines[i] = processos[i][2]*/
		for (int i=0 ;i<qnt ; i++) {
			deadlines[i] = processos[i][2];
		}
		/*periodos = [0] * qnt
    	for i in range(qnt):
        	periodos[i] = processos[i][3]*/
		int[] periodos = new int[qnt];
		for (int i=0 ;i<qnt ; i++) {
			periodos[i]=0;
		}
		for (int i=0 ;i<qnt ; i++) {
			periodos[i] = processos[i][3];
		}
		System.out.println("Processos: ");
		for (int i = 0; i < processos.length; i++) {
		    for (int j = 0; j < processos[i].length; j++) {
		        System.out.print(processos[i][j] + " ");
		    }
		    System.out.println();
		}
		System.out.println("Deadlines: "+ Arrays.toString(deadlines));
		
		System.out.println("Períodos: "+Arrays.toString(periodos));
		int[] contador = new int[qnt];
		for (int i=0 ;i<qnt ; i++) {
			contador[i] = 0;
		}
		while (true) {
			int  escolhido = escolher_menor_deadline(processos, qnt, deadlines);
			System.out.println("Processo escolhido: "+escolhido);
			 if (periodos[escolhido] >= relogio) {
				 relogio += processos[escolhido][1];
				 System.out.println("Processo: P{"+escolhido+"} executando...");
				 System.out.println("Relogio: {"+relogio+"}");
				 System.out.println("Burst Time do Processo P{"+escolhido+"}: "+processos[escolhido][1]);
				 System.out.println("Deadline ANTERIOR do Processo : {"+deadlines[escolhido]+"}");
				 deadlines[escolhido] += processos[escolhido][3];
				 System.out.println("Deadline do Processo P{"+escolhido+"} Atualizada: {"+deadlines[escolhido]+"}");
				 System.out.println("Periodo ANTERIOR do Processo: {"+periodos[escolhido]+"}");
				 periodos[escolhido] += processos[escolhido][3];
				 System.out.println("Periodo do Processo P{"+escolhido+"} Atualizado: {"+periodos[escolhido]+"}\n");
				 contador[escolhido] += 1;
				 if (relogio >= 20)
			            break;
			 }
			
		}
		for (int i=0 ;i<qnt ; i++) {
	        System.out.println("O Processo P{"+i+"} Executou {"+contador[i]+"} vezes");
		}
	}
	public static void main(String[] args) {
		int[][] processos = {
		                    {0, 3, 7, 20},
		                    {1, 2, 4, 5},
		                    {2, 2, 8, 10}
		};
		int qnt = processos.length;
		
		edf(processos,qnt);
	}
}
