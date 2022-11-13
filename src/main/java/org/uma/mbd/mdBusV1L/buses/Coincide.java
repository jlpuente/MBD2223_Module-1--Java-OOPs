package org.uma.mbd.mdBusV1L.buses;

public class Coincide implements Criterio{

    private Bus bus;

    public Coincide(Bus bus){
        this.bus = bus;
    }

    public boolean esSeleccionable(Bus bus) {
        return bus == this.bus;
    }

    @Override
    public String toString(){
        return "Autobús " + bus.getMatricula();
    }

}
