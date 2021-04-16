import java.util.Scanner;

public class Kayttoliittyma {

    private Arvosanarekisteri rekisteri;
    private Scanner lukija;

    public Kayttoliittyma(Arvosanarekisteri rekisteri, Scanner lukija) {
        this.rekisteri = rekisteri;
        this.lukija = lukija;
    }

    public void kaynnista() {
        lueKoepisteet();
        System.out.println("");
        tulostaArvosanajakauma();
    }

    public void lueKoepisteet() {
        while (true) {
            System.out.print("Syötä yhteispisteet, -1 lopettaa:");
            String luettu = lukija.nextLine();
            if (luettu.equals("-1")) {
                break;
            }

            int pisteet = Integer.valueOf(luettu);
            if (pisteet < 0 || pisteet > 100) {
                //System.out.println("Epäkelpo luku.");
                continue;
            }
            this.rekisteri.lisaaArvosanaPisteidenPerusteella(pisteet);
        }
    }

    public void tulostaArvosanajakauma() {
        System.out.println("Pisteiden keskiarvo (kaikki): " + this.rekisteri.koepisteidenKeskiarvo());  
        System.out.println("Pisteiden keskiarvo (hyväksytyt): " + this.rekisteri.hyvaksyttyjenKeskiarvo());      
        System.out.println("Hyväksymisprosentti: " + this.rekisteri.hyvaksytytProsentti());  
        int arvosana = 5;
        while (arvosana >= 0) {               
            int tahtia = rekisteri.montakoSaanutArvosanan(arvosana);                               
            System.out.print(arvosana + ": ");                                                      
            tulostaTahtia(tahtia);
            System.out.println("");
            arvosana = arvosana - 1;
        }        
    }

    public static void tulostaTahtia(int tahtia) {
        if (tahtia == 0) {
            System.out.print("-"); 
        }
        while (tahtia > 0) {
            System.out.print("*");
            tahtia--;
        }
    }
}