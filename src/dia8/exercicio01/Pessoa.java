package dia8.exercicio01;

public class Pessoa {
    // Crie uma classe para representar uma pessoa, com os atributos de nome, ano de nascimento e altura.
    // Crie e também um método para imprimir todos dados de uma pessoa.
    // Crie um método para mostrar quantos anos a pessoa fará/terá neste ano.

    //Atributos
    private String nome;
    private int anoNascimento;
    private double altura;

    //Construtor
    public Pessoa(String nome, int anoNascimento, double altura) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.altura = altura;
    }

    //Métodos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome
                + ", Ano de nascimento: " + this.anoNascimento
                + ", Altura: " + this.altura;
    }

    public int anosEsteAno() {
        return 2021 - this.anoNascimento;
    }


}
