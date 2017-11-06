/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ed.trabalho;

/**
 *
 * @author allyssoncc
 */
public class NoAVL {

    private Trafego elemento;
    private NoAVL esquerda;
    private NoAVL direita;
    private NoAVL pai;
    private int altura;

    public NoAVL(Trafego k) {
        setEsquerda(setDireita(setPai(null)));
        setAltura(0);
        setElemento(k);
    }

    public String toString() {
        return Double.toString(getElemento().getFluxo());
    }

    public Trafego getElemento() {
        return elemento;
    }

    public void setElemento(Trafego elemento) {
        this.elemento = elemento;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NoAVL getPai() {
        return pai;
    }

    public NoAVL setPai(NoAVL pai) {
        this.pai = pai;
        return pai;
    }

    public NoAVL getDireita() {
        return direita;
    }

    public NoAVL setDireita(NoAVL direita) {
        this.direita = direita;
        return direita;
    }

    public NoAVL getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoAVL esquerda) {
        this.esquerda = esquerda;
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
        System.out.print("" + getElemento().getFluxo());
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
