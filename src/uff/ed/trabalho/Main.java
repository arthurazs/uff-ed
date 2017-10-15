/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.trabalho;

import java.util.Date;
import com.opencsv.CSVReader;
import java.io.FileReader;

/**
 *
 * @author Arthur Zopellaro
 */
public class Main extends Util {

    private static final String DIR = "src/uff/ed/trabalho/";
    private static final String FILE1 = DIR + "data_13_05.csv";

    /**
     * List includes but never deletes
     * One insertion by day?
     * One print by day?
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        CSVReader reader = new CSVReader(new FileReader(FILE1), ',', '"', 1);

        Trafego[] trafego = new Trafego[10000];
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
                trafego[count++] = new Trafego(setor, rodovia, dia, fluxo);
            }
        }
        
        for (int i = 0; i < count; i++) {
            System.out.println(trafego[i].getContent());
        }

    }

}
