package pilhas.desafio;

public class PilhaParentese {

    Parentese topo;

    public boolean isEmpty() {
        return topo == null;
    }

    public void push(Parentese p){
        if(!isEmpty()){
            p.proximo = topo;
        }
        topo = p;
    }

    public Parentese pop(){
        if(!isEmpty()){
            Parentese saiu = topo;
            topo = topo.proximo;
            return saiu;
        }
        return null;
    }
}
