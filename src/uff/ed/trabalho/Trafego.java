/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.trabalho;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Arthur Zopellaro
 */
public class Trafego extends Util {
    
    private String setor;
    private String rodovia;
    private Date dia;
    private double fluxo;

    public Trafego(String setor, String rodovia, Date dia, double fluxo) {
        this.setor = setor;
        this.rodovia = rodovia;
        this.dia = dia;
        this.fluxo = fluxo;
    }
    
    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getRodovia() {
        return rodovia;
    }

    public void setRodovia(String rodovia) {
        this.rodovia = rodovia;
    }

    public String getDia() {
        return DATEFORMAT.format(dia);
    }

    public void setDia(Date dia) {
        this.dia = dia;
    }

    public double getFluxo() {
        return fluxo;
    }

    public void setFluxo(double fluxo) {
        this.fluxo = fluxo;
    }
    
    public String getContent() {
        return "[" + getSetor() + ", " + getRodovia() + ", " + getDia() + ", " + getFluxo() + "]";
    }
    
}
