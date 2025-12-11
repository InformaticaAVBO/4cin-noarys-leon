public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Lista lista = new Lista();
        lista.add("ciao, questa è la prima riga");
        lista.add("ciao");
        lista.add("hello");
        lista.add("hola");

        lista.stampa();
    }
}
