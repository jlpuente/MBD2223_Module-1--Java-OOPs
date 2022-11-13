package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

abstract public class Indice {

    protected List<String> texto;

    public Indice(){
        texto = new ArrayList<>();
    }

    public void agregarLinea(String txt){
        texto.add(txt);
    }

    abstract public void resolver(String delimitadores, Collection<String> noSignificativas);
    abstract public void presentarIndiceConsola();

}
