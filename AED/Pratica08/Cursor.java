public interface ListaClassificada {

    Object get(int i);

    Cursor procurarPosicao(Object o);

    boolean eMembro(Object o);

    void inserir(Object o);

    void remover(Object o);

    Object procurar(Object o);
}

public interface Cursor {

    Object getDado();

    void inserirDepois(Object o);

    void inserirAntes(Object o);

    void remover();
}

class No {
    Object dado;
    No proximo;

    public No(Object dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

class ListaClassificadaImpl implements ListaClassificada {

    private No inicio;

    public ListaClassificadaImpl() {
        this.inicio = null;
    }

    @Override
    public Object get(int i) {
        No noAtual = inicio;
        int indice = 0;
        while (noAtual != null) {
            if (indice == i) {
                return noAtual.dado;
            }
            noAtual = noAtual.proximo;
            indice++;
        }
        return null;
    }

    @Override
    public Cursor procurarPosicao(Object o) {
        No noAtual = inicio;
        while (noAtual != null) {
            if (noAtual.dado.equals(o)) {
                return new CursorImpl(noAtual);
            }
            noAtual = noAtual.proximo;
        }
        return null;
    }

    @Override
    public boolean eMembro(Object o) {
        No noAtual = inicio;
        while (noAtual != null) {
            if (noAtual.dado.equals(o)) {
                return true;
            }
            noAtual = noAtual.proximo;
        }
        return false;
    }

    @Override
    public void inserir(Object o) {
        if (inicio == null || ((Comparable) o).compareTo(inicio.dado) < 0) {
            No novoNo = new No(o);
            novoNo.proximo = inicio;
            inicio = novoNo;
        } else {
            No anterior = null;
            No atual = inicio;
            while (atual != null && ((Comparable) o).compareTo(atual.dado) > 0) {
                anterior = atual;
                atual = atual.proximo;
            }
            No novoNo = new No(o);
            anterior.proximo = novoNo;
            novoNo.proximo = atual;
        }
    }

    @Override
    public void remover(Object o) {
        No anterior = null;
        No atual = inicio;
        while (atual != null && !atual.dado.equals(o)) {
            anterior = atual;
            atual = atual.proximo;
        }
        if (atual != null) {
            if (anterior == null) {
                inicio = atual.proximo;
            } else {
                anterior.proximo = atual.proximo;
            }
        }
    }

    @Override
    public Object procurar(Object o) {
        No noAtual = inicio;
        while (noAtual != null) {
            if (noAtual.dado.equals(o)) {
                return noAtual.dado;
            }
            noAtual = noAtual.proximo;
        }
        return null;
    }

    private class CursorImpl implements Cursor {

        private No posicaoAtual;

        public CursorImpl(No posicaoAtual) {
            this.posicaoAtual = posicaoAtual;
        }

        @Override
        public Object getDado() {
            return posicaoAtual.dado;
        }

        @Override
        public void inserirDepois(Object o) {
            No novoNo = new No(o);
            novoNo.proximo = posicaoAtual.proximo;
            posicaoAtual.proximo = novoNo;
        }

        @Override
        public void inserirAntes(Object o) {
            if (inicio == posicaoAtual) {
                No novoNo = new No(o);
                novoNo.proximo = inicio;
                inicio = novoNo;
            } else {
                No anterior = inicio;
                while (anterior != null && anterior.proximo != posicaoAtual) {
                    anterior = anterior.proximo;
                }
                if (anterior != null) {
                    No novoNo = new No(o);
                    novoNo.proximo = posicaoAtual;
                    anterior.proximo = novoNo;
                }
            }
        }

        @Override
        public void remover() {
            No anterior = inicio;
            while (anterior != null && anterior.proximo != posicaoAtual) {
                anterior = anterior.proximo;
            }
            if (anterior != null) {
                anterior.proximo = posicaoAtual.proximo;
            }
        }
    }
}