package org.uma.mbd.mdBusV2.buses;

public class Coincide implements Criterio {

    private Bus bus;

    public Coincide(Bus bus){
        this.bus = bus;
    }

    public boolean esSeleccionable(Bus bus) {
        return bus.equals(this.bus);
    }

    @Override
    public String toString(){
        return "Autobús " + bus.getMatricula();
    }

}
