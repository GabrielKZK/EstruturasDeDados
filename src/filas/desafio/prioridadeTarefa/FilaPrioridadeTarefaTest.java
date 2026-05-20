package filas.desafio.prioridadeTarefa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilaPrioridadeTarefaTest {

    FilaPrioridadeTarefa fila;
    TarefaPrioridade t1;
    TarefaPrioridade t2;
    TarefaPrioridade t3;

    @BeforeEach
    void init() {
        fila = new FilaPrioridadeTarefa();

        t1 = new TarefaPrioridade("Tarefa A", 100.0, 1);
        t2 = new TarefaPrioridade("Tarefa B", 300.0, 10);
        t3 = new TarefaPrioridade("Tarefa C", 200.0, 5);
    }

    @Test
    void filaVaziaTest() {
        assertTrue(fila.isEmpty());
        assertEquals(0, fila.quantidadeTarefas());
        assertEquals(0.0, fila.valorTotal());
    }

    @Test
    void inserePrioridadeTest() {
        fila.enqueue(t1);
        fila.enqueue(t2);
        fila.enqueue(t3);

        assertEquals("Tarefa B", fila.inicio.identificador);
        assertEquals("Tarefa A", fila.fim.identificador);
    }

    @Test
    void repetidoTest() {
        TarefaPrioridade t4 = new TarefaPrioridade("Tarefa D", 150.0, 5);

        fila.enqueue(t3);
        fila.enqueue(t4);

        assertEquals("Tarefa C", fila.inicio.identificador);
        assertEquals("Tarefa D", fila.inicio.proximo.identificador);
    }

    @Test
    void viewTest() {
        fila.enqueue(t1);
        fila.enqueue(t2);
        fila.enqueue(t3);

        assertEquals("Tarefa B | Tarefa C | Tarefa A | ", fila.view());
    }

    @Test
    void quantidadeTarefasTest() {
        fila.enqueue(t1);
        fila.enqueue(t2);
        fila.enqueue(t3);

        assertEquals(3, fila.quantidadeTarefas());
    }

    @Test
    void valorTotalTest() {
        fila.enqueue(t1);
        fila.enqueue(t2);
        fila.enqueue(t3);

        assertEquals(600.0, fila.valorTotal());
    }

    @Test
    void dequeueTest() {
        fila.enqueue(t1);
        fila.enqueue(t2);
        fila.enqueue(t3);

        fila.dequeue();

        assertEquals("Tarefa C", fila.inicio.identificador);
        assertEquals(2, fila.quantidadeTarefas());
        assertEquals(300.0, fila.valorTotal());
    }

    @Test
    void dequeueUltimoElementoTest() {
        fila.enqueue(t1);

        fila.dequeue();

        assertTrue(fila.isEmpty());
        assertEquals(0, fila.quantidadeTarefas());
        assertEquals(0.0, fila.valorTotal());
    }
}