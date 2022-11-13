package org.uma.mbd.mdLibreria.libreria;

import java.util.Arrays;

public class Libreria {
    private Libro[] libros;
    private int numLibros;
    private static int TAM_DEFECTO = 16;

    public Libreria(){
        this(TAM_DEFECTO); // Llamada al segundo constructor
    }

    public Libreria(int n){
        libros = new Libro[n];
        numLibros = 0;
    }

    private void addLibro(Libro l) {
        int pos = posicionLibro(l.getAutor(), l.getAutor());
        if (pos < 0) {
            // No está en la librería
            aseguraQueCabe();
            libros[numLibros] = l;
            numLibros++;
        } else {
            // Está en pos
            libros[pos] = l;
        }
    }

    private void aseguraQueCabe(){
        if (numLibros == libros.length){
            // Hay que agrandar
            libros = Arrays.copyOf(libros, numLibros*2);
        }
    }

    private int posicionLibro(String autor, String titulo){
        int pos = 0;
        while(pos < numLibros
                && !libros[pos].getAutor().equalsIgnoreCase(autor)
                && !libros[pos].getTitulo().equalsIgnoreCase(titulo)){
            pos++;
        }
        return (pos == numLibros) ? -1: pos;
    }

    public void addLibro(String autor, String titulo, double precioBase){
        Libro l = new Libro(autor, titulo, precioBase);
        addLibro(l);
    }

    public void remLibro(String autor, String titulo){
        int pos = posicionLibro(autor, titulo);
        if(pos >= 0){
            // El libro existe y hay que eliminarlo
            for(int i = pos; i < numLibros-1; i++){
                libros[i] = libros[i+1];
            }
            libros[numLibros] = null;
            numLibros--;
        }
    }

    public double getPrecioBase(String autor, String titulo){
        int pos = posicionLibro(autor, titulo);
        return (pos >= 0) ? libros[pos].getPrecioBase(): 0;
    }

    public double getPrecioFinal(String autor, String titulo){
        int pos = posicionLibro(autor, titulo);
        return (pos >= 0) ? libros[pos].getPrecioFinal(): 0;
    }

    @Override
    public String toString(){
        String salida = "[";
        for(int i = 0; i < numLibros; i++){
            salida += libros[i];
            if(i < numLibros -1){
                salida += ", ";
            }
        }
        salida += "]";
        return salida;
    }
}
