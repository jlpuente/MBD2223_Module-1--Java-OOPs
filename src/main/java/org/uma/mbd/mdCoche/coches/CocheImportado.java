package org.uma.mbd.mdCoche.coches;
import org.uma.mbd.mdCoche.coches.Coche;

public class CocheImportado extends Coche{
    private double homologacion;

    public CocheImportado(String nombre, double precio, double homologacion){
        super(nombre, precio);
        this.homologacion = homologacion;
    }

    @Override
    public double precioTotal(){
        return super.precioTotal() + homologacion;
    }

}
