public class Teste {
    public static void main(String[] args) {
        PilhaEncadeada<Integer> pilha = new PilhaEncadeada<>();

        System.out.println("A pilha está vazia? " + pilha.estaVazia());

        pilha.empilhar(10);
        pilha.empilhar(20);
        pilha.empilhar(30);

        try {
            System.out.println("Topo da pilha: " + pilha.topo());
        } catch (PilhaVaziaException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            int elementoDesempilhado = pilha.desempilhar();
            System.out.println("Elemento desempilhado: " + elementoDesempilhado);
        } catch (PilhaVaziaException e) {
            System.out.println("Erro ao desempilhar: " + e.getMessage());
        }

        try {
            System.out.println("Topo da pilha: " + pilha.topo());
        } catch (PilhaVaziaException e) {
            System.out.println("Erro: " + e.getMessage());

        pilha.empilhar(40);

        System.out.println("A pilha está vazia? " + pilha.estaVazia());
    }
  }
}
  
