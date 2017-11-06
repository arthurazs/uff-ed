/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.trabalho;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Arthur Zopellaro
 */
public class Util {

    private static final String WINDOWS = "C:\\Users\\Allysson\\Documents\\NetBeansProjects\\TrabalhoED\\src\\uff\\ed\\trabalho\\";
    private static final String LINUX = "src/uff/ed/trabalho/";

    public static String filePath(String file) {

        switch (System.getProperty("os.name")) {
            case "Linux":
                return LINUX + file;
            case "Windows":
                return WINDOWS + file;
        }
        return null;
    }

    private static final DateFormat DATEFORMAT = new SimpleDateFormat("dd/MM/yyyy");
    private static final DateFormat INTFORMAT = new SimpleDateFormat("ddMMyyyy");

    public static String formatData(Date data) {
        return DATEFORMAT.format(data);
    }

    public static Date parseData(String data) throws ParseException {
        return DATEFORMAT.parse(data);
    }
    
    public static int dataToInt(Date data) {
        return Integer.parseInt(INTFORMAT.format(data));
    }
    
    public static int stringToInt(String elemento) {
        return Integer.parseInt(elemento);
    }
    
    public static final int TAM = 10000000;

}
