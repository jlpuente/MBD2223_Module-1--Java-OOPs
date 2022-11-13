package org.uma.mbd.mdGenetico.genetico;
import java.util.Random;

abstract public class AlgoritmoGenetico {

    private Poblacion poblacion;
    private Problema problema;
    private int pasos;
    private double probMutacion;

    public AlgoritmoGenetico(int tamPob, int lonInd, int nPasos, double pm, Problema p){
        poblacion = new Poblacion(tamPob, lonInd, p);
        pasos = nPasos;
        probMutacion = pm;
        problema = p;
    }

    public Individuo ejecuta(){
        Individuo ind1, ind2, nuevoInd;
        Cromosoma cr;
        Random alea = new Random();
        for (int i = 0; i < pasos; i++){
            ind1 = poblacion.getIndividuo(alea.nextInt(poblacion.getNumIndividuos()));
            ind2 = poblacion.getIndividuo(alea.nextInt(poblacion.getNumIndividuos()));
            cr = recombinar(ind1.getCromosoma(), ind2.getCromosoma());
            cr.mutar(probMutacion);
            nuevoInd = new Individuo(cr.getLongitud(), problema);
            poblacion.reemplaza(nuevoInd);
        }
        return poblacion.mejorIndividuo();
    }

    abstract protected Cromosoma recombinar(Cromosoma cr1, Cromosoma cr2);
}
