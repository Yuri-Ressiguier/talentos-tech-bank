package bancoDeMadeira;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;

public class Corrente extends Conta{

    private double emprestimo;
    private LocalDateTime dataEmprestimo;
    private double limiteEmprestimo;
    private boolean fezEmprestimo;

    public Corrente(Cliente cliente, Gerente gerente, Banco banco, double saldo) {
        super(cliente, gerente, banco, saldo);
        this.emprestimo = 0;
        this.dataEmprestimo = null;
        this.limiteEmprestimo = this.getCliente().getSalario()*2;
        this.fezEmprestimo = false;
    }

    public double getEmprestimo() {
        return emprestimo;
    }


    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }


    public double getLimiteEmprestimo() {
        return limiteEmprestimo;
    }


    public boolean isFezEmprestimo() {
        return fezEmprestimo;
    }


    //Pega empréstimo caso o limite seja maior que o valor e caso não tenha outro empréstimo ativo
    public void setEmprestimo(double valor) {
        if (fezEmprestimo) {
            System.out.println("Você já fez um empréstimo! Pague a dívida atual para efetuar um novo empréstimo");
        } else {
            if (valor <= limiteEmprestimo && !this.fezEmprestimo) {
                dataEmprestimo = LocalDateTime.now();
                this.emprestimo = - valor;
                this.saldo += valor;
                this.fezEmprestimo = true;
                System.out.println("Empréstimo feito com sucesso");
            } else {
                System.out.println("Você não tem limite para isso");
            }
        }
    }

    //Paga o empréstimo caso tenha o saldo para pagar (com taxas) - Paga tudo de uma vez
    public void pagaEmprestimo() {
        Duration duracao = Duration.between(this.dataEmprestimo, LocalDateTime.now());
        long diff = duracao.toMinutes();
        double taxaASerPaga = 0.05 * diff;  // 5% por minuto
        double totalASerPago = this.emprestimo * (1+taxaASerPaga);
        System.out.println("Sua dívida do emprestimo + taxas é igual a: " + totalASerPago);
        if (this.getSaldo() >= Math.abs(totalASerPago)) {
            this.saldo += totalASerPago;      //+ por que o emprestimo já está negativo
            this.emprestimo = 0;
            System.out.println("Seu empréstimo está pago");
            System.out.println("Você não tem saldo para pagar esta conta no momento");
        }
    }

    @Override
    public void listarExtrato() {
        for (Map.Entry<String, Double> valor : extrato.entrySet()) {
            if (valor.getValue() > 0) {
                System.out.println("Data: " + valor.getKey() + " .Depósito: " + valor.getValue());
            } else if (valor.getValue() < 0){
                System.out.println("Data: " + valor.getKey() + " .Saque: " + valor.getValue());
            }
        }
        System.out.printf("Saldo: %.2f%n", this.saldo);
        System.out.printf("Limite cheque especial: %.2f%n", this.getLimiteChequeEspecial());
        if (this.dataEmprestimo != null) {
            System.out.println("Empréstimo: " + this.emprestimo + ". Data: " + this.dataEmprestimo.format(formatter));
        }
    }

    public String toString() {
        return "== CONTA CORRENTE == \n" + super.toString();
    }
}
