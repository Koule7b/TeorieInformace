import java.util.ArrayList;

/**
 * Created by Koule7b on 2.6.2016.
 */
public class PrevodyZ2 {
/**
    static ArrayList<Object> celeCislo;
    static double cislo;
    static int pocet = 0;
    static int pocet2 = 0;

    public static void main(String[] args) {
        System.out.println("napis cislo pro prevod");
        PrevodyZ10.nactiCislo nacteni = new PrevodyZ10.nactiCislo();
        cislo = nacteni.nacteniCisla();
        System.out.println(cislo);
        prevodDo8(cislo);
        prevodDo10(cislo);
        prevodDo16(cislo);
    }
    static void prevodDo10(double cislo){
        if(cislo > 1){
            for (int i = 0; i < cislo; i++) {
                prevodCelyhoDo10(celeCislo(cislo));
            }
            System.out.print(".");
            prevodDesetinyho(desetiny(cislo));
        }else{
            prevodDesetinyho(cislo);
        }
    }
    static void prevodCelyhoDo10(int cislo){
        if(cislo == 1){

        }
    }
    static int celeCislo(double cislo){
        return (int) cislo;
    }
    static double desetiny(double cislo){
        return cislo - celeCislo(cislo);
    }
*/
}

