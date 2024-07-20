public class Teste{
  public static void main(String[] args){
  Node<String> raiz = new Node<String>("2");
  raiz.inserirOrdenado("5");
  raiz.inserirOrdenado("7");
  raiz.inserirOrdenado("3");
  raiz.inserirOrdenado("8");
  raiz.inserirOrdenado("4");
  raiz.inserirOrdenado("6");
  raiz.inserirOrdenado("9");
  raiz.inserirOrdenado("1");

  System.out.println("Imprime a arvore:");
  raiz.imprime();
  System.out.println("\nImprime a arvore em ordem:");
  raiz.imprimeInOrdem();
  System.out.println("\nImprime a arvore em ordem com o adicional: ");
  raiz.inserirOrdenado("10");
  raiz.imprimeInOrdem();

  System.out.println("\nImprimindo em pré-ordem (preOrder): ");
        raiz.imprimeEmPreordem();

        System.out.println("\nImprimindo em pós-ordem (postOrder): ");
        raiz.imprimeEmPosordem();

        System.out.println("\nImprimindo em largura: ");
        raiz.imprimeEmLargura();

        int altura = raiz.calculaAltura();
        System.out.println("\nAltura da árvore: " + altura);

        Node<String> resultadoBusca = raiz.pesquisarValor(8);
        if (resultadoBusca != null) {
            System.out.println("Valor 8 encontrado na árvore!");
        } else {
            System.out.println("Valor 8 não encontrado na árvore.");
        }

        System.out.println("\nRemovendo o valor 6 da árvore: ");
        raiz.removerNode(6, null);

        System.out.println("\nImprimindo em ordem após remoção: ");
        raiz.imprimeInOrdem();
    }
}
  }
}