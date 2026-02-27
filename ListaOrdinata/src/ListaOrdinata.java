public class ListaOrdinata<T extends Comparable<T>> {
    Nodo<T> head;

    public ListaOrdinata() {
        head = null;
    }
public void add(T v) {
    Nodo<T> n = new Nodo<>(v);
    
    if (head == null) {
        head = n;
        return;
    }
    
    if (head.getValore().compareTo(v) > 0) {
        n.setNext(head);
        head = n;
        return;
    }

    Nodo<T> temp = head;
    
    while (temp.getNext() != null && temp.getNext().getValore().compareTo(v) < 0) {
        temp = temp.getNext();
    }

    n.setNext(temp.getNext());
    temp.setNext(n);
}


    public String toString() {
        String s = "\nLa lista contiene: ";
        Nodo<T> temp = head;
        while (temp != null) {
            s += "\n- " +  temp.getValore();
            temp = temp.getNext();
        }
        return s;
    }

}
