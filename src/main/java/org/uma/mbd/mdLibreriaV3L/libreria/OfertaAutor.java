package org.uma.mbd.mdLibreriaV3L.libreria;

public class OfertaAutor implements OfertaFlex{

    private String[] autoresEnOferta;
    private double porDescuento;

    public OfertaAutor(double porDescuento, String[] autoresEnOferta){
        this.porDescuento = porDescuento;
        this.autoresEnOferta = autoresEnOferta;
    }

    @Override
    public double getDescuento(Libro libro){
        int pos = 0;
        while(pos < autoresEnOferta.length && !libro.getAutor().equalsIgnoreCase(autoresEnOferta[pos]))
            pos++;
        return (pos < autoresEnOferta.length) ? porDescuento : 0;
    }

    @Override
    public String toString(){
        String salida =  porDescuento + "%[";
        for(int i = 0; i < autoresEnOferta.length; i++){
            salida += autoresEnOferta[i];
            if(i < autoresEnOferta.length - 1)
                salida += ";";
        }
        salida += "]";
        return salida + super.toString(); // Llama a método toString() de la superclase Object.
    }
}
