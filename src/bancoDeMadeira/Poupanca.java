package bancoDeMadeira;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Poupanca extends Conta{

    private Map<String,Double> rendimentos;

    public Poupanca(Cliente cliente, Gerente gerente, Banco banco, double saldo) {
        super(cliente, gerente, banco, saldo);
        this.rendimentos = new HashMap<>();
    }

    public void adicionaRendimentos() {
        double ultimoRendimento = saldo * 0.05;
        LocalDateTime momentoRendimento = LocalDateTime.now();
        rendimentos.put(momentoRendimento.format(formatter), ultimoRendimento);
        this.saldo += ultimoRendimento;
    }

    public void mostraRendimentos() {
        for (Map.Entry<String, Double> rendimentos : rendimentos.entrySet()) {
            System.out.println("Data: " + rendimentos.getKey() + ". Rendimento: " + rendimentos.getValue());
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
        System.out.printf("Seu dinheiro está rendendo %.2f", this.saldo * 0.05);
        System.out.println(" a cada 2 minutos");
    }

    public String toString() {
        return "== CONTA POUPANÇA == \n" + super.toString();
    }
}
