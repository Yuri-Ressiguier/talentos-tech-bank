package dia6;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;

public class Exercicios {

    public static void exercicio01() {
        //Dado um array com 20 números, imprima seus valores de trás para frente.
        //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20]

        int[] listaInteiro = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        for (int i = listaInteiro.length -1;  i >= 0; i--) {
            System.out.println(listaInteiro[i]);
        }

    }

    public static void exercicio02() {
        //GRUPO 2 BUUBLE SORT

        int[] lista = {50, 30, 25, 80, 2, 7, 30, 20};
        int aux;
        for (int i = 1; i < lista.length; i++) {
            for (int j = 0; j < lista.length-1; j++) {
                if (lista[j] > lista[j+1]) {
                    aux = lista[j+1];
                    lista[j+1] = lista[j];
                    lista[j] = aux;
                }
            }
        }
        for (int valor : lista) {
            System.out.println(valor);
        }

        System.out.println(Arrays.toString(lista));
    }

    public static void exercicio03() {

        //GRUPO 2 SELECT SORT

        int[] lista = {50, 30, 25, 80, 2, 7, 30, 20};
        int menor;

        for (int i = 0; i < lista.length -1; i++) {
            for (int j = i + 1; j < lista.length; j++) {
                if (lista[j] < lista[i]) {
                    menor = lista[j];
                    lista[j] = lista[i];
                    lista[i] = menor;
                }
            }
        }
        for (int valor : lista) {
            System.out.println(valor);
        }
        System.out.println(Arrays.toString(lista));
    }

    public static void main(String[] args) {
        //exercicio01();
        //exercicio02();
        exercicio03();
    }
}
