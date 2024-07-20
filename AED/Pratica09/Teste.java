public class Teste {
    public static void main(String[] args) {
        Node<String> raiz = new Node<>("F");
        raiz.inserirOrdenado("B");
        raiz.inserirOrdenado("G");
        raiz.inserirOrdenado("A");
        raiz.inserirOrdenado("D");
        raiz.inserirOrdenado("C");
        raiz.inserirOrdenado("E");
        raiz.inserirOrdenado("I");
        raiz.inserirOrdenado("H");

        System.out.println("Imprimindo em Ordem:");
        raiz.imprimeInOrdem();
        System.out.println("\nImprimindo em Pré-Ordem:");
        raiz.imprimeEmPreordem();
        System.out.println("\nImprimindo em Pós-Ordem:");
        raiz.imprimeEmPosordem();
        System.out.println("\nImprimindo em Largura:");
        raiz.imprimeEmLargura();
    }
}