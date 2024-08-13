class PrincipalLista {
	public static void main(String[] args) {
		try {
			System.out.println("=== LISTA FLEXIVEL SIMPLESMENTE ENCADEADA ===");
			Lista lista = new Lista();

			lista.inserirInicio(12);
			lista.inserirInicio(32);
			lista.inserirInicio(25);


			System.out.print("Apos insercoes: ");
			lista.mostrar();

			//int x1 = lista.remover(3);
			//int x2 = lista.remover(2);
			//int x3 = lista.removerFim();
			//int x4 = lista.removerInicio();
			//int x5 = lista.remover(0);
			//int x6 = lista.remover(4);
			//lista.inserirFim(9);

			//System.out.print("Apos remocoes (" +x1+ ", " +x2+ ", " +x3+ ", " +x4+ ", " +x5+ ", " +x6+ "): ");
			//lista.mostrar();
			int x = lista.removerSegundaPosicao();
			System.out.println("Elemento removido =  " + x);
			System.out.print("Apos remocao da segunda posicao: ");
			lista.mostrar();
		}
		catch(Exception erro) {
			System.out.println(erro.getMessage());
		}
	}
}
