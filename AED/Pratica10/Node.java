import java.util.Stack;

public class Node<T> {
   
    private T valor;   /* Valor armazenado na raiz. */
    private Node<T> filho_esq, filho_dir; /* Referências para sub-árvores. */

        //construtor da arvore sem subarvore
    public Node(T v){
        valor = v;
        filho_esq = null;
        filho_dir = null;
    }
   
    //fornecendo as subarvores no construtor
    public Node(T v, Node<T> NoEsq, Node<T> NoDir){
        valor = v;
        filho_esq = NoEsq;
        filho_dir = NoDir;
    }
   
    // retorna o conteudo ou valor do no da arvore
    public T getValor(){
        return valor;
    }
   
   
    // Retorna a sub-árvore esquerda
    public Node<T> getFilho_esq() {
     return filho_esq;
    }

   // Retorna a sub-árvore direita
   public Node<T> getFilho_dir() {
       return filho_dir;
   }
 
   // seta o valor do no raiz da arvore
   public void setValor(T v){
     valor = v;
   }

 //seta o no da subarvore esquerda
   public void setEsq(Node<T> f_esq){
     filho_esq = f_esq;
 }

//seta o no da subarvore direita
   public void setDir(Node<T> f_dir){

     filho_dir = f_dir;
 
   } 

protected void imprime(){
  System.out.print(this.valor + " ");
  if (this.getFilho_esq()!=null) {
    this.getFilho_esq().imprime();
  }
  if (this.getFilho_dir()!=null) {
    this.getFilho_dir().imprime();
  }
}
     
protected void imprimeInOrdem() {
  if (this.getFilho_esq()!=null) {
  this.getFilho_esq().imprimeInOrdem();
}
System.out.print(this.valor + " "); //visitando o no raiz
  if (this.getFilho_dir()!=null) {
this.getFilho_dir().imprimeInOrdem();
  }            
}

   public boolean inserirOrdenado(T v) {      
       if (v.toString().compareTo(this.getValor().toString())<0) { //o valor deve ser inserido a esquerda do no atual
            if (this.getFilho_esq()!=null)
              return this.getFilho_esq().inserirOrdenado(v);//senao for nulo continua navegando na arvore ate encontrar uma folha
            else {
              Node<T> n = new Node<T>(v);//se for nulo, cria o no e adiciona na folha
              this.setEsq(n);
              return true;            
            }                
       }
       else{  
            //o valor deve ser inserido a direita atual
            if (this.getFilho_dir()!=null)
                  return this.getFilho_dir().inserirOrdenado(v);
             else {
                  Node<T> n = new Node<T>(v);
                  this.setDir(n);
                  return true;            
                }                    
       }
       
   }
}
protected void imprimeInOrdem() {
       
       if (this.getFilho_esq()!=null) {
         this.getFilho_esq().imprimeInOrdem();
       }      
       
       System.out.print(this.valor + " "); //visitando o no raiz
       
       if (this.getFilho_dir()!=null) {
       this.getFilho_dir().imprimeInOrdem();
         }        
       
       
   }
   protected void imprimeInOrdem2() {
       
       if (this.getFilho_dir()!=null) {
       this.getFilho_dir().imprimeInOrdem2();
         }        
       
       System.out.print(this.valor + " "); //visitando o no raiz
       
       if (this.getFilho_esq()!=null) {
             this.getFilho_esq().imprimeInOrdem2();
           }      
       
       
   }
   
   protected void imprimeEmPreordem() {
       
       System.out.print(this.valor + " "); //visitando o no raiz
       
       if (this.getFilho_esq()!=null) {
             this.getFilho_esq().imprimeEmPreordem();
           }      
       if (this.getFilho_dir()!=null) {
       this.getFilho_dir().imprimeEmPreordem();
         }        
  }
   
   protected void imprimeEmPosordem() {
       
       if (this.getFilho_esq()!=null) {
             this.getFilho_esq().imprimeEmPosordem();
           }      
       if (this.getFilho_dir()!=null) {
       this.getFilho_dir().imprimeEmPosordem();
         }        
     
       System.out.print(this.valor + " "); //visitando o no raiz
       
       
   }
   
   protected void imprimeEmLargura() {    
          //usaremos uma fila
          Queue<Object> f = new LinkedList<Object>();      
          f.offer(this); //enfileira o objeto node que chamou o metodo imprimiremLargura
          while( f.peek()!=null) { //enquanto fila nao estiver vazia repita
             Node<T>  no = (Node<T>)f.poll();//desenfileira um node da fila
             
             if (no.getFilho_esq()!=null) {
                     f.offer(no.getFilho_esq());//se tiver filho da esquerda, enfileira
             }          
             if (no.getFilho_dir()!=null) {
                      f.offer(no.getFilho_dir());//se tiver filho da direita, enfileira          
             }
             
             System.out.print(no.getValor()+ " ");
                 

          }//while
        }//imprimelargura

   protected void imprimeEmLarguraRecursivo(final Queue f) {
      if (f.peek()!=null) //verifica se a fila nao está vazia
        {        
          Node<T>  no = (Node<T>)f.poll();
         
          if (no!=null) {      
             if (no.getFilho_esq()!=null) {
               f.offer(no.getFilho_esq());
               }          
             if (no.getFilho_dir()!=null) {
                f.offer(no.getFilho_dir());              
               }
           System.out.print(no.getValor()+" ");          
           this.imprimeEmLarguraRecursivo(f);
          }
        }
      }                  
                 
 
   protected void imprimeEmLarguraInvertido(){
     
        Queue<Object> f = new LinkedList<Object>();    
        //PilhaEncadeada p = new PilhaEncadeada();
        java.util.Stack  p = new Stack<String>();
       
         f.offer(this);
          while( f.peek()!=null) {
             Node<T>  no = (Node<T>)f.poll();
             
             if (no.getFilho_esq()!=null) {
                     f.offer(no.getFilho_esq());;
             }          
             if (no.getFilho_dir()!=null) {
                      f.offer(no.getFilho_dir());          
             }
             
             p.push(no.getValor().toString());
             //System.out.print(no.getValor()+ " ");

          }//while
         
          System.out.println();
          imprimePilha(p);
         
  }
 
  private void imprimePilha(java.util.Stack p) {
       
       while (!p.empty()) {
           
           System.out.print(p.pop()+" ");
       }
  }

  protected int calculaAltura() {
//comprimento do caminho mais longo do nó a uma folha.      
       int alturaesquerda=0;
       int alturadireita=0;
               
       if (this.getFilho_esq()!=null)
           alturaesquerda = this.getFilho_esq().calculaAltura()+1;

       //aqui, como vou saber a altura do filho da direita pra eu poder calcular a altura do node
       
       if (this.getFilho_dir()!=null)
           alturadireita = this.getFilho_dir().calculaAltura()+1;
         
       
       if (alturaesquerda>alturadireita)
           return alturaesquerda;
       
       else
           return alturadireita;
  }
  //ate aqui
 
  protected int calculaAlturaEmLargura() {
       
      Queue<Object> f = new LinkedList<Object>();
      Queue<Integer> dist = new LinkedList<Integer>();

      f.offer(this);
      dist.offer(0);

      int altura_maxima = 0;

       while(f.peek()!=null) {
           Node<T>  no = (Node<T>)f.poll();
         int dist_pai = (int) dist.poll();
             
           if (no.getFilho_esq()!=null) {
                 f.offer(no.getFilho_esq());
                dist.offer(dist_pai + 1);
             }
                     
            if (no.getFilho_dir()!=null) {
                      f.offer(no.getFilho_dir());
                      dist.offer(dist_pai + 1);
             }
       
           // eh folha
           if (dist_pai > altura_maxima) altura_maxima = dist_pai;
         }//while

      return altura_maxima;
    }//imprimelargura

  protected Node<T> pesquisarValor(T v) {
       
       int comparacao = v.toString().compareTo(this.getValor().toString());
       
       if (comparacao<0) {//o valor a ser pesquisado estah do lado esquerdo do node?
             if (this.getFilho_esq()!=null)
                return this.getFilho_esq().pesquisarValor(v); // o valor pode estah na arvore esquerda
             else return null;//valor nao foi encontrado
      }
       else if (comparacao>0) {
         if (this.getFilho_dir()!=null)
            return this.getFilho_dir().pesquisarValor(v); // o valor pode estah na arvore direita
           else return null;//valor nao foi encontrado
       }
       else return this;// o valor encontra-se nesse noh atual
       
  }
 
  protected int calculaTotalNodes() {
      int totalesq=0;
      int totaldir=0;  
         
       if (this.getFilho_esq()!=null) {
         totalesq = this.getFilho_esq().calculaTotalNodes();
       }
       if (this.getFilho_dir()!=null) {
         totaldir = this.getFilho_dir().calculaTotalNodes();
         }
       
       return totalesq+totaldir + 1;
   }

protected int calculaTotalNodesFolhas() {

    int totalesq=0;
    int totaldir=0;
    boolean ehfolha=true;
                     
    if (this.getFilho_esq()!=null) {
        totalesq = this.getFilho_esq().calculaTotalNodesFolhas();
        ehfolha = false;
       }
    if (this.getFilho_dir()!=null) {
        totaldir = this.getFilho_dir().calculaTotalNodesFolhas();
        ehfolha = false;
       }
    if (ehfolha) { return 1;}
    else return (totaldir + totalesq);
    }


protected boolean removerNode(T v, Node<T> nodepai){
     
       int comparacao = v.toString().compareTo(this.getValor().toString());
       boolean resultado=false;
       
       if (comparacao<0){
          if (this.getFilho_esq()!=null)
          return this.getFilho_esq().removerNode(v,this); // o nó a ser removido ta na subarvore esquerda
            else resultado=false;//o valor nao ta na subarvoreesquerda  
       }
       else if (comparacao>0) {
         if (this.getFilho_dir()!=null)
             return this.getFilho_dir().removerNode(v,this); // o valor pode estah na subarvore direita
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
                   if (menorNodeDir !=this.getFilho_dir()) { //verifica se o proprio node raiz da subarvore direita eh ou nao o menor valor
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
                  //menorNodeDir.removerNode(menorNodeDir.getValor(), paiMenorNodeDir)
                   resultado = true;
                   }
                 
               }
   
       return resultado;
}

//seta o filho de um node pai como sendo o novo node.
protected void setFilhoNode(Node<T> nodePai, Node<T> novoNode) {

       if (nodePai.getFilho_esq()==this) {
             nodePai.setEsq(novoNode);}
       else
       if (nodePai.getFilho_dir()==this) {    
           nodePai.setDir(novoNode);}
}

protected Node<T> NodeComMaiorValor() {
 if (this.getFilho_dir()!= null) {
           return this.getFilho_dir().NodeComMaiorValor();          
        }
 else return this;
}//fim algotimo

protected Node<T> NodeComMenorValor() {
       if (this.getFilho_esq()!= null) {
            return this.getFilho_esq().NodeComMenorValor();
     } else return this;
    }//fim algotimo
 
protected Node<T> acharPai(Node<T> nofilho) {
    /*
       Esse algoritmo retorna o pai do Node noFilho
       O algoritmo verifica se o node do contexto de execução do metodo
       node This eh pai (pela esquerda ou pela direita) do nofilho.  
 */  

       if (this.getFilho_esq() == nofilho || this.getFilho_dir() == nofilho) {
          return this;
        } else
          {
          if (nofilho.getValor().toString().compareTo(this.getValor().toString()) > 0) {
              //o valor do no do atual contexto é maior que o nofilho, entao o pai estah do lado esquerdo
             if (this.getFilho_esq() != null) {
              return this.getFilho_esq().acharPai(nofilho);
            } else {
              return null;//pode ser que o nofilho nao esta na arvore ou ele eh o no raiz
            }
          } else {// subarvore direita
            if (this.getFilho_dir() != null) {
              return this.getFilho_dir().acharPai(nofilho);
            } else {
              return null; //pode ser que o nofilho nao esta na arvore ou ele eh o no raiz
            }
          }
        }
}