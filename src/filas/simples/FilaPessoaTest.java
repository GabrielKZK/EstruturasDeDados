package filas.simples;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FilaPessoaTest {

    FilaPessoa fila;
    Pessoa p1;
    Pessoa p2;
    Pessoa p3;

    @BeforeEach
    void init(){
        fila = new FilaPessoa();
        p1 = new Pessoa("Joao", null);
        p2 = new Pessoa("Santana", null);
        p3 = new Pessoa("Felipao", null);
    }

    @Test
    void insereTest(){
        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);
        assertEquals("Joao", fila.inicio.getNome());
        assertEquals("Felipao", fila.fim.getNome());

    }

    @Test
    void removeTest(){
        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);
        fila.dequeu();
        assertEquals("Santana", fila.inicio.getNome());
        assertEquals("Felipao", fila.fim.getNome());
        fila.dequeu();
        assertEquals("Felipao", fila.inicio.getNome());
        assertEquals("Felipao", fila.fim.getNome());
        fila.dequeu();
        assertTrue(fila.isEmpty());
    }

    @Test
    void viewTest(){
        fila.enqueue(p2);
        fila.enqueue(p3);
        fila.enqueue(p1);
        assertEquals("Santana | Felipao | Joao | ", fila.view());
    }


}
