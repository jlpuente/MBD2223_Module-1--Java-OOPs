package org.uma.mbd.mdLibreriaV4.libreria;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
    protected List<Libro> libros;

    public Libreria(){
        libros = new ArrayList<>();
    }

    protected void addLibro(Libro l) { // !
        int pos = libros.indexOf(l); // // indexOf usa equals en la lista
        if (pos < 0) {
            libros.add(l);
        } else {
            // Está en pos
            libros.set(pos,l);
        }
    }

    private int posicionLibro(String autor, String titulo){ // !
        Libro libro = new Libro(autor, titulo, 0);
        return libros.indexOf(libro);
    }

    public void addLibro(String autor, String titulo, double precioBase){
        Libro l = new Libro(autor, titulo, precioBase);
        addLibro(l);
    }

    public void remLibro(String autor, String titulo){ // Cambiar
        int pos = posicionLibro(autor, titulo);
        if(pos >= 0){
            // El libro existe y hay que eliminarlo
            libros.remove(pos);
        }
    }

    public double getPrecioBase(String autor, String titulo){ // Cambiar
        int pos = posicionLibro(autor, titulo);
        return (pos >= 0) ? libros.get(pos).getPrecioBase(): 0;
    }

    public double getPrecioFinal(String autor, String titulo){ // Cambiar
        int pos = posicionLibro(autor, titulo);
        return (pos >= 0) ? libros.get(pos).getPrecioFinal(): 0;
    }

    @Override
    public String toString(){
        return libros.toString();
    }
}
