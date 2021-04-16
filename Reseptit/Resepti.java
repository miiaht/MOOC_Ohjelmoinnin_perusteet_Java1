import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Resepti {
    private String nimi;
    private int keittoaika;
    private ArrayList<String> aineet = new ArrayList<>();
    
    public Resepti (String nimi, int keittoaika, ArrayList<String> aineet) {
        this.nimi = nimi;
        this.keittoaika = keittoaika;
        for (String aine : aineet) {
            this.aineet.add(aine);
        }
    }
    public String getNimi() {
        return this.nimi;
    }

    public int getKeittoaika() {
        return this.keittoaika;
    }
    
     public ArrayList<String> getAineet() {
        return this.aineet;
    }
     
    @Override
    public String toString() {
        return this.getNimi() + ", keittoaika: " + this.getKeittoaika();
    }
}
