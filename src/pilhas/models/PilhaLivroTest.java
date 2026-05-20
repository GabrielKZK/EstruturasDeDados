package pilhas.models;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilhaLivroTest {

    PilhaLivro pilha;
    Livro l1;
    Livro l2;
    Livro l3;

    @BeforeEach
    public void initTest(){
        pilha = PilhaLivro.builder().build();
        l1 = new Livro("titulo1", 200, 2030, null);
        l2 = new Livro("titulo2", 200, 2020, null);
        l3 = new Livro("titulo3", 300, 2030, null);
    }

    @Test
    @Description("Teste inserção com pilha vazia")
    void insereEmPilhaVaziaTest(){
        pilha.push(l1);
        pilha.push(l2);
        pilha.push(l3);
        Livro topo = pilha.peek();
        assertEquals(l3.getTitulo(), topo.getTitulo());
    }

    @Test
    @Description("Teste de remoção da pilha")
    void removePilhaTest(){
        pilha.push(l1);
        pilha.push(l2);
        pilha.push(l3);
        pilha.pop();
        assertEquals(l2.getTitulo(), pilha.peek().getTitulo());
        pilha.pop();
        assertEquals(l1.getTitulo(), pilha.peek().getTitulo());
        pilha.pop();
        assertTrue(pilha.isEmpty());
    }
}