
import java.util.Scanner;

public class NestesailiotOlioilla {
    
    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);
        Sailio sailio1 = new Sailio();
        Sailio sailio2 = new Sailio();

        Kayttoliittyma liittyma = new Kayttoliittyma(sailio1, sailio2, lukija);

        liittyma.kaynnista();
    }

}




