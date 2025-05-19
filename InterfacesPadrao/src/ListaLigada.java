// Lista com iterador
public class ListaLigada<T> implements Lista<T> {
    private class Nodo<E>{
        public E dado;
        public Nodo<E> prox;

        public Nodo(E dado){
            this.dado = dado;
            this.prox = null;
        }
    }

    private Nodo<T> prim;
    private Nodo<T> ult;
    private int cont;

    public ListaLigada(){
        prim = null;
        ult = null;
        cont = 0;
    }

    @Override
    public void add(T dado) {
        Nodo<T> aux = new Nodo<>(dado);
        if (prim == null){
            prim = aux;
            ult = aux;
        }else{
            ult.prox = aux;
            ult = aux;
        } 
        cont++;
    }

    @Override
    public String toString(){
        Nodo<T> aux = prim;
        StringBuffer sb = new StringBuffer();
        while(aux != null){
            sb.append(aux.dado+"\n");
            aux = aux.prox;
        }        
        return sb.toString();
    }

    @Override
    public int size() {
        return cont;
    }

    @Override
    public T get(int indice) {
        Nodo<T> aux = prim;
        for(int i=0;i<indice;i++){
            aux = aux.prox;
        }
        return aux.dado;
    }
}
