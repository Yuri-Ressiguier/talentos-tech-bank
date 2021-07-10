package dia12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Fabricação da Tv e Controle
        Televisao tv = new Televisao();
        ControleRemoto cr = new ControleRemoto(tv);

        System.out.println("=== Tv Ligada ===");

        cr.mostraVolumeCanalCR();
        cr.setCanalCR(20);
        cr.mostraVolumeCanalCR();
        cr.aumentarVolumeCR();
        cr.aumentarVolumeCR();
        cr.aumentarVolumeCR();
        cr.diminuirCanalCR();
        cr.diminuirCanalCR();
        cr.mostraVolumeCanalCR();

        in.close();
    }
}
