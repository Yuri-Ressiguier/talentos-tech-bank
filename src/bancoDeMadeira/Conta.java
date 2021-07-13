package bancoDeMadeira;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Conta {


    //Atributos
    //private final int id;
    private double saldo;
    private Cliente cliente;
    private Gerente gerente;
    List<Double> extrato = new ArrayList<>();

    public Conta(Cliente cliente, Gerente gerente) {
        this.saldo = 0;
        this.cliente = cliente;
        this.gerente = gerente;

    }

    public int getId() {
        return id;
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    private double limiteChequeEspecial;

    //Métodos
    public void listarExtrato() {
        StringBuilder sb = new StringBuilder();
        sb.append("===EXTRATO===");
        for (Double valor : extrato) {
            if (valor > 0) {
                sb.append("Depósito: " + valor + "\n");
            } else {
                sb.append("Saque: " + valor + "\n");
            }
        }
        System.out.println(sb);
    }

    public void realizarSaque(double valor) {
        Scanner in =  new Scanner(System.in);
        if (saldo >= valor) {
            saldo -= valor;
            extrato.add(-valor);
        } else {
            System.out.println("Saldo indisponível");
            /*
            System.out.println("Deseja utilizar o cheque especial? (S/N)");
            char resposta = in.next().toLowerCase().charAt(0);
            if (resposta == 's') {
                double total = valor - (saldo + limiteChequeEspecial);
                saldo = 0;
                if (total > 0) {
                    System.out.println("Limite de saque do cheque ultrapassado em " + total + " reais. Deseja Sacar mesmo assim? (S/N)");
                }
                resposta = in.next().toLowerCase().charAt(0);
                if (resposta == 's') {
                    System.out.println("Valor sacado: " + valor);
                }

            }

             */
        }

    }

    public void depositar(double valor) {
        saldo += valor;
        extrato.add(valor);

    }

    public void adicionarLimiteChequeEspecial() {
        Scanner in = new Scanner(System.in);
        int senha = in.nextInt();
        if (this.gerente.verificaChequeEspecial(senha))
        {
            this.limiteChequeEspecial = cliente.getSalario() * 0.3;
        } else {
            this.limiteChequeEspecial = 0;
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id='" + id + '\'' +
                ", saldo=" + saldo +
                ", cliente=" + cliente.getNome() +
                ", limiteChequeEspecial=" + limiteChequeEspecial +
                '}';
    }
}
