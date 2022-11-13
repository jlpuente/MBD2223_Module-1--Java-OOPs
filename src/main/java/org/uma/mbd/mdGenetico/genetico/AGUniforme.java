package org.uma.mbd.mdGenetico.genetico;

import java.util.Random;

public class AGUniforme extends AlgoritmoGenetico{

    public AGUniforme(int tamPob, int lonInd, int nPasos, double prob, Problema p){
        super(tamPob, lonInd, nPasos, prob, p);
    }

    protected Cromosoma recombinar(Cromosoma cr1, Cromosoma cr2){
        Cromosoma cr = new Cromosoma(cr1.getLongitud(),false);
        Random alea = new Random();
        for (int i = 0; i < cr.getLongitud(); i++){
            if (cr1.getGen(i) == cr2.getGen(i))
                cr.setGen(i, cr1.getGen(i));
            else
                cr.setGen(i, alea.nextInt(2));
        }
        return cr;
    }

}
