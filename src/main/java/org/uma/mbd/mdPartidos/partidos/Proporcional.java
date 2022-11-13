package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Proporcional implements CriterioSeleccion {

    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc){
        int vpe = sumVotos(partidos) / numEsc;
        Set<Token> tks = new TreeSet<>(); // orders tokens according to the natural order of its tokens
        for (Partido p: partidos){
            for (int i = 0; i < numEsc; i++){
                int ratio = p.getVotos() - (i * vpe);
                tks.add(new Token(p, ratio));
            }
        }
        Set<Token> set = Token.seleccioneTokens(tks, numEsc);
        return Token.generaResultados(set);
    }

    private static Set<Token> creaTokens(List<Partido> partidos, int numEsc){
        Set<Token> tks = new TreeSet<>();
        for (Partido p: partidos){
            int ratio = p.getVotos();
            for (int i = 1; i <= numEsc; i++){
                ratio /= i;
                Token tk = new Token(p, ratio);
                tks.add(tk);
            }
        }
        return tks;
    }

    private int sumVotos(List<Partido> partidos){
        int sum = 0;
        for (Partido p: partidos){
            sum += p.getVotos();
        }
        return sum;
    }

}
