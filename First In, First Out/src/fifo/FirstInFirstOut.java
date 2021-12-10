package fifo;

import java.util.Arrays;
import java.util.Scanner;

public class FirstInFirstOut {
	
	/*# Calcular Waiting Time
def waiting_time(processos):
    #Definindo a quantidade tempos de servico de cada baseado na qnt. de processos
    tempo_servico = [0] * len(processos)
    #O tempo de servico é a soma de todos os BurstTime dos Processos anteriores
    tempo_servico[0] = 0
    # Definindo tamanho da waiting list
    wt = [0] * len(processos)

    for x in range(1, len(processos)):
        tempo_servico[x] = (tempo_servico[x-1] + processos[x-1][1])
        wt[x] = tempo_servico[x] - processos[x][0]
        if (wt[x] < 0):
            wt[x] = 0
    return wt
*/
	public static int[] waiting_time(int[][] processos) {
		
		int[] tempo_servico = new int[processos.length];
		
		for (int i=0 ;i<tempo_servico.length ; i++) {
			tempo_servico[i] = 0;
		}
		
		int[] wt = new int[processos.length];
		
		for (int i=0 ;i<wt.length ; i++) {
			wt[i] = 0;
		}
		
		/* for x in range(1, len(processos)):
        tempo_servico[x] = (tempo_servico[x-1] + processos[x-1][1])
        wt[x] = tempo_servico[x] - processos[x][0]
        if (wt[x] < 0):
            wt[x] = 0*/
		
		for(int i=1; i<processos.length;i++) {
			tempo_servico[i]=(tempo_servico[i-1]+processos[i-1][1]);
			wt[i]= tempo_servico[i]-processos[i][0];
			if (wt[i]<0)
				wt[i]=0;
		}
		
		return wt;
		
	}
	
	/*# Calcular Turn around Time
def turn_around_time(processos):
    #TurnAround Time = BurstTime + WaitingTime
    tat = [0] * len(processos) # Turn around time
    wt = waiting_time(processos)
    for x in range(len(processos)):
        tat[x] = processos[x][1] + wt[x]
    return tat

*/
	public static int[] turn_around_time(int processos[][]) {
		
		int[] tat = new int[processos.length];
		Arrays.fill(tat, 0);
		
		int[] wt = waiting_time(processos);
		
		for (int i=0; i<processos.length;i++) {
			tat[i]=processos[i][1]+wt[i];
		}
		return tat;
	}
	
	/*# Calcular media do waiting time
def average_wt(processos):
    qnt_proc = len(processos)
    wt = sum(waiting_time(processos))
    return (wt / qnt_proc)
*/
	public static float average_wt(int processos[][]) {
		int qnt_proc = processos.length;
		int wt = Arrays.stream(waiting_time(processos)).sum();
		return wt/qnt_proc;
	}
	/*
# Calcular media do Turnaround time
def average_tat(processos):
    qnt_proc = len(processos)
    tat = sum(turn_around_time(processos))
    return (tat / qnt_proc)
*/
	public static float average_tat(int processos[][]) {
		int qnt_proc = processos.length;
		int tat = Arrays.stream(turn_around_time(processos)).sum();
		return tat/qnt_proc;
	}
	
	/**
	 * main method
	 * @param args
	 */
	public static void main(String[] args) {
		/*processos = []
qnt_processos = int(input("Qnt de Processos: "))
for x in range(qnt_processos):
    at = int(input("Arrival Time: "))
    bt =  int(input("Burst Time: "))
    processos.append([at, bt])
*/
		
		int qnt_processos=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Qnt de processos: ");
		qnt_processos= sc.nextInt();
		int[][] processos = new int[qnt_processos][2];
		for (int i=0; i<qnt_processos;i++) {
			System.out.println("Arrival time: ");
			int at = sc.nextInt();
			System.out.println("Burst time: ");
			int bt = sc.nextInt();
			processos[i][0] = at;
			processos[i][1] = bt;
		}
		sc.close();
		
		/*print("Process\tBurst Time\tArrival Time\tWaiting Time\tTurn-Around Time\tCompletion Time\n\n")
wt = waiting_time(processos)
tat = turn_around_time(processos)
avg_wt = average_wt(processos)
avg_tat = average_tat(processos)
*/
		System.out.println("Process\tBurst Time\tArrival Time\tWaiting Time\tTurn-Around Time\tCompletion Time\n\n");
		int[] wt = waiting_time(processos);
		int[] tat = turn_around_time(processos);
		float avg_wt = average_wt(processos);
		float avg_tat = average_tat(processos);
		
		/*for proc in range(len(processos)):
    		print(f"{proc}\t\t{processos[proc][1]}\t\t{processos[proc][0]}\t\t{wt[proc]}\t\t{tat[proc]}\t\t{tat[proc] + processos[proc][0]}\n")
		print(f"Average Waiting Time : {avg_wt}")
		print(f"Average Turn-Around Time: {avg_tat}")
*/
		for (int i=0; i<processos.length;i++) {
			System.out.println(i+"\t"+processos[i][1]+"\t"+processos[i][0]+"\t"+wt[i]+"\t"+tat[i]+"\t"+(tat[i] + processos[i][0]));	
		}
		System.out.println("Average Waiting Time :"+avg_wt);
		System.out.println("Average Turn-Around Time:"+avg_tat);
	}
}
