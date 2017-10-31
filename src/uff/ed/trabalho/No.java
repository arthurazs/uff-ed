package uff.ed.trabalho;

/**
 *
 * @author allyssoncc
 */
public class No {
    
    private No proximo;
    private Trafego elemento;
    
    public No(No proximo, Trafego elemento) {
        this.proximo = proximo;
        this.elemento = elemento;
    }
    
    public No(Trafego elemento) {
        this.elemento = elemento;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

    public No getProximo() {
        return proximo;
    }

    public Trafego getElemento() {
        return elemento;
    }

    public void setElemento(Trafego elemento) {
        this.elemento = elemento;
    }
}
