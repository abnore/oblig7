/**
 * IN1010 Oblig 7 
 * Labyrint med rekursjon
 * 
 * 
 * Andreas Nore - andrebn@uio.no
 */

import java.util.ArrayList;

/**
 * Klassen {@code HvitRute} arver fra {@code Rute}
 * Redefiner {@code toString} metoden til å sende en .
 * 
 */
public class HvitRute extends Rute {
    boolean startRute;
/**
 * Kaller {@code super()} for parametere
 * 
 * @param labyrint
 * @param radnummer
 * @param kolnummer
 */
    public HvitRute(Labyrint labyrint, int radnummer, int kolnummer) {
        super(labyrint, radnummer, kolnummer);
        identitet = " . ";
        startRute = false;
    }

/**
 * Søker alle retninger, bortsett fra retningen den kom fra
 * 
 * @param fra {@code Rute}
 */
    @Override
    public void finn(Rute fra, ArrayList<Tuppel> sti) {
        if(fra == null) startRute = true;

        ArrayList<Tuppel> nySti = new ArrayList<>(sti);
        nySti.add(new Tuppel(radnummer, kolnummer));

        // sjekker alle retninger - sort rute stopper, ny hvit rute rekurserer
        if(nord != null && nord != fra){
            nord.finn(this, nySti); 
        }
        if (syd != null && syd != fra) {
            syd.finn(this, nySti); 
        }
        if (oest != null && oest != fra) {
            oest.finn(this, nySti); 
        }
        if (vest != null && vest != fra) {
            vest.finn(this, nySti); 
        }    
    }

    @Override
    public String toString() {
        return identitet;
    }
}

