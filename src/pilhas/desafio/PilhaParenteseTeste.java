package pilhas.desafio;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PilhaParenteseTeste {

    PilhaParentese pilha;

    @BeforeEach
    public void initTest() {
        // Inicializa a pilha do zero antes de cada teste
        pilha = new PilhaParentese();
    }

    // --- MÉTODOS DE APOIO ---

    public boolean validar(String expressao) {
        for (int i = 0; i < expressao.length(); i++) {
            char c = expressao.charAt(i);

            if (c == '(') {
                pilha.push(new Parentese(c, null));
            } else if (c == ')') {
                // Se encontrar ')' e não houver '(' na pilha, é inválido
                if (pilha.isEmpty()) {
                    return false;
                }
                pilha.pop();
            }
        }
        return pilha.isEmpty();
    }

    // --- TESTES DO DESAFIO ---

    @Test
    @Description("Exemplo 1: (1 + 2) * (3 + 4) -> Deve ser balanceado")
    void expressaoValidaTest() {
        assertTrue(validar("(1 + 2) * (3 + 4)"));
    }

    @Test
    @Description("Exemplo 2: (1 + 2 * (3 + 4) -> Deve ser desbalanceado")
    void expressaoInvalidaTest() {
        assertFalse(validar("(1 + 2 * (3 + 4)"));
    }

    @Test
    @Description("Teste Extra: Fechamento sem abertura -> Deve ser desbalanceado")
    void fechamentoSemAberturaTest() {
        assertFalse(validar("())"));
    }

    @Test
    @Description("Teste de Unidade: Verifica se o pop realmente esvazia a pilha")
    void pilhaFuncionamentoTest() {
        pilha.push(new Parentese('(', null));
        assertFalse(pilha.isEmpty());

        Parentese saiu = pilha.pop();
        assertEquals('(', saiu.getValor());
        assertTrue(pilha.isEmpty());
    }
}