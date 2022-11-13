package org.uma.mbd.mdGenetico.genetico;

public class CeroMax implements Problema{

    public double evalua(Cromosoma cromosoma){
        int numCeros = 0;
        for (int i = 0; i < cromosoma.getLongitud(); i++){
            if (cromosoma.getGen(i) == 0)
                numCeros++;
        }
        return numCeros;
    }

}
