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

    private static final ListaDinamica lista = new ListaDinamica();
    private static final ArvoreAVL arvore = new ArvoreAVL();
    private static final TabelaHash hash = new TabelaHash(1009);

    /**
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        readFile(FILE1, false);
        readFile(FILE2, true);
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
        Trafego[] novos = lista.estatica();
        for (Trafego novo : novos)
            hash.inserir(novo.getChave(), novo.getFluxo());

        hash.findMin();

        if (verbose)
            System.out.println("Inserindo os fluxos na arvore.");
        Double[] fluxos = hash.getValues();
        for (Double fluxo : fluxos)
            arvore.adicionar(fluxo);

        if (verbose)
            System.out.println("Inserindo elementos nos fluxos da arvore.");
        for (Trafego novo : novos)
            arvore.adicionarElemento(novo);

    }

    private static void atualizar(CSVReader reader, boolean verbose) throws Exception {

        if (verbose)
            System.out.println("Atualizando dados na lista encadeada.");
        String[] line;
        //TODO 1 Tentar utilizar tabelahash no lugar dessas duas listas
        ListaDinamica listaAlterados = new ListaDinamica(); // Guarda os que foram alterados
        ListaDinamica listaFluxoAntigo = new ListaDinamica();
        while ((line = reader.readNext()) != null)
            if (line != null) {
                // cria elemento do tipo trafego
                String setor = line[0];
                Date dia = Util.parseData(line[2]);
                double fluxo = Double.parseDouble(line[3]);
                Trafego elemento = new Trafego(setor, dia, fluxo);

                // adiciona o elemento na lista encadeada e na tabela hash
                Double aux1 = hash.buscar(elemento.getChave()); //verifica se existe na lista
                Trafego aux2 = listaAlterados.buscar(elemento.getChave()); //verifica se é uma atualização
                if (aux1 != null && aux2 == null){
                    listaFluxoAntigo.copiarPrimeiro(elemento);
                }
                lista.adicionar(elemento);
                listaAlterados.referenciar(lista.buscar(elemento.getChave()));

            }

        if (verbose)
            System.out.println("Atualizando o hash de fluxos.");
        Trafego[] novos = listaAlterados.estatica();
        for (Trafego novo : novos)
            hash.inserir(novo.getChave(), novo.getFluxo());

        hash.findMin();

        if (verbose)
            System.out.println("Atualizando os fluxos na arvore.");
        Double[] fluxos = hash.getValues();
        for (Double fluxo : fluxos)
            arvore.adicionar(fluxo);

        //TODO 2
        /* FALTA A REMOÇÃO AQUI
        A forma que imaginei para fazer:
        pega a lista listaFluxoAntigo, cria uma nova funcao na AVL para remover
        ELEMENTO (e nao fluxo). Após remover, verifica se a lista (da avl) ficou
        vazia. Se estiver vazia: remove o NÓ (fluxo) da arvore.
        
        Após isso, vem o for abaixo que vai adicionar os que foram removidos.
        
        Nota: já funciona sem a remoção, pois aquela regra "𝑚𝑖𝑛(𝑓𝑙𝑢𝑥𝑜) + 0.8delta"
        sempre vai aumentar, fazendo com que os elementos "desatualizados" nao
        sejam mais lidos, pois terao fluxo inferior a regra.
        Esta errado pois: ainda estao na arvore e talvez ela nao fique balanceada
                          de forma ideal.
        Esta certo pois: nao sera mais impresso.
        Pra mim: vamos tentar fazer a remoção. se nao der certo, paciencia.
        
        //TODO 3
        Deveriamos modificar as listas dinamicas para listas estaticas pois
        precisamos usar FOR nelas. Ta muito gambiarra do jeito que tá, pois
        estou transformando a lista dinamica em estatica para poder iterar.
        
        */
        
        if (verbose)
            System.out.println("Atualizando os elementos nos fluxos da arvore.");
        for (Trafego novo : novos)
            arvore.adicionarElemento(novo);
        
//        arvore.imprimirAVL(false);

    }

}
