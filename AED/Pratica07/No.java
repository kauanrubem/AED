public class No<T> {
    T valor;
    No<T> proximo;
    No<T> anterior;

    public No(T valor) {
        this.valor = valor;
        this.proximo = null;
        this.anterior = null;
    }
}

interface Deque<T> {
    void adicionarInicio(T elemento);
    void adicionarFim(T elemento);
    T removerInicio();
    T removerFim();
    T primeiro();
    T ultimo();
    boolean estaVazio();
}

public class DequeLista<T> implements Deque<T> {
    private No<T> inicio;
    private No<T> fim;

    public DequeLista() {
        inicio = null;
        fim = null;
    }

    public void adicionarInicio(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (estaVazio()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            novoNo.proximo = inicio;
            inicio.anterior = novoNo;
            inicio = novoNo;
        }
    }

    public void adicionarFim(T elemento) {
        No<T> novoNo = new No<>(elemento);
        if (estaVazio()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            novoNo.anterior = fim;
            fim = novoNo;
        }
    }

    public T removerInicio() {
        if (estaVazio()) {
            throw new IllegalStateException("O deque está vazio");
        }
        T elemento = inicio.valor;
        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.proximo;
            inicio.anterior = null;
        }
        return elemento;
    }

    public T removerFim() {
        if (estaVazio()) {
            throw new IllegalStateException("O deque está vazio");
        }
        T elemento = fim.valor;
        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            fim = fim.anterior;
            fim.proximo = null;
        }
        return elemento;
    }

    public T primeiro() {
        if (estaVazio()) {
            throw new IllegalStateException("O deque está vazio");
        }
        return inicio.valor;
    }

    public T ultimo() {
        if (estaVazio()) {
            throw new IllegalStateException("O deque está vazio");
        }
        return fim.valor;
    }

    public boolean estaVazio() {
        return inicio == null;
    }
}

public class Main {
    public static void main(String[] args) {
        Deque<String> deque = new DequeLista<>();
        deque.adicionarInicio("A");
        deque.adicionarFim("B");
        deque.adicionarInicio("C");
        deque.adicionarFim("D");

        System.out.println("Primeiro elemento: " + deque.primeiro()); // C
        System.out.println("Último elemento: " + deque.ultimo()); // D

        System.out.println("Removendo do início: " + deque.removerInicio()); // C
        System.out.println("Removendo do fim: " + deque.removerFim()); // D

        System.out.println("Novo primeiro elemento: " + deque.primeiro()); // A
        System.out.println("Novo último elemento: " + deque.ultimo()); // B
    }
}