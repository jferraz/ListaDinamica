package ListaEncadeada;

public class Node<T> { 

    public T elemento; //onde guarda o valor, que pode ser de qualquer tipo
    Node<T> proximo; 

    //*****CONSTRUTORES*****/

    public Node(T elemento, Node<T> proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }
    public Node(T elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    //*****GETTERS/SETTERS*****/

    public T getElemento() {
        return elemento;
    }
    public void setElemento(T elemento) {
        this.elemento = elemento;
    }
    public Node<T> getProximo() {
        return proximo;
    }
    public void setProximo(Node<T> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "" + elemento + "," + proximo + "";
    }

      

}
