package org.uma.mbd.mdAlturasV3.alturas;

public record Pais(String nombre, String continente, double altura) implements Comparable<Pais> {
    @Override
    public int compareTo(Pais pais) {
        int res = Double.compare(altura, pais.altura);
        if (res == 0) {
            res = nombre.compareTo(pais.nombre);
        }
        return res;
    }
}
