package org.uma.mbd.mdGenetico.genetico;

import java.util.Random;

public class AGUnPunto extends AlgoritmoGenetico{

    public AGUnPunto(int tamPob, int lonInd, int nPasos, double prob, Problema p){
        super(tamPob, lonInd, nPasos, prob, p);
    }

    protected Cromosoma recombinar(Cromosoma cr1, Cromosoma cr2){
        Random alea = new Random();
        int z = alea.nextInt(cr1.getLongitud()); // o cr2
        Cromosoma cr = new Cromosoma(cr1.getLongitud(), false);
        for(int i = 0; i < cr.getLongitud(); i++){
            if (i < z)
                cr.setGen(i, cr1.getGen(i));
            else
                cr.setGen(i, cr2.getGen(i));
        }
        return cr;
    }
}
