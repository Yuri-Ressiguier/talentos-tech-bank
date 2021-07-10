package dia12;

public class Televisao {
    private int volume;
    private int canal;

    public Televisao() {
        this.volume = 50;
        this.canal = 50;
    }

    public int getVolume() {
        return volume;
    }

    public void aumentarVolume() {
        this.volume = volume + 1;
        if (this.volume >= 100) {
            this.volume = 100;
        }
    }

    public void diminuirVolume() {
        this.volume = volume - 1;
        if (this.volume < 0) {
            this.volume = 0;
        }
    }

    public int getCanal() {
        return canal;
    }

    public void diminuirCanal() {
        this.canal = canal -1;
        if (this.canal < 0) {
            this.canal = 0;
        }
    }

    public void aumentarCanal() {
        this.canal = canal +1;
        if (this.canal >= 100) {
            this.canal = 100;
        }
    }

    public void setCanal(int canal) {
        if (canal < 0 || canal >= 100) {
            return;
        }
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
