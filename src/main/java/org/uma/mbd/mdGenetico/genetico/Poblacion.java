package org.uma.mbd.mdGenetico.genetico;

public class Poblacion {

    private Individuo[] individuos;

    public Poblacion(int nInd, int lInd, Problema p){
        individuos = new Individuo[nInd];
        for (int i = 0; i < nInd; i++){
            individuos[i] = new Individuo(lInd, p);
        }
    }

    public Individuo mejorIndividuo(){
        Individuo mejorIndividuo = individuos[0];
        for(int i = 1; i < individuos.length; i++){
            if (individuos[i].getFitness() > mejorIndividuo.getFitness())
                mejorIndividuo = individuos[i];
        }
        return mejorIndividuo;
    }

    public Individuo getIndividuo(int i){
        return individuos[i];
    }

    public void reemplaza(Individuo individuo){
        int pos = 0;
        Individuo peorIndividuo = individuos[pos];
        for(int i = 1; i < individuos.length; i++){
            if (individuos[i].getFitness() < peorIndividuo.getFitness())
                pos = i;
        }
        if (individuo.getFitness() > individuos[pos].getFitness())
            individuos[pos] = individuo;
    }

    public int getNumIndividuos(){
        return individuos.length;
    }
}
