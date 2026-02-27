public class App {
    public static void main(String[] args) throws Exception {
        ListaOrdinata<String> lista = new ListaOrdinata<>();
        lista.add("Merida");
        lista.add("Rayane"); 
        lista.add("Ryan");
        lista.add("Jennie");
        lista.add("Svetlana");   

        System.out.println(lista);
        
        ListaOrdinata<Bici> lista2 = new ListaOrdinata<>();
        lista2.add(new Bici(16, Colori.BIANCO));
        lista2.add(new Bici(15, Colori.VERDE));
        lista2.add(new Bici(22, Colori.ROSSO));
        System.out.println(lista2);
    }
}