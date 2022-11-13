package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.*;

public class ClubPareja extends Club{

    private Set<Pareja> parejas;

    public ClubPareja(){
        super();
        parejas = new HashSet<>(); // Elijo la implementacion HashSet porque no precisa de ordenamiento
    }

    @Override
    protected void creaSocioDesdeString(String nombre){
        if (nombre.contains("-")) {
            String[] pareja = nombre.split("-");
            Persona uno = new Persona(pareja[0]);
            Persona otro = new Persona(pareja[1]);
            Pareja p = new Pareja(uno, otro);
            parejas.add(p);
            socios.add(uno);
            socios.add(otro);
        }else{
            socios.add(new Persona(nombre));
        }
    }

    @Override
    protected void hacerAmigos(){

        int n = socios.size();
        List<Integer> posAmigos = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            posAmigos.add(i, i);

        while (hayCoincidencias(posAmigos));

        for (int i = 0; i < n; i++){
            int pos = posAmigos.get(i);
            Persona amigo = socios.get(pos);
            socios.get(i).setAmigo(amigo);
        }

    }

    private boolean hayCoincidencias(List<Integer> l){
        boolean coinciden = false;
        Collections.shuffle(l);
        int pos = 0;
        while (!coinciden && pos < l.size()){
            if (pos == l.get(pos))
                coinciden = true;
            else if (sonPareja(l, pos))
                coinciden = true; // Separo las condiciones en dos ramas diferentes por eficiencia
            else
                pos++;
        }
        return coinciden;
    }

    private boolean sonPareja(List<Integer> l, int pos){
        boolean sonPareja = false;
        Persona uno = socios.get(pos);
        Persona otro = socios.get(l.get(pos));
        Pareja p = new Pareja(uno, otro);
        if (parejas.contains(p)) {
            sonPareja = true;
        }
        return sonPareja;
    }
}
