package org.uma.mbd.mdLibreriaV3L.libreria;

public class LibreriaOfertaFlexible extends Libreria{

    private OfertaFlex oferta;

    public LibreriaOfertaFlexible(OfertaFlex of){
        oferta = of;
    }

    @Override
    public void addLibro(String autor, String titulo, double precioBase){
        Libro l = new Libro(autor, titulo, precioBase);
        double descuento = oferta.getDescuento(l);
        if (descuento > 0)
            l = new LibroEnOferta(autor, titulo, precioBase, descuento);
        addLibro(l);
    }

    public OfertaFlex getOferta() {
        return oferta;
    }

    public void setOferta(OfertaFlex oferta) {
        this.oferta = oferta;
        for (Libro libro : libros)
            addLibro(libro.getAutor(), libro.getTitulo(), libro.getPrecioBase());
    }

    @Override
    public String toString(){
        return oferta + super.toString();
    }
}
