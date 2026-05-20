package filas.provaGerenciamentoDados;


public class GerenciadorLogistico {

    public GerenciamentoLogisticoNo filaPrioridade;
    public GerenciamentoLogisticoNo fimFila;

    public GerenciamentoLogisticoNo pilhaHistorico;

    public boolean isEmptyFila(){return filaPrioridade == null;}

    public boolean isEmptyPilha(){return pilhaHistorico == null;}

    public void receberPedido(int id, double valor, int prioridade){
        GerenciamentoLogisticoNo novoPedido = new GerenciamentoLogisticoNo(id, valor, prioridade);
        if (isEmptyFila()){
            filaPrioridade = novoPedido;
            fimFila = novoPedido;
            return;
        }

        if (novoPedido.prioridade > filaPrioridade.prioridade) {
            novoPedido.proximo = filaPrioridade;
            filaPrioridade = novoPedido;
            return;
        }

        GerenciamentoLogisticoNo atual = filaPrioridade;
        while(atual.proximo != null && atual.proximo.prioridade >= novoPedido.prioridade){
            atual = atual.proximo;
        }
        novoPedido.proximo = atual.proximo;
        atual.proximo = novoPedido;

        if (novoPedido.proximo == null){
            fimFila = novoPedido;
        }
    }

    public void processarProximo(){
        if (!isEmptyFila()){

            GerenciamentoLogisticoNo removido = filaPrioridade;

            if (filaPrioridade == fimFila){
                filaPrioridade = null;
                fimFila = null;
            }else {
                filaPrioridade = filaPrioridade.proximo;
            }

            removido.proximo = pilhaHistorico;
            pilhaHistorico = removido;
        }
    }

    public void desfazerProcessamento() {
        if (!isEmptyPilha()) {

            GerenciamentoLogisticoNo recuperado = pilhaHistorico;
            pilhaHistorico = pilhaHistorico.proximo;
            recuperado.proximo = null;

            // Reinsere na fila (mesma lógica do enqueue)
            if (isEmptyFila()) {
                filaPrioridade = recuperado;
                fimFila = recuperado;
                return;
            }

            if (recuperado.prioridade > filaPrioridade.prioridade) {
                recuperado.proximo = filaPrioridade;
                filaPrioridade = recuperado;
                return;
            }

            GerenciamentoLogisticoNo atual = filaPrioridade;

            while (atual.proximo != null && atual.proximo.prioridade >= recuperado.prioridade) {
                atual = atual.proximo;
            }

            recuperado.proximo = atual.proximo;
            atual.proximo = recuperado;

            if (recuperado.proximo == null) {
                fimFila = recuperado;
            }
        }
    }

    public String viewFila() {
        if (isEmptyFila()) {
            return "";
        }

        String ret = "";
        GerenciamentoLogisticoNo aux = filaPrioridade;

        while (aux != null) {
            ret += aux.idPedido + " | ";
            aux = aux.proximo;
        }

        return ret;
    }

    // Visualizar histórico (pilha)
    public String viewHistorico() {
        if (isEmptyPilha()) {
            return "";
        }

        String ret = "";
        GerenciamentoLogisticoNo aux = pilhaHistorico;

        while (aux != null) {
            ret += aux.idPedido + " | ";
            aux = aux.proximo;
        }

        return ret;
    }



}
