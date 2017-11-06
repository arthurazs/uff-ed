/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.trabalho;

import java.util.Date;
import com.opencsv.CSVReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Arthur Zopellaro, Allysson
 */
public class Main {

    private static final String FILE1 = "data_13_05.csv";
    private static final String FILE2 = "data_13_05_2.csv";

    private static final ListaEstatica lista = new ListaEstatica(Util.TAM);
    private static final ArvoreAVL arvore = new ArvoreAVL();
    private static final TabelaHash hash = new TabelaHash(1009);

    /**
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        readFile(FILE1, false);
        readFile(FILE2, false);
    }

    private static void readFile(String filename, boolean verbose) throws Exception {
        System.out.println("Lendo arquivo " + filename);
        String filepath = Util.filePath(filename);

        // verificar se o arquivo existe
        File file = new File(filepath);
        if (!file.exists()) {
            System.out.println("ERROR Arquivo " + file.getPath() + " nao encotrado");
            System.exit(-1);
        }
        CSVReader reader = new CSVReader(new FileReader(filepath), ',', '"', 1);

        if (lista.estaVazia())
            criar(reader, verbose); // insere os dados
        else
            atualizar(reader, verbose); // atualiza os dados

        Double delta = hash.max() - hash.min();
        Double regra = hash.min() + 0.8 * delta;
        System.out.println("Imprimindo setores com tráfego superior (ou igual) a " + regra);

        arvore.imprimirResposta(regra);
        System.out.println();
    }

    private static void criar(CSVReader reader, boolean verbose) throws Exception {

        if (verbose)
            System.out.println("Inserindo dados na lista encadeada.");
        String[] line;
        while ((line = reader.readNext()) != null)
            if (line != null) {
                // cria elemento do tipo trafego
                String setor = line[0];
                Date dia = Util.parseData(line[2]);
                double fluxo = Double.parseDouble(line[3]);
                Trafego elemento = new Trafego(setor, dia, fluxo);

                // adiciona o elemento na lista encadeada e na tabela hash
                lista.adicionar(elemento);
            }

        if (verbose)
            System.out.println("Populando o hash de fluxos.");
        for (int i = 0; i < lista.tamanho(); i++)
            hash.inserir(lista.obter(i).getChave(), lista.obter(i).getFluxo());

        hash.findMin();

        if (verbose)
            System.out.println("Inserindo os fluxos na arvore.");
        Double[] fluxos = hash.getValues();
        for (Double fluxo : fluxos)
            arvore.adicionar(fluxo);
//        for (int i = 0; i < lista.tamanho(); i++){
//            arvore.adicionar(lista.obter(i).getFluxo());}
        
        if (verbose)
            System.out.println("Inserindo elementos nos fluxos da arvore.");
        for (int i = 0; i < lista.tamanho(); i++)
            arvore.adicionarElemento(lista.obter(i));

    }

    private static void atualizar(CSVReader reader, boolean verbose) throws Exception {

        if (verbose)
            System.out.println("Atualizando dados na lista encadeada.");
        String[] line;
        ListaEstatica listaAlterados = new ListaEstatica(Util.TAM); // Guarda os que foram alterados
        while ((line = reader.readNext()) != null)
            if (line != null) {
                // cria elemento do tipo trafego
                String setor = line[0];
                Date dia = Util.parseData(line[2]);
                double fluxo = Double.parseDouble(line[3]);
                Trafego elemento = new Trafego(setor, dia, fluxo);

                // adiciona o elemento na lista encadeada e na tabela hash
                Trafego antigo = lista.buscar(elemento.getChave());
                if (antigo != null){
                    listaAlterados.referenciar(antigo);
                    lista.adicionar(elemento);
                }
                else{
                    lista.adicionar(elemento);
                    Trafego novo = lista.buscar(elemento.getChave());
                    listaAlterados.referenciar(novo);
                }

            }

        if (verbose)
            System.out.println("Atualizando o hash de fluxos.");
        for (int i = 0; i < listaAlterados.tamanho(); i++) {
            int chave = listaAlterados.obter(i).getChave();
            Trafego aux = lista.buscar(chave);
            hash.inserir(chave, aux.getFluxo());
        }

        hash.findMin();

        if (verbose)
            System.out.println("Atualizando os fluxos na arvore.");
        Double[] fluxos = hash.getValues();
        for (Double fluxo : fluxos)
            arvore.adicionar(fluxo);

        for (int i = 0; i < listaAlterados.tamanho(); i++) {
            Trafego elemento = listaAlterados.obter(i);
            arvore.removerElemento(elemento);
        }
        
        if (verbose)
            System.out.println("Atualizando os elementos nos fluxos da arvore.");
        for (int i = 0; i < listaAlterados.tamanho(); i++) {
            int chave = listaAlterados.obter(i).getChave();
            Trafego aux = lista.buscar(chave);
            arvore.adicionarElemento(aux);
        }
    }

}
