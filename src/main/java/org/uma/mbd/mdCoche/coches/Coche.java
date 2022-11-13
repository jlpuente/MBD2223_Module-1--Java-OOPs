package org.uma.mbd.mdCoche.coches;

public class Coche {
    private String nombre;
    private double precio;
    private static double PIVA = 0.16;

    public Coche(String nombre, double precio){
        this.nombre = nombre;
        this.precio = precio;
    }

    public static void setPIVA(double nuevoPIVA){
        Coche.PIVA = nuevoPIVA;
    }

    public static void setPiva(double piva) {
        Coche.PIVA = piva;
    }

    public double precioTotal(){
        return precio + precio * Coche.PIVA;
    }

    @Override
    public String toString(){
        return nombre + " -> " + precioTotal();
    }
}
