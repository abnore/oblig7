/**
 * IN1010 Hovedprogram for Oblig 7 - uten utvidelser
 * Labyrint med rekursjon
 * 
 * 
 * Andreas Nore - andrebn@uio.no
 */

import java.util.Scanner;

public class Oblig7 {
    public static void main(String[] args) {
        
        Labyrint lab = new Labyrint(args[0]);

        int startRad;
        int startKol;

        boolean running = true;

        Scanner sc = new Scanner(System.in);

        while(running){
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
                    
                    if(lab.utveier.size() == 0 ) {
                        System.out.println("> Ingen utveier fra denne ruten");
                    } else {
                        System.out.println("> Aapninger: ");
                    }
                    for ( Tuppel rute : lab.utveier) {
                        System.out.println(rute+" ");
                    }
                    System.out.println();
                    break;
            }
        }
        sc.close();
    }
}