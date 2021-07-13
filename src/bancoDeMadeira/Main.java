package bancoDeMadeira;

import java.util.*;

public class Main {

    public static void validaInteiro(Scanner in) {
        if (!in.hasNextInt()) {
            System.out.println("ERRO! O valor informado deve ser um número inteiro");
            in.close();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        Map<Integer, Conta> sistemaDeContas = new HashMap<>();      //Armazena Contas
        boolean sistemaLoop = true;                                 //Controla Loop
        int op;                                                     //Operador do sistema
        int opAninhada;


        System.out.println("Bem vindo ao Banco de Madeira");
        while (sistemaLoop) {
            System.out.println("1: Criar Conta / 2: Acessar Conta (ID) / 3: Listar Tudo / 4: Encerrar Conta / 0: Sair");
            validaInteiro(in);
            op = in.nextInt();

            switch (op) {
                case 0:
                    System.out.println("=== Saindo do sistema ===");
                    sistemaLoop = false;
                case 1:
                    System.out.println("=== Criar Conta ===");
                    System.out.println("Qual o nome do cliente? ");
                    String nomeCliente = in.nextLine();
                    System.out.println("Qual a renda mensal do cliente? ");
                    double rendaMensal =  in.nextDouble();
                    //Cria cliente
                    Cliente cliente = new Cliente(nomeCliente, rendaMensal);
                    System.out.println("Qual a conta o cliente deseja abrir? (C = Corrente / P = Poupança)");
                    char resposta = in.next().toLowerCase().charAt(0);
                    if (resposta == 'c') {
                        Conta conta = new Corrente(cliente);
                        sistemaDeContas.put(conta.getId(), conta);
                    } else if (resposta == 'p') {
                        Conta conta = new Poupanca(cliente);
                        sistemaDeContas.put(conta.getId(), conta);
                    } else {
                        System.out.println("Erro, resposta inválida");
                    }
                    System.out.println("Deseja adicionar um saldo inicial? (s/n)");

                case 2:
                    System.out.println("Qual é o ID?");
                    validaInteiro(in);
                    int id = in.nextInt();
                    if (sistemaDeContas.containsKey(id)) {
                        Conta contaSelecionada = sistemaDeContas.get(id);
                        System.out.println(contaSelecionada.toString());
                    }

                    System.out.println("Qual operação você deseja fazer? ");
                    System.out.println("1: Listar Extrato / 2: Saque / 3: Depositar / 4: AdicionarLimiteChequeEspecial / 0: Sair");
                    opAninhada

                case 3:


            }

        }

    }
}
