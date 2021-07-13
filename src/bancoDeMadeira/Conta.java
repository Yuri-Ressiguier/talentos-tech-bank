package bancoDeMadeira;

import java.text.SimpleDateFormat;
import java.util.*;


public abstract class Conta {

    private static List<String> listaIds = new ArrayList<>();
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    //Atributos
    private String id;
    private double saldo;
    private double limiteChequeEspecial;
    private Cliente cliente;
    private Gerente gerente;
    private Date datacCriacao;
    List<Double> extrato = new ArrayList<>();

    //Construtor
    public Conta(Cliente cliente, Gerente gerente, double saldo) {
        verificaIdRepetido();
        depositar(saldo);
        this.limiteChequeEspecial = 0;
        this.cliente = cliente;
        this.gerente = gerente;
        this.datacCriacao = new Date();
        System.out.println("Conta " + this.id + " criada com sucesso!");

    }


    //Getters e Setters
    public String getId() {
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

    //Métodos
    private void verificaIdRepetido() {
        Random r = new Random();
        String randomNumber = String.format("%04d", r.nextInt(1001));
        if (listaIds.contains(randomNumber)) {
            verificaIdRepetido();
        } else {
            this.id = randomNumber;
        }
    }

    public void listarExtrato() {

        for (Double valor : extrato) {
            if (valor > 0) {
                System.out.println("Depósito: " + valor);
            } else if (valor < 0){
                System.out.println("Saque: " + valor);
            }
        }
        System.out.println("Saldo: " + this.saldo);
    }

    public void realizarSaque(double valor) {
        Scanner in =  new Scanner(System.in);
        if (saldo >= valor) {
            saldo -= valor;
            extrato.add(-valor);
            System.out.println("Saque realizado com sucesso!");

        } else {
            double total = saldo + limiteChequeEspecial - valor;
            if (total >= 0) {
                extrato.add(-valor);
                double totalChequeEspecial = saldo - valor + limiteChequeEspecial;
                System.out.println("Entrando no limite do cheque especial");
                System.out.println("Um valor de 5% será cobrado sobre sua dívida no Cheque Especial");
                this.saldo = totalChequeEspecial - limiteChequeEspecial  * 1.05;
            } else {
                System.out.println("Saldo indisponível");
            }

        }

    }

    public void depositar(double valor) {
        saldo += valor;
        extrato.add(valor);
        System.out.println("Depósito realizado com sucesso!");

    }

    public void adicionarLimiteChequeEspecial(int senha) {
        if (this.gerente.verificaChequeEspecial(senha)) {
            System.out.println("Limite cheque especial gerado com sucesso!");
            this.limiteChequeEspecial = cliente.getSalario() * 0.3;
            System.out.println("O valor é: " + this.limiteChequeEspecial);
        } else {
            System.out.println("Senha do Gerente incorreta");
            this.limiteChequeEspecial = 0;
        }
    }

    public boolean checaConta() {
        if (saldo != 0) {
            System.out.println("Favor checar saldo. O valor deve ser 0 para deletar a conta");
            return false;
        } else  {
            System.out.println("Sua conta foi removida com sucesso!");
            return true;
        }
    }

    @Override
    public String toString() {
        return "Conta [" +
                "id='" + id + '\'' +
                ", saldo=" + saldo +
                ", cliente=" + cliente.getNome() +
                ", limiteChequeEspecial=" + limiteChequeEspecial +
                ']';
    }
}
