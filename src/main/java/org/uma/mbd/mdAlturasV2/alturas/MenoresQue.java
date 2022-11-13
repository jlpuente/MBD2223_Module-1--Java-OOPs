package org.uma.mbd.mdAlturasV2.alturas;

public class MenoresQue implements Seleccion {

    public double alturaMax;

    public MenoresQue(double alturaMax){
        this.alturaMax = alturaMax;
    }

    public boolean test(Pais pais){
        return pais.altura() <= alturaMax;
    }

}
