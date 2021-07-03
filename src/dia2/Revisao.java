package dia1;

public class Revisao {

    public static void main(String[] args) {
        short s = 123;
        int i = s;
        long l = i;
        float f = l;
        double d = f;

        double d2 = 100.00;
        float f2 = (float) d2;
        long l2 = (long) f2;
        int i2 = (int) l2;
        short s2 = (short) i2;

        //EM OPERAÇÕES COM TIPOS DISTINTOS, O RESULTADO É DO TIPO "MAIOR" DELES

        System.out.println(s2);

        //Operações entre shorts retorna inteiro

        //Para garantir operações entre dois ints grandes, deve-se fazer o cast para long e armazenar o resultado em long
    }

}
