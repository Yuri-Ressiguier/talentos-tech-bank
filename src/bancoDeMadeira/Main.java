package bancoDeMadeira;
import java.time.Duration;
import java.time.LocalDateTime;
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
        LocalDateTime inicioPrograma;                               //Salva a data do início do sistema bancário


        Gerente gerente =  new Gerente(123123);                //Cria um gerente ficticio para aprovar Cheque Especial



        /*
        Programa base do programa:
        - Todas as contas tem opção de transferências sem taxas
        - A conta poupança rende 5% a cada dois minutos
        - A conta corrente pode realizar empréstimos de até 2x seu salário. (Juro de 5% por minuto)
        - As contas que necessitem de Cheque Especial devem consultar o gerente. (Juro fixo de 5%) Obs: Especial Secreto 10%


        Mostra um menu para o usuário selecionar:
        1 - Cria uma conta no banco
        2 - Acessa a conta através do ID
            2.1 - Mostra o status da conta
            2.2 - Lista o extrato mostrando as mudanças de saldo
            2.3 - Saca valores com limite máximo de saldo + limite cheque especial
            2.4 - Deposito
            2.5 - Transferência (Pedir id de outro objeto)
            2.6 - Mostrar Rendimentos (Conta Poupança)
            2.7 - Solicita Empréstimo (Conta corrente)
            2.8 - Paga empréstimo (Conta corrente)
            2.9 - AdicionarLimiteChequeEspecial (Adiciona 30% do salário do cliente como limite do cheque especial)
            2.0 - Retornar ao menu principal
        3 - Lista todas as contas registradas no banco
        4 - Encerra a conta caso o saldos seja 0
        0 - Sai do programa
         */

        System.out.println("Bem vindo ao Banco de Madeira [MODO FUNCIONÁRIO] BETA (1.3)");
        inicioPrograma = LocalDateTime.now();
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
                    validaDouble(in);
                    double rendaMensal =  in.nextDouble();
                    if (rendaMensal < 0) {
                        System.out.println("A renda não pode ser negativa");
                        continue;
                    }
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
                            if (valor < 0) {
                                System.out.println("O valor inicial não pode ser negativo");
                                continue;
                            }
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
                            if (valor < 0) {
                                System.out.println("O valor inicial não pode ser negativo");
                                continue;
                            }
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
                            System.out.println("1: Mostrar Conta / 2: Listar Extrato / 3: Saque / 4: Deposito" +
                                    " / 5: Transferência / 6: Mostra Rendimentos (POUPANCA)");
                            System.out.println("7: Solicitação de empréstimo (CORRENTE) / 8: Pagamento de empréstimo (CORRENTE)" +
                                    " / 9: AdicionarLimiteChequeEspecial / 0: Retornar ao menu");
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
                                    if (valor < 0) {
                                        System.out.println("O valor inicial não pode ser negativo");
                                        continue;
                                    }
                                    contaSelecionada.realizarSaque(valor);
                                    break;
                                //Deposita valores
                                case 4:
                                    System.out.println("== DEPOSITO ==");
                                    System.out.println("Qual o valor do depósito?");
                                    validaDouble(in);
                                    valor = in.nextDouble();
                                    if (valor < 0) {
                                        System.out.println("O valor inicial não pode ser negativo");
                                        continue;
                                    }
                                    contaSelecionada.depositar(valor);
                                    break;
                                //Transfere dinheiro para outra conta
                                case 5:
                                    System.out.println("=== TRANSFERÊNCIA ===");
                                    System.out.println("Qual é o ID do favorecido? (4 dígitos)");
                                    id = in.next();
                                    System.out.println("Qual o valor da transferência?");
                                    validaDouble(in);
                                    valor = in.nextDouble();
                                    if (valor < 0) {
                                        System.out.println("O valor inicial não pode ser negativo");
                                        continue;
                                    }
                                    contaSelecionada.transferencia(id, valor);
                                    break;
                                //Mostra os rendimentos - Somente conta poupança
                                case 6:
                                    if (contaSelecionada instanceof Poupanca) {
                                        System.out.println("=== MOSTRA RENDIMENTOS ===");
                                        ((Poupanca) contaSelecionada).mostraRendimentos();
                                    } else {
                                        System.out.println("Esta área é somente para conta poupança");
                                    }
                                    break;
                                //Solicita empréstimo - Somente conta corrente
                                case 7:
                                    if (contaSelecionada instanceof Corrente) {
                                        System.out.println("=== SOLICITA EMPRÉSTIMO ===");
                                        System.out.println("Qual é o valor do empréstimo? ");
                                        System.out.println("Seu limite é de " + ((Corrente) contaSelecionada).getLimiteEmprestimo());
                                        validaDouble(in);
                                        valor = in.nextDouble();
                                        if (valor < 0) {
                                            System.out.println("O valor inicial não pode ser negativo");
                                            continue;
                                        }
                                        ((Corrente) contaSelecionada).setEmprestimo(valor);
                                    } else {
                                        System.out.println("Esta área é somente para conta corrente");
                                    }
                                    break;
                                //Paga o empréstimo realizado
                                case 8:
                                    if (contaSelecionada instanceof Corrente) {
                                        System.out.println("=== PAGAMENTO DE EMPRÉSTIMO ===");
                                        ((Corrente) contaSelecionada).pagaEmprestimo();
                                    } else {
                                        System.out.println("Esta área é somente para conta corrente");
                                    }
                                    break;
                                //Adiciona limite do cheque especial
                                case 9:
                                    System.out.println("== ADD LIMITE CHEQUE ESPECIAL ==");
                                    System.out.println("Esta operação necessita de um Gerente. Digite a senha do gerente desta conta: ");
                                    contaSelecionada.adicionarLimiteChequeEspecial(in.nextInt());
                                    break;
                                default:
                                    System.out.println("Valor informado incorreto!");
                            }
                            //O sistema adiciona o rendimento para as contas poupança
                            Duration duracao = Duration.between(inicioPrograma, LocalDateTime.now());
                            long diff = duracao.toMinutes();
                            if (diff >= 2) {
                                banco.rendePoupanca();
                                inicioPrograma = LocalDateTime.now();
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
            //O sistema adiciona o rendimento para as contas poupança
            Duration duracao = Duration.between(inicioPrograma, LocalDateTime.now());
            long diff = duracao.toMinutes();
            if (diff >= 2) {
                banco.rendePoupanca();
                inicioPrograma = LocalDateTime.now();
            }
        }

    }
}
