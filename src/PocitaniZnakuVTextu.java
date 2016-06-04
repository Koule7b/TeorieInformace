import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Admin on 3.6.2016.
 */
public class PocitaniZnakuVTextu {
    static int pocetZnaku;
    static int celkovejPocet;
    static ArrayList<Object> znaky = new ArrayList<>();
    static ArrayList<Object> pruchozi = new ArrayList<>();
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
        System.out.println("Celkovy pocet znaku "+celkovejPocet);
    }
    static void nacteniTextuZeSouboru(){
        try (FileReader br = new FileReader("soubor.txt"))
        {
            char s;
            while ((br.ready()))
            {
                pruchozi.add((char)br.read());
                celkovejPocet++;
                //System.out.println(s);
            }
        //    System.out.println(celkovejPocet);
        //    System.out.println(String.valueOf(pruchozi));
        }
        catch (Exception e)
        {
            System.err.println("Chyba při četení ze souboru.");
        }
    }
    static void pruchod(ArrayList<?> text, ArrayList<?> prvky){
        for (int i = 0; i < pocetZnaku; i++) {
            int pocetVyskytu = 0;
            System.out.print(znaky.get(i)+" ");
            for (int k = 0; k < text.size(); k++) {
                if (String.valueOf(prvky.get(i)).contains(String.valueOf(text.get(k)))){
                    pocetVyskytu++;
                }
            }
            System.out.println(pocetVyskytu);
            //System.out.println(celkovejPocet);
            System.out.println("Pravdepodobnost "+znaky.get(i)+" "+pocetVyskytu+" / "+celkovejPocet);
        }
    }
    private static class nactiPocetZnaku{
        Scanner sc = new Scanner(System.in);
        int nacteniPocetuZnaku(){
            return pocetZnaku = sc.nextInt();
        }
        void nactiZnak(int i) throws IOException {
            znaky.add(sc.next());
            sc.nextLine();
        }
    }
}
