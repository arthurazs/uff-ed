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

    private static final String FILE1 = Util.filePath("data_13_05.csv");
    // private static final String FILE2 = // criar para testes

    /**
     * @param args
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        // verificar se o arquivo existe
        File file = new File(FILE1);
        if (!file.exists()) {
            System.out.println("ERROR Arquivo " + file.getPath() + " nao encotrado");
            System.exit(-1);
        }

        CSVReader reader = new CSVReader(new FileReader(FILE1), ',', '"', 1);

        ListaDinamica lista = new ListaDinamica();
        TabelaHash hash = new TabelaHash(1009); // tamanho da lista

        String[] line;
        while ((line = reader.readNext()) != null)
            if (line != null) {
                String setor = line[0];
                String rodovia = line[1];
                Date dia = Util.parseData(line[2]);
                double fluxo = Double.parseDouble(line[3]);

                // cria elemento do tipo trafego e adiciona no final da lista
                Trafego elemento = new Trafego(setor, rodovia, dia, fluxo);
                lista.adicionarNoFinal(elemento);
                
                // adiciona o elemento no hash,
                // e totaliza o fluxo nas colisões setor+dia 
                hash.inserir(elemento);
                /* DÚVIDA
                essa é a correta utilização do hash?
                fiquei na duvida se o hash é usado para
                armazenar apenas o fluxo total
                ou se guarda mais coisas.
                
                Poderia também ser feito um loop para ler
                a lista e totalizar no hash depois de ler
                o arquivo mas nao vejo necessidade p/ isso,
                acho melhor já fazer ambos (add na lista e no hash)
                aqui na leitura do arquivo
                */
            }

        // imprime a lista toda
        System.out.println("Lista");
        lista.imprimirLista();
    }

}
