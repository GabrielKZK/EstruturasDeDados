package models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PilhaLivro {

    private Livro valor;
    private PilhaLivro topo;
    private PilhaLivro proximo;

    public boolean isEmpty(){
        return topo == null;
    }

    public void push(Livro l){
        PilhaLivro p = PilhaLivro.builder().valor(l).build();
        if (!isEmpty()){
            p.proximo = topo;
        }
        this.topo = p;
    }

    public Livro pop(){
        if (!isEmpty()){
            Livro saiu = topo.valor;
            topo = topo.proximo;
            return saiu;
        }
        return null;
    }

    public  Livro peek(){
        if (isEmpty()){
            return null;
        }
        return topo.valor;
    }

    public String view(){
        PilhaLivro aux = topo;
        StringBuilder retorno = new StringBuilder();
        retorno.append(aux.valor.getTitulo()).append("\n");

        while (aux.proximo != null){
            aux = aux.proximo;
            retorno.append(aux.valor.getTitulo()).append("\n");
        }
        return retorno.toString();
    }

}
