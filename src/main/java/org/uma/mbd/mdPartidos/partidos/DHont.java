package org.uma.mbd.mdPartidos.partidos;

import java.util.*;

public class DHont extends DHontSimple implements CriterioSeleccion {

    double minPor;

    public DHont(double mp){
        if (mp < 0 || mp > 15)
            throw new EleccionesException("the minimum percentage must be between 0 and 15.");
        else
            minPor = mp;
    }

    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc){
        List<Partido> copy = new ArrayList<>();
        copy.addAll(partidos);
        filtraPartidos(copy);
        return super.ejecuta(copy, numEsc);
    }

    private void filtraPartidos(List<Partido> partidos){
        List<Partido> subList = new ArrayList<>();
        int th = threshold(partidos);
        for (Partido p: partidos){
            if (p.getVotos() < th)
                subList.add(p);
        }
        partidos.removeAll(subList);
    }

    private int threshold(List<Partido> partidos){
        int sum = 0;
        for (Partido p: partidos)
            sum += p.getVotos();
        return (int) (minPor/100 * sum); // rounds to the floor
    }

}
