/**
 * Classe ThreadR - Thread
 * @author sergioluna
 *
 */
public class ThreadR extends Thread {
	
	//Gerenciador da Lista
	private GerenciadorLista gerenciadorLista;
	
	//Item
	private int item;
	
	/**
	 * Método de Inicialização
	 * @param nome
	 */
	public ThreadR(String nome, GerenciadorLista gerenciadorLista){
		super(nome);
		this.gerenciadorLista = gerenciadorLista;
	}
	
	/**
	 * Método Start da thread R
	 */
	@Override
	public void run() {
		try {
			for (int i = 0; i < 5; i++) {
				item = gerenciadorLista.remover();
				System.out.println(Thread.currentThread().getName() + " retirando item " + item + " da lista...");
				Thread.sleep((long)(Math.random() * 500));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
}
