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
 * @author Arthur Zopellaro
 */
public class Main extends Util {

    private static final String DIR = "C:\\Users\\Allysson\\Documents\\NetBeansProjects\\TrabalhoED\\src\\uff\\ed\\trabalho\\";
    private static final String FILE1 = DIR + "data_13_05.csv";

    /**
     * List includes but never deletes One insertion by day? One print by day?
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        // verificar se o arquivo existe
        File file = new File(FILE1);
        if (file.exists()) {
            System.out.println("Arquivo " + file.getPath() + " existe");
        } else {
            System.out.println("Arquivo " + file.getPath() + " nao encotrado");
        }

        CSVReader reader = new CSVReader(new FileReader(FILE1), ',', '"', 1);

        Trafego[] trafego = new Trafego[10000];
        ListaDinamica lista = new ListaDinamica();
        int count = 0;

        String[] line;
        while ((line = reader.readNext()) != null) {
            if (line != null) {
//                System.out.println(Arrays.toString(line));
                String setor = line[0];
                String rodovia = line[1];
                Date dia = DATEFORMAT.parse(line[2]);
                double fluxo = Double.parseDouble(line[3]);
//                System.out.println(line[2]);

                // cria elemento do tipo trafego e adiciona no final da lista
                Trafego elemento = new Trafego(setor, rodovia, dia, fluxo);
                lista.adicionarNoFinal(elemento);

                // adiciona elemento no vetor trafego
                trafego[count++] = new Trafego(setor, rodovia, dia, fluxo);
            }
        }

        // imprime a lista toda
        System.out.println("Lista");
        lista.imprimirLista();

        // imprime o vetor
        System.out.println("Vetor");
        for (int i = 0; i < count; i++) {
            System.out.println(trafego[i].getContent());
        }
    }

}
