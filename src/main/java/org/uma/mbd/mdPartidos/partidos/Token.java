package org.uma.mbd.mdPartidos.partidos;

import java.util.*;

public class Token implements Comparable<Token> {

    private Partido partido;
    private double ratio;

    public Token (Partido p, double r){
        partido = p;
        ratio = r;
    }

    public Partido getPartido() {
        return partido;
    }

    public double getRatio() {
        return ratio;
    }

    @Override
    public boolean equals(Object o){ // !
        return (o instanceof Token t) && partido.equals(t.partido) && ratio == t.ratio;
    }

    @Override
    public int compareTo(Token t){
        if (t.ratio > ratio)
            return 1;
        else if (t.ratio < ratio)
            return -1;
        else
            return partido.getNombre().compareToIgnoreCase(t.partido.getNombre());
    }

    public static Set<Token> seleccioneTokens(Set<Token> tks, int numEsc){
        Set<Token> set = new TreeSet<>();
        Iterator<Token> it = tks.iterator();
        int count = 0;
        while (count < numEsc){
            set.add(it.next());
            count++;
        }
        return set;
    }

    public static Map<Partido, Integer> generaResultados(Set<Token> tks){
        Map<Partido, Integer> m = new HashMap<>();
        for (Token tk: tks){
            int count = m.getOrDefault(tk.partido,0);
            m.put(tk.partido, count + 1);
        }
        return OrderResults.sortByValue(m); // Look at OrderResults class
    }

}
