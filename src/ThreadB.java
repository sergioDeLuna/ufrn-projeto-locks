/**
 * Classe ThreadB - Thread
 * @author sergioluna
 *
 */
public class ThreadB extends Thread {
	
	//Gerenciador da Lista
	private GerenciadorLista gerenciadorLista;
	
	//Item
	private int item;
	
	/**
	 * Método de Inicialização
	 * @param nome
	 */
	public ThreadB(String nome, GerenciadorLista gerenciadorLista){
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
				item = (int)(Math.random() * 100 + 1);
				System.out.println(Thread.currentThread().getName() + " colocando item " + item + " na lista...");
				gerenciadorLista.consultar(item);
				Thread.sleep((long)(Math.random() * 500));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
}
