package models;

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
    public void init(){
        pilha = PilhaLivro.builder().build();
        l1 = new Livro("titulo 1", 100, 2015);
        l2 = new Livro("titulo 2", 200, 2020);
        l3 = new Livro("titulo 3", 300, 2030);
    }
    @Test
    @Description("Teste inserção pilha vazia")
    void insereEmPilhaVazia(){
        pilha.push(l1);
        pilha.push(l2);
        pilha.push(l3);

        Livro topo = pilha.peek();
        assertEquals(l3.getTitulo(), topo.getTitulo());

    }

}