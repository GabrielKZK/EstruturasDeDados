package filas.provaGerenciamentoDados;

import filas.desafio.prioridadeTarefa.TarefaPrioridade;

public class GerenciamentoLogisticoNo {

    public int idPedido;
    public double valorFrete;
    public int prioridade;
    public GerenciamentoLogisticoNo proximo;

    public GerenciamentoLogisticoNo (int idPedido, double valorFrete, int prioridade){
        this.idPedido = idPedido;
        this.valorFrete = valorFrete;
        this.prioridade = prioridade;
        this.proximo = null;
    }

}
