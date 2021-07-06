package dia7;

import javax.sound.midi.Soundbank;
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


        //Utilizando String


        Scanner in = new Scanner(System.in);
        String[] palavra = {"a", "b", "a", "c", "a", "x", "i"};
        String[] jogadas = {"_", "_", "_", "_", "_", "_", "_"};
        List<String> letrasAdicionadas = new ArrayList<>();
        String letra = "";
        int tentativas = 10;
        boolean acerto;
        boolean gameLoop = true;
        int contadorAcertos = 0;


        while (gameLoop) {
            System.out.println("===================================================================");
            acerto = false;         //Controle caso haja acerto
            System.out.println("Tentativa número " + tentativas + ": ");
            letra = in.next();

            //Verifica se a letra já foi utilizada e bloqueia caso positivo
            if (letrasAdicionadas.contains(letra) ) {
                System.out.println("A letra já foi utilizada!");
                continue;
            } else {
                letrasAdicionadas.add(letra);
            }

            //Verifica se a letra selecionada faz parte da palavra
            for (int i = 0; i < palavra.length; i++) {
                if (palavra[i].equals(letra)) {
                    contadorAcertos ++;     //Controle de acertos - para verificar a vitória
                    acerto = true;
                    jogadas[i] = letra;     //Adiciona as letras no jogo
                }
            }

            //Mostra o estado do jogo
            System.out.println("Letras utilizadas: " + letrasAdicionadas);
            System.out.println(Arrays.toString(jogadas));

            //Verifica vitória pela quantidade de acertos (tamanho do array)
            if (acerto) {
                if (contadorAcertos == jogadas.length) {
                    System.out.println("===================================================================");
                    System.out.println("Parabéns! Você venceu o jogo faltando " + tentativas + " tentativas");
                    gameLoop = false;
                }
            //Caso seja alguma letra errada, o número de tentativas é decrementado
            } else {
                System.out.println("A letra " + letra + " não está presente na palavra!");
                tentativas --;
                //Verifica GAME OVER pela quantidade de tentativas
                if (tentativas == 0) {
                    System.out.println("===================================================================");
                    System.out.println("Que pena, você não conseguiu vencer este jogo.");
                    System.out.println("A palavra era " + Arrays.toString(palavra));
                    gameLoop = false;
                }
            }
        }
        in.close();
    }

    public static void exercicio06() {
        //Dado um array de números inteiros com valores negativos e positivos, encontro o número mais próximo de zero.
        // Se ouver valores como 2 e -2, considere o número positivo.

        Scanner in = new Scanner(System.in);
        //int[] valores = {-50, 20, 35, 2, 8, -3, -2, 74, -30, -9, 10, 55, 13, -15, -1};
        System.out.println("Quantidade de valores do array: ");
        int qtdValores = in.nextInt();
        int[] valores = new int [qtdValores];

        //Preenche o array com valores
        for (int i = 0; i < qtdValores; i++) {
            System.out.println("Digite o valor " + (i+1));
            valores[i] = in.nextInt();
        }
        //Ordena o array
        Arrays.sort(valores);
        int maisProx;
        int menorValor = valores[0];
        int maiorValor = valores[valores.length-1];

        //Verifica o valor mais próximo a 0 vindo pelos valores negativos
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] > menorValor && valores[i] < 0) {
                menorValor = valores[i];
            }
        }

        //Verifica o valor mais próximo a 0 vindo pelos valores positivos
        for (int i = valores.length -1; i >= 0; i--) {
            if (valores[i] < maiorValor && valores[i] > 0) {
                maiorValor = valores[i];
            }
        }

        //Compara o valor mais próximo positivo e negativo
        if ((maiorValor + menorValor) > 0) {
            maisProx = menorValor;
        } else if ((maiorValor + menorValor) < 0) {
            maisProx = maiorValor;
        } else {
            maisProx = maiorValor;
        }

        //Printa resultados
        System.out.println("O array é: ");
        System.out.println(Arrays.toString(valores));
        System.out.println("O valor mais próximo de zero é: " + maisProx);
        in.close();

    }

    public static void main(String[] args) {
        //exercicio01();
        //exercicio02();
        //exercicio03();
        //exercicio04();
        //exercicio05();
        exercicio06();
    }




}
