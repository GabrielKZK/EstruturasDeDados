package arvores;

public class Node {
    int valor;
    int altura;
    Node esquerdo;
    Node direito;

    public Node(int valor) {
        this.valor = valor;
        this.altura = 1;
        this.esquerdo = null;
        this.direito = null;
    }
}