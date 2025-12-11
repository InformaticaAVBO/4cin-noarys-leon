public class Lista {
    private String[] dati;
    private int dim;

    public Lista(){
        this(10);
    }

    public Lista(int capacità) {
        dati = new String[capacità];
        dim = 0;
    }

    public void add(String v) {
        if (dim < dati.length) {
            dati[dim] = v;
            dim++;
        } else {
            System.out.println("!!! La lista è piena !!!");
        }
    }

    public void stampa() {
        System.out.println("Contenuto della lista: ");
        for (int i = 0; i < dim; i++) {
            System.out.println(" - " + dati[i]);
        }
    }
}
