/**
 * Classe que gerencia o problema
 * @author sergioluna
 *
 */
public class Main {
	
	//Quantidade de Threas do tipo B I R
	private static final int QUANTIDADE_THREADS_B_I_R = 3;
	
	//Array para armazenar as threads do tipo R
	private static ThreadR[] threadsRemover;
	
	//Array para armazenar as thread do tipo I
	private static ThreadI[] threadsInserir;
	
	//Array para armazenar as thread do tipo B
	private static ThreadB[] threadsConsultar;

	/**
	 * Método principal do projeto
	 * Gerencia as principais funcionalidades
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException{
		
		GerenciadorLista gerenciadorLista = new GerenciadorLista();
		
		inicializaBIR(gerenciadorLista);

	   try {
		  startBIR();
		  waitingBIR();
	    } catch (InterruptedException e) {
	      e.printStackTrace();
	    } 
	   
	   System.out.println("\nAs threads B, I e R finalizaram seus trabalhos!");
        
	}
	
	/**
	 * Método para inicializar as threads do tipo B, I e R
	 * @param gerenciadorLista
	 */
	 private static void inicializaBIR(GerenciadorLista gerenciadorLista) {
		
		threadsRemover = new ThreadR[QUANTIDADE_THREADS_B_I_R];
	    for (int i = 0; i < QUANTIDADE_THREADS_B_I_R; i++) {
	    	threadsRemover[i] = new ThreadR("ThreadR #" + (i + 1), gerenciadorLista);
	    }
	    
		threadsInserir = new ThreadI[QUANTIDADE_THREADS_B_I_R];
	    for (int i = 0; i < QUANTIDADE_THREADS_B_I_R; i++) {
	    	threadsInserir[i] = new ThreadI("ThreadI #" + (i + 1), gerenciadorLista);
	    }
	    
		threadsConsultar = new ThreadB[QUANTIDADE_THREADS_B_I_R];
	    for (int i = 0; i < QUANTIDADE_THREADS_B_I_R; i++) {
	    	threadsConsultar[i] = new ThreadB("ThreadB #" + (i + 1), gerenciadorLista);
	    }
	 }
	
	  /**
	   * Método para fazer com os processos aguardem
	   * @throws InterruptedException 
	   */
	  private static void waitingBIR() throws InterruptedException {
		    
		  	for (ThreadR r : threadsRemover) {
		  		r.join();
		    }
		    
		    for (ThreadI i : threadsInserir) {
		    	i.join();
		    }
		    
		    for (ThreadB b : threadsConsultar) {
		    	b.join();
		    }
	  }
	
	  /**
	   * Realiza o start dos processos
	   */
	  private static void startBIR() {
		  for (ThreadR r : threadsRemover) {
			  r.start();
		    }
		    
		    for (ThreadI i : threadsInserir) {
		    	i.start();
		    }
		    
		    for (ThreadB b : threadsConsultar) {
		    	b.start();
		    }
	  }

}
