package dia12;

public class Televisao {
    private int volume;
    private int canal;

    Televisao() {
        this.volume = 50;
        this.canal = 50;
    }

    public int getVolume() {
        return volume;
    }

    public void aumentarVolume() {
        this.volume = volume - 1;
    }

    public void diminuirVolume() {
        this.volume = volume + 1;
    }

    public int getCanal() {
        return canal;
    }

    public void diminuirCanal() {
        this.canal = canal -1;
    }

    public void aumentarCanal() {
        this.canal = canal +1;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    public void mostraVolumeCanal() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Volume: " + this.getVolume() +
                " .Canal: " + this.getCanal();
    }
}
