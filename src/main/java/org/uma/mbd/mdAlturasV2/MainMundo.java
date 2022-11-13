package org.uma.mbd.mdAlturasV2;

import org.uma.mbd.mdAlturasV2.alturas.Mundo;
import org.uma.mbd.mdAlturasV2.alturas.Pais;

import java.io.IOException;
import java.util.*;

public class MainMundo {
    public static void main(String[] args) throws IOException {

        Mundo paises = new Mundo();
        paises.leePaises("src/main/java/org/uma/mbd/mdAlturas/alturas.txt");

        List<Pais> listaPaises = paises.getPaises();

        // a) Crear un conjunto de los países ordenados de menor a mayor altura
        Comparator<Pais> ordenAltura = Comparator.comparing(Pais::altura);
        Set<Pais> setPaisesA = new TreeSet<>(ordenAltura);
        setPaisesA.addAll(listaPaises);
        System.out.println(setPaisesA);

        // b) Crear un conjunto de los países ordenados alfabéticamente
        Comparator<Pais> ordenNombre = Comparator.comparing(Pais::nombre);
        Set<Pais> setPaisesB = new TreeSet<>(ordenNombre);
        setPaisesB.addAll(listaPaises);
        System.out.println(setPaisesB);

        // c) Crear un conjunto de los países ordenados por continente y a igualdad de contienente, alfabéticamente
        Comparator<Pais> ordenContinente = Comparator.comparing(Pais::continente);
        Set<Pais> setPaisesC = new TreeSet<>(ordenContinente.thenComparing(ordenNombre));
        setPaisesC.addAll(listaPaises);
        System.out.println(setPaisesC);

        /*
        d) Crear un conjunto de los países ordenados por continente y a igualdad de continente, alfabéticamente
        en orden inverso
         */
        Set<Pais> setPaisesD = new TreeSet<>(ordenContinente.thenComparing(ordenNombre.reversed()));
        setPaisesD.addAll(listaPaises);
        System.out.println(setPaisesD);

        /*
        e) Redefine la clase Pais para que tenga un orden natural que ordene los países por altura
        y a igualdad de altura, los ordena alfabéticamente.
         */
        Comparator<Pais> ordenNatural = ordenAltura.thenComparing(Comparator.naturalOrder());
        Set<Pais> setPaisesE = new TreeSet<>(ordenNatural);
        setPaisesE.addAll(listaPaises);
        System.out.println(setPaisesE);

        /*
        f) Crear un conjunto de los países de la lista ordenados por continente y en caso de
        igualdad, por el orden natural.
         */
        Set<Pais> setPaisesF = new TreeSet<>(ordenContinente.thenComparing(ordenNatural));
        setPaisesF.addAll(listaPaises);
        System.out.println(setPaisesF);

    }
}
