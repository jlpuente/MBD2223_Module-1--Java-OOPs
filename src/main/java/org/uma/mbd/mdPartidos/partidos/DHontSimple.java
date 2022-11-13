package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DHontSimple implements CriterioSeleccion {

    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc){
        Set<Token> tks = creaTokens(partidos, numEsc);
        Set<Token> set = Token.seleccioneTokens(tks, numEsc);
        return Token.generaResultados(set);
    }

    private static Set<Token> creaTokens(List<Partido> partidos, int numEsc){
        Set<Token> tks = new TreeSet<>(); // natural order of its tokens
        for (Partido p: partidos){
            for (int i = 1; i <= numEsc; i++){
                int ratio = p.getVotos() / i;
                Token tk = new Token(p, ratio);
                tks.add(tk);
            }
        }
        return tks;
    }

}
