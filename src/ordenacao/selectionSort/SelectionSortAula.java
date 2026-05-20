package ordenacao.selectionSort;

public class SelectionSortAula {

    public int[] ordenar (int[] dados, String nomeConjunto){
        System.out.println("Ordenando conjunto: " + nomeConjunto);

        // Medição do tempo de início da operação total
        long tempoInicioTotal = System.nanoTime();

        int n = dados.length;

        // Algoritmo Selection Sort
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;

            // Procura o menor elemento no restante do vetor
            for (int j = i + 1; j < n; j++) {
                if (dados[j] < dados[indiceMinimo]) {
                    indiceMinimo = j;
                }
            }

            // Realiza a troca do elemento atual pelo menor encontrado
            int temp = dados[indiceMinimo];
            dados[indiceMinimo] = dados[i];
            dados[i] = temp;
        }

        // Medição do tempo final
        long tempoFimTotal = System.nanoTime();
        // Converte o tempo total de nano para milissegundos
        double tempoTotalExecucaoMs = (tempoFimTotal - tempoInicioTotal) / 1_000_000.0;

        System.out.println("Tempo total para " + nomeConjunto + " em milisegundos: " + tempoTotalExecucaoMs + " ms\n");

        return dados;
    }
}