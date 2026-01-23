public class Posto {
    private int numero;
    private Barca barca;

    public Posto(int numero) {
        this.numero = numero;
        this.barca = null; // così il posto è inizialmente vuoto
    }

    public int getNumero() {
        return numero;
    }

    public Barca getBarca() {
        return barca;
    }
    
    public boolean isLibero() {
        return barca == null;
    }
    
    public void occupaPosto(Barca barca) {
        this.barca = barca;
    }
    
    public Barca liberaPosto() {
        Barca temp = this.barca;
        this.barca = null;
        return temp;
    }
    
    @Override
    public String toString() {
        if(isLibero()) {
            return "Il posto " + numero + " e' libero.";
        } else {
            return "Il posto " + numero + " e' occupato da: " + barca.toString();
        }
    }
}
