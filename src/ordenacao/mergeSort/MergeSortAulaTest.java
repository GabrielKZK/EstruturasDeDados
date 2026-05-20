package ordenacao.mergeSort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortAulaTest {

    MergeSortAula mergeSort = new MergeSortAula();

    int[] v11, v12, v13;
    int[] v21, v22, v23;
    int[] v31, v32, v33;

    @BeforeEach
    void gerarDados(){

        v11 = gerarOrdenado(50);
        v12 = gerarAleatorio(50);
        v13 = gerarInverso(50);

        v21 = gerarOrdenado(500);
        v22 = gerarAleatorio(500);
        v23 = gerarInverso(500);

        v31 = gerarOrdenado(500000);
        v32 = gerarAleatorio(500000);
        v33 = gerarInverso(500000);
    }

    @Test
    void testVetorPequeno() {

        int[] r11 = mergeSort.ordenar(v11, "v11 (50 - Ordenado)");
        assertTrue(estaOrdenado(r11));

        int[] r12 = mergeSort.ordenar(v12, "v12 (50 - Aleatório)");
        assertTrue(estaOrdenado(r12));

        int[] r13 = mergeSort.ordenar(v13, "v13 (50 - Inverso)");
        assertTrue(estaOrdenado(r13));
    }

    @Test
    void testVetorMedio() {

        int[] r21 = mergeSort.ordenar(v21, "v21 (500 - Ordenado)");
        assertTrue(estaOrdenado(r21));

        int[] r22 = mergeSort.ordenar(v22, "v22 (500 - Aleatório)");
        assertTrue(estaOrdenado(r22));

        int[] r23 = mergeSort.ordenar(v23, "v23 (500 - Inverso)");
        assertTrue(estaOrdenado(r23));
    }

    @Test
    void testVetorGrande() {

        int[] r31 = mergeSort.ordenar(v31, "v31 (500000 - Ordenado)");
        assertTrue(estaOrdenado(r31));

        int[] r32 = mergeSort.ordenar(v32, "v32 (500000 - Aleatório)");
        assertTrue(estaOrdenado(r32));

        int[] r33 = mergeSort.ordenar(v33, "v33 (500000 - Inverso)");
        assertTrue(estaOrdenado(r33));
    }

    private boolean estaOrdenado(int[] vetor) {

        for (int i = 0; i < vetor.length - 1; i++) {

            if (vetor[i] > vetor[i + 1]) {
                return false;
            }
        }

        return true;
    }

    int[] gerarOrdenado(int tamanho){

        int[] v = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            v[i] = i + 1;
        }

        return v;
    }

    int[] gerarInverso(int tamanho){

        int[] v = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            v[i] = tamanho - i;
        }

        return v;
    }

    int[] gerarAleatorio(int tamanho){

        int[] v = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            v[i] = (int) (Math.random() * tamanho);
        }

        return v;
    }
}