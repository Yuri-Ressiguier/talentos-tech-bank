package dia7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exercicios {

    public static void validaInteiro(Scanner in) {
        if (!in.hasNextInt()) {
            System.out.println("ERRO! O valor informado deve ser um número inteiro");
            in.close();
            System.exit(1);
        }
    }

    public static void exercicio01() {
        //Escreva um algoritmo que leia 5 números insira em um array e após mostre os números informados na tela.
        Scanner in = new Scanner(System.in);
        int[] vetorInteiro = new int[5];
        for( int i = 0; i < 5; i++){
            System.out.println("Digite o valor " + (i+1) + ": ");
            validaInteiro(in);
            vetorInteiro[i] = in.nextInt();
        }
        System.out.println(Arrays.toString(vetorInteiro));
        in.close();
    }

    public static void exercicio02() {
        //Escreva um algoritmo que leia números, insira em um array e após mostre a quantidade de números negativos.

        //VETOR
        /*
        Scanner in = new Scanner(System.in);
        int totalNegativos = 0;
        System.out.println("Digite a quantidade de valores: ");
        validaInteiro(in);
        int quantidade = in.nextInt();
        int[] vetorInteiro = new int[quantidade];

        for (int i = 0; i < vetorInteiro.length; i++) {
            System.out.println("Digite o valor " + (i+1) + ": ");
            validaInteiro(in);
            vetorInteiro[i] = in.nextInt();
        }

        for (int valor : vetorInteiro) {
            if (valor < 0) {
                totalNegativos ++;
            }
        }

        System.out.println("A quantidade de valores negativos é: " + totalNegativos);
        in.close();

         */


        //LISTA
        Scanner in = new Scanner(System.in);
        List<Integer> listaInteiros =  new ArrayList<>();
        int totalNegativos = 0;

        System.out.println("Digite a quantidade de valores: ");
        validaInteiro(in);
        int quantidade = in.nextInt();


        for (int i = 0; i < quantidade; i++) {
            System.out.println("Digite o valor " + (i+1) + ": ");
            validaInteiro(in);
            listaInteiros.add(in.nextInt());
        }

        for (int valor : listaInteiros) {
            if (valor < 0) {
                totalNegativos ++;
            }
        }

        System.out.println("A quantidade de valores negativos é: " + totalNegativos);
        in.close();



    }

    public static  void exercicio03() {
        //Escreva um algoritmo que leia números, insira em um array e após mostre a quantidade de números pares.

        //VETOR

        /*
        Scanner in = new Scanner(System.in);
        int totalPares = 0;
        System.out.println("Digite a quantidade de valores: ");
        validaInteiro(in);
        int quantidade = in.nextInt();
        int[] vetorInteiro = new int[quantidade];

        for (int i = 0; i < vetorInteiro.length; i++) {
            System.out.println("Digite o valor " + (i+1) + ": ");
            validaInteiro(in);
            vetorInteiro[i] = in.nextInt();
        }

        for (int valor : vetorInteiro) {
            if (valor % 2 ==  0) {
                totalPares ++;
            }
        }

        System.out.println("A quantidade de valores pares é: " + totalPares);
        in.close();

         */

        //LISTA

        Scanner in = new Scanner(System.in);
        List<Integer> listaInteiros =  new ArrayList<>();
        int totalPares = 0;

        System.out.println("Digite a quantidade de valores: ");
        validaInteiro(in);
        int quantidade = in.nextInt();


        for (int i = 0; i < quantidade; i++) {
            System.out.println("Digite o valor " + (i+1) + ": ");
            validaInteiro(in);
            listaInteiros.add(in.nextInt());
        }

        for (int valor : listaInteiros) {
            if (valor % 2 == 0) {
                totalPares ++;
            }
        }

        System.out.println("A quantidade de valores pares é: " + totalPares);
        in.close();

    }



    public static  void exercicio04() {
        //Escreva um algoritmo que leia números, insira em um array e após mostre o maior valor.

        //VETOR
        /*
        Scanner in = new Scanner(System.in);
        int maior = Integer.MIN_VALUE;
        System.out.println("Digite a quantidade de valores: ");
        validaInteiro(in);
        int quantidade = in.nextInt();
        int[] vetorInteiro = new int[quantidade];

        for (int i = 0; i < vetorInteiro.length; i++) {
            System.out.println("Digite o valor " + (i+1) + ": ");
            validaInteiro(in);
            vetorInteiro[i] = in.nextInt();
        }

        for (int valor : vetorInteiro) {
            if (valor > maior) {
                maior = valor;
            }
        }

        System.out.println("O maior valor é: " + maior);
        in.close();
         */

        //LISTA

        Scanner in = new Scanner(System.in);
        List<Integer> listaInteiros =  new ArrayList<>();
        int maior = Integer.MIN_VALUE;

        System.out.println("Digite a quantidade de valores: ");
        validaInteiro(in);
        int quantidade = in.nextInt();


        for (int i = 0; i < quantidade; i++) {
            System.out.println("Digite o valor " + (i+1) + ": ");
            validaInteiro(in);
            listaInteiros.add(in.nextInt());
        }

        for (int valor : listaInteiros) {
            if (valor > maior) {
                maior = valor;
            }
        }

        System.out.println("O maior valor é: " + maior);
        in.close();
    }

    public static void exercicio05() {
        //Escreva um algoritmo que simula um jogo da forca simples.
        // O usuario precisara adivinhar uma palavra chutando cada letra em no máximo 10 chutes,
        // caso o usuario acerte a letra o jogo dirá que ele acertou, caso tenha errado, o numero de tentativas vai diminuindo.
        // Caso o numero de tentativas chegue a 0 o usuário perde.


        //NÃO TERMINADO

        Scanner in = new Scanner(System.in);
        String[] palavra = {"a", "b", "a", "c", "a", "x", "i"};
        String[] jogadas = {"_", "_", "_", "_", "_", "_", "_"};
        String letra = "";
        int tentativas = 10;

        while (tentativas > 0) {
            System.out.println("Chute " + tentativas + ": ");
            letra = in.next();
            for (int i = 0; i < palavra.length; i++) {
                if (palavra[i].equals(letra)) {
                    jogadas[i] = letra;
                    continue;
                }
            }
            tentativas --;
        }

    }

    public static void main(String[] args) {
        //exercicio01();
        //exercicio02();
        //exercicio03();
        //exercicio04();
    }




}
