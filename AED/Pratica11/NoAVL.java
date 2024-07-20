class NoAVL {
    String chave;
    NoAVL esquerda, direita;
    int altura;

    NoAVL(String d) {
        chave = d;
        altura = 1;
    }
}

class ArvoreAVL {
    private NoAVL raiz;

    private int altura(NoAVL N) {
        if (N == null)
            return 0;
        return N.altura;
    }

    private NoAVL rotacaoDireita(NoAVL y) {
        NoAVL x = y.esquerda;
        NoAVL T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private NoAVL rotacaoEsquerda(NoAVL x) {
        NoAVL y = x.direita;
        NoAVL T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    private int getBalance(NoAVL N) {
        if (N == null)
            return 0;
        return altura(N.esquerda) - altura(N.direita);
    }

    private NoAVL inserir(NoAVL node, String chave) {
        if (node == null)
            return (new NoAVL(chave));

        if (chave.compareTo(node.chave) < 0)
            node.esquerda = inserir(node.esquerda, chave);
        else if (chave.compareTo(node.chave) > 0)
            node.direita = inserir(node.direita, chave);
        else
            return node;

        node.altura = 1 + Math.max(altura(node.esquerda), altura(node.direita));

        int balance = getBalance(node);

        if (balance > 1 && chave.compareTo(node.esquerda.chave) < 0)
            return rotacaoDireita(node);

        if (balance < -1 && chave.compareTo(node.direita.chave) > 0)
            return rotacaoEsquerda(node);

        if (balance > 1 && chave.compareTo(node.esquerda.chave) > 0) {
            node.esquerda = rotacaoEsquerda(node.esquerda);
            return rotacaoDireita(node);
        }

        if (balance < -1 && chave.compareTo(node.direita.chave) < 0) {
            node.direita = rotacaoDireita(node.direita);
            return rotacaoEsquerda(node);
        }

        return node;
    }

    public void inserir(String chave) {
        raiz = inserir(raiz, chave);
    }

    private NoAVL minValueNode(NoAVL node) {
        NoAVL current = node;

        while (current.esquerda != null)
            current = current.esquerda;

        return current;
    }

    private NoAVL remover(NoAVL root, String chave) {
        if (root == null)
            return root;

        if (chave.compareTo(root.chave) < 0)
            root.esquerda = remover(root.esquerda, chave);
        else if (chave.compareTo(root.chave) > 0)
            root.direita = remover(root.direita, chave);
        else {
            if ((root.esquerda == null) || (root.direita == null)) {
                NoAVL temp = null;
                if (temp == root.esquerda)
                    temp = root.direita;
                else
                    temp = root.esquerda;

                if (temp == null) {
                    temp = root;
                    root = null;
                } else
                    root = temp;
            } else {
                NoAVL temp = minValueNode(root.direita);

                root.chave = temp.chave;

                root.direita = remover(root.direita, temp.chave);
            }
        }

        if (root == null)
            return root;

        root.altura = Math.max(altura(root.esquerda), altura(root.direita)) + 1;

        int balance = getBalance(root);

        if (balance > 1 && getBalance(root.esquerda) >= 0)
            return rotacaoDireita(root);

        if (balance > 1 && getBalance(root.esquerda) < 0) {
            root.esquerda = rotacaoEsquerda(root.esquerda);
            return rotacaoDireita(root);
        }

        if (balance < -1 && getBalance(root.direita) <= 0)
            return rotacaoEsquerda(root);

        if (balance < -1 && getBalance(root.direita) > 0) {
            root.direita = rotacaoDireita(root.direita);
            return rotacaoEsquerda(root);
        }

        return root;
    }

    public void remover(String chave) {
        raiz = remover(raiz, chave);
    }

    private void preOrder(NoAVL node) {
        if (node != null) {
            System.out.print(node.chave + " ");
            preOrder(node.esquerda);
            preOrder(node.direita);
        }
    }

    public void imprimir() {
        preOrder(raiz);
    }
}
