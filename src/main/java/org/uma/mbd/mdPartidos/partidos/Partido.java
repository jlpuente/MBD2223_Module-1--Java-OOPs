package org.uma.mbd.mdPartidos.partidos;

import java.util.Objects;

public class Partido {

    private String nombre;
    private int votos;

    public Partido(String nombre, int votos){
        this.nombre = nombre;
        this.votos = votos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVotos() {
        return votos;
    }

    @Override
    public boolean equals(Object o){
        return (o instanceof Partido p) && p.nombre.equalsIgnoreCase(nombre);
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre, votos);
    }

    @Override
    public String toString(){
        return nombre + " : " + votos;
    }

}
