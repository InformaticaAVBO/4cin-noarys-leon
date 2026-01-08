public class App {
    public static void main(String[] args) throws Exception {
        Player p1 = new Player("Matteo", 100);
        Player p2 = new Player("Malik", 200);
        Player p3 = new Player("George", 300);
        
        p1.salvaSuFile();
        p2.salvaSuFile();
        p3.salvaSuFile();

    }
}
