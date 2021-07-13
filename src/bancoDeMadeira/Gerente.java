package bancoDeMadeira;

public class Gerente {
    private int senha;

    public Gerente(int senha) {
        this.senha = senha;
    }

    public int getSenha() {
        return senha;
    }

    public boolean verificaChequeEspecial(int senha) {
        if (senha == this.senha) {
            return true;
        } else {
            return false;
        }
    }
}
