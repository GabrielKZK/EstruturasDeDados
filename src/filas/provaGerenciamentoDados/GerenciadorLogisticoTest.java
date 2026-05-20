package filas.provaGerenciamentoDados;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GerenciadorLogisticoTest {

    GerenciadorLogistico gerenciador;
    GerenciamentoLogisticoNo p1;
    GerenciamentoLogisticoNo p2;
    GerenciamentoLogisticoNo p3;

    @BeforeEach
    void init() {
        gerenciador = new GerenciadorLogistico();

        p1 = new GerenciamentoLogisticoNo(1, 100.0, 1);
        p2 = new GerenciamentoLogisticoNo(2, 300.0, 10);
        p3 = new GerenciamentoLogisticoNo(3, 200.0, 5);
    }

    @Test
    void filaVaziaTest() {
        assertTrue(gerenciador.isEmptyFila());
        assertTrue(gerenciador.isEmptyPilha());
        assertEquals("", gerenciador.viewFila());
        assertEquals("", gerenciador.viewHistorico());
    }

    @Test
    void receberPedidoPrioridadeTest() {
        gerenciador.receberPedido(p1.idPedido, p1.valorFrete, p1.prioridade);
        gerenciador.receberPedido(p2.idPedido, p2.valorFrete, p2.prioridade);
        gerenciador.receberPedido(p3.idPedido, p3.valorFrete, p3.prioridade);

        assertEquals(2, gerenciador.filaPrioridade.idPedido);
        assertEquals(1, gerenciador.fimFila.idPedido);
    }

    @Test
    void repetidoTest() {
        GerenciamentoLogisticoNo p4 = new GerenciamentoLogisticoNo(4, 150.0, 5);

        gerenciador.receberPedido(p3.idPedido, p3.valorFrete, p3.prioridade);
        gerenciador.receberPedido(p4.idPedido, p4.valorFrete, p4.prioridade);

        assertEquals(3, gerenciador.filaPrioridade.idPedido);
        assertEquals(4, gerenciador.filaPrioridade.proximo.idPedido);
    }

    @Test
    void viewFilaTest() {
        gerenciador.receberPedido(p1.idPedido, p1.valorFrete, p1.prioridade);
        gerenciador.receberPedido(p2.idPedido, p2.valorFrete, p2.prioridade);
        gerenciador.receberPedido(p3.idPedido, p3.valorFrete, p3.prioridade);

        assertEquals("2 | 3 | 1 | ", gerenciador.viewFila());
    }

    @Test
    void processarProximoTest() {
        gerenciador.receberPedido(p1.idPedido, p1.valorFrete, p1.prioridade);
        gerenciador.receberPedido(p2.idPedido, p2.valorFrete, p2.prioridade);
        gerenciador.receberPedido(p3.idPedido, p3.valorFrete, p3.prioridade);

        gerenciador.processarProximo();

        assertEquals(3, gerenciador.filaPrioridade.idPedido);
        assertEquals(2, gerenciador.pilhaHistorico.idPedido);
    }

    @Test
    void viewHistoricoTest() {
        gerenciador.receberPedido(p1.idPedido, p1.valorFrete, p1.prioridade);
        gerenciador.receberPedido(p2.idPedido, p2.valorFrete, p2.prioridade);
        gerenciador.receberPedido(p3.idPedido, p3.valorFrete, p3.prioridade);

        gerenciador.processarProximo();
        gerenciador.processarProximo();

        assertEquals("3 | 2 | ", gerenciador.viewHistorico());
    }

    @Test
    void desfazerProcessamentoTest() {
        gerenciador.receberPedido(p1.idPedido, p1.valorFrete, p1.prioridade);
        gerenciador.receberPedido(p2.idPedido, p2.valorFrete, p2.prioridade);
        gerenciador.receberPedido(p3.idPedido, p3.valorFrete, p3.prioridade);

        gerenciador.processarProximo();
        gerenciador.desfazerProcessamento();

        assertEquals("2 | 3 | 1 | ", gerenciador.viewFila());
        assertEquals("", gerenciador.viewHistorico());
    }

    @Test
    void processarUltimoElementoTest() {
        gerenciador.receberPedido(p1.idPedido, p1.valorFrete, p1.prioridade);

        gerenciador.processarProximo();

        assertTrue(gerenciador.isEmptyFila());
        assertEquals("", gerenciador.viewFila());
        assertEquals("1 | ", gerenciador.viewHistorico());
    }
}