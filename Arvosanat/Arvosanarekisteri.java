
import java.util.ArrayList;

public class Arvosanarekisteri {
    private ArrayList<Integer> arvosanat;
    private ArrayList<Integer> koepisteet;
    private ArrayList<Integer> hyvaksytyt;

    public Arvosanarekisteri() {
        this.arvosanat = new ArrayList<>();
        this.koepisteet = new ArrayList<>();
        this.hyvaksytyt = new ArrayList<>();
    }

    public void lisaaArvosanaPisteidenPerusteella(int pisteet) {
        this.arvosanat.add(pisteetArvosanaksi(pisteet));
        this.koepisteet.add(pisteet);
        if (pisteet >= 50) {
            this.hyvaksytyt.add(pisteet);
        }
    }

    public int montakoSaanutArvosanan(int arvosana) {
        int lkm = 0;
        for (int saatu : this.arvosanat) {
            if (saatu == arvosana) {
                lkm++;
            }
        }
        return lkm;
    }

    public static int pisteetArvosanaksi(int pisteet) {

        int arvosana = 0;
        if (pisteet < 50) {
            arvosana = 0;
        } else if (pisteet < 60) {
            arvosana = 1;
        } else if (pisteet < 70) {
            arvosana = 2;
        } else if (pisteet < 80) {
            arvosana = 3;
        } else if (pisteet < 90) {
            arvosana = 4;
        } else {
            arvosana = 5;
        }

        return arvosana;
    }
    public double arvosanojenKeskiarvo() {
        if (this.arvosanat.isEmpty()) {
            return -1;
         } 
            int arvosanojenSumma =0;
            for (Integer arvosana : arvosanat) {
                arvosanojenSumma += arvosana;
            }    
            return 1.0 * arvosanojenSumma / this.arvosanat.size();
                  
    }
    public double koepisteidenKeskiarvo() {
          if (this.koepisteet.isEmpty()) {
            return -1;
         } 
            int pisteidenSumma = 0;
            for (Integer pisteet : koepisteet) {
                pisteidenSumma += pisteet;
            }    
            return 1.0 * pisteidenSumma / this.koepisteet.size();
        
    }
    public double hyvaksyttyjenKeskiarvo() {
         if (this.hyvaksytyt.isEmpty()) {
            return -1;
         } 
            int pisteidenSumma = 0;                            
            for (Integer pisteet : koepisteet) {
                if (pisteet >= 50)
                pisteidenSumma += pisteet;
            } 
         
            return 1.0 * (pisteidenSumma / this.hyvaksytyt.size());
    }
    
    public double hyvaksytytProsentti() {
       double hyvaksytytProsentti = 100 * ((double) this.hyvaksytyt.size() / (double) this.koepisteet.size());
       return hyvaksytytProsentti;
    }
    
}