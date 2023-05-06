/**
 * UTVIDELSE Hovedprogram Oblig 7 - sykliske og korteste rute
 * Labyrint med rekursjon
 * 
 * 
 * Andreas Nore - andrebn@uio.no
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Oblig7Utvidelse {
    public static void main(String[] args) {

        Labyrint lab = new Labyrint(args[0]);

        int startRad;
        int startKol;

        boolean running = true;

        Scanner sc = new Scanner(System.in);

        while (running) {
            System.out.println("[ ] Skriv inn koordinatene <rad> <kolonne> (q for å avslutte)");

            String lest = sc.nextLine().trim();

            switch (lest) {
                case "q":
                    System.out.println("Ha en fin dag");
                    running = false;
                    break;
                default:
                    String[] koordinater = lest.split(" ");
                    startRad = Integer.parseInt(koordinater[0]);
                    startKol = Integer.parseInt(koordinater[1]);

                    lab.finnUtveiFra(startRad, startKol);

                    if (lab.utveier.size() == 0) {
                        System.out.println("> Ingen utveier fra denne ruten");
                    } else {
                        System.out.println("> Aapninger: ");
                    }
                    for (Tuppel rute : lab.utveier) {
                        System.out.println(rute + " ");
                    }
                    System.out.println();
                    
                    System.out.println(lab.loesninger.size()+" loesninger funnet:");
                    
                    List<Tuppel> minst = new ArrayList<>();

                    if(lab.loesninger.size() != 0){
                        int minstNummer = lab.loesninger.get(0).size();
                        for ( ArrayList<Tuppel> losning : lab.loesninger) {
                            if(losning.size() <= minstNummer){
                                minst = losning;
                                minstNummer = losning.size();
                            }
                        }
                        System.out.println("> Den korteste ruten er: ");
                        for (Tuppel rute : minst) {
                            System.out.print(rute+" ");
                        }
                        
                        System.out.println();
                        lab.printMedKorteste(minst);
                    }
                    break;
            }
        }
        sc.close();
    }
}