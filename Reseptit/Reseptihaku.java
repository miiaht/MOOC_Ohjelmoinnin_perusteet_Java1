
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.logging.Logger;

public class Reseptihaku {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Mistä luetaan?");
        String tiedosto = lukija.nextLine();
        ArrayList<Resepti> reseptit = lueReseptit(tiedosto);
        
        System.out.println("Komennot:");
        System.out.println("listaa - listaa reseptit");
        System.out.println("lopeta - lopettaa ohjelman");
        System.out.println("hae nimi - hakee reseptiä nimen perusteella");
        System.out.println("hae keittoaika - hakee reseptiä keittoajan perusteella");
        System.out.println("hae aine - hakee reseptiä raaka-aineen perusteella");
        
        System.out.print("Syötä komento: ");
            while (true) {
            String komento = lukija.nextLine();
                if (komento.equals("listaa")) {
                    System.out.println("Reseptit: ");
                    for (Resepti resepti : reseptit) {
                        System.out.println(resepti.toString());
                        } 
                }    
                if (komento.equals("lopeta")) {
                    break;
                }
                if (komento.equals("hae nimi")) {
                    System.out.println("Mitä haetaan: ");
                    String haettava = lukija.nextLine();
                    System.out.println("Reseptit: ");
                    for (Resepti resepti : reseptit) {
                        if (resepti.getNimi().contains(haettava)) {
                            System.out.println(resepti.toString());
                        }    
                    }
                }
                
                if (komento.equals("hae keittoaika")) {
                    System.out.println("Keittoaika korkeintaan: ");
                    int maxAika = Integer.valueOf(lukija.nextLine());
                    System.out.println("Reseptit: ");
                    for (Resepti resepti : reseptit) {
                        if (resepti.getKeittoaika() <= maxAika) {
                            System.out.println(resepti.toString());
                        }    
                    }
                }
                   if (komento.equals("hae aine")) {
                    System.out.println("Mitä raaka-ainetta haetaan: ");
                    String haettavaAine = lukija.nextLine();
                    System.out.println("Reseptit: ");
                    for (Resepti resepti : reseptit) {
                        if (resepti.getAineet().contains(haettavaAine)) {
                            System.out.println(resepti.toString());
                        }    
                    }
                }
            System.out.print("Syötä komento: ");
            }         
    }
            
    
    public static ArrayList<Resepti> lueReseptit(String tiedosto) {
        String nimi;
        String rivi = "";
        int keittoaika;   
        ArrayList<Resepti> reseptit = new ArrayList<>();
        ArrayList<String> ainesosat = new ArrayList<>();
    try (Scanner lukija = new Scanner(Paths.get(tiedosto))) {       
        while (lukija.hasNextLine()) {
            rivi = lukija.nextLine();
            ainesosat.add(rivi);
            if (rivi.isEmpty()) {
                nimi = ainesosat.get(0);
                keittoaika = Integer.valueOf(ainesosat.get(1));
                reseptit.add(new Resepti(nimi, keittoaika, ainesosat));                
                ainesosat.clear();
            }
            }
            nimi = ainesosat.get(0);
            keittoaika = Integer.valueOf(ainesosat.get(1));
            reseptit.add(new Resepti(nimi, keittoaika, ainesosat));
           
        }
    catch (IOException ex) {
            Logger.getLogger(ex.getMessage());
        } 
        return reseptit;
    }
               
}   
