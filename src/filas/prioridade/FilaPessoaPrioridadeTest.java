package filas.prioridade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilaPessoaPrioridadeTest {

    FilaPessoaPrioridade fila;
    PessoaPrioridade p1;
    PessoaPrioridade p2;
    PessoaPrioridade p3;

    @BeforeEach
    void init() {
        fila = new FilaPessoaPrioridade();

        p1 = new PessoaPrioridade("Joao", 1);
        p2 = new PessoaPrioridade("Santana", 10);
        p3 = new PessoaPrioridade("Felipao", 5);
    }

    @Test
    void inserePrioridadeTest() {
        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);

        // No início deve estar o de maior prioridade
        assertEquals("Santana", fila.inicio.nome);
        // No fim deve estar o de menor prioridade
        assertEquals("Joao", fila.fim.nome);
    }

    @Test
    void repetidoTest() {
        PessoaPrioridade p4 = new PessoaPrioridade("Clone", 5);

        fila.enqueue(p3);
        fila.enqueue(p4);

        assertEquals("Felipao", fila.inicio.nome);
        assertEquals("Clone", fila.inicio.proximo.nome);
    }

    @Test
    void viewTest() {
        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);

        assertEquals("Santana | Felipao | Joao | ", fila.view());
    }
}