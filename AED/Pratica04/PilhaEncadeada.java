interface IPilha<T> {
    void empilhar(T item);
    T desempilhar() throws PilhaVaziaException;
    T topo() throws PilhaVaziaException;
    boolean estaVazia();
}

class PilhaVaziaException extends Exception {
    public PilhaVaziaException() {
        super("A pilha está vazia.");
    }
}

public class PilhaEncadeada<T> implements IPilha<T> {
    private ListaEncadeada lista;

    public PilhaEncadeada() {
        lista = new ListaEncadeada();
    }

    @Override
    public void empilhar(T item) {
        lista.inserirInicio(item);
    }

    @Override
    public T desempilhar() throws PilhaVaziaException {
        try {
            T item = topo();
            lista.extrair(item);
            return item;
        } catch (ObjetoNaoEncontradoException e) {
            throw new PilhaVaziaException();
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public T topo() throws PilhaVaziaException {
        try {
            return (T) lista.getPrimeiro();
        } catch (ListaVaziaException e) {
            throw new PilhaVaziaException();
        }
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }
}