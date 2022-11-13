package org.uma.mbd.mdAlturasV2.alturas;

public class MayoresQue implements Seleccion {

    public double alturaMin;

    public MayoresQue(double alturaMin){
        this.alturaMin = alturaMin;
    }

    public boolean test(Pais pais){
        return pais.altura() >= alturaMin;
    }

}
