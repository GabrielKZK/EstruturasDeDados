package filas.prioridade;

public class FilaPessoaPrioridade {

    public PessoaPrioridade inicio; // Public para o teste enxergar direto
    public PessoaPrioridade fim;    // Public para o teste enxergar direto

    public boolean isEmpty() {
        return inicio == null;
    }

    public void enqueue(PessoaPrioridade novaPessoa) {
        // Caso 1: Fila vazia
        if (isEmpty()) {
            inicio = novaPessoa;
            fim = novaPessoa;
            return;
        }

        // Caso 2: Nova pessoa tem prioridade MAIOR que o início (vai para a frente)
        if (novaPessoa.prioridade > inicio.prioridade) {
            novaPessoa.proximo = inicio;
            inicio = novaPessoa;
            return;
        }

        // Caso 3: Procurar o lugar certo no meio ou fim
        PessoaPrioridade atual = inicio;
        while (atual.proximo != null && atual.proximo.prioridade >= novaPessoa.prioridade) {
            atual = atual.proximo;
        }

        // Insere
        novaPessoa.proximo = atual.proximo;
        atual.proximo = novaPessoa;

        // Se inseriu depois do antigo fim, atualiza o ponteiro fim
        if (novaPessoa.proximo == null) {
            fim = novaPessoa;
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
        if (isEmpty()) return "";
        String ret = "";
        PessoaPrioridade aux = inicio;
        while (aux != null) {
            ret += aux.nome + " | ";
            aux = aux.proximo;
        }
        return ret;
    }
}