package ordenacao.selectionSort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortAulaTest {

    // Instância necessária para chamar o algoritmo (Alterado para SelectionSort)
    SelectionSortAula selectionSort = new SelectionSortAula();

    int[] v11 = new int[50];
    int[] v12 = new int[50];
    int[] v13 = new int[50];

    int[] v21 = new int[500];
    int[] v22 = new int[500];
    int[] v23 = new int[500];

    int[] v31 = new int[500000];
    int[] v32 = new int[500000];
    int[] v33 = new int[500000];

    @BeforeEach
    void gerarDados(){
        v11 = gerarOrdenado(50);
        v12 = gerarAleatorio(50);
        v13 = gerarInverso(50);

        v21 = gerarOrdenado(500);
        v22 = gerarAleatorio(500);
        v23 = gerarInverso(500);

        v31 = gerarOrdenado(50000);
        v32 = gerarAleatorio(50000);
        v33 = gerarInverso(50000);
    }

    // --- MÉTODOS DE TESTE ATUALIZADOS PARA VALIDAÇÃO DINÂMICA ---

    @Test
    void testVetorPequeno() {
        int[] r11 = selectionSort.ordenar(v11, "v11 (50 - Ordenado)");
        assertTrue(estaOrdenado(r11), "O vetor v11 não foi ordenado corretamente!");

        int[] r12 = selectionSort.ordenar(v12, "v12 (50 - Aleatório)");
        assertTrue(estaOrdenado(r12), "O vetor v12 não foi ordenado corretamente!");

        int[] r13 = selectionSort.ordenar(v13, "v13 (50 - Inverso)");
        assertTrue(estaOrdenado(r13), "O vetor v13 não foi ordenado corretamente!");
    }

    @Test
    void testVetorMedio() {
        int[] r21 = selectionSort.ordenar(v21, "v21 (500 - Ordenado)");
        assertTrue(estaOrdenado(r21), "O vetor v21 não foi ordenado corretamente!");

        int[] r22 = selectionSort.ordenar(v22, "v22 (500 - Aleatório)");
        assertTrue(estaOrdenado(r22), "O vetor v22 não foi ordenado corretamente!");

        int[] r23 = selectionSort.ordenar(v23, "v23 (500 - Inverso)");
        assertTrue(estaOrdenado(r23), "O vetor v23 não foi ordenado corretamente!");
    }

    @Test
    void testVetorGrande() {
        int[] r31 = selectionSort.ordenar(v31, "v31 (500000 - Ordenado)");
        assertTrue(estaOrdenado(r31), "O vetor v31 não foi ordenado corretamente!");

        int[] r32 = selectionSort.ordenar(v32, "v32 (500000 - Aleatório)");
        assertTrue(estaOrdenado(r32), "O vetor v32 não foi ordenado corretamente!");

        int[] r33 = selectionSort.ordenar(v33, "v33 (500000 - Inverso)");
        assertTrue(estaOrdenado(r33), "O vetor v33 não foi ordenado corretamente!");
    }

    // --- MÉTODO AUXILIAR DE VALIDAÇÃO ---

    private boolean estaOrdenado(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            if (vetor[i] > vetor[i + 1]) {
                return false;
            }
        }
        return true;
    }

    // --- SEUS MÉTODOS ORIGINAIS DE GERAÇÃO ABAIXO ---

    int[] gerarOrdenado(int tamanho){
        int[] v = new int[tamanho];
        for (int i = 0; i <tamanho; i++){
            v[i] = i + 1;
        }
        return v;
    }

    int[] gerarInverso(int tamanho){
        int[] v = new int[tamanho];
        for (int i = tamanho - 1; i >= 0; i--){
            v[i] = tamanho - i - 1;
        }
        return v;
    }

    int[] gerarAleatorio(int tamanho){
        int[] v = new int[tamanho];
        for (int i = 0; i < tamanho; i++){
            v[i] = (int) (Math.random() * tamanho);
        }
        return v;
    }

}