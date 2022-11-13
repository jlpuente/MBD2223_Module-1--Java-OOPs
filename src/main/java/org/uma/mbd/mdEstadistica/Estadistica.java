package org.uma.mbd.mdEstadistica;

import java.lang.Math;

public class Estadistica {

    private int numElementos;
    private double sumaX, sumaX2;

    public void agrega(double d){
        this.agrega(d, 1);
    }

    public void agrega(double d, int n){
            sumaX += n * d;
            sumaX2 += n * d * d;
            numElementos++;
    }

    public double media(){
        if(numElementos == 0)
            throw new RuntimeException("No hay elementos");
        return sumaX/(double)numElementos;
    }

    public double varianza(){
        if(numElementos == 0)
            throw new RuntimeException("No hay elementos");
        return sumaX/(double)numElementos - Math.pow(media(),2);
    }

    public double desviacionTipica(){
        return Math.sqrt(varianza());
    }
}
