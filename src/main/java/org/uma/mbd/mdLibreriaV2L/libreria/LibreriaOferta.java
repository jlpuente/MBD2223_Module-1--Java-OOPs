package org.uma.mbd.mdLibreriaV2L.libreria;

public class LibreriaOferta extends Libreria{

    private String[] oferta; // autores en oferta
    private double descuento;

    public LibreriaOferta(double descuento, String[] autoresEnOferta){
        // Siempre hay que llamar al constructor padre, pero en este caso como no recibe argumentos no hace falta llamarlo.
        setOferta(descuento, autoresEnOferta);
    }

    public void setOferta(double descuento, String[] autoresEnOferta){
        this.descuento = descuento;
        oferta = autoresEnOferta;
        for (Libro libro: libros)
            addLibro(libro.getAutor(), libro.getTitulo(), libro.getPrecioFinal());
    }

    public String[] getOferta() {
        return oferta;
    }

    public double getDescuento() {
        return descuento;
    }

    @Override
    public void addLibro(String autor, String titulo, double precioBase){

        Libro libro;
        if (esAutorEnOferta(autor)){
            libro = new LibroEnOferta(autor, titulo, precioBase, descuento);
            addLibro(libro);
        }else{
            libro = new Libro(autor, titulo, precioBase);
            addLibro(libro);
        }



        /*
        Libro libro = esAutorEnOferta(autor)
                ? new LibroEnOferta(autor, titulo, precioBase, descuento)
                : new Libro(autor, titulo, precioBase);
        addLibro(libro);
        */
    }

    private boolean esAutorEnOferta(String autor){
        int pos = 0;
        while (pos < oferta.length && !autor.equalsIgnoreCase(oferta[pos]))
            pos++;
        return pos < oferta.length;
    }

    @Override
    public String toString(){
        String salida = descuento + "%[";
        for(int i = 0; i < oferta.length; i++){
            salida += oferta[i];
            if(i < oferta.length - 1)
                salida += "; ";
        }
        salida += "]";
        return salida + super.toString();
    }

}
