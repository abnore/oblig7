/**
 * UTVIDELSE Oblig 7 - sykliske og korteste rute
 * Labyrint med rekursjon
 * 
 * 
 * Andreas Nore - andrebn@uio.no
 */

import java.util.ArrayList;

/**
 * Klasen {@code HvitRute} arver fra {@code Rute}
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
        telt = 0;
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
        if(besoekt) return;
        besoekt = true;

        ArrayList<Tuppel> nySti = new ArrayList<>(sti);
        nySti.add(new Tuppel(radnummer, kolnummer));
        
        teller++;
        telt = teller;
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
        /* ved å sette den false her utføres et søk som gjør at vi kan finne alle rutene.
         * Dette er mindre effektivt om vi kun skal finne utveier, men om vi er ute
         * etter korteste rute må vi tillate å prøve alle kombinasjoner. 
         */
        besoekt = false;
    }

    @Override
    public String toString() {

    return ""+identitet;
}
}

