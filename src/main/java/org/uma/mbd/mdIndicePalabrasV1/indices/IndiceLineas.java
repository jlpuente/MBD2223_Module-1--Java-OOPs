package org.uma.mbd.mdIndicePalabrasV1.indices;

import java.util.*;

public class IndiceLineas extends Indice {

    private Map<String, Set<Integer>> palabras;

    public IndiceLineas(){
        super();
        palabras = new TreeMap<>(Comparator.naturalOrder());
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
            try(Scanner scLinea = new Scanner(linea)){
                scLinea.useDelimiter(delimitadores);
                while (scLinea.hasNext()){
                    String clave = scLinea.next().toLowerCase();
                    if (!c.contains(clave.toLowerCase())){
                        if (palabras.containsKey(clave)) {
                            palabras.get(clave).add(nLinea);
                        }else{
                            Set<Integer> valor = new TreeSet<>(Comparator.naturalOrder());
                            valor.add(nLinea);
                            palabras.put(clave, valor);
                        }
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
        for (Map.Entry<String, Set<Integer>> entrada: palabras.entrySet()) {
            System.out.print(entrada.getKey() + "\t");
            for (Integer elemento: entrada.getValue()) {
                System.out.print(elemento + ".");
            }
            System.out.println();
        }
    }

}
