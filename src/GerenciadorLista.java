import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Classe que gerencia os processos através do mecanismo de Lock
 * @author sergioluna
 *
 */
public class GerenciadorLista {
	
	//Buffer representado por uma lista
	ArrayList<Integer> lista;
	
	private Lock bloqueio = new ReentrantLock();
	
	public GerenciadorLista(){
		lista = new ArrayList<>();
	}
	
	/**
	 * Inserir itens
	 * @param item
	 * @throws InterruptedException
	 */
	public void inserir(int item) throws InterruptedException {
		bloqueio.lock();
			try {
				lista.add(item);
			}catch (Exception e) {
				// TODO: handle exception
			} finally {
				bloqueio.unlock();
			}
		
	}
	
	/**
	 * Inserir itens
	 * @param item
	 * @throws InterruptedException
	 */
	public void consultar(int item) throws InterruptedException {
			try {
				System.out.println(Thread.currentThread().getName() + " verificando se item [" + item + "] se encontra na lista");
				
				if(lista.contains(item)) {
					System.out.println("Item: [" + item + "] presente na lista");
				}
				else System.out.println("Item: [" + item + "] NÃO presente na lista");
			}catch (Exception e) {
				// TODO: handle exception
			} 
		
	}
	
	/**
	 * Remover item
	 * @param item
	 * @throws InterruptedException
	 */
	public int remover() throws InterruptedException {
		int contador = 0;
		while(lista.size() == 0) {
			if(contador == 0) {
				System.out.println(Thread.currentThread().getName() + " aguardando..");
				contador++;
			}
			Thread.sleep(100);
		}
			
		bloqueio.lock();
			Random r = new Random();
			int random = r.nextInt(lista.size());
			int valor = lista.get(random);
			lista.remove(random);
		bloqueio.unlock();

		return valor;
	}	
	
}
