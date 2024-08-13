/*
 * EX 3: Na lista simples, crie um contador para a quantidade de elementos.
 * DICA: Nas inserções aumente o contador em uma unidade e nas remoções,
 * decremente uma unidade
 */
class Lista {
	protected Celula primeiro;
	protected Celula ultimo;
	private int contador;

	/**
	 * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
	 */
	public Lista() {
		primeiro = new Celula();
		ultimo = primeiro;
		contador = 0;
	}

	/**
	 * Insere um elemento na primeira posicao da lista.
	 * 
	 * @param x int elemento a ser inserido.
	 */
	public void inserirInicio(int x) {
		Celula tmp = new Celula(x);
		tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {
			ultimo = tmp;
		}
		tmp = null;
		contador++;
	}

	/**
	 * Insere um elemento na ultima posicao da lista.
	 * 
	 * @param x int elemento a ser inserido.
	 */
	public void inserirFim(int x) {
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
		contador++;
	}

	/**
	 * Remove um elemento da primeira posicao da lista.
	 * 
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public int removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

		Celula tmp = primeiro;
		primeiro = primeiro.prox;
		int resp = primeiro.elemento;
		tmp.prox = null;
		tmp = null;
		contador--;
		return resp;
	}

	/**
	 * Remove um elemento da ultima posicao da lista.
	 * 
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public int removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

		// Caminhar ate a penultima celula:
		Celula i;
		for (i = primeiro; i.prox != ultimo; i = i.prox)
			;

		int resp = ultimo.elemento;
		ultimo = i;
		i = ultimo.prox = null;
		contador--;
		return resp;
	}

	/**
	 * Insere um elemento em uma posicao especifica considerando que o
	 * primeiro elemento valido esta na posicao 0.
	 * 
	 * @param x   int elemento a ser inserido.
	 * @param pos int posicao da insercao.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
	public void inserir(int x, int pos) throws Exception {

		int tamanho = tamanho();

		if (pos < 0 || pos > tamanho) {
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
		} else if (pos == 0) {
			inserirInicio(x);
		} else if (pos == tamanho) {
			inserirFim(x);
		} else {
			// Caminhar ate a posicao anterior a insercao
			Celula i = primeiro;
			for (int j = 0; j < pos; j++, i = i.prox)
				;

			Celula tmp = new Celula(x);
			tmp.prox = i.prox;
			i.prox = tmp;
			tmp = i = null;
			contador++;
		}
	}

	/**
	 * Remove um elemento de uma posicao especifica da lista
	 * considerando que o primeiro elemento valido esta na posicao 0.
	 * 
	 * @param posicao Meio da remocao.
	 * @return resp int elemento a ser removido.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
	public int remover(int pos) throws Exception {
		int resp;
		int tamanho = tamanho();

		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");

		} else if (pos < 0 || pos >= tamanho) {
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
		} else if (pos == 0) {
			resp = removerInicio();
		} else if (pos == tamanho - 1) {
			resp = removerFim();
		} else {
			// Caminhar ate a posicao anterior a insercao
			Celula i = primeiro;
			for (int j = 0; j < pos; j++, i = i.prox)
				;

			Celula tmp = i.prox;
			resp = tmp.elemento;
			i.prox = tmp.prox;
			tmp.prox = null;
			i = tmp = null;

		}
		contador--;
		return resp;
	}

	/**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar() {
		System.out.print("[ ");
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			System.out.print(i.elemento + " ");
		}
		System.out.println("] ");
	}

	/**
	 * Procura um elemento e retorna se ele existe.
	 * 
	 * @param x Elemento a pesquisar.
	 * @return <code>true</code> se o elemento existir,
	 *         <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(int x) {
		boolean resp = false;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
			if (i.elemento == x) {
				resp = true;
				i = ultimo;
			}
		}
		return resp;
	}

	/**
	 * Calcula e retorna o tamanho, em numero de elementos, da lista.
	 * 
	 * @return resp int tamanho
	 */
	public int tamanho() {
		int tamanho = 0;
		for (Celula i = primeiro; i != ultimo; i = i.prox, tamanho++)
			;
		return tamanho;
	}

	/*
	 * EX 1: Seja nossa classe Lista, implemente um método que remove a segunda
	 * posição válida. Siga os passos da figura abaixo
	 */
	public int removerSegundaPosicao() throws Exception {
		int resp = 0;
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}
		Celula p = new Celula();
		Celula q = new Celula();
		p = primeiro.prox;
		q = primeiro.prox.prox;
		resp = q.elemento;
		p.prox = ultimo;
		q = q.prox = null;
		contador--;
		return resp;
	}

	/*
	 * Modifique o método inserirInicio de tal forma que o novo valor seja inserido
	 * no nó cabeça e, em seguida, criamos uma nova célula como nó cabeça
	 */
	public void inserirInicioModificado(int x) {
		primeiro.elemento = x;
		Celula tmp = new Celula();
		tmp.prox = primeiro;
		primeiro = tmp;
		tmp = null;
		contador++;
	}
}
