package bancoDeMadeira;

public class Corrente extends Conta{

    private double limite;

    public Corrente(Cliente cliente, Gerente gerente, double saldo) {
        super(cliente, gerente, saldo);
    }


    public void calculaLimite() {
        limite = this.getCliente().getSalario() * 1.15;
    }

    public String toString() {
        return "== CONTA CORRENTE == \n" + super.toString();
    }
}
