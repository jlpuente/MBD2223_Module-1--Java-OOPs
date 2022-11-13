package org.uma.mbd.mdLibreriaV1L;

import java.util.ArrayList;
import java.util.List;

public class Libreria {
    private List<Libro> libros;

    public Libreria(){
        libros = new ArrayList<>();
    }

    private void addLibro(Libro l) {
        int pos = posicionLibro(l.getAutor(), l.getAutor());
        if (pos < 0) {
            libros.add(l);
        } else {
            // Está en pos
            libros.set(pos,l);
        }
    }

    private int posicionLibro(String autor, String titulo){
        int pos = 0;
        while(pos < libros.size()
                && !libros.get(pos).getAutor().equalsIgnoreCase(autor)
                && !libros.get(pos).getTitulo().equalsIgnoreCase(titulo)){
            pos++;
        }
        return (pos == libros.size()) ? -1: pos;
    }

    public void addLibro(String autor, String titulo, double precioBase){
        Libro l = new Libro(autor, titulo, precioBase);
        addLibro(l);
    }

    public void remLibro(String autor, String titulo){
        int pos = posicionLibro(autor, titulo);
        if(pos >= 0){
            // El libro existe y hay que eliminarlo
            libros.remove(pos);
        }
    }

    public double getPrecioBase(String autor, String titulo){
        int pos = posicionLibro(autor, titulo);
        return (pos >= 0) ? libros.get(pos).getPrecioBase(): 0;
    }

    public double getPrecioFinal(String autor, String titulo){
        int pos = posicionLibro(autor, titulo);
        return (pos >= 0) ? libros.get(pos).getPrecioFinal(): 0;
    }

    @Override
    public String toString(){
        return libros.toString();
    }
}
