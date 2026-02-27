public class Lista<T> {
    Nodo<T> head;

    public Lista() {
        head = null;
    }

    public void add(T v) {
        Nodo<T> n = new Nodo<>(v); // cosi crea un nodo automaticamente
        addTail(n); 
    }
    
    public void addHead(Nodo<T> n) { // aggiunge un nuovo nodo davanti, nella "head"
        /*if  (root == null) {
            root = n;
            return;
        } else {
            n.setNext(root);
            root = n;
        }*/

        Nodo<T> temp = head;
        head = n;
        n.setNext(temp);
    } 

    public void addTail(Nodo<T> n) { // aggiunge un nuovo nodo in fondo alla lista, alla "tail"
        if (head == null) {
            head = n;
        } else {
            Nodo<T> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(n);
        }
    }
    public void remove(T v) {
        if (head == null) return;

        // CASO 1: L'elemento da eliminare è il primo (head)
        if (head.getValore() != null && head.getValore().equals(v)) {
            head = head.getNext();
            System.out.println("Il nodo con valore " + v + " (testa) è stato eliminato.");
            return;
        }
        
        // CASO 2: L'elemento è nel resto della lista
        Nodo<T> previo = head;
        Nodo<T> corrente = head.getNext();

        while (corrente != null) {
            if (corrente.getValore() != null && corrente.getValore().equals(v)) {
                previo.setNext(corrente.getNext());
                System.out.println("Il nodo con valore " + v + " è stato eliminato.");
                return;
            }
            previo = corrente;
            corrente = corrente.getNext();
        }
    }

    public boolean exists(T v) {
        Nodo<T> temp = head;
        while (temp != null) {
            // Controllo anti-crash: verifichiamo che il valore del nodo non sia null
            if (temp.getValore() != null && temp.getValore().equals(v)) {
                System.out.println("Il nodo con valore " + v + " esiste.");
                return true;
            }
            temp = temp.getNext();
        }
        System.out.println("Il nodo con valore " + v + " non esiste.");
        return false;
    }


    public String toString() {
        String v = "\nLa lista contiene: ";
        Nodo<T> temp = head;
        while (temp != null) {
            v += temp.getValore() + " - ";
            temp = temp.getNext();
        }
        return v;
    }

}