package org.uma.mbd.mdAlturasV3;

import org.uma.mbd.mdAlturasV3.alturas.Mundo;
import org.uma.mbd.mdAlturasV3.alturas.Pais;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainMundo {
    public static void main(String args[]) throws IOException {
        Mundo mundo = new Mundo();
        mundo.leePaises("recursos/mdAlturas/alturas.txt");


        for (String continente : mundo.getContinentes()) {
            System.out.println(continente);
        }

        // System.out.println(mundo.todosMayores(1.65));
        // System.out.println(mundo.masBajoDelContinente("Europa"));
        //System.out.println(mundo.paisDeMayorAltura());
        /*
        for(Pais pais: mundo.conjuntoOrdPaisesDelContinente("Europe")) {
            System.out.println(pais);
        }
         */
        /*
        for (Map.Entry<String, List<Pais>> par : mundo.paisesPorContinente().entrySet() ) {
            System.out.println(par.getKey());
            for (Pais pais :  par.getValue()) {
                System.out.println("\t"+ pais);
            }
        }
         */
        /*
        Map<String, Set<Double>> map =  mundo.alturasPorContinente();
        for (String continente : map.keySet()) {
            System.out.println(continente+ " " + map.get(continente));
        }
         */
//        System.out.println(mundo.extraeMenoresDeContinente("Europe", 1.75));
//        System.out.println(mundo.extraeMayoresDeContinente("Europe", 1.75));
//        mundo.getPaises().stream().forEach(System.out::println);
//        System.out.println(mundo.numPaisesQueVerifican(p->p.getNombre().charAt(0)=='E'));
//        System.out.println(mundo.alturasDelContinente("Europe"));
//        System.out.println(mundo.separaPor(pais->pais.getAltura()>1.75));
//        System.out.println(mundo.paisesPorContinente());
//        System.out.println(mundo.numPaisesPorContinente());
    }
}
