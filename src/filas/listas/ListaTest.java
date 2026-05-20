package filas.listas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaTest {

    Lista lista;

    @BeforeEach
    void init(){
        lista = new Lista();
    }

    @Test
    void addTest(){
        assertTrue(lista.isEmpty());
        lista.add(new No("A"));
        lista.add(new No("B"));
        lista.add(new No("C"));
        lista.add(new No("D"));
        assertFalse(lista.isEmpty());
        assertEquals(4, lista.qtd);
        assertEquals("A|B|C|D|", lista.view());
    }

    @Test
    void removeTest(){
        assertTrue(lista.isEmpty());
        lista.add(new No("A"));
        lista.add(new No("B"));
        lista.add(new No("C"));
        lista.add(new No("D"));
        lista.remove(0);
        assertEquals("B|C|D|", lista.view());

    }

}