package pack;

/**
 * classe representa um processo na lista de processos
 * @author leo
 *
 */
public class Processo{
	int pid;
	int bt; 
	int art; 
	
	public Processo(int pid, int bt, int art)
	{
		this.pid = pid;
		this.bt = bt;
		this.art = art;
	}
}
