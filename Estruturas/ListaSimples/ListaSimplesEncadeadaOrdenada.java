// EX 2: Crie uma classe ListaSimplesEncadeadaOrdenada, garantindo que os elementos sempre fiquem ordenados

public class ListaSimplesEncadeadaOrdenada extends Lista {

    @Override
    public void inserirInicio(int x) {
        inserir(x);
    }

    @Override
    public void inserirFim(int x) {
        inserir(x);
    }

    @Override
    public void inserir(int x, int pos) throws Exception {
        inserir(x);
    }

    private void inserir(int x) {
        Celula tmp = new Celula(x);
        Celula i = primeiro;

        // Procurar a posição de inserção
        while (i.prox != null && i.prox.elemento < x) {
            i = i.prox;
        }

        tmp.prox = i.prox;
        i.prox = tmp;

        // Atualizar o último elemento se necessário
        if (i == ultimo) {
            ultimo = tmp;
        }
    }

    // Remover não precisa ser modificado, pois os elementos sempre serão removidos
    // corretamente
}
