package dia12;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //Fabricação da Tv e Controle
        Televisao tv1 = new Televisao();
        Televisao tv2 = new Televisao();
        ControleRemoto cr = new ControleRemoto(tv1);


        System.out.println("TV DE FÁBRICA");
        cr.mostraVolumeCanalCR();
        cr.setCanalCR(20);
        cr.mostraVolumeCanalCR();
        cr.aumentarVolumeCR();
        cr.aumentarVolumeCR();
        cr.aumentarVolumeCR();
        cr.diminuirCanalCR();
        cr.diminuirCanalCR();
        cr.mostraVolumeCanalCR();
        System.out.println("TROCANDO TV");
        cr.setTv(tv2);
        cr.mostraVolumeCanalCR();
        cr.setCanalCR(200);
        cr.diminuirVolumeCR();
        cr.diminuirVolumeCR();
        cr.mostraVolumeCanalCR();


        in.close();
    }
}
