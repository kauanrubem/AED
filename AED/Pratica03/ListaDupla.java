public class ListaDupla<T> {
    private Elemento<T> head;

    public class Elemento<T> {
        T dado;
        Elemento<T> next, prev;

        public Elemento(T dado) {
            this.dado = dado;
            this.next = null;
            this.prev = null;
        }
    }

    public void adicionar(T dado) {
        Elemento<T> novoElemento = new Elemento<>(dado);
        if (head == null) {
            head = novoElemento;
        } else {
            Elemento<T> atual = head;
            while (atual.next != null) {
                atual = atual.next;
            }
            atual.next = novoElemento;
            novoElemento.prev = atual;
        }
    }

    public void remover(T dado) {
        Elemento<T> atual = head;
        while (atual != null) {
            if (atual.dado.equals(dado)) {
                if (atual.prev != null) {
                    atual.prev.next = atual.next;
                } else {
                    head = atual.next;
                }
                if (atual.next != null) {
                    atual.next.prev = atual.prev;
                }
                return;
            }
            atual = atual.next;
        }
    }

    public void imprimir() {
        Elemento<T> atual = head;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.next;
        }
        System.out.println();
    }

    public int tamanho() {
        int tamanho = 0;
        Elemento<T> atual = head;
        while (atual != null) {
            tamanho++;
            atual = atual.next;
        }
        return tamanho;
    }
}