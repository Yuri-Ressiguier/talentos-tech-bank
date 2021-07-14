package bancoDeMadeira;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Banco {

    //Atributos
    Map<String, Conta> sistemaDeContas = new LinkedHashMap<>();
    int id;

    public Banco(int id) {
        this.id=id;
    }

    public void criarContaCorrente(Cliente cliente, Gerente gerente, double valor) {
        Conta conta = new Corrente(cliente, gerente,this, valor);
        sistemaDeContas.put(conta.getId(), conta);
    }

    public void criarContaPoupanca(Cliente cliente, Gerente gerente, double valor) {
        Conta conta = new Poupanca(cliente, gerente, this, valor);
        sistemaDeContas.put(conta.getId(), conta);
    }

    public Conta acessarConta(String id) {
        if (sistemaDeContas.containsKey(id)) {
            return sistemaDeContas.get(id);
        } else {
            return null;
        }
    }

    public void listarContas() {
        for (Map.Entry<String, Conta> contas : sistemaDeContas.entrySet()) {
            System.out.println(contas.getValue().toString());
            System.out.println("==========================");
        }
    }

    public void encerrarConta(String id) {
        if (sistemaDeContas.containsKey(id)) {
            Conta contaSelecionada = sistemaDeContas.get(id);
            if (contaSelecionada.checaConta()) {
                System.out.println("Conta " + id + " removida com sucesso");
                sistemaDeContas.remove(id);
        } else {
                System.out.println("Conta não encontrada");
            }
        }
    }

    public void rendePoupanca() {
        for (Map.Entry<String, Conta> contas : sistemaDeContas.entrySet()) {
            if (contas.getValue() instanceof Poupanca) {
                ((Poupanca) contas.getValue()).adicionaRendimentos();   //Downcasting
            }
        }
    }
}
