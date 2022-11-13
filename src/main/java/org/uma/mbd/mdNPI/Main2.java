package org.uma.mbd.mdNPI;
import org.uma.mbd.mdNPI.npi.NPI;

public class Main2 {
    public static void main(String[] args) {
        NPI npi = new NPI();
        npi.entra(3);
        npi.entra(6);
        npi.entra(2);
        npi.resta();
        npi.multiplica();
        npi.entra(2);
        npi.entra(7);
        npi.suma();
        npi.entra(5);
        npi.divide();
        npi.suma();
        System.out.println("Salida= " + npi.getResultado());
    }
}
