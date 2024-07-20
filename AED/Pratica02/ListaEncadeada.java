import java.util.List;

import javax.lang.model.element.Element;

public class ListaEncadeada{
  private Element head;
  private Element tail;

  public final class Element{
    Object data;
    Element next;
    Element(Object data){
      data = d;
      next = n;
    }

    public Object getData(){
      return data;
    }

    public Element getNext(){
      return next;
    }
    
  }

  public ListaEncadeada(){
    this.head = null;
    this.tail = null;
  }
}

//metodo fazVazia()//

public void fazVazia(){
  head = null;
  tail = null;
}

//metodo de acesso//

public Element getHead(){
  return head;
}

public Element getTail(){
  return tail;
}

public boolean estaVazia(){
  return head == null;
}

//metodo inserir inicio//

public void inserirInicio(object item){
  Element temp = new Element(item);
  if(head == null){
    tail = temp;
  }else{
    head = temp;
  }
}

//metodo inserir fim//

public void inserirFim(object item){
  Element temp = new Element(item);
  if(tail == null){
    head = temp;
  }else{
    tail = temp;
  }
}

//metodo inserirDepois//

public void inserirDepois(Object item){
    next = new Element (item, next);
    if(tail = null){
      tail = next;
    }
  }

  
