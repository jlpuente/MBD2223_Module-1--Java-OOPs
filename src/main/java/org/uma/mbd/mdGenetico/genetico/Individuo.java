package org.uma.mbd.mdGenetico.genetico;

public class Individuo{

    private Cromosoma cromosoma;
    private double fitness;

    public Individuo(int longCromosoma, Problema p){
        cromosoma = new Cromosoma(longCromosoma,true);
        fitness = p.evalua(cromosoma);
    }

    public Individuo(Cromosoma cromosoma, Problema p){
        this.cromosoma = cromosoma;
        fitness = p.evalua(cromosoma);
    }

    public Cromosoma getCromosoma(){
        return cromosoma;
    }

    public double getFitness(){
        return fitness;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("[Cromosoma= ");
        for (int i = 0; i < cromosoma.getLongitud(); i++)
            str.append(cromosoma.getGen(i));
        str.append("; fitness= " + fitness + "]");
        return str.toString();
    }
}
