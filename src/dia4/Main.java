package dia4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println(Math.pow(2,3));
        //exercicio01();
        exercicio02_1();
        exercicio02_2();
        exercicio02_3();
        exercicio2IV();
        exercicio2V();
        exercicio2VI();

    }

    public static void exercicio01() {

        Scanner in = new Scanner(System.in);
        System.out.println("=== Potencia ===");
        System.out.println("Digite a base: ");
        int base = in.nextInt();
        System.out.println("Digite o expoente: ");
        int potencia = in.nextInt();
        int resultado = 1;

        for (int i = 1; i <= potencia; i++) {
            resultado = resultado * base;
        }

        System.out.println("O resultado é: " + resultado);
    }

    public static void exercicio02_1() {
        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 10; j++) {
                System.out.print("*");
            }
        }
    }
    public static void exercicio02_2() {

        for (int i = 0; i < 5; i++) {
            System.out.println();
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
        }
        System.out.println();
    }

    public static void exercicio02_3() {

        for (int i = 0; i < 5; i++) {
            for (int j = 4 - i; j > 0; j--){
                System.out.print(" ");
            }
            for (int k = 5 - i; k <= 5; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

   //Resolução Professor Anderson (4,5,6)

    public static void exercicio2IV() {
        int linhas = 5;

        for (int i = 1; i <= linhas; i++) {

            int espacos = linhas - i;

            while (espacos > 0) {
                System.out.print("  ");
                espacos--;
            }

            int k = 0;
            while (k != 2 * i - 1) {
                System.out.print("* ");
                k++;
            }

            System.out.print("\n");
        }
    }

    public static void exercicio2V() {
        int linhas = 5;

        for (int i = 1; i <= linhas; i++) {

            int espacos = linhas - i;

            while (espacos > 0) {
                System.out.print("  ");
                espacos--;
            }

            int k = 0;
            while (k != 2 * i - 1) {
                System.out.printf("%d ", i);
                k++;
            }

            System.out.print("\n");
        }
    }

    public static void exercicio2VI() {
        int linhas = 5;

        for (int i = 1; i <= linhas; i++) {

            int espacos = linhas - i;

            while (espacos > 0) {
                System.out.print("  ");
                espacos--;
            }

            int k = 0;
            int l = i;
            boolean estaDecrementando = true;
            while (k != 2 * i - 1) {

                System.out.printf("%d ", l);
                k++;
                if (l > 1 && estaDecrementando) {
                    l--;
                } else {
                    estaDecrementando = false;
                    l++;
                }
            }

            System.out.print("\n");
        }
    }
}




