public class teste {
    public static void main(String[] args) {
        ListaDupla<Integer> lista = new ListaDupla<>();

        lista.adicionar(1);
        lista.adicionar(2);
        lista.adicionar(3);
        lista.adicionar(4);
        lista.adicionar(5);

        System.out.print("Lista: ");
        lista.imprimir(); 

        lista.remover(3);
        lista.remover(1);

        System.out.print("Lista após remoção: ");
        lista.imprimir();

        System.out.println("Tamanho da lista: " + lista.tamanho()); 
    }
}