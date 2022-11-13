package org.uma.mbd.mdGenetico.genetico;

import java.util.Random;

public class Cromosoma {

    protected int[] datos;
    protected static Random gna;
    protected static int GEN_POR_DEFECTO = 0;
    private int longitud;

    public Cromosoma(int numGenes, boolean esAleatorio){
        datos = new int[numGenes];
        gna = new Random();
        longitud = numGenes;
        if(esAleatorio){
            for(int i = 0; i < datos.length; i++)
                datos[i] = gna.nextInt(2); // 0 o 1
        }else
            for(int i = 0; i < datos.length; i++)
                datos[i] = Cromosoma.GEN_POR_DEFECTO;
    }

    public int getGen(int pos){
        return datos[pos];
    }

    public void setGen(int pos, int gen){
        datos[pos] = gen;
    }

    public void mutar(double pm){
        Random alea = new Random();
        double p;
        for (int i = 0; i < datos.length; i++){
            p = alea.nextDouble(100) / 100;
            if (p < pm)
                datos[i] = (datos[i] + 1) % 2;
        }
    }

    public Cromosoma copia(){
        Cromosoma copia = new Cromosoma(getLongitud(), false);
        for(int i = 0; i < getLongitud(); i++){
            copia.setGen(i, datos[i]);
        }
        return copia;
    }

    public int getLongitud(){
        return longitud;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < getLongitud(); i++){
            str.append(getGen(i));
            if (i < (getLongitud() - 1))
                str.append(",");
        }
        str.append("]");
        return str.toString();
    }
}
