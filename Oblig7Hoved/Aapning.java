/**
 * IN1010 Oblig 7
 * Labyrint med rekursjon
 * 
 * 
 * Andreas Nore - andrebn@uio.no
 */

import java.util.ArrayList;

/**
 * Klassen {@code Aapning} arver fra {@code Rute}
 * 
 */
public class Aapning extends HvitRute {
/**
 * Kaller {@code super()} for parametere
 * 
 * @param labyrint
 * @param radnummer
 * @param kolnummer
 */
    public Aapning(Labyrint labyrint, int radnummer, int kolnummer){
        super(labyrint, radnummer, kolnummer);
        identitet = "🏁";
    }
/**
 * Lagrer utveien som en tuppel om funnet
 * @param fra {@code Rute}
 */
    @Override
    public void finn(Rute fra, ArrayList<Tuppel> sti) {
        labyrint.utveier.add(new Tuppel(radnummer, kolnummer));
    }
    
    @Override
    public String toString() {      
        return identitet;
    }
}
