package uff.ed.trabalho;

/**
 *
 * @author allyssoncc
 */
public class No {
    
    private No proximo = null;
    private Trafego elemento;
    
    public No(No proximo, Trafego elemento) {
        this.proximo = proximo;
        this.elemento = elemento;
    }
    
    public No getProximo() {
        return proximo;
    }

    public Trafego getElemento() {
        return elemento;
    }

}
