/**
 * IN1010 Oblig 7 
 * Labyrint med rekursjon
 * 
 * 
 * Andreas Nore - andrebn@uio.no
 */

import java.util.ArrayList;

/**
 * Klasen {@code SortRute} arver fra {@code Rute}
 * Redefiner {@code toString} metoden til å sende en #
 * 
 */
public class SortRute extends Rute {
   String identitet = "#";

/**
 * Kaller {@code super()} fra klassen {@code Rute} med parameterne
 */
    public SortRute (Labyrint labyrint, int radnummer, int kolnummer){
        super(labyrint, kolnummer, radnummer);
    }
/**
 * Gjør ingenting, her er det stopp
 * 
 * @param fra {@code Rute}
 */
    @Override
    public void finn(Rute fra, ArrayList<Tuppel> sti) {
        if(fra == null){
            System.out.println("[X] Du kan ikke starte fra en sort rute.");
        } 
    }

    @Override
    public String toString() {
        return "" + identitet;
    }
}
