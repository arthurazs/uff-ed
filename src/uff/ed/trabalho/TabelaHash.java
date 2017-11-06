/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.trabalho;

/**
 *
 * @author Arthur Zopellaro
 */
public class TabelaHash {

    private Double[] tabela;
    private int tamanho;
    private int contador;
    private Double max;
    private Double min;

    public TabelaHash(int N) {
        this.tabela = new Double[N];
        this.tamanho = N;
        this.max = null;
        this.min = null;
        this.contador = 0;
    }

    private int hash(int chave) {
        return chave % tamanho;
    }

    public boolean inserirAntigo(int chave, double valor) {

        int posicao = hash(chave); // hash do setor + dia
        if (contador == 0)
            max = valor;

        // se colidir, soma o fluxo total
        if (tabela[posicao] != null)
            tabela[posicao] += valor;
        else {
            contador++;
            tabela[posicao] = valor;
        }

        Double aux = tabela[posicao];
        if (aux > max)
            max = aux;

        return true;
    }

    public boolean inserir(int chave, double valor) {

        int posicao = hash(chave); // hash do setor + dia
        if (contador == 0)
            max = valor;

        // se colidir, soma o fluxo total
        if (tabela[posicao] == null)
            contador++;
        tabela[posicao] = valor;

        Double aux = tabela[posicao];
        if (aux > max)
            max = aux;

        return true;
    }

    public Double max() {
        return max;
    }

    public void findMin() {
        min = max;
        for (int i = 0; i < tamanho; i++)
            if (tabela[i] != null && tabela[i] < min)
                min = tabela[i];
    }

    public Double[] getValues() {
        Double[] aux = new Double[contador];
        int cont = 0;
        for (int i = 0; i < tamanho; i++)
            if (tabela[i] != null)
                aux[cont++] = tabela[i];
        return aux;
    }

    public Double min() {
        return min;
    }

    public Double buscar(int chave) {
        return tabela[hash(chave)];
    }

}
