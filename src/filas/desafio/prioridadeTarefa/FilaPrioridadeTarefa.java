package filas.desafio.prioridadeTarefa;

public class FilaPrioridadeTarefa {

    public TarefaPrioridade inicio;
    public TarefaPrioridade fim;

    public boolean isEmpty() {
        return inicio == null;
    }

    public void enqueue(TarefaPrioridade novaTarefa) {
        // Caso 1: fila vazia
        if (isEmpty()) {
            inicio = novaTarefa;
            fim = novaTarefa;
            return;
        }

        // Caso 2: nova tarefa tem prioridade maior que a do início
        if (novaTarefa.prioridade > inicio.prioridade) {
            novaTarefa.proximo = inicio;
            inicio = novaTarefa;
            return;
        }

        // Caso 3: procurar posição correta
        TarefaPrioridade atual = inicio;
        while (atual.proximo != null && atual.proximo.prioridade >= novaTarefa.prioridade) {
            atual = atual.proximo;
        }

        novaTarefa.proximo = atual.proximo;
        atual.proximo = novaTarefa;

        // Atualiza o fim se inseriu no final
        if (novaTarefa.proximo == null) {
            fim = novaTarefa;
        }
    }

    public void dequeue() {
        if (!isEmpty()) {
            if (inicio == fim) {
                inicio = null;
                fim = null;
            } else {
                inicio = inicio.proximo;
            }
        }
    }

    public String view() {
        if (isEmpty()) {
            return "";
        }

        String ret = "";
        TarefaPrioridade aux = inicio;

        while (aux != null) {
            ret += aux.identificador + " | ";
            aux = aux.proximo;
        }

        return ret;
    }

    public int quantidadeTarefas() {
        int quantidade = 0;
        TarefaPrioridade aux = inicio;

        while (aux != null) {
            quantidade++;
            aux = aux.proximo;
        }

        return quantidade;
    }

    public double valorTotal() {
        double soma = 0;
        TarefaPrioridade aux = inicio;

        while (aux != null) {
            soma += aux.valor;
            aux = aux.proximo;
        }

        return soma;
    }
}