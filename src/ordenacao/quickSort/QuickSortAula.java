package ordenacao.quickSort;

public class QuickSortAula {

    public int[] ordenar(int[] dados, String nomeConjunto) {

        System.out.println("Iniciando ordenação do conjunto: " + nomeConjunto);

        long tempoInicioTotal = System.nanoTime();

        quickSort(dados, 0, dados.length - 1);

        long tempoFimTotal = System.nanoTime();

        double tempoTotalExecucaoMs =
                (tempoFimTotal - tempoInicioTotal) / 1_000_000.0;

        System.out.println("Tempo total para "
                + nomeConjunto + ": "
                + tempoTotalExecucaoMs + " ms\n");

        return dados;
    }

    private void quickSort(int[] dados, int inicio, int fim) {

        if (inicio < fim) {

            int posicaoPivo = particionar(dados, inicio, fim);

            quickSort(dados, inicio, posicaoPivo - 1);

            quickSort(dados, posicaoPivo + 1, fim);
        }
    }

    private int particionar(int[] dados, int inicio, int fim) {

        int pivo = dados[fim];

        int i = inicio - 1;

        for (int j = inicio; j < fim; j++) {

            if (dados[j] < pivo) {

                i++;

                int temp = dados[i];
                dados[i] = dados[j];
                dados[j] = temp;
            }
        }

        int temp = dados[i + 1];
        dados[i + 1] = dados[fim];
        dados[fim] = temp;

        return i + 1;
    }
}