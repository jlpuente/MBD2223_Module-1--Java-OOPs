package org.uma.mbd.mdTren.trenes;

public class Vagon {

    private int capacidad;
    private int carga;

    public Vagon(int capacidad){
        this.capacidad = capacidad;
        carga = 0;
    }

    public int carga(int ton){
        int cabe = getCapacidad();
        int sobra;
        if(ton > cabe){
            carga = capacidad;
            sobra = ton - cabe;
        }else {
            carga += ton;
            sobra = 0;
        }
        return sobra;
    }

    public int descarga(int ton){
        int queda = carga - ton;
        int falta;
        if(queda >= 0){
            carga = queda;
            falta = 0;
        }else{
            carga = 0;
            falta = -queda;
        }
        return falta;
    }

    public int getCarga(){
        return carga;
    }

    public int getCapacidad(){
        return (capacidad - carga);
    }

    @Override
    public String toString(){
        return "V(" + carga + "/" + capacidad + ")";
    }

}
