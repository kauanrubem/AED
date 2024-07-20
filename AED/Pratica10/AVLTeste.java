public class AVLTeste {

    public static void main(String[] args) {
        // Testar operações da árvore AVL
        AVL<Integer>    AVL = new AVL<>(5);
        AVL.inserirOrdenado(3, null);
        AVL.inserirOrdenado(7, null);
        AVL.inserirOrdenado(2, null);
        AVL.inserirOrdenado(4, null);
        AVL.inserirOrdenado(6, null);
        AVL.inserirOrdenado(8, null);
        AVL.inserirOrdenado(1, null);
        AVL.inserirOrdenado(9, null);

        System.out.println("AVL Tree Traversal em Ordem:");
        AVL.emOrdem(); // Percurso em ordem

        // Realizar remoção
        AVL.removerNode(40, null);
        AVL.removerNode(10, null);

        System.out.println("\nDepois de remover 4 e 1:");
        AVL.emOrdem(); // Percurso em ordem após remoção

        // Operações/testes adicionais
        System.out.println("\nBuscar valor 70: " +  AVL.buscar(7));
        System.out.println("Buscar valor 40 após remoção: " +   AVL.buscar(4));

        System.out.println("\nAltura da árvore: " + AVL.calculaAltura());
        System.out.println("Fator de balanceamento da raiz: " + AVL.getFB());
    }
}