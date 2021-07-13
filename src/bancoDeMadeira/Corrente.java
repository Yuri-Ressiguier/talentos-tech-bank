package bancoDeMadeira;

public class Corrente extends Conta{

    private double limite;

    public Corrente(Cliente cliente) {
        super(cliente);
    }


    public void calculaLimite() {
        limite = this.getCliente().getSalario() * 1.15;
    }
}
