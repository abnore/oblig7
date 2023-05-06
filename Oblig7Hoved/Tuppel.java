/**
 * IN1010 Oblig 7
 * Labyrint med rekursjon
 * 
 * 
 * Andreas Nore - andrebn@uio.no
 */

/**
 * Klassen {@code Tuppel} er et objekt som representerer hver rute i labyrinten for utskift og lagring i lister
 * <p>
 * Har koordinater som tilsvarer rad og kolonne
 */
public class Tuppel {
    
    int r, k;
    
/**
 * Tar inn {@code int} for rad og kolonne
 * 
 * @param rad
 * @param kolonne
 */
    public Tuppel(int rad, int kolonne){
        r = rad;
        k = kolonne;
    }
    @Override
    public String toString(){
        return "("+ r + "," + k + ")";
    }

}