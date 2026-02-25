package pilhas;

public class Elemento {

    int valor;
    Elemento proximo;
    Elemento topo;

    Elemento(int vl){
        this.valor = vl;
        this.proximo = null;
        this.topo = null;
    }

    public boolean isEmpty(){
        return topo == null;
    }

    public void push(int vl){
        Elemento novo = new Elemento(vl);
        if (isEmpty()){
            topo = novo;
        }else {
            novo.proximo = topo;
            topo = novo;
        }
    }

    public void pop(){
        topo = topo.proximo;
    }
    public int peek(){
        return topo.valor;
    }

}
