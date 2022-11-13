package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;

public interface CriterioSeleccion {

    Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc);

}
