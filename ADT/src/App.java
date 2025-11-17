public class App {
    public static void main(String[] args) throws Exception {
        Stack<String> x = new Stack();
        for (int i=0; i<50; i++)
            x.push("ciao " + i);
        for (int i=0; i<50; i++)
            System.out.println(x.pop(i));
    }
}