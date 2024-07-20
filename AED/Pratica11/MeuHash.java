public class MeuHash {
    private ArvoreAVL tabelaHash[];
    private int m; // m deve ser primo

    public MeuHash(int m) {
        tabelaHash = new ArvoreAVL[m];
        this.m = m;
    }

    public void inserir(String strk) {
        int entradahash = funcaohash(strk);
        if (tabelaHash[entradahash] == null) {
            tabelaHash[entradahash] = new ArvoreAVL();
        }
        tabelaHash[entradahash].inserir(strk);
    }

    public boolean remover(String strk) {
        int entradahash = funcaohash(strk);
        boolean resultado = false;
        if (tabelaHash[entradahash] == null) {
            return resultado;
        } else {
            tabelaHash[entradahash].remover(strk);
            resultado = true;
            return resultado;
        }
    }

    public void alterarValor(String strKVelho, String strkNovo) {
        if (this.remover(strKVelho)) {
            this.inserir(strkNovo);
        }
    }

    private int funcaohash(String chave) {
        int soma = 0;
        int comp = chave.length();
        for (int i = 0; i < comp; i++) {
            soma += (chave.charAt(i) * (i + 1));
        }
        return (soma % m);
    }

    public void imprimir() {
        for (int i = 0; i < m; i++) {
            if (tabelaHash[i] != null) {
                tabelaHash[i].imprimir();
                System.out.println();
            } else {
                System.out.println("-------");
            }
        }
    }

    public static void main(String[] args) {
        int M = 13; // Exemplo de tamanho da tabela hash
        MeuHash hF = new MeuHash(M);
        hF.inserir("Helio");
        hF.inserir("jose");
        hF.inserir("Jose");
        hF.inserir("Antonio");
        hF.inserir("Roberto");
        hF.inserir("Hugo");

        for (int i = 0; i < hF.m; i++) {
            if (hF.tabelaHash[i] != null) {
                hF.tabelaHash[i].imprimir();
                System.out.println();
            } else {
                System.out.println("-------");
            }
        }
    }
}
