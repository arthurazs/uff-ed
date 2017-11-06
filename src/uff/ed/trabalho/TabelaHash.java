/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.trabalho;

import java.util.Objects;

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

    public boolean inserir(int chave, double valor) {

        int posicao = hash(chave); // hash do setor + dia
        if (contador == 0)
            min = max = valor;

        if (tabela[posicao] == null){
            contador++;
        }
        else {
            // se colidir, significa que um fluxo foi alterado
            // portanto é importante resetar o mínimo
            if (Objects.equals(min, tabela[posicao])) {
                min = max;
            }
        }
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
