/**
 * UTVIDELSE Oblig 7 - sykliske og korteste rute
 * Labyrint med rekursjon
 * 
 * 
 * Andreas Nore - andrebn@uio.no
 */

import java.util.ArrayList;

/**
 * En {@code Rute} tar vare på sine koordinater, og ha en referanse til
 * Labyrinten den er del av.
 * <p>
 * I tillegg skal en Rute ha referanser til sine evt naboer
 * Det skal ikke være mulig å opprette et objekt av klassen {@code abstract}
 * 
 */
public abstract class Rute {

    public int radnummer, kolnummer;
    public Labyrint labyrint;   
    public Rute nord, syd, oest, vest;
    String identitet;
    int telt;
    static int teller = 0;
    boolean besoekt = false;

    /**
     * Tar inn koordinater i form av rad og kol
     * @param labyrint
     * @param radnummer
     * @param kolnummer
     */
    public Rute(Labyrint labyrint, int radnummer, int kolnummer){
        this.radnummer = radnummer;
        this.kolnummer = kolnummer;
        this.labyrint = labyrint;
        }

    // dette kallet kommer fra andre ruter, tar inn hvor kallet kommer fra
    public void finn(Rute fra, ArrayList<Tuppel> sti){}

}