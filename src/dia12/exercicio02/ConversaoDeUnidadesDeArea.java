package dia12.exercicio02;

public class ConversaoDeUnidadesDeArea {
    public final static double METROPARAPES = 10.76;
    public final static double PESPARACENTIMETROS = 929.0;
    public final static double MILHAPARAACRES = 640.0;
    public final static double ACREPARAPES = 43_560.0;


    public static double metroParaPes(double valor) {
        return valor * METROPARAPES;
    }
    public static double pesParaCentimetros(double valor) {
        return valor * PESPARACENTIMETROS;
    }
    public static double milhaParaAcres(double valor) {
        return  valor * MILHAPARAACRES;
    }
    public static double acreParaPes(double valor) {
        return valor * ACREPARAPES;
    }
}
