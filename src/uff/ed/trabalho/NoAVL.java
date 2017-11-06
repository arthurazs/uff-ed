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

    private ListaDinamica lista;
    private Double chave;
    private NoAVL esquerda;
    private NoAVL direita;
    private NoAVL pai;
    private int altura;

    public NoAVL(Double k) {
        this.esquerda = this.direita = this.pai = null;
        this.altura = 0;
        this.lista = new ListaDinamica();
        this.chave = k;
    }

    @Override
    public String toString() {
        return Double.toString(this.chave);
    }

    public Double getChave() {
        return chave;
    }

    public void inserirElemento(Trafego elemento) {
        this.lista.adicionar(elemento);
    }

    public ListaDinamica getLista() {
        return lista;
    }

    public void setChave(Double chave, ListaDinamica lista) {
        this.chave = chave;
        this.lista = lista;
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

    public void imprimir(boolean printList) {
        if (direita != null)
            direita.imprimir(printList, false, "");
        System.out.print(chave + " ");
        if (printList)
            lista.imprimirLista();
        else
            System.out.println();
        if (esquerda != null)
            esquerda.imprimir(printList, true, "");
    }

    private void imprimir(boolean printList, boolean isRight, String indent) {
        if (direita != null)
            direita.imprimir(printList, false, indent + (isRight ? " |      " : "        "));
        System.out.print(indent);
        if (isRight)
            System.out.print(" \\");
        else
            System.out.print(" /");
        System.out.print("----- ");
        System.out.print(chave + " ");
        if (printList)
            lista.imprimirLista();
        else
            System.out.println();
        if (esquerda != null)
            esquerda.imprimir(printList, true, indent + (isRight ? "        " : " |      "));
    }

    public void imprimirResposta(Double regra) {
        if (chave > regra)
            lista.imprimirListaLn();

        if (esquerda != null && esquerda.getChave() > regra)
            esquerda.imprimirResposta(regra);
        else if (direita != null && direita.getChave() > regra)
            direita.imprimirResposta(regra);

    }
}
