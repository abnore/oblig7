/**
 * UTVIDELSE Oblig 7 - sykliske og korteste rute
 * Labyrint med rekursjon
 * 
 * 
 * Andreas Nore - andrebn@uio.no
 */

import java.util.Objects;

/**
 * Klassen {@code Tuppel} er et objekt som representerer hver rute i labyrinten
 * for utskift og lagring i lister
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
/**
 * overskriver {@code equals} for å kunne lagre unike objekter i HashSets basert på rad og kolonne
 */
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuppel tuppel = (Tuppel) o;
        return r == tuppel.r && k == tuppel.k;
    }
/**
 * Overskriver hashCode for å returnere en hash med rad og kolonne for å sammenligne kun det
 */
    @Override
    public int hashCode(){
        return Objects.hash(r,k);
    }

}