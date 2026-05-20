package ordenacao.insertionSort;

public class InsertionSortAula {

    public int[] ordenar(int[] dados, String nomeConjunto) {
        System.out.println("Ordenando conjunto: " + nomeConjunto);

        // Medição do tempo de início da operação total
        long tempoInicioTotal = System.nanoTime();

        int n = dados.length;

        // Algoritmo Insertion Sort
        for (int i = 1; i < n; i++) {
            int chave = dados[i];
            int j = i - 1;

            /* Move os elementos de dados[0..i-1] que são maiores que a chave
               para uma posição à frente de sua posição atual */
            while (j >= 0 && dados[j] > chave) {
                dados[j + 1] = dados[j];
                j = j - 1;
            }
            dados[j + 1] = chave;
        }

        // Medição do tempo final
        long tempoFimTotal = System.nanoTime();
        // Converte o tempo total de nano para milissegundos
        double tempoTotalExecucaoMs = (tempoFimTotal - tempoInicioTotal) / 1_000_000.0;

        System.out.println("Tempo total para " + nomeConjunto + " em milisegundos: " + tempoTotalExecucaoMs + " ms\n");

        return dados;
    }
}