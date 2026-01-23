public class Barca {
    private String nome, nazionalità, tipologia;
    private double lunghezza, stazza;

    public Barca(String nome, String nazionalità, String tipologia, double lunghezza, double stazza) {
        this.nome = nome;
        this.nazionalità = nazionalità;
        this.tipologia = tipologia;
        this.lunghezza = lunghezza;
        this.stazza = stazza;
    }

    public String getNome() {
        return nome;
    }

    public String getNazionalità() {
        return nazionalità;
    }

    public String getTipologia() {
        return tipologia;
    }

    public double getLunghezza() {
        return lunghezza;
    }

    public double getStazza() {
        return stazza;
    }

    public boolean isVela() {
        return tipologia.equals("Vela");
    }
    
    @Override
    public String toString() {
        return "\nNome: " + nome + "\nNazionalita': " + nazionalità + "\nTipologia: " + tipologia + "\nLunghezza: " + lunghezza + " metri" + "\nStazza: " + stazza;
    }
    
    
}
