package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.*;

public class IndicePosicionesEnLineas extends Indice {

    private Map<String, Map<Integer, Set<Integer>>> palabras;

    public IndicePosicionesEnLineas(){
        super();
        palabras = new TreeMap<>(Comparator.naturalOrder());
    }

    @Override
    public void resolver(String delimitadores, Collection<String> noSignificativas){

        Collection<String> c = miColAMin(noSignificativas); // devuelva una colección de minúsculas
        int nLinea = 0;
        for (String linea: texto){
            nLinea++;
            try (Scanner scLinea = new Scanner(linea)){
                scLinea.useDelimiter(delimitadores);
                int iPalabra = 0;
                while (scLinea.hasNext()){
                    String palabra = scLinea.next();
                    iPalabra++;
                    if (!c.contains(palabra.toLowerCase())) {
                        String clave = palabra.toLowerCase();
                        if (!palabras.containsKey(clave)){
                            Set<Integer> setIndicePalabra = new TreeSet<>(Comparator.naturalOrder());
                            Map<Integer, Set<Integer>> valor= new TreeMap<>(Comparator.naturalOrder());
                            setIndicePalabra.add(iPalabra);
                            valor.put(nLinea, setIndicePalabra);
                            palabras.put(clave, valor);
                        }else if (palabras.get(clave).containsKey(nLinea)){
                            palabras.get(clave).get(nLinea).add(iPalabra);
                        }else{
                            Set<Integer> setIndiceLinea = new TreeSet<>(Comparator.naturalOrder());
                            setIndiceLinea.add(iPalabra);
                            palabras.get(clave).put(nLinea, setIndiceLinea);
                        }
                    }
                }
            }
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

        for (Map.Entry<String, Map<Integer, Set<Integer>>> entrada: palabras.entrySet()){
            System.out.println(entrada.getKey());
            for (Map.Entry<Integer, Set<Integer>> subentrada: entrada.getValue().entrySet()){
                System.out.print("\t\t\t" + subentrada.getKey() + "\t");
                for (Integer elem: subentrada.getValue()){
                    System.out.print(elem + ".");
                }
                System.out.println();
            }
        }

    }

}
