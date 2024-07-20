import java.util.LinkedList;
import java.util.Queue;

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
   
public boolean inserirOrdenado(T v) {      
       if (v.toString().compareTo(this.getValor().toString())<0) {
            //o valor deve ser inserido a esquerda do no atual
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
     protected void imprimeInOrdem() {
       
       if (this.getFilho_esq()!=null) {
         this.getFilho_esq().imprimeInOrdem();
       }      
       
       System.out.print(this.valor + " "); //visitando o no raiz
       
       if (this.getFilho_dir()!=null) {
       this.getFilho_dir().imprimeInOrdem();
         }        
       
     }

         protected void imprimeEmPreordem() {
        System.out.print(this.valor + " ");
        if (this.getFilho_esq() != null) {
            this.getFilho_esq().imprimeEmPreordem();
        }
        if (this.getFilho_dir() != null) {
            this.getFilho_dir().imprimeEmPreordem();
        }
    }

    protected void imprimeEmPosordem() {
        if (this.getFilho_esq() != null) {
            this.getFilho_esq().imprimeEmPosordem();
        }
        if (this.getFilho_dir() != null) {
            this.getFilho_dir().imprimeEmPosordem();
        }
        System.out.print(this.valor + " ");
    }

    protected void imprimeEmLargura() {
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();
            System.out.print(current.valor + " ");

            if (current.getFilho_esq() != null) {
                queue.add(current.getFilho_esq());
            }
            if (current.getFilho_dir() != null) {
                queue.add(current.getFilho_dir());
            }
        }
    }

   }