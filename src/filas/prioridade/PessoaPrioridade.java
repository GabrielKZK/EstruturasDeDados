package filas.prioridade;

public class PessoaPrioridade {
    public String nome;
    public int prioridade;
    public PessoaPrioridade proximo;

    public PessoaPrioridade(String nome, int prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
        this.proximo = null;
    }
}
