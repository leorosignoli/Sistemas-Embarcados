package br.edu.uniceub;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * This program simulates a Round Robin Implementation
 * 
 * @author LeonardoRP - Leonardo Andrade Rosignoli Pereira 
 * UniCEUB - Sistemas Embarcados 
 * 09/08/2021
 */

public class RoundRobin {

	/**
	 * @param qnt_processos in the array
	 * @param processos     to be put in order
	 * @param quantum       time each process is to be played before being swapped
	 * @return waiting time array
	 */
	public static int[] roundRobinImp(int qnt_processos, int[][] processos, int quantum) {

		// Remaining burst time list
		int[] rem_bt = new int[qnt_processos];
		Arrays.fill(rem_bt, 0);
		// waiting time list
		int[] wt = new int[qnt_processos];
		Arrays.fill(wt, 0);

		// copying processes' burst time into the remaining bt list.
		for (int i = 0; i < qnt_processos; i++) {
			rem_bt[i] = processos[i][2];
		}

		int time = 0; // total value to be added to WaitingTime
		int overhead = 0; // hypothetical value to represent time spent on changing processes
		System.out.println("Timeline:");
		while (true) {
			boolean ended = true; // control variable that signalizes if a processes has ended.

			for (int i = 0; i < qnt_processos; i++) {
				System.out.print("(Tempo:" + time + ", " + (char) (processos[i][0] + 65) + ")\t");// prints the table
				time += overhead; // Adds a overHead value each time the process changes

				if (rem_bt[i] > 0) { // if > 0 it means the process still hasn't ended

					ended = false;
					if (rem_bt[i] > quantum) { // if rem_bt > quantum then total time increases
						time += quantum; // and the remaining_bt subtracts the amount of time spent processing
						rem_bt[i] -= quantum;
					}

					else { // else just add the remaining time in the total time
						time += rem_bt[i]; // and
						wt[i] = time - processos[i][2];
						rem_bt[i] = 0;
					}
				}
			}

			if (ended == true) // when the loop gets here, it means that the remaining time =0 and we've
								// reached
				break; // the desired outcome, which is to run the process completely.

		}
		System.out.println("\n");
		return wt;

	}

	/**
	 * function that returns around time values of each process
	 * 
	 * @param qt_processos in the array
	 * @param processos    to be measured
	 * @param wt           of each element
	 * @return around time value
	 */
	public static int[] turnAroundTime(int qt_processos, int[][] processos, int[] wt) {

		int[] tat = new int[qt_processos];
		Arrays.fill(tat, 0);
		for (int i = 0; i < qt_processos; i++)
			tat[i] = processos[i][2] + wt[i];
		return tat;
	}

	/**
	 * returns average turn around time
	 * 
	 * @param tat          of processes
	 * @param qt_processos in the array
	 * @return average turn around time
	 */
	public static float averageTat(int[] tat, int qt_processos) {
		int sum = IntStream.of(tat).sum();
		return (sum / qt_processos);
	}

	/**
	 * returns average waiting time
	 * 
	 * @param tat          of processes
	 * @param qt_processos in the array
	 * @return average waiting time
	 */
	public static float averageWt(int[] wt, int qt_processos) {
		int sum = IntStream.of(wt).sum();
		return (sum / qt_processos);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Round Robin Algorithm \n Number of processes: ");
		int qnt_processos = sc.nextInt();
		int[][] processos = new int[qnt_processos][3];

		for (int i = 0; i < qnt_processos; i++) {

			// for better representation, I'll use this id as a ASCII index to represent
			// each process as a Character.
			char c = (char) (i + 65);
			System.out.println("Process " + c);
			System.out.print("ArrivalTime: ");
			int at = sc.nextInt();
			System.out.print("Burst Time: ");
			int bt = sc.nextInt();

			// inserts all values in the array
			processos[i][0] = i;
			processos[i][1] = at;
			processos[i][2] = bt;

		}
		System.out.println("Quantum Value: ");
		int quantum = sc.nextInt();

		sc.close(); // closes the scanner to avoid warnings

		// calls the functions to get average values
		int[] wt = new int[qnt_processos];
		wt = roundRobinImp(qnt_processos, processos, quantum);
		int[] tat = new int[qnt_processos];
		tat = turnAroundTime(qnt_processos, processos, wt);

		// loop to print the data
		System.out.print(
				"| Process |\t| Burst Time |\t\t| Arrival Time |\t| Waiting Time |\t| Turn-Around Time |\t | Exit Time |\n\n");
		for (int i = 0; i < qnt_processos; i++)
			System.out.print((char) (processos[i][0] + 65) + "\t\t\t" + processos[i][2] + "\t\t\t" + processos[i][1]
					+ "\t\t\t" + wt[i] + "\t\t\t" + tat[i] + "\t\t\t" + (tat[i] + processos[i][1]) + "\n");

		System.out.println("Average Waiting Time: " + averageWt(wt, qnt_processos));
		System.out.println("Average Turn-Around Time: " + averageTat(tat, qnt_processos));

	}

}
