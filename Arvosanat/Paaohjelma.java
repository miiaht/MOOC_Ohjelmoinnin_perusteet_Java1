
import java.util.ArrayList;
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Arvosanarekisteri rekisteri = new Arvosanarekisteri();

        Kayttoliittyma kali = new Kayttoliittyma(rekisteri, lukija);
        kali.kaynnista();
    }
}

