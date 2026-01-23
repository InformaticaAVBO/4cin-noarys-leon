// imports
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Porto porto = new Porto();
        
        boolean continua = true;
        while (continua) {
            System.out.println("\n| GESTIONE PORTO |");
            System.out.println("1. Assegna posto a una barca");
            System.out.println("2. Libera un posto e calcola affitto");
            System.out.println("3. Cerca barca in un posto");
            System.out.println("4. Salva stato del porto su un file");
            System.out.println("5. Cerca barche per nazionalita'");
            System.out.println("6. Visualizza posti occupati");
            System.out.println("0. Esci");
            System.out.println("Scegli un'opzione: ");
            
            int scelta = scanner.nextInt();
            scanner.nextLine();            
            
            try {
                switch (scelta) {
                    case 1: // Assegna posto
                        assegnaPosto(porto, scanner);
                        break;
                    
                    case 2: // Libera posto
                        liberaPosto(porto, scanner);
                        break;
                    
                    case 3: // Cerca barca
                        cercaBarca(porto, scanner);
                        break;
                    
                    case 4: // Salva su file
                        salvaSuFile(porto, scanner);
                        break;
                    
                    case 5: // Cerca per nazionalità
                        cercaPerNazionalita(porto, scanner);
                        break;
                    
                    case 6: // Visualizza posti occupati
                        porto.viewPostiOccupati();
                        break;
                    
                    case 0: // Esci
                        continua = false;
                        System.out.println("\nBye Bye!");
                        break;
                    
                    default: // Scelta non valida
                        System.out.println("Opzione non valida!");
                }
            } catch (Exception e) {
                System.out.println("\nErrore: " + e.getMessage());
            }
        }
        
        scanner.close();
    }
    
    private static void assegnaPosto(Porto porto, Scanner scanner) throws Exception {
        System.out.println("\nAssegna posto a una barca: ");
        
        System.out.print("Nome barca: ");
        String nome = scanner.nextLine();
        
        System.out.print("Nazionalita': ");
        String nazionalita = scanner.nextLine();
        
        System.out.print("Lunghezza (metri): ");
        double lunghezza = scanner.nextDouble();
        
        System.out.print("Stazza (tonnellate): ");
        double stazza = scanner.nextDouble();
        
        scanner.nextLine();
        
        System.out.print("Tipologia (VELA/MOTORE): ");
        String tipologia = scanner.nextLine();
        
        Barca barca = new Barca(nome, nazionalita, tipologia, lunghezza, stazza);
        
        int numeroPosto = porto.assegnaPosto(barca);
        
        System.out.println("Barca assegnata al posto " + numeroPosto);
    }
    
    private static void liberaPosto(Porto porto, Scanner scanner) throws Exception {
        System.out.println("\nLibera posto: ");
        
        System.out.print("Numero posto da liberare: ");
        int numeroPosto = scanner.nextInt();
        
        System.out.print("Giorni di sosta: ");
        int giorni = scanner.nextInt();
        scanner.nextLine();
        
        double costo = porto.liberaPosto(numeroPosto, giorni);
        System.out.printf("Posto liberato. Importo da pagare: €", costo);
    }
    
    private static void cercaBarca(Porto porto, Scanner scanner) throws Exception {
        System.out.println("\nCerca barca: ");
        
        System.out.print("Numero posto: ");
        int numeroPosto = scanner.nextInt();
        scanner.nextLine();
        
        String info = porto.cercaBarca(numeroPosto);
        System.out.println(info);
    }
    
    private static void salvaSuFile(Porto porto, Scanner scanner) throws Exception {
        System.out.println("\nSalva su un file: ");
        
        System.out.print("Nome file (es. stato_porto.txt): ");
        String nomeFile = scanner.nextLine();
        
        porto.salvaSuFile(nomeFile);
    }
    
    private static void cercaPerNazionalita(Porto porto, Scanner scanner) {
        System.out.println("\nCerca per nazionalità: ");
        
        System.out.print("Nazionalità da cercare: ");
        String nazionalita = scanner.nextLine();
       
        String[] nomi = porto.barcheNazionalità(nazionalita);
        
        if (nomi.length == 0) {
            System.out.println("Nessuna barca trovata con nazionalità: " + nazionalita);
        } else {
            System.out.println("\nBarche di nazionalità " + nazionalita + ":");
            for (int i = 0; i < nomi.length; i++) {
                System.out.println((i + 1) + ". " + nomi[i]);
            }
        }
    }
}
