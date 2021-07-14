package bancoDeMadeira;

public class Poupanca extends Conta{

    public Poupanca(Cliente cliente, Gerente gerente, Banco banco, double saldo) {
        super(cliente, gerente, banco, saldo);
    }

    public String toString() {
        return "== CONTA POUPANÇA == \n" + super.toString();
    }
}
