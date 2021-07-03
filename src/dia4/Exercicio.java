package dia4;

import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) {
        //exercicio01();
        exercicio02();
    }

    public static void exercicio01() {
        //Construa um algoritmo que leia 10 valores inteiros e positivos e:
        //Encontre o maior valor
        //Encontre o menor valor
        //Calcule a média dos números lidos Esse exercício foi dado na aula 3 e agora vamos otimizar ele utilizando o while e for.+

        System.out.println("=== Maior / Menor ===");

        /*
        System.out.println("FOR");

        Scanner in =  new Scanner(System.in);
        int menor = Integer.MAX_VALUE;
        int maior = Integer.MIN_VALUE;
        int soma = 0;
        int valor;

        for (int i = 1; i <=10; i++) {
            System.out.println("Digite o valor "+ i + ": ");
            if (!in.hasNextInt()) {
                System.out.println("ERRO! O valor informado deve ser um número inteiro");
                in.close();
                System.exit(1);
            }
            valor = in.nextInt();
            if (valor < menor) {
                menor = valor;
            }
            if (valor > maior) {
                maior = valor;
            }
            soma += valor;

        }
        System.out.println("Maior valor: " + maior);
        System.out.println("Menor valor: " + menor);
        System.out.println("Média: " + soma / 10.0);
        in.close();

         */

        System.out.println("DO WHILE");


        Scanner in =  new Scanner(System.in);
        int i = 1;
        int maiorDoWhile = Integer.MIN_VALUE;
        int menorDoWhile = Integer.MAX_VALUE;
        int somaDoWhile = 0;
        int valorDoWhile;

        while (i <= 10) {
            System.out.println("Digite o valor "+ i + ": ");
            if (!in.hasNextInt()) {
                System.out.println("ERRO! O valor informado deve ser um número inteiro");
                in.close();
                System.exit(1);
            }
            valorDoWhile = in.nextInt();
            if (valorDoWhile < menorDoWhile) {
                menorDoWhile = valorDoWhile;
            }
            if (valorDoWhile > maiorDoWhile) {
                maiorDoWhile = valorDoWhile;
            }
            somaDoWhile += valorDoWhile;

            i++;
        }
        in.close();

        System.out.println("Maior valor: " + maiorDoWhile);
        System.out.println("Menor valor: " + menorDoWhile);
        System.out.println("Média: " + somaDoWhile / 10.0);
        in.close();

    }

    public static void exercicio02() {
        Scanner in = new Scanner(System.in);
        System.out.println("=== Fatorial ===");
        System.out.println("Digite um valor: ");
        if (!in.hasNextInt()) {
            System.out.println("ERRO! O valor informado deve ser um número inteiro");
            in.close();
            System.exit(1);
        }
        int valor = in.nextInt();
        int resposta = 1;

        for (int i = valor; i > 1; i--) {
            resposta = resposta * i;
        }

        System.out.println("O resultado é: " + resposta);
    }

}
