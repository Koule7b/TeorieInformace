import java.util.Scanner;

/**
 * Created by Koule7b on 2.6.2016.
 */
public class PrevodyZ10 {
    static double cislo;
    static int pocet = 0;
    static int pocet2 = 0;

    public static void main(String[] args) {
        System.out.println("napis cislo pro prevod");
        nactiCislo nacteni = new nactiCislo();
        cislo = nacteni.nacteniCisla();
        System.out.println(cislo);
        prevodDo2(cislo);
        prevodDo16(cislo);
    }

    public static void prevodDo2(double cislo) {
        if (cislo > 1) {
            prevodCelyhoCislaDo2(rozdeleniNaCely(cislo));
            System.out.print(".");
            prevodDesitinyhoCislaDo2(desetiny(cislo));
        } else {
            System.out.print("0.");
            prevodDesitinyhoCislaDo2(cislo);
        }
    }

    private static void prevodCelyhoCislaDo2(int cislo) {
        if (cislo % 2 == 0) {
            System.out.print(0);
            cislo = cislo / 2;
            if (cislo == 0)
                return;
            prevodCelyhoCislaDo2(cislo);
        } else {
            System.out.print(1);
            cislo = (cislo - 1) / 2;
            if (cislo == 0)
                return;
            prevodCelyhoCislaDo2(cislo);
        }
    }

    private static void prevodDesitinyhoCislaDo2(double cislo) {
        pocet++;
        if (cislo > 1) {
            System.out.print(1);
            cislo = (cislo - 1) * 2;
            if (pocet == 7) {
                System.out.println();
                return;
            }
            prevodDesitinyhoCislaDo2(cislo);
        } else {
            System.out.print(0);
            cislo = cislo * 2;
            if (pocet == 7) {
                System.out.println();
                return;
            }
            prevodDesitinyhoCislaDo2(cislo);
        }
    }

    static int rozdeleniNaCely(double cislo) {
        int cely;
        cely = (int) cislo;
        return cely;
    }

    static double desetiny(double cislo) {
        double desetiny;
        desetiny = cislo - (int) cislo;
        return desetiny;
    }

    static void prevodDo16(double cislo) {
        if (cislo > 1) {
            prevodCelyDo16(rozdeleniNaCely(cislo));
            System.out.print(".");
            prevodDesetinyhoCislaDo16(desetiny(cislo));
        }else{
            System.out.print("0.");
            prevodDesetinyhoCislaDo16(cislo);
        }
    }

    static void prevodCelyDo16(int cislo) {
        if (cislo != 0) {
            int zbytek;
            zbytek = cislo % 16;
            switch (zbytek) {
                case 15:
                    System.out.print("F");
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 14:
                    System.out.print("E");
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 13:
                    System.out.print("D");
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 12:
                    System.out.print("C");
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 11:
                    System.out.print("B");
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 10:
                    System.out.print("A");
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 9:
                    System.out.print(9);
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 8:
                    System.out.print(8);
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 7:
                    System.out.print(7);
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 6:
                    System.out.print(6);
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 5:
                    System.out.print(5);
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 4:
                    System.out.print(4);
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 3:
                    System.out.print(3);
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 2:
                    System.out.print(2);
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 1:
                    System.out.print(1);
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
                case 0:
                    System.out.print(0);
                    cislo = (cislo - zbytek) / 16;
                    prevodCelyDo16(cislo);
                    break;
            }
        }
    }

    static void prevodDesetinyhoCislaDo16(double cislo) {
        pocet2++;
        if (pocet2 < 9) {
            double vysledek = cislo * 16;
            if (vysledek > 15) {
                System.out.print("F");
                cislo = vysledek - 15;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 14) {
                System.out.print("E");
                cislo = vysledek - 14;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 13) {
                System.out.print("D");
                cislo = vysledek - 13;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 12) {
                System.out.print("C");
                cislo = vysledek - 12;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 11) {
                System.out.print("B");
                cislo = vysledek - 11;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 10) {
                System.out.print("A");
                cislo = vysledek - 10;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 9) {
                System.out.print(9);
                cislo = vysledek - 9;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 8) {
                System.out.print(8);
                cislo = vysledek - 8;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 7) {
                System.out.print(7);
                cislo = vysledek - 7;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 6) {
                System.out.print(6);
                cislo = vysledek - 6;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 5) {
                System.out.print(5);
                cislo = vysledek - 5;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 4) {
                System.out.print(4);
                cislo = vysledek - 4;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 3) {
                System.out.print(3);
                cislo = vysledek - 3;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 2) {
                System.out.print(2);
                cislo = vysledek - 2;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 1) {
                System.out.print(1);
                cislo = vysledek - 1;
                prevodDesetinyhoCislaDo16(cislo);
            } else if (vysledek > 0) {
                System.out.print(0);
                cislo = vysledek - 0;
                prevodDesetinyhoCislaDo16(cislo);
            }

        }
    }

    public static class nactiCislo {
        Scanner sc = new Scanner(System.in);

        double nacteniCisla() {
            return sc.nextDouble();
        }
    }
}
