public class Bici implements Comparable<Bici>{
    int pollici;
    Colori colore;

    public Bici(int pollici, Colori colore){
        this.pollici = pollici;
        this.colore = colore;
    }

    public String toString(){
        return "Sono una bici da " + pollici + " pollici e di colore  " + colore;
    }

    @Override
    public int compareTo(Bici o){
        if (pollici < o.pollici) return -1;
        if (pollici > o.pollici) return 1;
        return 0;
    }
}
