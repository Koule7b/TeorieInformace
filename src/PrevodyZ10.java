import java.util.Scanner;

/**
 * Created by Koule7b on 2.6.2016.
 */
public class PrevodyZ10 {
    static double cislo;
    static int pocet = 0;
    public static void main(String[] args) {
        System.out.println("napis cislo pro prevod");
        nactiCislo nacteni = new nactiCislo();
        cislo = nacteni.nacteniCisla();
        System.out.println(cislo);
        prevodDo2(cislo);
    }
    public static void prevodDo2(double cislo){
        int cely;
        double desetiny;
        if(cislo > 1){
            cely = (int) cislo;
            prevodCelyhoCislaDo2(cely);
            desetiny = cislo - cely;
            System.out.print(".");
            prevodDesitinyhoCislaDo2(desetiny);
            System.out.println(cely+" "+desetiny);
        }else{
            System.out.print("0.");
            prevodDesitinyhoCislaDo2(cislo);
        }
    }
    private static void prevodCelyhoCislaDo2(int cislo){
        if(cislo % 2 == 0){
            System.out.print(0);
            cislo = cislo / 2;
            if(cislo == 0)
                return;
            prevodCelyhoCislaDo2(cislo);
        }else{
            System.out.print(1);
            cislo = (cislo - 1) / 2;
            if(cislo == 0)
                return;
            prevodCelyhoCislaDo2(cislo);
        }
    }
    private static void prevodDesitinyhoCislaDo2(double cislo){
        pocet++;
        if(cislo > 1){
            System.out.print(1);
            cislo = (cislo - 1) * 2;
            if(pocet == 7) {
                System.out.println();
                return;
            }
            prevodDesitinyhoCislaDo2(cislo);
        }else{
            System.out.print(0);
            cislo = cislo * 2;
            if(pocet == 7) {
                System.out.println();
                return;
            }
            prevodDesitinyhoCislaDo2(cislo);
        }
    }
    public static class nactiCislo{
        Scanner sc = new Scanner(System.in);
        nactiCislo(){

        }
        double nacteniCisla(){
            return sc.nextDouble();
        }
    }
}
