package org.uma.mbd.mdJarras.jarras;

public class Jarra {

    public int contenido;
    public final int capacidad;

    public Jarra(int c){

        capacidad = c;
        contenido = 0;

    }

    public void llenar(){
        contenido = capacidad;
    }

    public void vaciar(){
        contenido = 0;
    }

    public void llenarDesde(Jarra j){
        int cabe = capacidad - contenido;
        if(cabe >= j.contenido){
            contenido += j.contenido;
            j.contenido = 0;
        }else{
            contenido = capacidad;
            j.contenido -= cabe;
        }
    }

    @Override
    public String toString(){
        return "J(" + capacidad + ", " + contenido + ")";
    }

    // Definición de métodos getter. La clase Jarra compone a la clase Mesa.
    public int getContenido(){
        return contenido;
    }

    public int getCapacidad(){
        return capacidad;
    }

}
