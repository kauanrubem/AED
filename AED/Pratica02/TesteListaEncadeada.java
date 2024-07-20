public class TesteListaEncadeada {
    public static void main(String[] args) {
        // Criar uma lista encadeada
        ListaEncadeada lista = new ListaEncadeada();

        // Adicionar elementos à lista
        lista.inserirInicio(1);
        lista.inserirFim("hello world!");
        lista.inserirFim(1.5);

        // Imprimir os elementos da lista
        imprimirLista(lista);
    }

    public static void imprimirLista(ListaEncadeada lista) {
        ListaEncadeada.Element atual = lista.getHead();
        System.out.println("Elementos da lista:");
        while (atual != null) {
            System.out.println(atual.getData());
            atual = atual.getNext();
        }
    }
}