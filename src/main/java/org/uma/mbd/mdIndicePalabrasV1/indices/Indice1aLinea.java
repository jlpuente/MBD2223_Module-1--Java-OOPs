package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.*;

public class Indice1aLinea extends Indice{

    private Map<String, Integer> palabras;

    public Indice1aLinea(){
        super();
        palabras = new TreeMap<>(Comparator.naturalOrder()); // Tabla de correspondencias ordenada por el orden natural de sus claves
    }

    @Override
    public void agregarLinea(String texto){
        super.agregarLinea(texto);
        palabras.clear(); // ?
    }

    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas){

        Collection<String> c = miColAMin(noSignificativas); // convierte a colección de palabras minúsculas
        int nLinea = 1;
        for (String linea: texto){
            int valor = nLinea;
            try(Scanner scLinea = new Scanner(linea)){
                scLinea.useDelimiter(delimitadores);
                while (scLinea.hasNext()){
                    String clave = scLinea.next().toLowerCase();
                    if (!c.contains(clave.toLowerCase())){
                        palabras.putIfAbsent(clave, valor);
                    }
                }
            }
            nLinea++;
        }

    }

    private Collection<String> miColAMin(Collection<String> c){
        Collection<String> nc = new HashSet<>(c);
        for (String s: c)
            nc.add(s.toLowerCase());
        return nc;
    }

    @Override
    public void presentarIndiceConsola(){
        for (Map.Entry<String, Integer> entrada: palabras.entrySet())
            System.out.println(entrada.getKey() + "\t" + entrada.getValue());
    }

}
