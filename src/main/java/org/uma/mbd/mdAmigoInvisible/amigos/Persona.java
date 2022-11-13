package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.Objects;

public class Persona implements Comparable<Persona> {

    private String nombre;
    private Persona amigo;

    public Persona(String nombre){
        this.nombre = nombre;
        amigo = null;
    }

    public void setAmigo(Persona am){
        amigo = am;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona getAmigo() {
        return amigo;
    }

    @Override
    public boolean equals(Object o){
        return (o instanceof Persona p)
                && (p.nombre.equalsIgnoreCase(nombre));
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre.toLowerCase(), amigo);
    }

    @Override
    public int compareTo(Persona p){
        return nombre.compareToIgnoreCase(p.nombre);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(nombre).append(" --> ");
        if (amigo == null)
            sb.append("sin amigo");
        else
            sb.append(amigo.nombre);
        return sb.toString();
    }

}
