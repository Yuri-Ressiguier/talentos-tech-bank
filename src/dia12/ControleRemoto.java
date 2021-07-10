package dia12;

public class ControleRemoto {

    private Televisao tv;

    ControleRemoto(Televisao tv) {
        this.tv = tv;
    }

    public void aumentarVolumeCR() {
        tv.aumentarVolume();
    }

    public void diminuirVolumeCR() {
        tv.diminuirVolume();
    }

    public void aumentarCanalCR() {
        tv.aumentarCanal();
    }

    public void diminuirCanalCR() {
        tv.diminuirCanal();
    }

    public void setCanalCR(int canal) {
        tv.setCanal(canal);
    }

    public void mostraVolumeCanalCR() {
        tv.mostraVolumeCanal();
    }


}
