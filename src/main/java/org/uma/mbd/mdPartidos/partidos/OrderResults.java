package org.uma.mbd.mdPartidos.partidos;

import java.util.*;

/*
This class sorts a source map into a new ordered map by integer values,
from higher to lower values.
 */

public class OrderResults {

    public static <Partido, Integer extends Comparable<? super Integer>> Map<Partido, Integer>
    sortByValue(Map<Partido, Integer> map){

        List<Map.Entry<Partido, Integer>> list = new ArrayList<>(map.entrySet());
        Comparator<Integer> byEscanos = Comparator.reverseOrder();
        list.sort(Map.Entry.comparingByValue(byEscanos));

        Map<Partido, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Partido, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

}
