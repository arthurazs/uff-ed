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

    public TabelaHash(int N) {
        this.tabela = new Double[N];
        this.tamanho = N;
    }

    private int hash(int chave) {
        return chave % tamanho;
    }

    public boolean inserir(Trafego trafego) {

        int setor = Util.stringToInt(trafego.getSetor());
        int dia = Util.dataToInt(trafego.getDia());
        
        int chave = setor + dia;
        double valor = trafego.getFluxo();

        int posicao = hash(chave); // hash do setor + dia

        // se colidir, soma o fluxo total
        if (tabela[posicao] != null)
            tabela[posicao] += valor;
        else
            tabela[posicao] = valor;

        return true;
    }
    
    public Double buscar(Trafego trafego) {
        // busca o setor+dia no hash
        // retorna o total
        throw new Error("NÃO IMPLEMENTADO AINDA");
    }

}
