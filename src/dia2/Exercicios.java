package dia2;

import java.util.Scanner;


public class Exercicios {
    public static void main(String[] args) {
        //exercicio01();
        //exercicio02();
        //exercicio03();
        exercicio04();
    }

    public static void exercicio01() {
        //Escreva um algoritmo que leia um número inteiro e diga se ele é par ou ímpar.
        Scanner in = new Scanner(System.in);
        System.out.println("=== IMPAR OU PAR? ===");
        System.out.println("Digite um valor inteiro: ");

        if (!in.hasNextInt()) {
            System.out.println("ERRO! O valor informado deve ser um número inteiro");
            in.close();
            System.exit(1);
        }

        int valor = in.nextInt();

        if (valor % 2 == 0) {
            System.out.println("O valor digitado é PAR");
        } else {
            System.out.println("O valor digitado é ÍMPAR");
        }



        //Ternário
        String resultadoTernario = valor % 2 == 0 ? "É um número par" : "É um número impar";
        System.out.println(resultadoTernario);

        in.close();
    }

    public static void exercicio02() {
        //Elabore um algoritmo que dada a idade de um nadador classifique-o em uma das seguintes categorias:
        //Infantil A = 5 a 7 anos
        //Infantil B = 8 a 11 anos
        //Juvenil A = 12 a 13 anos
        //Juvenil B = 14 a 17 anos
        //Adultos = Maiores de 18 anos
        Scanner in = new Scanner(System.in);
        System.out.println("=== NATAÇÃO ===");
        System.out.println("Digite o valor do nadador: ");
        if (!in.hasNextInt()) {
            System.out.println("ERRO! O valor informado deve ser um número inteiro");
            in.close();
            System.exit(1);
        }

        int valor = in.nextInt();
        String categoria;


        if (valor >= 5 && valor <= 7) {
            categoria = "Infantil A";
            System.out.println("A categoria deste nadador é: " + categoria);
        } else if (valor >= 8 && valor <= 11) {
            categoria = "Infantil B";
            System.out.println("A categoria deste nadador é: " + categoria);
        } else if (valor >= 12 && valor <= 13) {
            categoria = "Juvenil A";
            System.out.println("A categoria deste nadador é: " + categoria);
        } else if (valor >= 14 && valor <= 17) {
            categoria = "Juvenil B";
            System.out.println("A categoria deste nadador é: " + categoria);
        } else if (valor >= 18) {
            categoria = "Adultos";
            System.out.println("A categoria deste nadador é: " + categoria);
        } else {
            System.out.println("ERRO! Valor inválido");
        }
        in.close();
    }

    public static void exercicio03() {
      //Escreva um algoritmo em Java que leia dois números inteiros e determine qual é o menor.
        // Escreva um algoritmo que determina o maior também.


        System.out.println("=== Maior / Menor ===");
        Scanner in = new Scanner(System.in);
        System.out.println("Digite dois valores inteiros");
        System.out.println("Valor 1: ");
        if (!in.hasNextInt()) {
            System.out.println("ERRO! O valor informado deve ser um número inteiro");
            in.close();
            System.exit(1);
        }
        int valor1 = in.nextInt();

        System.out.println("Valor 2: ");
        if (!in.hasNextInt()) {
            System.out.println("ERRO! O valor informado deve ser um número inteiro");
            in.close();
            System.exit(1);
        }
        int valor2 = in.nextInt();

        if (valor1 < valor2) {
            System.out.println("O valor menor é o valor: " + valor1);
            System.out.println("O valor maior é o valor: " + valor2);
        } else if (valor1 > valor2){
            System.out.println("O valor menor é o valor: " + valor2);
            System.out.println("O valor maior é o valor: " + valor1);
        } else {
            System.out.println("Os números são iguais");
        }
        in.close();
    }

    public static void exercicio04() {
        //Construa um algoritmo que leia 10 valores inteiros e positivos e:
        //Encontre o maior valor
        //Encontre o menor valor
        //Calcule a média dos números lidos

        System.out.println("=== Maior / Menor ===");
        Scanner in = new Scanner(System.in);
        int[] vetor = new int[10];
        System.out.println("Digite dez valores inteiros");

        //Input dos valores
        for (int i = 1; i <= 10; i++) {
            System.out.println("Digite o valor " + i + " :");
            if (!in.hasNextInt()) {
                System.out.println("ERRO! O valor informado deve ser um número inteiro");
                in.close();
                System.exit(1);
            }
            vetor[i-1] = in.nextInt();
        }

        int menor = vetor[0];       //Garante que o menor valor esteja na lista
        int maior = vetor[0];       //Garante que o maior valor esteja na lista
        int soma = 0;

        //Percorre o vetor buscando o maior, menor e a soma
        for (int valor : vetor) {
            if (valor < menor) {
                menor = valor;
            }
            if (valor > maior) {
                maior = valor;
            }
            soma += valor;
        }

        int media = soma / 10;
        System.out.println("Maior valor: " + maior);
        System.out.println("Menor valor: " + menor);
        System.out.println("Média: " + media);

    }


}
