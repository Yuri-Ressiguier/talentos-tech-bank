package dia3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("WHILE");
        int contagem = 1;

        while (contagem < 11) {
            System.out.println(contagem);
            contagem += 1;
        }

        System.out.println("DO WHILE");

        contagem = 11;

        do {
            System.out.println(contagem);
            contagem++;
        } while (contagem < 11);

        System.out.println("FOR");

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        System.out.println("FOR EACH");

        List<Integer> minhaLista = new ArrayList<>();
        minhaLista.add(1);
        minhaLista.add(2);
        minhaLista.add(3);

        minhaLista.forEach(item ->  {
            System.out.println(item);
        });

        for (int i = 0; i < minhaLista.size();i++) {
            System.out.println(minhaLista.get(i));
        }
    }
}
