
public class No<T> {
    T valor;
    No<T> proximo;

    public No(T valor) {
        this.valor = valor;
        this.proximo = null;
    }
}


interface Fila<T> {
    void enfileirar(T elemento);
    T desenfileirar();
    T primeiro();
    boolean estaVazia();
}

class FilaArray<T> implements Fila<T> {
    private static final int TAMANHO_PADRAO = 10;
    private Object[] elementos;
    private int tamanho;
    private int inicio;
    private int fim;

    public FilaArray() {
        this.elementos = new Object[TAMANHO_PADRAO];
        this.tamanho = 0;
        this.inicio = 0;
        this.fim = -1;
    }

    public void enfileirar(T elemento) {
        if (tamanho == elementos.length) {
            aumentarCapacidade();
        }
        fim = (fim + 1) % elementos.length;
        elementos[fim] = elemento;
        tamanho++;
    }

    public T desenfileirar() {
        if (estaVazia()) {
            throw new IllegalStateException("A fila está vazia");
        }
        T elemento = (T) elementos[inicio];
        elementos[inicio] = null;
        inicio = (inicio + 1) % elementos.length;
        tamanho--;
        return elemento;
    }

    public T primeiro() {
        if (estaVazia()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return (T) elementos[inicio];
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    private void aumentarCapacidade() {
        int novoTamanho = elementos.length * 2;
        Object[] novoArray = new Object[novoTamanho];
        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = elementos[(inicio + i) % elementos.length];
        }
        elementos = novoArray;
        inicio = 0;
        fim = tamanho - 1;
    }
}

class FilaLista<T> implements Fila<T> {
    private No<T> inicio;
    private No<T> fim;

    public FilaLista() {
        inicio = null;
        fim = null;
    }

    public void enfileirar(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (estaVazia()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
    }

    public T desenfileirar() {
        if (estaVazia()) {
            throw new IllegalStateException("A fila está vazia");
        }
        T elemento = inicio.valor;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        }
        return elemento;
    }

    public T primeiro() {
        if (estaVazia()) {
            throw new IllegalStateException("A fila está vazia");
        }
        return inicio.valor;
    }

    public boolean estaVazia() {
        return inicio == null;
    }
}


public class Main {
    public static void main(String[] args) {
        // Usando FilaArray
        Fila<Integer> filaArray = new FilaArray<>();
        filaArray.enfileirar(1);
        filaArray.enfileirar(2);
        filaArray.enfileirar(3);
        System.out.println("Primeiro elemento da fila (FilaArray): " + filaArray.primeiro());
        System.out.println("Desenfileirando elementos:");
        while (!filaArray.estaVazia()) {
            System.out.println(filaArray.desenfileirar());
        }

        // Usando FilaLista
        Fila<String> filaLista = new FilaLista<>();
        filaLista.enfileirar("A");
        filaLista.enfileirar("B");
        filaLista.enfileirar("C");
        System.out.println("Primeiro elemento da fila (FilaLista): " + filaLista.primeiro());
        System.out.println("Desenfileirando elementos:");
        while (!filaLista.estaVazia()) {
            System.out.println(filaLista.desenfileirar());
        }
    }
}