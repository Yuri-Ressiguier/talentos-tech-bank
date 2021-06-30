package dia1;

import java.util.Locale;
import java.util.Scanner;

public class Exercicios {
    public static void main(String[] args) {
        //exercicio1();
        //exercicio2();
        //exercicio3();
        exercicio4();



    }

    public static void exercicio1() {
        /*Escreva um algoritmo que armazene o valor 99 em uma variável Y e o valor 11 em uma variável Z.
         A seguir (utilizando apenas atribuições entre variáveis) troque os seus conteúdos fazendo com que
         o valor que está em Y passe para Z e vice-versa. Ao final, escrever os valores que ficaram armazenados
         nas variáveis.
         */

        int y = 99;
        int z = 11;

        y = y + z;      //99 + 11 = 110
        z = y - z;      //110 - 11 = 99
        y = y - z;      //110 - 99 = 11

        System.out.println("O y é: " + y);
        System.out.println("O z é: " + z);

    }

    public static void exercicio2() {
        //Escreva um algoritmo para ler um valor (do teclado) e escrever (na tela) o seu antecessor.

        Scanner in = new Scanner(System.in);
        System.out.println("Digite o valor para mostrar o seu antecessor: ");
        int valor = in.nextInt();
        int valorAntecessor = valor -  1;

        //ctrl + alt + l (formata automaticamente)

        //valor-- decrementa posteriormente o uso
        //--valor decrementa anteriormente o uso

        System.out.println("O valor antecessor do valor " + valor + " é o valor: " + valorAntecessor);
        in.close();
    }

    public static void exercicio3() {
        //Escreva um algoritmo para ler as dimensões de um retângulo (base e altura), calcular e escrever a área do retângulo.

        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        System.out.println("=== Cálculo da Área de um Triângulo ===");
        System.out.println("Digite a base: ");
        double base = in.nextDouble();
        System.out.println("Digite a altura: ");
        double altura = in.nextDouble();

        double area = base * altura;

        System.out.printf("A área do triângulo é: %.2f", area);
        in.close();
    }

    public static void exercicio4() {
        /*4 - Escreva um algoritmo para ler o número total de eleitores de um município, o número de votos brancos, nulos e válidos.
         Calcular e escrever o percentual que cada um representa em relação ao total de eleitores. (editado)
         */

        Scanner in = new Scanner(System.in);
        System.out.println("=== ELEIÇÕES ===");

        //Total eleitores
        System.out.println("Digite o total de eleitores do município: ");
        int totalEleitores = in.nextInt();

        //Total branco
        System.out.println("Digite o total de votos brancos: ");
        double brancos = in.nextDouble();

        //Total nulos
        System.out.println("Digite o total de votos nulos: ");
        double nulos = in.nextDouble();

        //Total válidos
        System.out.println("Digite o total de votos válidos: ");
        double validos = in.nextDouble();

        double percentBranco = brancos / totalEleitores * 100;
        double percentNulo = nulos / totalEleitores * 100;
        double percentValidos = validos / totalEleitores * 100;

        System.out.println("Resultados: ");
        System.out.println("Porcentagem  eleitores: " + totalEleitores);
        System.out.println("Porcentagem de votos brancos: " + percentBranco);
        System.out.println("Porcentagem de votos nulos: " + percentNulo);
        System.out.println("Porcentagem de votos válidos: " + percentValidos);

        System.out.println("======================");
        in.close();


    }
}
