package uff.ed.trabalho;

/**
 *
 * @author allyssoncc
 */
class NoAVL {

    private Trafego elemento;
    private NoAVL esquerda;
    private NoAVL direita;
    private int altura;

    NoAVL(Trafego elemento) {
        this.elemento = elemento;
        esquerda = null;
        direita = null;
        altura = 0;
    }

    public Trafego getElemento() {
        return elemento;
    }

    public void setElemento(Trafego elemento) {
        this.elemento = elemento;
    }

    public NoAVL getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoAVL esquerda) {
        this.esquerda = esquerda;
    }

    public NoAVL getDireita() {
        return direita;
    }

    public void setDireita(NoAVL direita) {
        this.direita = direita;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void imprimirArvore() {
        if (direita != null) {
            direita.imprimirArvore(false, "");
        }
        imprimirFluxo();
        if (esquerda != null) {
            esquerda.imprimirArvore(true, "");
        }
    }

    private void imprimirFluxo() {
        System.out.print("" + elemento.getFluxo());
        System.out.print('\n');
    }

    private void imprimirArvore(boolean isRight, String indent) {
        if (direita != null) {
            direita.imprimirArvore(false, indent + (isRight ? " |      " : "        "));
        }
        System.out.print(indent);
        if (isRight) {
            System.out.print(" \\");
        } else {
            System.out.print(" /");
        }
        System.out.print("----- ");
        imprimirFluxo();
        if (esquerda != null) {
            esquerda.imprimirArvore(true, indent + (isRight ? "        " : " |      "));
        }
    }
}
