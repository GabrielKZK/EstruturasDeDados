package ordenacao.heapSort;

public class HeapSortAula {

    public int[] ordenar(int[] dados, String nomeConjunto) {

        System.out.println("Iniciando ordenação do conjunto: " + nomeConjunto);

        long tempoInicioTotal = System.nanoTime();

        int n = dados.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(dados, n, i);
        }

        for (int i = n - 1; i > 0; i--) {

            int temp = dados[0];
            dados[0] = dados[i];
            dados[i] = temp;

            heapify(dados, i, 0);
        }

        long tempoFimTotal = System.nanoTime();

        double tempoTotalExecucaoMs =
                (tempoFimTotal - tempoInicioTotal) / 1_000_000.0;

        System.out.println("Tempo total para "
                + nomeConjunto + ": "
                + tempoTotalExecucaoMs + " ms\n");

        return dados;
    }

    private void heapify(int[] dados, int tamanho, int raiz) {

        int maior = raiz;

        int esquerda = 2 * raiz + 1;
        int direita = 2 * raiz + 2;

        if (esquerda < tamanho && dados[esquerda] > dados[maior]) {
            maior = esquerda;
        }

        if (direita < tamanho && dados[direita] > dados[maior]) {
            maior = direita;
        }

        if (maior != raiz) {

            int troca = dados[raiz];
            dados[raiz] = dados[maior];
            dados[maior] = troca;

            heapify(dados, tamanho, maior);
        }
    }
}