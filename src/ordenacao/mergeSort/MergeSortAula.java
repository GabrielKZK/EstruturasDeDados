package ordenacao.mergeSort;

public class MergeSortAula {

    public int[] ordenar(int[] dados, String nomeConjunto) {

        System.out.println("Iniciando ordenação do conjunto: " + nomeConjunto);

        long tempoInicioTotal = System.nanoTime();

        mergeSort(dados, 0, dados.length - 1);

        long tempoFimTotal = System.nanoTime();

        double tempoTotalExecucaoMs =
                (tempoFimTotal - tempoInicioTotal) / 1_000_000.0;

        System.out.println("Tempo total para "
                + nomeConjunto + ": "
                + tempoTotalExecucaoMs + " ms\n");

        return dados;
    }

    private void mergeSort(int[] dados, int inicio, int fim) {

        if (inicio < fim) {

            int meio = (inicio + fim) / 2;

            mergeSort(dados, inicio, meio);
            mergeSort(dados, meio + 1, fim);

            merge(dados, inicio, meio, fim);
        }
    }

    private void merge(int[] dados, int inicio, int meio, int fim) {

        int tamanhoEsquerda = meio - inicio + 1;
        int tamanhoDireita = fim - meio;

        int[] esquerda = new int[tamanhoEsquerda];
        int[] direita = new int[tamanhoDireita];

        for (int i = 0; i < tamanhoEsquerda; i++) {
            esquerda[i] = dados[inicio + i];
        }

        for (int j = 0; j < tamanhoDireita; j++) {
            direita[j] = dados[meio + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = inicio;

        while (i < tamanhoEsquerda && j < tamanhoDireita) {

            if (esquerda[i] <= direita[j]) {
                dados[k] = esquerda[i];
                i++;
            } else {
                dados[k] = direita[j];
                j++;
            }

            k++;
        }

        while (i < tamanhoEsquerda) {
            dados[k] = esquerda[i];
            i++;
            k++;
        }

        while (j < tamanhoDireita) {
            dados[k] = direita[j];
            j++;
            k++;
        }
    }
}