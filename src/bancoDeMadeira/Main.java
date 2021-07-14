package bancoDeMadeira;

import java.util.*;

public class Main {

    //Valida se os valores de entrada são inteiros
    public static void validaInteiro(Scanner in) {
        if (!in.hasNextInt()) {
            System.out.println("ERRO! O valor informado deve ser um número inteiro");
            in.close();
            System.exit(1);
        }
    }
    //Valida se os valores de entrada são doubles
    public static void validaDouble(Scanner in) {
        if (!in.hasNextDouble()) {
            System.out.println("ERRO! O valor informado deve ser um número double");
            in.close();
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        boolean sistemaLoop = true;                                 //Controla Loop
        boolean sistemaLoopInterno;                                 //Controla os subloops
        int op;                                                     //Operador do sistema
        int opAninhada;                                             //Operador dos subsistemas
        String id;                                                  //Para consultar as contas através dos IDs
        double valor;                                               //Armazena valor das operações


        Gerente gerente =  new Gerente(123123);                //Cria um gerente ficticio para aprovar Cheque Especial



        /*
        Programa base do programa:
        Mostra um menu para o usuário selecionar:
        1 - Cria uma conta no banco
        2 - Acessa a conta através do ID
            2.1 - Lista o extrato mostrando as mudanças de saldo
            2.2 - Saca valores com limite máximo de saldo + limite cheque especial
            2.3 - Deposito
            2.4 - AdicionarLimiteChequeEspecial (Adiciona 30% do salário do cliente como limite do cheque especial)
            2.5 - Transferência (Pedir id de outro objeto)
            2.0 - Retornar ao menu principal
        3 - Lista todas as contas registradas no banco
        4 - Encerra a conta caso o saldos seja 0
        0 - Sai do programa
         */
        System.out.println("Bem vindo ao Banco de Madeira [MODO FUNCIONÁRIO]");
        Banco banco = new Banco(6); //Nosso banco criado
        while (sistemaLoop) {
            System.out.println("1: Criar Conta / 2: Acessar Conta (ID) / 3: Listar Tudo / 4: Encerrar Conta / 0: Sair");
            validaInteiro(in);
            op = in.nextInt();
            switch (op) {
                //Sair do programa
                case 0:
                    System.out.println("=== SAINDO DO SISTEMA ===");
                    sistemaLoop = false;
                    break;
                //Cria conta
                case 1:
                    in.nextLine();
                    System.out.println("=== CRIAR CONTA ===");
                    System.out.println("Qual o nome do cliente? ");
                    String nomeCliente = in.nextLine();
                    System.out.println("Qual a renda mensal do cliente? ");
                    double rendaMensal =  in.nextDouble();
                    //Cria cliente para criar uma conta
                    Cliente cliente = new Cliente(nomeCliente, rendaMensal);
                    System.out.println("Qual a conta o cliente deseja abrir? (C = Corrente / P = Poupança)");
                    char resposta = in.next().toLowerCase().charAt(0);
                    if (resposta == 'c') {
                        System.out.println("Deseja adicionar um saldo inicial? (s/n)");
                        resposta = in.next().toLowerCase().charAt(0);
                        if (resposta == 's') {
                            System.out.println("Qual o valor? ");
                            validaDouble(in);
                            valor = in.nextDouble();
                            banco.criarContaCorrente(cliente, gerente, valor);
                        } else {
                            banco.criarContaCorrente(cliente, gerente, 0);
                        }
                    } else if (resposta == 'p') {
                        System.out.println("Deseja adicionar um saldo inicial? (s/n)");
                        resposta = in.next().toLowerCase().charAt(0);
                        if (resposta == 's') {
                            System.out.println("Qual o valor? ");
                            validaDouble(in);
                            valor = in.nextDouble();
                            banco.criarContaPoupanca(cliente, gerente, valor);
                        } else {
                            banco.criarContaPoupanca(cliente, gerente, 0);
                        }
                    } else {
                        System.out.println("Erro, resposta inválida");
                    }
                    break;
                //Acessa conta
                case 2:
                    System.out.println("=== ACESSAR CONTA ===");
                    System.out.println("Qual é o ID?");
                    validaInteiro(in);
                    id = in.next();
                    Conta contaSelecionada = banco.acessarConta(id);
                    if (contaSelecionada != null) {
                        sistemaLoopInterno = true;
                        System.out.println("Qual operação você deseja fazer? ");
                        while (sistemaLoopInterno) {
                            System.out.println("1: Mostrar Conta / 2: Listar Extrato / 3: Saque / 4: Deposito / 5: Transferência / 6: AdicionarLimiteChequeEspecial / 0: Retornar ao menu");
                            validaInteiro(in);
                            opAninhada = in.nextInt();
                            switch (opAninhada) {
                                //Volta para o menu principal
                                case 0:
                                    System.out.println("=== RETORNANDO AO MENU PRINCIPAL ===");
                                    sistemaLoopInterno = false;
                                    break;
                                //Mostra os atributos da conta
                                case 1:
                                    contaSelecionada.mostrarConta();
                                    break;
                                //Mostra o extrato da conta
                                case 2:
                                    System.out.println("=== EXTRATO ===");
                                    contaSelecionada.listarExtrato();
                                    break;
                                //Saca valores
                                case 3:
                                    System.out.println("=== SAQUE ===");
                                    System.out.println("Qual o valor do saque?");
                                    validaDouble(in);
                                    valor = in.nextDouble();
                                    contaSelecionada.realizarSaque(valor);
                                    break;
                                //Deposita valores
                                case 4:
                                    System.out.println("== DEPOSITO ==");
                                    System.out.println("Qual o valor do depósito?");
                                    validaDouble(in);
                                    valor = in.nextDouble();
                                    contaSelecionada.depositar(valor);
                                    break;
                                //Transfere dinheiro para outra conta
                                case 5:
                                    System.out.println("=== TRANSFERÊNCIA ===");
                                    System.out.println("Qual é o ID do favorecido? (4 dígitos)");
                                    id = in.next();
                                    System.out.println("Qual o valor da transferência?");
                                    valor = in.nextDouble();
                                    contaSelecionada.transferencia(id, valor);
                                    break;
                                //Adiciona limite do cheque especial
                                case 6:
                                    System.out.println("== ADD LIMITE CHEQUE ESPECIAL ==");
                                    System.out.println("Esta operação necessita de um Gerente. Digite a senha do gerente desta conta: ");
                                    contaSelecionada.adicionarLimiteChequeEspecial(in.nextInt());
                                    break;
                                default:
                                    System.out.println("Valor informado incorreto!");
                            }
                        }
                        break;          //Fecha case2 externo
                    } else {
                        System.out.println("Conta não encontrada");
                        break;          //Fecha case2
                    }
                //Lista todas as contas do banco
                case 3:
                    System.out.println("=== LISTAR TUDO ===");
                    banco.listarContas();
                    break;
                //Encerra a conta
                case 4:
                    System.out.println("=== ENCERRAR CONTA ===");
                    System.out.println("Digite o ID da sua conta: ");
                    validaInteiro(in);
                    id = in.next();
                    banco.encerrarConta(id);
                    break;
                default:
                    System.out.println("Valor informado incorreto!");
            }

        }

    }
}
