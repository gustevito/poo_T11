public class ListaArranjo<T> implements Lista<T>{
    public static final int TMAX = 100;
    private T[] base;
    private int proxLivre;

    public ListaArranjo(){
        base = (T[])(new Object[TMAX]);
        proxLivre = 0;
    }

    @Override
    public void add(T dado) {
        base[proxLivre] = dado;
        proxLivre++;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<proxLivre;i++){
            sb.append(base[i]+"\n");
        }
        return sb.toString();
    }

    @Override
    public int size() {
        return proxLivre;
    }

    @Override
    public T get(int i) {
        return base[i];
    }
}

