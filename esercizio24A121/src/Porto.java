// imports
// import java.io.BufferedReader;
// import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Porto {
    private Posto[] posti;
    private int maxPosti = 100;
    
    public Porto() { // costruttore
        posti = new Posto[maxPosti];
        for (int i = 0; i < maxPosti; i++) {
            posti[i] = new Posto(i + 1);
        }
    }
    
    private int cercaPosto(Barca barca, int inizio, int fine) throws Exception {
        for (int i = 0; i < fine; i++) {
            if (posti[i].isLibero()) {
                posti[i].occupaPosto(barca);
                return posti[i].getNumero();
            }
        } throw new Exception("Nessun posto disponibile.");
    }
    
    public int assegnaPosto(Barca barca) throws Exception {
        if (barca.getLunghezza() > 10) {
            return cercaPosto(barca, 20, maxPosti);
        } else if (barca.isVela()) {
            try {
                return cercaPosto(barca, 50, maxPosti);
            } catch (Exception e) {
                return cercaPosto(barca, 0, maxPosti);
            }
        } else {
            return cercaPosto(barca, 0, maxPosti);
        } 
    }
    
    public double liberaPosto(int numeroPosto, int giorniSosta) throws Exception {
        if (numeroPosto < 1 || numeroPosto > maxPosti) {
            throw new Exception("Posto non valido.");            
        }
        
        Posto posto = posti[numeroPosto - 1];
        
        if (posto.isLibero()) {
            throw new Exception("Il posto " + numeroPosto + " e' libero.");
        }
        
        Barca barca = posto.getBarca();
        
        double costoGiornaliero;
        if (barca.isVela()) {
            costoGiornaliero = barca.getLunghezza() * 10;
        } else {
            costoGiornaliero = barca.getStazza() * 20;
        }
        
        double costoTot = costoGiornaliero + giorniSosta;
        posto.liberaPosto();
        
        return costoTot;
    }
    
    public String cercaBarca(int numeroPosto) throws Exception {
        if (numeroPosto < 1 || numeroPosto > maxPosti) {
            throw new Exception("Numero posto non valido.");
        }
        
        Posto posto = posti[numeroPosto - 1];
        
        if (posto.isLibero()) {
            return "Il posto " + numeroPosto + " e' libero.";
        } else {
            return posto.toString();
        }
    }
    
    public void salvaSuFile(String nomeFile) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(nomeFile));
            pw.println("Stato del porto.");
            pw.println();
            for (int i = 0; i < maxPosti; i++) {
                if (!posti[i].isLibero()) {
                    pw.println(posti[i].toString());
                }
            }   pw.close();
            System.out.println("Stato del porto salvato su " + nomeFile + " :)");
        } catch (IOException ex) {
            System.out.println("Errore nella scrittura del file" + ex.getMessage());
        } finally {
            pw.close();
        }
    }
    
    /*public void stampaStatoFile(String nomeFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeFile))) {
        String s;
        while ((s = br.readLine()) != null) { 
            System.out.println(s); 
        }
        } catch (IOException ex) {
            System.out.println("Errore nella scrittura del file" + ex.getMessage());
        }
    }*/
    
    public String[] barcheNazionalità(String nazionalità) {
        ArrayList<String> barche = new ArrayList<>();
        
        for (int i = 0; i < maxPosti; i++) {
            if (!posti[i].isLibero()) {
                Barca barca = posti[i].getBarca();
                if (barca.getNazionalità().equalsIgnoreCase(nazionalità)) {
                    barche.add(barca.getNome());
                }
            }
        }
        
        return barche.toArray(new String[0]);
    }
    
    public void viewPostiOccupati() {
        System.out.println("\nPosti occupati: ");
        boolean trovatoUno = false;
        
        for (int i = 0; i < maxPosti; i++) {
            if (!posti[i].isLibero()) {
                System.out.println(posti[i].toString());
                trovatoUno = true;
            }
        }
        
        if (!trovatoUno) {
            System.out.println("Nessun posto è occupato :)");
        }
    }

    /*@Override
    public String toString() {
        String s = "Il porto contiene le seguenti barche:\n";
        for (int i = 0; i < posti.length(); i++) {
            if (posti[i] == null) {
                continue;
            }

            s += "Posto numero: " + (i + 1) + " " + posti[i] + "\n";
        }

        return s;
    }*/

}
