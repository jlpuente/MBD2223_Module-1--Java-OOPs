package org.uma.mbd.mdGenetico.genetico;

public class OneMax implements Problema{

    public double evalua(Cromosoma cromosoma){
        int numUnos = 0;
        for (int i = 0; i < cromosoma.getLongitud(); i++){
            if (cromosoma.getGen(i) == 1)
                numUnos++;
        }
        return numUnos;
    }

}
