import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by Admin on 19.6.2016.
 */
public class Kodovani {
    static char[] velkyZnaky = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    static char[] malyZnaky = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static ArrayList<Object> pruchozi = new ArrayList<>();
    static int[] pocty = new int[velkyZnaky.length];
    static int celkovyPOcetZnaku;
    static double E = 0;
    static double[] pravdepodobnostPismen = new double[velkyZnaky.length];

    public static void main(String[] args) {
        nacteniTextuZeSouboru();
        pruchod(pruchozi, velkyZnaky, malyZnaky);
        pravdepodobnosti();
        entropie();
        serazeniPravdepodobnosti();
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
    static void pruchod(ArrayList<?> text, char[] prvky, char[] prvkyMaly) {
        for (int i = 0; i < velkyZnaky.length; i++) {
            int pocetVyskytu = 0;
            System.out.print(velkyZnaky[i] + " ");
            for (int k = 0; k < text.size(); k++) {
                if (String.valueOf(prvky[i]).contains(String.valueOf(text.get(k))) || String.valueOf(prvkyMaly[i]).contains(String.valueOf(text.get(k)))) {
                    pocetVyskytu++;
                }
            }
            pocty[i] = pocetVyskytu;
            System.out.println(pocetVyskytu);
        }
    }
    private static void pravdepodobnosti(){
        for (int i = 0; i < pravdepodobnostPismen.length; i++) {
            pravdepodobnostPismen[i] = (double)pocty[i] / (double)celkovyPOcetZnaku;
            System.out.println("Pravdepodobnost"+velkyZnaky[i]+" je "+(double)pocty[i] / (double)celkovyPOcetZnaku);
        }
    }
    private static void entropie(){
        for (int i = 0; i < pocty.length; i++) {
            E = E - (pravdepodobnostPismen[i] * (Math.log(pravdepodobnostPismen[i]) / Math.log(2)));
        }
        System.out.println("Entropie je "+E);
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

    }
}
