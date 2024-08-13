public class Pilha {
	private Celula topo;

	/**
	 * Construtor da classe que cria uma fila sem elementos.
	 */
	public Pilha() {
		topo = null;
	}

	/**
	 * Insere elemento na pilha (politica FILO).
	 * 
	 * @param x int elemento a inserir.
	 */
	public void inserir(int x) {
		Celula tmp = new Celula(x);
		tmp.prox = topo;
		topo = tmp;
		tmp = null;
	}

	/**
	 * Remove elemento da pilha (politica FILO).
	 * 
	 * @return Elemento removido.
	 * @trhows Exception Se a sequencia nao contiver elementos.
	 */
	public int remover() throws Exception {
		if (topo == null) {
			throw new Exception("Erro ao remover!");
		}
		int resp = topo.elemento;
		Celula tmp = topo;
		topo = topo.prox;
		tmp.prox = null;
		tmp = null;
		return resp;
	}

	/**
	 * Mostra os elementos separados por espacos, comecando do topo.
	 */
	public void mostrar() {
		System.out.print("[ ");
		for (Celula i = topo; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] ");
	}

	/* EX1- Seja nossa Pilha, faça um método RECURSIVO que retorna soma dos elementos contidos na mesma */
	public int getSoma() {
		return getSoma(topo);
	}

	private int getSoma(Celula i) {
		int resp = 0;
		if (i != null) {
			resp += i.elemento + getSoma(i.prox);
		}
		return resp;
	}

	public int getMax() {
		int max = topo.elemento;
		for (Celula i = topo.prox; i != null; i = i.prox) {
			if (i.elemento > max)
				max = i.elemento;
		}
		return max;
	}

	public void mostraPilha() {
		mostraPilha(topo);
	}

	private void mostraPilha(Celula i) {
		if (i != null) {
			mostraPilha(i.prox);
			System.out.println("" + i.elemento);
		}
	}

	// -------------------------------------------------------------------------------------------

	/* EX- Seja nossa Pilha, faça um método que retorna soma dos elementos contidos na mesma */
	public int somaElementos (){
		int soma = 0;
		for (Celula i = topo; i != null; i = i.prox){
			soma += i.elemento;
		}
		
		return soma;
	}

	// -------------------------------------------------------------------------------------------

	/* Seja nossa Pilha, faça um método que retorna o maior elemento contido na mesma */
	public int maiorElemento (){
		int maior = topo.elemento;
		for (Celula i = topo; i != null; i = i.prox){
			if (maior < i.elemento){
				maior = i.elemento;
			}
		}
		return maior;

	}

	// -------------------------------------------------------------------------------------------

	/* Seja nossa Pilha, faça um método RECURSIVO que retorna o maior elemento contido na mesma */
	public int maiorElementoRecursivo (){
		return maiorElementoRecursivo(topo, topo.elemento);
	}
	
	private int maiorElementoRecursivo (Celula i, int maiorAtual){
		if (i == null)
			return maiorAtual;
	
		if (i.elemento > maiorAtual)
			maiorAtual = i.elemento;
	
		return maiorElementoRecursivo(i.prox, maiorAtual);
	}

	// -------------------------------------------------------------------------------------------

	// Seja nossa Pilha, faça um método RECURSIVO para mostrar os elementos da pilha na ordem em que os mesmos serão removidos
	public void mostraPilhaRecursivo() {
		mostraPilhaRecursivo(topo);
	}

	private void mostraPilhaRecursivo(Celula i) {
		if (i != null) {
			mostraPilhaRecursivo(i.prox);
			System.out.println("" + i.elemento);
		}
	}


}
