package bancoDeMadeira;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;



public abstract class Conta {

    //Armazena os ids de todas as contas
    private static List<String> listaIds = new ArrayList<>();
    protected static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    //Atributos
    private String id;
    protected double saldo;
    private double limiteChequeEspecial;
    private Cliente cliente;
    private Gerente gerente;
    private Banco banco;
    private LocalDateTime dataCriacao;
    private int contadorChequeEspecial;
    Map<String, Double> extrato = new HashMap<>();


    //Construtor
    public Conta(Cliente cliente, Gerente gerente, Banco banco,  double saldo) {
        verificaIdRepetido();
        depositar(saldo);
        this.limiteChequeEspecial = 0;
        this.contadorChequeEspecial = 0;
        this.cliente = cliente;
        this.gerente = gerente;
        this.banco = banco;
        this.dataCriacao = LocalDateTime.now();
        System.out.println("Conta " + this.id + " criada com sucesso!");

    }


    //Getters e Setters (A maioria não pode ter SET diretamente)
    public String getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public Banco getBanco() {
        return banco;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public String getDataCriacaoString() {
        return dataCriacao.format(formatter);
    }

    //Métodos

    //Verifica se o id já está sendo utilizado pelo outro cliente
    private void verificaIdRepetido() {
        Random r = new Random();
        String randomNumber = String.format("%04d", r.nextInt(1001));
        if (listaIds.contains(randomNumber)) {
            verificaIdRepetido();
        } else {
            this.id = randomNumber;
        }
    }

    public void mostrarConta() {
        System.out.println(this.toString());
    }

    public void listarExtrato() {
        for (Map.Entry<String, Double> valor : extrato.entrySet()) {
            if (valor.getValue() > 0) {
                System.out.println("Data: " + valor.getKey() + " .Depósito: " + valor.getValue());
            } else if (valor.getValue() < 0){
                System.out.println("Data: " + valor.getKey() + " .Saque: " + valor.getValue());
            }
        }
        System.out.printf("Saldo: %.2f%n", this.saldo);
        System.out.printf("Limite cheque especial: %.2f%n", this.limiteChequeEspecial);
    }

    public void realizarSaque(double valor) {
        Scanner in =  new Scanner(System.in);
        if (saldo >= valor) {
            saldo -= valor;
            extrato.put(LocalDateTime.now().format(formatter), -valor);
            System.out.println("Saque realizado com sucesso!");

        } else {
            //Cheque especial 5% do valor do cheque especial
            double total = saldo + limiteChequeEspecial - valor;
            if (total >= 0) {
                this.contadorChequeEspecial +=1;
                extrato.put(LocalDateTime.now().format(formatter), -valor);
                double totalChequeEspecial = saldo - valor + limiteChequeEspecial; // 1000 - 1200 + 300 = 100
                System.out.println("Entrando no limite do cheque especial");
                System.out.println("Um valor de 5% será cobrado sobre sua dívida no Cheque Especial");
                this.saldo = totalChequeEspecial - limiteChequeEspecial  * 1.05; //100 - 300 = -200 + 5%
            } else {
                //Caso o cliente exceda o valor do cheque especial e tenha entrado menos de 5 vezes nesta condição de cheque especial
                //10% do valor da
                total = saldo + limiteChequeEspecial*3 - valor;
                if (contadorChequeEspecial < 5 && total >= 0) {
                    extrato.put(LocalDateTime.now().format(formatter), -valor);
                    System.out.println("Condição especial de cheque especial: ");
                    System.out.println("Você ultrapassou o limite do cheque especial, mas temos uma condição para você cliente amigo," +
                            " será acrescentado " + this.limiteChequeEspecial*2 + ". Os juros sobre esta condição será 10%");
                    double totalChequeEspecial = saldo - valor + limiteChequeEspecial + limiteChequeEspecial*2; //1000 - 1800 +300 +600 = 100
                    this.saldo = totalChequeEspecial - limiteChequeEspecial*2 * 1.10 - limiteChequeEspecial * 1.05; // 100 - 660 - 315= -875
                } else {
                    System.out.println("Saldo indisponível");
                }
            }
        }
    }

    public void depositar(double valor) {
        saldo += valor;
        extrato.put(LocalDateTime.now().format(formatter), valor);
        //Controle para não mostrar caso o usuário não entre com valor inicial
        if (valor != 0) {
            System.out.println("Depósito realizado com sucesso!");
        }
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
     public void transferencia(String id, double valor) {
        if (saldo >= valor) {
            if (banco.acessarConta(id) != null) {
                Conta conta = banco.acessarConta(id);
                conta.depositar(valor);
                this.realizarSaque(valor);
            } else {
                System.out.println("Conta não encontrada");
            }
        } else {
            System.out.println("Saldo insuficiente");
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
                "Data de Criação = " + this.getDataCriacaoString() +
                ", ID ='" + id + '\'' +
                ", Cliente = " + cliente.getNome() +
                String.format(", Saldo = %.2f", saldo) +
                ", LimiteChequeEspecial =" + limiteChequeEspecial +
                ']';
    }
}
