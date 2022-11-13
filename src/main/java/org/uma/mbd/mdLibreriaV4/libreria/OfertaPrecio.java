package org.uma.mbd.mdLibreriaV4.libreria;

public class OfertaPrecio implements OfertaFlex {
    // Obligado a hacer el método getDescuento
    private double umbral;
    private double porDescuento;

    public OfertaPrecio(double porcentajeDescuento, double umbral){
        this.umbral = umbral;
        this.porDescuento = porcentajeDescuento;
    }

    @Override
    public double getDescuento(Libro libro){
        double descuento = 0;
        if (libro.getPrecioBase() >= umbral)
            descuento = porDescuento;
        return descuento;
    }

    @Override
    public String toString(){
        return porDescuento + "%(" + umbral + ")";
    }

}
