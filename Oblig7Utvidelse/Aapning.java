/**
 * UTVIDELSE Oblig 7 - sykliske og korteste rute
 * Labyrint med rekursjon
 * 
 * 
 * Andreas Nore - andrebn@uio.no
 */

import java.util.ArrayList;

/**
 * Klasen {@code Aapning} arver fra {@code Rute}
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
        telt = 0;
        identitet = "🏁";
    }
/**
 * Printer koordinatene sine som er en utvei
 * @param fra {@code Rute}
 */
    @Override
    public void finn(Rute fra, ArrayList<Tuppel> sti) {
        Tuppel denneRuten = new Tuppel(radnummer, kolnummer);
        ArrayList<Tuppel> nySti = new ArrayList<>(sti);
        nySti.add(denneRuten);
        labyrint.utveier.add(denneRuten);
        teller++;
        telt = teller;
        labyrint.loesninger.add(nySti);
    }

    
    @Override
    public String toString() {     
        return identitet;
    }
}
