package ordenacao.bubbleSort;

public class BubbleSortAula {

    public int[] ordenar(int[] dados, String nomeConjunto) {

        System.out.println("Iniciando ordenação do conjunto: " + nomeConjunto);

        long tempoInicioTotal = System.nanoTime();

        int n = dados.length;

        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (dados[j] > dados[j + 1]) {

                    int temp = dados[j];
                    dados[j] = dados[j + 1];
                    dados[j + 1] = temp;
                }
            }
        }

        long tempoFimTotal = System.nanoTime();

        double tempoTotalExecucaoMs =
                (tempoFimTotal - tempoInicioTotal) / 1_000_000.0;

        System.out.println("Tempo total para "
                + nomeConjunto + ": "
                + tempoTotalExecucaoMs + " ms\n");

        return dados;
    }
}