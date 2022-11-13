package org.uma.mbd.mdTestL.tests;
import java.util.Objects;

public record Test(String nombre, int aciertos, int errores) {

    @Override
    public boolean equals(Object obj){
        return (obj instanceof Test t && t.nombre.equalsIgnoreCase(nombre));
    }

    @Override
    public int hashCode(){
        return Objects.hash(nombre.toLowerCase());
    }

    public double calificacion(double valAc, double valErr){
        return aciertos * valAc + errores * valErr;
    }

}
