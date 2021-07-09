package dia8.exercicio02;

import javax.swing.plaf.IconUIResource;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        //Variáveis
        Scanner in = new Scanner(System.in);
        boolean agendaLoop = true;
        Agenda agenda = new Agenda();
        int escolha;
        String nome;
        int idade;
        float altura;
        int indice;

        System.out.println("=== Bem vindo a sua agenda ===");

        //Loop para rodar o sistema
        while (agendaLoop) {
            System.out.println("1: Add / 2: Remover / 3: Buscar (Nome) / 4: Listar Tudo / 5: Buscar (Índice) / 0: Sair");
            if (!in.hasNextInt()) {
                System.out.println("ERRO! O valor informado deve ser um número inteiro");
                in.nextLine();
                continue;
            }
            escolha = in.nextInt();
            in.nextLine();
            switch (escolha) {
                case 0:
                    System.out.println("->SAIR DA AGENDA<-");
                    agendaLoop = false;
                    break;
                case 1:
                    System.out.println("->ADICIONAR CONTATO<-");
                    System.out.println("Nome: ");
                    nome = in.nextLine();
                    System.out.println("Idade: ");
                    idade = in.nextInt();
                    System.out.println("Altura: ");
                    altura = in.nextFloat();
                    agenda.armazenaPessoa(nome, idade, altura);
                    break;
                case 2:
                    System.out.println("->REMOVER CONTATO<-");
                    System.out.println("Digite o nome do contato para ser excluido: ");
                    nome = in.nextLine();
                    agenda.removePessoa(nome);
                    break;
                case 3:
                    System.out.println("->BUSCAR CONTATO (NOME)<-");
                    System.out.println("Digite o nome do contato para ser encontrado: ");
                    nome = in.nextLine();
                    //PRINT FINAL PORQUE O MÉTODO RETORNA UM INT AO INVÉS DE VOID COMO OS OUTROS
                    if (agenda.buscaPessoa(nome) >= 0) {
                        System.out.println("O índice da pessoa na agenda é: " + agenda.buscaPessoa(nome));
                    } else {
                        System.out.println("Nenhum contato com este índice foi encontrado.");
                    }
                    break;
                case 4:
                    System.out.println("->LISTAR TODOS OS CONTATOS<-");
                    agenda.imprimeAgenda();
                    break;
                case 5:
                    System.out.println("->BUSCAR CONTATO (ÍNDICE)<-");
                    System.out.println("Digite o índice do contato para ser encontrado: ");
                    indice = in.nextInt();
                    agenda.imprimePessoa(indice);
                    break;
                default:
                    System.out.println("Número inválido!");
            }
        }
    }
}
