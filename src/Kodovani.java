import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Admin on 19.6.2016.
 */
public class Kodovani {
    static char[] velkyZnaky = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static char[] nulaJedna = "01".toCharArray();
    static char[] kodyPismen = new char[velkyZnaky.length];
    static ArrayList<Object> pruchozi = new ArrayList<>();
    static ArrayList<Object> kod = new ArrayList<>();
    static int[] pocty = new int[velkyZnaky.length];
    static int celkovyPOcetZnaku;
    static double E = 0;
    static double[] pravdepodobnostPismen = new double[velkyZnaky.length];

    public static void main(String[] args) {
        nacteniTextuZeSouboru();
        pruchod(pruchozi, velkyZnaky);
        pravdepodobnosti();
        entropie();
        serazeniPravdepodobnosti();
        pruchodSKodovanim(pruchozi, velkyZnaky);
        System.out.println();
        pruchodSDekodovanim(kod);
    }

    static void nacteniTextuZeSouboru() {
        try (FileReader br = new FileReader("soubor.txt")) {
            char s;
            while ((br.ready())) {
                pruchozi.add((char) br.read());
                celkovyPOcetZnaku++;
                //System.out.println(s);
            }
            //    System.out.println(celkovejPocet);
            //    System.out.println(String.valueOf(pruchozi));
        } catch (Exception e) {
            System.err.println("Chyba při četení ze souboru.");
        }
    }

    static void pruchod(ArrayList<?> text, char[] prvky) {
        for (int i = 0; i < velkyZnaky.length; i++) {
            int pocetVyskytu = 0;
            System.out.print(velkyZnaky[i] + " ");
            for (int k = 0; k < text.size(); k++) {
                if (String.valueOf(prvky[i]).toLowerCase().contains(String.valueOf(text.get(k)).toLowerCase())) {
                    pocetVyskytu++;
                }
            }
            pocty[i] = pocetVyskytu;
            System.out.println(pocetVyskytu);
        }
    }

    private static void pravdepodobnosti() {
        for (int i = 0; i < pravdepodobnostPismen.length; i++) {
            pravdepodobnostPismen[i] = (double) pocty[i] / (double) celkovyPOcetZnaku;
            System.out.println("Pravdepodobnost" + velkyZnaky[i] + " je " + (double) pocty[i] / (double) celkovyPOcetZnaku);
        }
    }

    private static void entropie() {
        for (int i = 0; i < pocty.length; i++) {
            E = E - (pravdepodobnostPismen[i] * (Math.log(pravdepodobnostPismen[i]) / Math.log(2)));
        }
        System.out.println("Entropie je " + E);
    }

    public static void serazeniPravdepodobnosti() {
        double pomoc;
        char pomoc1;
        for (int i = 0; i < pocty.length; i++) {
            for (int j = 0; j < pocty.length - 1; j++) {
                if (pravdepodobnostPismen[j] < pravdepodobnostPismen[j + 1]) {
                    pomoc = pravdepodobnostPismen[j];
                    pravdepodobnostPismen[j] = pravdepodobnostPismen[j + 1];
                    pravdepodobnostPismen[j + 1] = pomoc;
                    pomoc1 = velkyZnaky[j];
                    velkyZnaky[j] = velkyZnaky[j + 1];
                    velkyZnaky[j + 1] = pomoc1;
                }
            }
        }
        //System.out.println(Arrays.toString(pravdepodobnostPismen));
        //System.out.println(Arrays.toString(velkyZnaky));
    }
    private static void pruchodSKodovanim(ArrayList<?> text, char[] prvky){
            for (int k = 0; k < text.size(); k++) {
                for (int i = 0; i < velkyZnaky.length; i++) {
                    if(String.valueOf(velkyZnaky[i]).toLowerCase().contains(String.valueOf(text.get(k)).toLowerCase())){
                        kodovani(pravdepodobnostPismen[i]);
                    }
                }
            }
    }
    private static void kodovani(double pravdepodobnostPismene) {
        int k = 0;
        for (int i = 0; i < pravdepodobnostPismen.length; i++) {
            if (pravdepodobnostPismene < pravdepodobnostPismen[i]) {
                k++;
            }
        }
        for (int j = 0; j < k; j++) {
            kod.add(0);
            System.out.print(0);
        }
        kod.add(1);
        System.out.print(1);
    }
    private static void pruchodSDekodovanim(ArrayList<?> kod){
        int k = 0;
        for (int i = 0; i < kod.size(); i++) {
            if(String.valueOf(kod.get(i)).contains(String.valueOf(nulaJedna[1]))){
                System.out.print(velkyZnaky[k]);
                k = 0;
            }else{
                k++;
            }
        }
    }
}
