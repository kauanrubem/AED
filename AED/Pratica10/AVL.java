public class AVL<T> extends Node<T> {

    private int fatorbalanceamento = 0;
    //private AVL<T> pai;
   
    public AVL (T v) {
        super(v);
        fatorbalanceamento =0;        
    }
   
    //o metodo getfilho é reescrito para retornar um node AVL
    public AVL<T> getFilho_dir() {
           return (AVL<T>)super.getFilho_dir();
       }
   
    //o metodo getfilho é reescrito para retornar um node AVL
    public AVL<T> getFilho_esq() {
           return (AVL<T>)super.getFilho_esq();
       }
   
    //fator de balanceamento de cada no AVL
    public int getFB() { return this.fatorbalanceamento;}
   
   
    //reescreveremos o metodo inserir para atualizar o fator de balanceamento apos a insercao
    protected boolean InsereOrdenado(T v, AVL<T> nodepai ) {
          boolean resultado;
       
          if (v.toString().compareTo(this.getValor().toString())<0) {  
              //o valor deve ser inserido a esquerda do no atual
            if (this.getFilho_esq()!=null) {                    
                resultado = this.getFilho_esq().InsereOrdenado(v,this);//senao for nulo continua navegando na arvore ate encontrar uma folha
                this.verificarbalanceamento(nodepai);//verifica balanceamento e rotaciona se necessario.
                return resultado;                    
            }
            else {
              AVL<T> n = new AVL<T>(v);//se for nulo, cria o no e adiciona na folha
              this.setEsq(n);
              return true;                            
             }
          }
   
          else {
               //o valor deve ser inserido a direita atual
                if (this.getFilho_dir()!=null) {
                      resultado = this.getFilho_dir().InsereOrdenado(v,this);
                      this.verificarbalanceamento(nodepai);//verifica e o balanceamento e rotaciona se necessario
                      return resultado;
                  }
                 else {
                      AVL<T> n = new AVL<T>(v);
                      this.setDir(n);                          
                      return true;            
                    }          

          }
           
       }
   
    protected boolean removerNode(T v, AVL<T> nodepai){
         
           int comparacao = v.toString().compareTo(this.getValor().toString());
           boolean resultado=false;
           
           if (comparacao<0){
              if (this.getFilho_esq()!=null) {
                resultado = this.getFilho_esq().removerNode(v,this); // o nó a ser removido ta na subarvore esquerda
                this.verificarbalanceamento(nodepai);//verifica balanceamento e rotaciona se necessario.
                return resultado;
              }
               else resultado=false;//o valor nao ta na subarvoreesquerda  
           }
           else if (comparacao>0) {
             if (this.getFilho_dir()!=null) {
                  resultado = this.getFilho_dir().removerNode(v,this); // o valor pode estah na subarvore direita
                  this.verificarbalanceamento(nodepai);//verifica balanceamento e rotaciona se necessario.
                  return resultado;
                 }
                 else resultado=false;//valor nao foi encontrado               }
            }
            else //o no a ser removido é o atual.
            {
                if ((this.getFilho_esq()==null)&&(this.getFilho_dir()==null)){
                     //este node é folha, pois os dois filhos sao nulos
                     this.setFilhoNode(nodepai,null);//setar o filho de pai como nulo
                     resultado = true;
                   }
                   else if ((this.getFilho_esq()!=null)&&(this.getFilho_dir()==null)){
                     //o node tem o filho da esquerda diferente de nulo e o da direita eh nulo
                     this.setFilhoNode(nodepai,this.getFilho_esq()); //seta o pai o node atual com o filho da esquerda do nodeatual  
                     resultado = true;
                   }
                   else if ((this.getFilho_esq()==null)&&(this.getFilho_dir()!=null)){
                     //o node tem o filho da direita diferente de nulo e o da esquerda eh nulo
                     this.setFilhoNode(nodepai,this.getFilho_dir()); //seta o pai do node atual com o filho da direita do nodeatual
                     resultado = true;  
                   }
                   else if ((this.getFilho_esq()!=null)&&(this.getFilho_dir()!=null)){
                     //podemos pegar um dos dois nodes a seguir, tanto faz.
                     //Node<String> nEsq = NodeComMaiorValor(nodeatual.getFilho_esq()); //pega o node com maior valor da subarvore esquerda
                     
                       Node<T> menorNodeDir = this.getFilho_dir().NodeComMenorValor(); //pega o node com menor valor da subarvore da direita
                       Node<T> paiMenorNodeDir;
                       if (menorNodeDir!=this.getFilho_dir()) {
                         paiMenorNodeDir = this.getFilho_dir().acharPai(menorNodeDir);
                       }
                       else paiMenorNodeDir=this;
                       
                       this.setValor(menorNodeDir.getValor());//coloca o novo valor no nodeatual.
                       /*
                        * Se menorNodeDir eh o menor valor da subarvore direita, entao menorNodeDir nao tem filhos a esquerda porque
                        * o menor valor de uma arvore eh o node mais a esquerda dessa arvore
                        * sendo assim, eu já sei que o menorNodeDir tem no maximo um filho a direita
                        * ou ele eh um node folha.
                        * Sendo assim posso setar diretamente o filho (direita) do paiMenorNoDir com o filho da direita do menorNodeDir
                        */
                        menorNodeDir.setFilhoNode(paiMenorNodeDir,menorNodeDir.getFilho_dir()); //seta o pai do menorNode com o filho da direita                    
                        resultado = true;
                       }
                     
                   }
       
           return resultado;
       }
   
   
    public AVL<T> acharPai(Node<T> noraiz) {
            return (AVL<T>)super.acharPai(noraiz);      
          }
     
    //calcular fator balanceamento node
    private int calculaFatorBalanceamento() {
        int alturaesq = 0;
        int alturadir = 0;
        if (this.getFilho_esq()!=null)
            alturaesq = this.getFilho_esq().calculaAltura();            
        if (this.getFilho_dir()!=null)
            alturadir = this.getFilho_dir().calculaAltura();
        this.fatorbalanceamento = alturadir-alturaesq;
        return this.fatorbalanceamento;
    }
   
    private void verificarbalanceamento(AVL<T> nopai) {
     
     int fb = this.calculaFatorBalanceamento();
     int fb1=0;
     if ((fb<-1)||(fb>1)){//verificar se ha desbalanceamento.
         if (fb>1) { //o lado direito é bem maior
            if (this.getFilho_dir()!=null) {
                fb1 = this.getFilho_dir().calculaFatorBalanceamento();
            if (fb1<0)
                 this.rotacaoDuplaAEsquerda(nopai);
            else this.rotacaoAEsquerda(nopai);            
            }
             
         }
         else { //fb<-1
            fb1=0;
            if (this.getFilho_esq()!=null)
              fb1 = this.getFilho_esq().calculaFatorBalanceamento();
            if (fb1>0)
                this.rotacaoDuplaADireita(nopai);
            else this.rotacaoADireita(nopai);
         }
     }
    }
 
    //implementamos o algoritmo para rotacao a esquerda
    private void rotacaoAEsquerda(AVL<T> nopaideA) {
        AVL<T> novaraizB =  this.getFilho_dir();//filho da direita sera a nova raiz
        AVL<T> tempA = this;//raiz da rotacao
        if (novaraizB!=null) {              
          nopaideA.setFilhoNode(this, novaraizB);//o filho da direita vira a raiz
          tempA.setDir(novaraizB.getFilho_esq());//filho da esquerda da nova raiz vira filho da direita da antiga raiz    
          novaraizB.setEsq(tempA);//no A vira filho da direita da nova raizB                  
        }
        //if f
    }
   
    //implementamos o algoritmo para rotacao a direita
    private void rotacaoADireita(AVL<T> nopaideC) {
        AVL<T> novaraizB =  this.getFilho_esq();//filho da esquerda sera a nova raiz
        AVL<T> tempC = this;//raiz da rotacao
        if (novaraizB!=null) {              
          nopaideC.setFilhoNode(this, novaraizB);//o filho da direita vira a raiz
          tempC.setEsq(novaraizB.getFilho_dir());//filho da direita da nova raiz vira filho da Esquerda da antiga raiz    
          novaraizB.setDir(tempC);//                  
        }
        //if f    
    }
   
    //rotação dupla é a chamada consecutiva de duas rotacoes simples
    private void rotacaoDuplaAEsquerda(AVL<T> nopaideA) {
        //rotacao simples a direita no filho da direita.
        this.getFilho_dir().rotacaoADireita(this);
        //rotacao a esquerda na arvore original
        this.rotacaoAEsquerda(nopaideA);
    }
   
    //rotação dupla é a chamada consecutiva de duas rotacoes simples
    private void rotacaoDuplaADireita(AVL<T> nopaideA) {
        //rotacao simples a esquerda no filho da esquerda
        this.getFilho_esq().rotacaoAEsquerda(this);
        //rotacao a esquerda na arvore original
        this.rotacaoADireita(nopaideA);        
    }
   
}