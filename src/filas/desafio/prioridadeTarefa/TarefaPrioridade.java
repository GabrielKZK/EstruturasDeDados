package filas.desafio.prioridadeTarefa;

public class TarefaPrioridade {

    public String identificador;
    public double valor;
    public int prioridade;
    public TarefaPrioridade proximo;

    public TarefaPrioridade(String identificador, double valor, int prioridade) {
        this.identificador = identificador;
        this.valor = valor;
        this.prioridade = prioridade;
        this.proximo = null;
    }
}