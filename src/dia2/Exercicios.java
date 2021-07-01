package dia2;

import java.util.Locale;
import java.util.Scanner;


public class Exercicios {
    public static void main(String[] args) {
        //exercicio01();
        //exercicio02();
        //exercicio03();
        exercicio04();
        //exercicio05();
        //exercicio06();
    }

    public static void exercicio01() {
        //Escreva um algoritmo que leia um número inteiro e diga se ele é par ou ímpar.
        Scanner in = new Scanner(System.in);
        System.out.println("=== IMPAR OU PAR? ===");
        System.out.println("Digite um valor inteiro: ");

        validaInteiro(in);

        int valor = in.nextInt();

        if (valor % 2 == 0) {
            System.out.println("O valor digitado é PAR");
        } else {
            System.out.println("O valor digitado é ÍMPAR");
        }

        //Ternário
        /*
        String resultadoTernario = valor % 2 == 0 ? "É um número par" : "É um número impar";
        System.out.println(resultadoTernario);

        System.out.println("===========================");
        in.close();
        */

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

        validaInteiro(in);

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
        System.out.println("===========================");
        in.close();
    }

    public static void exercicio03() {
      //Escreva um algoritmo em Java que leia dois números inteiros e determine qual é o menor.
        // Escreva um algoritmo que determina o maior também.

        System.out.println("=== Maior / Menor ===");
        Scanner in = new Scanner(System.in);
        System.out.println("Digite dois valores inteiros");
        System.out.println("Valor 1: ");
        validaInteiro(in);
        int valor1 = in.nextInt();

        System.out.println("Valor 2: ");
        validaInteiro(in);
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
        System.out.println("===========================");
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
            System.out.println("Digite o valor " + i + ": ");
            validaInteiro(in);
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

        double media = (double) soma / 10;
        System.out.println("Maior valor: " + maior);
        System.out.println("Menor valor: " + menor);
        System.out.println("Média: " + media);
        System.out.println("===========================");
        in.close();
    }

    public static void exercicio05() {
        //Escreva um algoritmo em Java que seja capaz de fazer as seguintes operações matemáticas (adição, subtração, multiplicação e divisão).
        // Todas as operações serão entre dois valores.
        // No começo do algoritmo pergunte ao usuário qual operação ele deseja fazer e quais são os valores.

        //Verificações sem LOOPs

        System.out.println("=== Calculadora ===");
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        double resultado;

        System.out.println("Digite a operação desejada (+, -, *, /)");
        char operacao = in.next().charAt(0);

        //Verifica se a operação existe já no início
        if (!(operacao == '+' || operacao == '-' || operacao == '*' || operacao == '/')) {
            System.out.println("ERRO! A calculadora só aceita operações (+, -, *, /)");
            in.close();
            System.exit(1);
        }

        //Verifica e adiciona o valor 1
        System.out.println("Digite o primeiro valor: ");
        validaInteiro(in);
        double valor1 = in.nextDouble();

        //Verifica e adiciona o valor 2
        System.out.println("Digite o segundo valor: ");
        validaInteiro(in);
        double valor2 = in.nextDouble();

        switch (operacao) {
            case '+':
                resultado = valor1 + valor2;
                System.out.println("O resultado da operação ("+ valor1 + operacao + valor2 +") é: " + resultado);
                break;
            case '-':
                resultado = valor1 - valor2;
                System.out.println("O resultado da operação ("+ valor1 + operacao + valor2 +") é: " + resultado);
                break;
            case '*':
                resultado = valor1 * valor2;
                System.out.println("O resultado da operação ("+ valor1 + operacao + valor2 +") é: " + resultado);
                break;
            case '/':
                resultado = valor1 / valor2;
                System.out.println("O resultado da operação ("+ valor1 + operacao + valor2 +") é: " + resultado);
                break;
            default:
                System.out.println("ERRO!");
        }
        System.out.println("===========================");
        in.close();
    }

    public static void exercicio06() {
        //Faça a implementação do Jogo Pedra, Papel e Tesoura (Jokempô).
        // O algoritmo deverá perguntar qual é a escolha do jogador 1 (Pedra [pe], Papel [pa], Tesoura [t]) e deverá fazer o mesmo para o jogador 2.
        // No final da execução o algoritmo deverá dizer qual é o jogador vencedor ou se houve empate.

        //Verificações sem LOOPs

        System.out.println("=== Pedra, Papel e Tesoura ===");
        Scanner in = new Scanner(System.in);
        System.out.println("Digite: pe -> Pedra / pa -> Papel / t -> Tesoura");

        System.out.println("Jogador 1: ");
        String jog1 = in.next();
        int valor1 = 0;

        //Categoriza a String para reduzir o código no switch case e fecha o programa com inconsistências
        //Escolhi o nome completo e abreviado para ampliar o sucesso do programa
        if (jog1.equalsIgnoreCase("pe") || jog1.equalsIgnoreCase("pedra")) {
            valor1 = 1;
        } else if (jog1.equalsIgnoreCase("pa") || jog1.equalsIgnoreCase("papel")) {
            valor1 = 2;
        } else if (jog1.equalsIgnoreCase("t") || jog1.equalsIgnoreCase("tesoura")) {
            valor1 = 3;
        } else {
            System.out.println("ERRO! Valor informado incorreto");
            in.close();
            System.exit(1);
        }

        System.out.println("Jogador 2: ");
        String jog2 = in.next();
        int valor2 = 0;

        //Categoriza a String para reduzir o código no switch case e fecha o programa com inconsistências
        //Escolhi o nome completo e abreviado para ampliar o sucesso do programa
        if (jog2.equalsIgnoreCase("pe") || jog2.equalsIgnoreCase("pedra")) {
            valor2 = 1;
        } else if (jog2.equalsIgnoreCase("pa") || jog2.equalsIgnoreCase("papel")) {
            valor2 = 2;
        } else if (jog2.equalsIgnoreCase("t") || jog2.equalsIgnoreCase("tesoura")) {
            valor2 = 3;
        } else {
            System.out.println("ERRO! Valor informado incorreto");
            in.close();
            System.exit(1);
        }

        switch (valor1) {
            case 1:
                if (valor2 == 1) {
                    System.out.println("EMPATE!");
                    break;
                } else if (valor2 == 2) {
                    System.out.println("Jogador 2 ganhou. Papel cobre pedra!");
                    break;
                } else {
                    System.out.println("Jogador 1 ganhou. Pedra quebra tesoura!");
                    break;
                }
            case 2:
                if (valor2 == 1) {
                    System.out.println("Jogador 1 ganhou. Papel cobre pedra!");
                    break;
                } else if (valor2 == 2) {
                    System.out.println("EMPATE!");
                    break;
                } else {
                    System.out.println("Jogador 2 ganhou. Tesoura corta papel!");
                    break;
                }
            case 3:
                if (valor2 == 1) {
                    System.out.println("Jogador 2 ganhou. Pedra quebra tesoura!");
                    break;
                } else if (valor2 == 2) {
                    System.out.println("Jogador 1 ganhou. Tesoura corta papel!");
                    break;
                } else {
                    System.out.println("EMPATE!");
                    break;
                }
            default:
                System.out.println("Ocorreu algum erro!");
        }
        System.out.println("===========================");
        in.close();
    }

    //Reuso em diversos exercícios
    public static void validaInteiro(Scanner in) {
        if (!in.hasNextInt()) {
            System.out.println("ERRO! O valor informado deve ser um número inteiro");
            in.close();
            System.exit(1);
        }
    }
}
