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
        Map<String, Conta> sistemaDeContas = new HashMap<>();       //Armazena Contas
        boolean sistemaLoop = true;                                 //Controla Loop
        boolean sistemaLoopInterno;                                 //Controla os subloops
        int op;                                                     //Operador do sistema
        int opAninhada;                                             //Operador dos subsistemas
        String id;                                                  //Para consultar as contas através dos IDs
        double valor;                                               //Armazena valor das operações

        Gerente gerente =  new Gerente(123123);                //Cria um gerente ficticio para aprovar Cheque Especial

        System.out.println("Bem vindo ao Banco de Madeira [MODO FUNCIONÁRIO]");
        while (sistemaLoop) {
            System.out.println("1: Criar Conta / 2: Acessar Conta (ID) / 3: Listar Tudo / 4: Encerrar Conta / 0: Sair");
            validaInteiro(in);
            op = in.nextInt();

            switch (op) {
                case 0:
                    System.out.println("=== SAINDO DO SISTEMA ===");
                    sistemaLoop = false;
                    break;
                case 1:
                    in.nextLine();
                    System.out.println("=== CRIAR CONTA ===");
                    System.out.println("Qual o nome do cliente? ");
                    String nomeCliente = in.nextLine();
                    System.out.println("Qual a renda mensal do cliente? ");
                    double rendaMensal =  in.nextDouble();
                    //Cria cliente
                    Cliente cliente = new Cliente(nomeCliente, rendaMensal);
                    System.out.println("Qual a conta o cliente deseja abrir? (C = Corrente / P = Poupança)");
                    char resposta = in.next().toLowerCase().charAt(0);
                    if (resposta == 'c') {
                        System.out.println("Deseja adicionar um saldo inicial? (s/n)");
                        resposta = in.next().toLowerCase().charAt(0);
                        if (resposta == 's') {
                            System.out.println("Quanto? ");
                            validaDouble(in);
                            valor = in.nextDouble();
                            Conta conta = new Corrente(cliente, gerente, valor);
                            sistemaDeContas.put(conta.getId(), conta);
                        } else {
                            Conta conta = new Corrente(cliente, gerente, 0);
                            sistemaDeContas.put(conta.getId(), conta);
                        }
                    } else if (resposta == 'p') {
                        System.out.println("Deseja adicionar um saldo inicial? (s/n)");
                        resposta = in.next().toLowerCase().charAt(0);
                        if (resposta == 's') {
                            System.out.println("Quanto? ");
                            validaDouble(in);
                            valor = in.nextDouble();
                            Conta conta = new Poupanca(cliente, gerente, valor);
                            sistemaDeContas.put(conta.getId(), conta);
                        } else {
                            Conta conta = new Poupanca(cliente, gerente, 0);
                            sistemaDeContas.put(conta.getId(), conta);
                        }
                    } else {
                        System.out.println("Erro, resposta inválida");
                    }
                    break;

                case 2:
                    System.out.println("=== ACESSAR CONTA ===");
                    System.out.println("Qual é o ID?");
                    validaInteiro(in);
                    id = in.next();
                    if (sistemaDeContas.containsKey(id)) {
                        Conta contaSelecionada = sistemaDeContas.get(id);
                        System.out.println(contaSelecionada.toString());
                        sistemaLoopInterno = true;
                        System.out.println("Qual operação você deseja fazer? ");
                        while (sistemaLoopInterno) {
                            System.out.println("1: Listar Extrato / 2: Saque / 3: Deposito / 4: AdicionarLimiteChequeEspecial / 0: Retornar ao menu");
                            validaInteiro(in);
                            opAninhada = in.nextInt();
                            switch (opAninhada) {
                                case 0:
                                    System.out.println("=== RETORNANDO AO MENU PRINCIPAL ===");
                                    sistemaLoopInterno = false;
                                    break;
                                case 1:
                                    System.out.println("=== EXTRATO ===");
                                    contaSelecionada.listarExtrato();
                                    break;
                                case 2:
                                    System.out.println("=== SAQUE ===");
                                    System.out.println("Qual o valor do saque?");
                                    validaDouble(in);
                                    valor = in.nextDouble();
                                    contaSelecionada.realizarSaque(valor);
                                    break;
                                case 3:
                                    System.out.println("== DEPOSITO ==");
                                    System.out.println("Qual o valor do depósito?");
                                    validaDouble(in);
                                    valor = in.nextDouble();
                                    contaSelecionada.depositar(valor);
                                    break;
                                case 4:
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
                case 3:
                    System.out.println("=== LISTAR TUDO ===");
                    for (Map.Entry<String, Conta> contas : sistemaDeContas.entrySet()) {
                        System.out.println(contas.getValue().toString());
                        System.out.println("==========================");
                    }
                    break;
                case 4:
                    System.out.println("=== ENCERRAR CONTA ===");
                    System.out.println("Digite o ID da sua conta: ");
                    validaInteiro(in);
                    id = in.next();
                    if (sistemaDeContas.containsKey(id)) {
                        Conta contaSelecionada = sistemaDeContas.get(id);
                        if (contaSelecionada.checaConta()) {
                            System.out.println("Conta " + id + " removida com sucesso");
                            sistemaDeContas.remove(id);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Conta não encontrada");
                        break;
                    }
                default:
                    System.out.println("Valor informado incorreto!");
            }

        }

    }
}
