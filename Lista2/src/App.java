public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("\nArrayList: ");
        // lista è un oggetto che contiene root, creare una lista significa creare un puntatore al prossimo nodo.
        // cosa sono? una sequenza di nodi in cui ogni nodo è fatto di due elementi, un elemento e un puntatore. Quello dell'inizio si chiama root, quello della fine si chiama null (se non c'e' un nodo successivo).
        // questi nodi sono degli oggetti che hanno un valore e un suggerimento al nodo successivo.
        
        Lista lista = new Lista();
        
        lista.addTail(new Nodo("IT: Ciao"));
        lista.addTail(new Nodo("EN: Hello"));
        lista.addTail(new Nodo("ES: Hola"));
        
        lista.addHead(new Nodo("Prova !!"));
        
        lista.add("Prova 2 !!");
        lista.add("yolo");

        lista.exists("EN: Hello");
        lista.exists("Prova 2 !!");

        lista.remove("IT: Ciao");
        lista.remove("Prova !!");
        lista.remove("Prova 2 !!");

        lista.exists("Prova 2 !!");
        lista.exists("IT: Ciao");

        System.out.println(lista);
    }
}
