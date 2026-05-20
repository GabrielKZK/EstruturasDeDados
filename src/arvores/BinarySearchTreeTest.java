package arvores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    BinarySearchTree arvore;

    @BeforeEach
    void init(){
        arvore = new BinarySearchTree();
    }

    @Test
    void testeAVL(){
        int[] valores = {10, 20, 30, 40, 50, 25, 26};

        for (int v : valores) {
            arvore.inserir(v);
            arvore.exibir();
        }

        System.out.println("Removendo 40:");
        arvore.remover(40);
        arvore.exibir();
    }
}