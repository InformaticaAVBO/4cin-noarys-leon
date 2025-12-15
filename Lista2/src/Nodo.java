public class Nodo {
    private String valore;
    private Nodo next;

    public Nodo(String v) {
        valore = v;
        next = null;
    }

    public void setNext(Nodo n) {
        next = n;
    }

    public Nodo getNext() {
        return next;
    }

    public void setValore(String v) {
        valore = v;
    }

    public String getValore() {
        return valore;
    }
}
