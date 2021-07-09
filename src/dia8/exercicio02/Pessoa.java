package dia8.exercicio02;

public class Pessoa {
    //Atributos

    private String nome;
    private int idade;
    private float altura;

    //Construtor
    public Pessoa(String nome, int idade, float altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    //Métodos
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome
                + ", Idade: " + this.idade
                + ", Altura: " + this.altura;
    }


}
