/**
 * In1010 Oblig 7
 * Labyrint med rekursjon
 * 
 * 
 * Andreas Nore - andrebn@uio.no
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Klassen {@code Labyrint} skal inneholde en todimensjonal array med referanser til alle Rute-objektene i
 * labyrinten, stiene som er gått og utveier funnet.
 */
public class Labyrint {
   public Rute[][] rutene;
   public int rader, kolonner;
   ArrayList<Tuppel> sti;
   ArrayList<Tuppel> utveier;
   
/**
 * Kaller {@code lesFraFil}, skriver ut labyrinten og kaller {@code settNaboer}
 * 
 * @param filnavn
 */
    public Labyrint(String filnavn){
        lesFraFil(filnavn);
        System.out.println("\n[ ] Konstruktøren er ferdig, slik er labyrinten");
        System.out.println("\n"+this); 
        System.out.println("> Rader: " + rader +" Kolonner: " + kolonner);
        settNaboer(); 
    }

/**
 * Denne skal kalle på metoden finn i den ruta som ligger på posisjon (rad, kol)
 * i labyrinten.
 * 
 */
    public void finnUtveiFra(int rad, int kol){
        sti = new ArrayList<>();
        utveier = new ArrayList<>(); // restarter utveier, "glemmer" om nye koordinater
        try {
            rutene[rad][kol].finn(null, sti);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("[X] Rad og/eller kolonner fins ikke.");
        }
    }
/**
 * Tar inn en fil, lagrer alle linjene i en {@code Liste} lines
 * Ta ut rader og kolonner fra første linjen og lager ruter av resten
 * 
 * @param filnavn
 */
    public void lesFraFil(String filnavn) {
        Path labyrint = Path.of(filnavn);

        try {
            List<String> lines = Files.readAllLines(labyrint, StandardCharsets.UTF_8);
        /** 
         * lagrer den første linjen som koordinatene rad og kol
         * og initialiserer rutene nå som jeg har den info - bruker det under
         */
            String[] koordinater = lines.get(0).split(" ");
            rader = Integer.parseInt(koordinater[0]);
            kolonner = Integer.parseInt(koordinater[1]);
            rutene = new Rute[rader][kolonner];

        /**
         * dobbel for-løkke for å traversere rader og kolonner
         * men må hoppe over første linje!
         * sjekker også om det er kant og hvit = åpning!
         */
            for (int r = 1; r <= rader; r++) {
                String line = lines.get(r); 
                Rute[] rad = new Rute[kolonner];

                for (int i = 0; i < kolonner; i++) {
                    char tegn = line.charAt(i);
                    switch (tegn) {
                        case '#':
                            rad[i] = new SortRute(this, r-1, i);
                            break;
                        case '.':
                            if( r-1 == 0 || i == 0 || i == kolonner-1 || r-1 == rader-1 ){
                                    rad[i] = new Aapning(this, r-1, i);
                                    break;
                                } else {
                                    rad[i] = new HvitRute(this, r-1, i);
                                    break;
                                }

                    }
                }
                rutene[r-1] = rad;
            }
        } catch (IOException e) {
            System.err.println("[X] Det oppsto en feil med fillesing!");
            e.printStackTrace(System.err);
        }
    }
/**
 * Går gjennom alle rutene og setter verdier til naboer med vektorene:<p>
 * nord(-1,0)<p> vest(0,-1)<p> syd(1,0)<p> oest(0,1)
 */
    public void settNaboer() {

        for (int i = 0; i < rader; i++){
            for (int j = 0; j< kolonner; j++){

                if(i > 0){
                    rutene[i][j].nord = rutene[i-1][j];
                }
                if(j > 0){
                    rutene[i][j].vest = rutene[i][j-1];
                }
                if(i < rader-1){
                    rutene[i][j].syd = rutene[i+1][j];
                }
                if(j < kolonner-1){
                    rutene[i][j].oest = rutene[i][j+1];
                }
            } 
        }
    }

    @Override
    public String toString() {
        StringBuilder linje = new StringBuilder();

        for (Rute[] ruter : rutene) { // for hver rad
            for (int i = 0; i < kolonner; i++) { // for hver kolonne (elementer i den raden)
                String celle = ruter[i].toString();
                // her bruker jeg instanceof siden det har ingenting med logikken for rekursjon å gjoere
                if (ruter[i] instanceof SortRute){
                    linje.append(celle);
                    linje.append(celle);
                    linje.append(celle);
                } else if (ruter[i] instanceof HvitRute){ 
                    linje.append(String.format("%-3s", celle)); 
                }
            }
            linje.append('\n');
        }
        return linje.toString();
    }
}