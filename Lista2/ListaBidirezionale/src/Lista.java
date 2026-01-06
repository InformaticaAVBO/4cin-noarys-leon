public class Lista {
    Nodo root;

    public Lista() {
        root = null;
    }

    public void add(String s) {
        Nodo n = new Nodo(s); // cosi crea un nodo automaticamente
        addTail(n); 
    }
    
    public void addHead(Nodo n) { // aggiunge un nuovo nodo davanti, nella "head"
        /*if  (root == null) {
            root = n;
            return;
        } else {
            n.setNext(root);
            root = n;
        }*/

        Nodo temp = root;
        root = n;
        n.setNext(temp);
    } 

    public void addTail(Nodo n) { // aggiunge un nuovo nodo in fondo alla lista, alla "tail"
        if (root == null) {
            root = n;
        } else {
            Nodo temp = root;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(n);
        }
    }

    public void remove(String s) { // per eliminare un nodo della lista
        if (root == null) {
            return;
        }

        if (root.getValore().equals(s)) {
            root = root.getNext();
            System.out.println("Il nodo con valore " + root.getValore() + " nella head è stato eliminato.");
            return;
        }

        Nodo previo = root;
        Nodo corrente = root.getNext();

        while (corrente != null) {
            if (corrente.getValore().equals(s)) {
                previo.setNext(corrente.getNext());
                System.out.println("Il nodo con valore " + corrente.getValore() + " è stato eliminato.");
                return;
            }

            previo = corrente;
            corrente = corrente.getNext();
        }
    }

    public boolean exists(String s) { // per capire se una stringa/nodo è nella lista
        Nodo temp = root;
        while (temp != null) {
            if (temp.getValore().equals(s)) {
                System.out.println("Il nodo con valore " + temp.getValore() + " esiste.");
                return true;
            }
            temp = temp.getNext();
        }
        System.out.println("Il nodo con valore " + s + " non esiste.");
        return false;
    }

    public String toString() {
        String s = "\nLa lista contiene: ";
        Nodo temp = root;
        while (temp != null) {
            s += temp.getValore() + " - ";
            temp = temp.getNext();
        }
        return s;
    }
}
