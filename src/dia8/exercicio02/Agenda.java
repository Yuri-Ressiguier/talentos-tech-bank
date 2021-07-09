package dia8.exercicio02;

import java.util.ArrayList;
import java.util.List;

public class Agenda {
    //Crie uma classe Agenda que pode armazenar 10 pessoas e que seja capaz de realizar as seguintes operações:
    //void armazenaPessoa(String nome, int idade, float altura);
    //void removePessoa(String nome);
    //int buscaPessoa(String nome); // informa em que posição da agenda está a pessoa
    //void imprimeAgenda(); // imprime os dados de todas as pessoas da agenda
    //void imprimePessoa(int index); // imprime os dados da pessoa que está na posição “i” da agenda.


    //Atributos
    private int capacidade;
    private List<Pessoa> contatos =  new ArrayList<>();

    //Construtor
    public Agenda() {
        this.capacidade = 10;
    }

    //Métodos
    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void armazenaPessoa(String nome, int idade, float altura) {
        contatos.add(new Pessoa(nome, idade, altura));
        System.out.println("Contato adicionado com sucesso");
    }

    public void removePessoa(String nome) {
        //contatos.removeIf(pessoa -> pessoa.getNome().equals(nome));

        for (Pessoa pessoa : contatos) {
            if (pessoa.getNome().equals(nome)) {
                contatos.remove(pessoa);
                System.out.println("O contato " + pessoa.getNome() + " foi removido da agenda.");
                return;
            }
        }
        System.out.println("Nenhum contato com este nome foi encontrado.");
    }

    public int buscaPessoa(String nome) {

        for (Pessoa pessoa : contatos) {
            if (pessoa.getNome().equals(nome)) {
                return contatos.indexOf(pessoa);
            }
        }
        return -1;

    }

    public void imprimeAgenda() {
        if (contatos.size() >= 1) {
            for (Pessoa pessoa : contatos) {
                System.out.println(pessoa.toString());
            }
        } else {
            System.out.println("Desculpe, a lista está vazia");
        }

    }

    public void imprimePessoa(int index) {
        if (index >= 0 && index <= contatos.size()-1) {
            System.out.println(contatos.get(index).toString());
        } else {
            System.out.println("Nenhum contato com este índice foi encontrado.");
        }
    }

    @Override
    public String toString() {
        return "Total contatos da agenda: " + contatos.size() + ". Capacidade de contatos: " + capacidade;
    }




}
