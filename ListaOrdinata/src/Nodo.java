public class Nodo<T> {
    private T valore;
    private Nodo<T> next;

    public Nodo(T v) {
        valore = v;
        next = null;
    }

    public void setNext(Nodo<T> n) {
        next = n;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setValore(T v) {
        valore = v;
    }

    public T getValore() {
        return valore;
    }
}