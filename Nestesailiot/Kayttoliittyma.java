
import java.util.Scanner;

public class Kayttoliittyma {
    private Sailio sailio1;
    private Sailio sailio2;
    private Scanner lukija;
    
        public Kayttoliittyma (Sailio sailio1, Sailio sailio2, Scanner lukija) {
        this.sailio1 = sailio1;
        this.sailio2 = sailio2;
        this.lukija = lukija;
        }
   
    public void kaynnista() {  
        System.out.println("Ensimmäinen: " + sailio1.toString());
        System.out.println("Toinen: " + sailio2.toString());
        while (true) {          
        String luettu = lukija.nextLine();
        if (luettu.equals("lopeta")) {
            break;
        }
        String[] osat = luettu.split(" ");
        String komento = osat[0];
        int maara = Integer.valueOf(osat[1]);
                   
        if (komento.contains("lisaa")) { 
            sailio1.lisaa(maara);
        
        System.out.println("Ensimmäinen: " + sailio1.toString());
        System.out.println("Toinen: " + sailio2.toString());
        }
               
        if (komento.contains("siirra")) { 
            if (maara <= sailio1.sisalto()) {
            sailio1.poista(maara);
            if (maara + sailio2.sisalto() <= 100)
            sailio2.lisaa(maara);
            else
                sailio2.asetaTaydeksi();
            }    
                else if (maara > sailio1.sisalto()) {
                    if (maara + sailio2.sisalto() <= 100)
                    sailio2.lisaa(sailio1.sisalto());
                    else
                        sailio2.asetaTaydeksi();
                        sailio1.asetaTyhjaksi();
                }
        System.out.println("Ensimmäinen: " + sailio1.toString());
        System.out.println("Toinen: " + sailio2.toString());                                   
        }  
            
        if (komento.contains("poista")) {  
            sailio2.poista(maara);
        System.out.println("Ensimmäinen: " + sailio1.toString());
        System.out.println("Toinen: " + sailio2.toString());              
        }
        }           
    }   
}

