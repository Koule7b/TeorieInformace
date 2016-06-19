import sun.swing.SwingUtilities2;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Admin on 3.6.2016.
 */
public class PocitaniZnakuVTextu {
    static int pocetZnaku;
    static int celkovejPocet;
    static ArrayList<Object> znaky = new ArrayList<>();
    static ArrayList<Object> pruchozi = new ArrayList<>();
    static ArrayList<Double> pravdepodobnosti = new ArrayList<>();
    static ArrayList<Integer> pocty = new ArrayList<>();
    static ArrayList<Integer> dvojcePocet = new ArrayList<>();
    static ArrayList<Double> informace = new ArrayList<>();
    static int pocetDvojceA = 0;
    static int pocetDvojceC = 0;
    static int pocetDvojceT = 0;
    static int pocetDvojceG = 0;
    static int pocetDvojceTA = 0;
    static int pocetDvojceTC = 0;
    static int pocetDvojceTG = 0;
    static int pocetDvojceAC = 0;
    static int pocetDvojceAG = 0;
    static int pocetDvojceCG = 0;
    static int pocetDvojceAT = 0;
    static int pocetDvojceGT = 0;
    static int pocetDvojceGA = 0;
    static int pocetDvojceCA = 0;
    static int pocetDvojceCT = 0;
    static int pocetDvojceGC = 0;

    public static void main(String[] args) throws IOException {
        System.out.println("napis pocet znaku");
        nactiPocetZnaku nacteni = new nactiPocetZnaku();
        pocetZnaku = nacteni.nacteniPocetuZnaku();
        for (int i = 0; i < pocetZnaku; i++) {
            nacteni.nactiZnak(i);
        }
        //System.out.println(String.valueOf(znaky));

        nacteniTextuZeSouboru();
        pruchod(pruchozi, znaky);
        System.out.println("Celkovy pocet znaku " + celkovejPocet);
        poctyDvojic(pruchozi);
        vypisPodminePravdepodobnosti(znaky);
        vypisInformace(znaky);
        podminenaInformace();
    }

    static void vytvoreniDvojic() {
        for (int i = 0; i < znaky.size(); i++) {
            for (int j = 0; j < znaky.size(); j++) {
            }
        }
    }

    static void nacteniTextuZeSouboru() {
        try (FileReader br = new FileReader("soubor.txt")) {
            char s;
            while ((br.ready())) {
                pruchozi.add((char) br.read());
                celkovejPocet++;
                //System.out.println(s);
            }
            //    System.out.println(celkovejPocet);
            //    System.out.println(String.valueOf(pruchozi));
        } catch (Exception e) {
            System.err.println("Chyba při četení ze souboru.");
        }
    }

    static void pruchod(ArrayList<?> text, ArrayList<?> prvky) {
        for (int i = 0; i < pocetZnaku; i++) {
            int pocetVyskytu = 0;
            System.out.print(znaky.get(i) + " ");
            for (int k = 0; k < text.size(); k++) {
                if (String.valueOf(prvky.get(i)).contains(String.valueOf(text.get(k)))) {
                    pocetVyskytu++;
                }
            }
            pocty.add(pocetVyskytu);
            System.out.println(pocetVyskytu);
            pravdepodobnosti.add((double) pocetVyskytu / (double) celkovejPocet);
            System.out.println("Pravdepodobnost " + znaky.get(i) + " " + pravdepodobnosti.get(i) + " " + (double) pocetVyskytu / (double) celkovejPocet);
        }
    }

    private static void poctyDvojic(ArrayList<?> text) {
        for (int k = 0; k < text.size(); k += 2) {
            if (k < (text.size() - 1)) {
                switch (String.valueOf(text.get(k))) {
                    case "A":
                        if (String.valueOf(text.get(k)).contains(String.valueOf(text.get(k + 1)))) {
                            pocetDvojceA++;
                        } else {
                            switch (String.valueOf(text.get(k + 1))) {
                                case "T":
                                    pocetDvojceAT++;
                                    break;
                                case "C":
                                    pocetDvojceAC++;
                                    break;
                                case "G":
                                    pocetDvojceAG++;
                                    break;
                            }
                        }
                        break;
                    case "G":
                        if (String.valueOf(text.get(k)).contains(String.valueOf(text.get(k + 1)))) {
                            pocetDvojceG++;
                        } else {
                            switch (String.valueOf(text.get(k + 1))) {
                                case "T":
                                    pocetDvojceGT++;
                                    break;
                                case "C":
                                    pocetDvojceGC++;
                                    break;
                                case "A":
                                    pocetDvojceGA++;
                                    break;
                            }
                        }
                        break;
                    case "T":
                        if (String.valueOf(text.get(k)).contains(String.valueOf(text.get(k + 1)))) {
                            pocetDvojceT++;
                        } else {
                            switch (String.valueOf(text.get(k + 1))) {
                                case "A":
                                    pocetDvojceTA++;
                                    break;
                                case "C":
                                    pocetDvojceTC++;
                                    break;
                                case "G":
                                    pocetDvojceTG++;
                                    break;
                            }
                        }
                        break;
                    case "C":
                        if (String.valueOf(text.get(k)).contains(String.valueOf(text.get(k + 1)))) {
                            pocetDvojceC++;
                        } else {
                            switch (String.valueOf(text.get(k + 1))) {
                                case "T":
                                    pocetDvojceCT++;
                                    break;
                                case "A":
                                    pocetDvojceCA++;
                                    break;
                                case "G":
                                    pocetDvojceCG++;
                                    break;
                            }
                        }
                        break;
                }
            }
        }
    }

    private static void vypisPodminePravdepodobnosti(ArrayList<?> znaky) {
        dvojcePocet.add(pocetDvojceA);
        dvojcePocet.add(pocetDvojceAC);
        dvojcePocet.add(pocetDvojceAG);
        dvojcePocet.add(pocetDvojceAT);
        dvojcePocet.add(pocetDvojceCA);
        dvojcePocet.add(pocetDvojceC);
        dvojcePocet.add(pocetDvojceCG);
        dvojcePocet.add(pocetDvojceCT);
        dvojcePocet.add(pocetDvojceGA);
        dvojcePocet.add(pocetDvojceGC);
        dvojcePocet.add(pocetDvojceG);
        dvojcePocet.add(pocetDvojceGT);
        dvojcePocet.add(pocetDvojceTA);
        dvojcePocet.add(pocetDvojceTC);
        dvojcePocet.add(pocetDvojceTG);
        dvojcePocet.add(pocetDvojceT);
        int k = 0;
        for (int i = 0; i < znaky.size(); i++) {
            for (int j = 0; j < znaky.size(); j++) {
                System.out.println(znaky.get(i) + " " + znaky.get(j) + " " + dvojcePocet.get(k));
                k++;
            }
        }
        int p = 0;
        for (int i = 0; i < znaky.size(); i++) {
            for (int j = 0; j < znaky.size(); j++) {
                System.out.println(znaky.get(i) + " " + znaky.get(j) + " " +vnitrekLog(p, j));
                p++;
                //vnitrekLog(p, j);
            }
        }
        /**
         System.out.println(((double)pocetDvojceA / (double)(celkovejPocet / 2) / pravdepodobnosti.get(0)));
         System.out.println(((double)pocetDvojceAC / (double)(celkovejPocet / 2) / pravdepodobnosti.get(1)));
         System.out.println(((double)pocetDvojceAG / (double)(celkovejPocet / 2) / pravdepodobnosti.get(2)));
         System.out.println(((double)pocetDvojceAT / (double)(celkovejPocet / 2) / pravdepodobnosti.get(3)));
         System.out.println(((double)pocetDvojceC / (double)(celkovejPocet / 2) / pravdepodobnosti.get(1)));
         System.out.println(((double)pocetDvojceCA / (double)(celkovejPocet / 2) / pravdepodobnosti.get(0)));
         System.out.println(((double)pocetDvojceCG / (double)(celkovejPocet / 2) / pravdepodobnosti.get(2)));
         System.out.println(((double)pocetDvojceCT / (double)(celkovejPocet / 2) / pravdepodobnosti.get(3)));
         System.out.println(((double)pocetDvojceG / (double)(celkovejPocet / 2) / pravdepodobnosti.get(2)));
         System.out.println(((double)pocetDvojceGA / (double)(celkovejPocet / 2) / pravdepodobnosti.get(0)));
         System.out.println(((double)pocetDvojceGC / (double)(celkovejPocet / 2) / pravdepodobnosti.get(1)));
         System.out.println(((double)pocetDvojceGT / (double)(celkovejPocet / 2) / pravdepodobnosti.get(3)));
         System.out.println(((double)pocetDvojceT / (double)(celkovejPocet / 2) / pravdepodobnosti.get(3)));
         System.out.println(((double)pocetDvojceTA / (double)(celkovejPocet / 2) / pravdepodobnosti.get(0)));
         System.out.println(((double)pocetDvojceTC / (double)(celkovejPocet / 2) / pravdepodobnosti.get(1)));
         System.out.println(((double)pocetDvojceTG / (double)(celkovejPocet / 2) / pravdepodobnosti.get(2)));
         */
    }

    static void logaritmus2(double cislo, int znaminko) {
        if(znaminko == 0) {
            informace.add((Math.log(cislo)) / (Math.log(2.0)));
            System.out.println((Math.log(cislo)) / (Math.log(2.0)));
        }else{
            System.out.println(-((Math.log(cislo)) / (Math.log(2.0))));
        }
    }
    static double vnitrekLog(int i, int k){
        return ((double) dvojcePocet.get(i) / (double) (celkovejPocet / 2) / pravdepodobnosti.get(k));
    }

    private static void vypisInformace(ArrayList<?> pismena) {
        for (int i = 0; i < pismena.size(); i++) {
            //System.out.println(pravdepodobnosti.get(i));
            double vel = 1 / pravdepodobnosti.get(i);
            System.out.println(vel);
            System.out.print("infor. "+pismena.get(i)+" ");
            logaritmus2(vel, 0);
        }
    }

    private static void podminenaInformace() {
        int k = 0;
        for (int i = 0; i < znaky.size(); i++) {
            for (int j = 0; j < znaky.size(); j++) {
                System.out.print("PI "+znaky.get(i)+" a "+znaky.get(j)+" = ");
                logaritmus2(vnitrekLog(k, j), 1);
                k++;
            }
        }
    }

    private static class nactiPocetZnaku {
        Scanner sc = new Scanner(System.in);

        int nacteniPocetuZnaku() {
            return pocetZnaku = sc.nextInt();
        }

        void nactiZnak(int i) throws IOException {
            znaky.add(sc.next());
            sc.nextLine();
        }
    }
}
