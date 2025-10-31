import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void copyFile(String fileIn, String fileOut) throws IOException { // lancia l'eccezione a chi ha chiamato il metodo
        // Apre il file di input e lo legge
        File f = new File(fileIn);
        Scanner leggiFile = new Scanner(f);
        // Crea il file di output
        FileWriter scriviFile = new FileWriter(fileOut);
        // Legge riga per riga e le scrive in output
        while (leggiFile.hasNextLine()) {
            String s = leggiFile.nextLine();
            scriviFile.write(s);
        }
        leggiFile.close();
        scriviFile.close();
    }
    public static void main(String[] args) throws Exception { // lancia l'eccezione a chi ha chiamato il main
        // Prende in input il nome del file sorgente e il nome del file di destinazione
        Scanner leggiDaTastiera = new Scanner(System.in);
        System.out.print("Inserisci il nome del file di input: ");
        String inputFilename = leggiDaTastiera.nextLine();
        System.out.print("Inserisci il nome del file di output: ");
        String outputFilename = leggiDaTastiera.nextLine();
        leggiDaTastiera.close();

        // Copia input in output
        App.copyFile(inputFilename, outputFilename);
    }
}