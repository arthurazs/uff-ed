/*
 * Copyright (c) 2017 @arthurazs
 * Refer to the MIT License
 *
 */
package uff.ed.trabalho;

import java.util.Date;

/**
 *
 * @author Arthur Zopellaro
 */
public class Trafego {

    private String setor;
    private Date dia;
    private double fluxo;

    public Trafego(String setor, Date dia, double fluxo) {
        this.setor = setor;
        this.dia = dia;
        this.fluxo = fluxo;
    }
    
    public int getChave() {
        return Util.stringToInt(this.setor) + Util.dataToInt(this.dia);
    }

    public String getSetor() {
        return setor;
    }

    public String getDia() {
        return Util.formatData(dia);
    }

    public double getFluxo() {
        return fluxo;
    }

    public void setFluxo(double fluxo) {
        this.fluxo = fluxo;
    }

    @Override
    public String toString() {
        return "[" + getSetor() + ", " + getDia() + ", " + getFluxo() + "]";
    }

    public boolean equals(Trafego trafego) {
        return this.getChave() == trafego.getChave();
    }

}
