package bancoDeMadeira;

public class Poupanca extends Conta{

    public Poupanca(Cliente cliente, Gerente gerente, double saldo) {
        super(cliente, gerente, saldo);
    }

    public String toString() {
        return "== CONTA POUPANÇA == \n" + super.toString();
    }
}
