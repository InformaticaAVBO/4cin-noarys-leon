import java.io.File;
import java.io.PrintWriter;

public class Player {
    private String nome;
    private int valore;

    public Player(String nome, int valore) {
        this.nome = nome;
        this.valore = valore;
    }

    public String getNome() {
        return nome;
    }

    public int getValore() {
        return valore;
    }

    public void salvaSuFile() {
        File f = new File("data/" + nome + ".txt");
        try {
            PrintWriter pw = new PrintWriter(f);
            pw.println(nome);
            pw.println(valore);
            pw.close();
            System.out.println("Valore salvato nel file " + nome + ".txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
