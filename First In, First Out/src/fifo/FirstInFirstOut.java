package fifo;

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
	public int[] waiting_time(int[] processos) {
		
		int[] tempo_servico = new int[processos.length];
		
		for (int i=0 ;i<tempo_servico.length ; i++) {
			tempo_servico[i] = 0;
		}
		
		
		return null;
		
	}

}
