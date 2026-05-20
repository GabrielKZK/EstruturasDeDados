package arvores;

public class BinarySearchTree {
    private Node raiz;

    // =========================
    // INSERÇÃO (COM BALANCEAMENTO)
    // =========================
    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private Node inserirRecursivo(Node node, int valor) {
        if (node == null) return new Node(valor);

        if (valor < node.valor) {
            node.esquerdo = inserirRecursivo(node.esquerdo, valor);
        } else if (valor > node.valor) {
            node.direito = inserirRecursivo(node.direito, valor);
        } else {
            return node; // não permite duplicado
        }

        atualizarAltura(node);
        return balancear(node);
    }

    // =========================
    // REMOÇÃO (COM BALANCEAMENTO)
    // =========================
    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private Node removerRecursivo(Node node, int valor) {
        if (node == null) return null;

        if (valor < node.valor) {
            node.esquerdo = removerRecursivo(node.esquerdo, valor);
        } else if (valor > node.valor) {
            node.direito = removerRecursivo(node.direito, valor);
        } else {

            // 1 ou 0 filhos
            if (node.esquerdo == null || node.direito == null) {
                node = (node.esquerdo != null) ? node.esquerdo : node.direito;
            } else {
                // 2 filhos
                Node sucessor = menor(node.direito);
                node.valor = sucessor.valor;
                node.direito = removerRecursivo(node.direito, sucessor.valor);
            }
        }

        if (node == null) return null;

        atualizarAltura(node);
        return balancear(node);
    }

    // =========================
    // BALANCEAMENTO AVL
    // =========================
    private Node balancear(Node node) {
        int fb = fatorBalanceamento(node);

        // Esquerda pesada
        if (fb > 1) {
            if (fatorBalanceamento(node.esquerdo) < 0) {
                node.esquerdo = rotacaoEsquerda(node.esquerdo);
            }
            return rotacaoDireita(node);
        }

        // Direita pesada
        if (fb < -1) {
            if (fatorBalanceamento(node.direito) > 0) {
                node.direito = rotacaoDireita(node.direito);
            }
            return rotacaoEsquerda(node);
        }

        return node;
    }

    private int fatorBalanceamento(Node node) {
        return altura(node.esquerdo) - altura(node.direito);
    }

    private int altura(Node node) {
        return (node == null) ? 0 : node.altura;
    }

    private void atualizarAltura(Node node) {
        node.altura = 1 + Math.max(altura(node.esquerdo), altura(node.direito));
    }

    // =========================
    // ROTAÇÕES
    // =========================
    private Node rotacaoDireita(Node y) {
        Node x = y.esquerdo;
        Node t2 = x.direito;

        x.direito = y;
        y.esquerdo = t2;

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    private Node rotacaoEsquerda(Node x) {
        Node y = x.direito;
        Node t2 = y.esquerdo;

        y.esquerdo = x;
        x.direito = t2;

        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    private Node menor(Node node) {
        while (node.esquerdo != null) {
            node = node.esquerdo;
        }
        return node;
    }

    // =========================
    // EXIBIR
    // =========================
    public void exibir() {
        if (raiz == null) {
            System.out.println("Árvore vazia.");
            return;
        }
        TreePinter.printNode(raiz);
        System.out.println("\n" + "=".repeat(30));
    }
}