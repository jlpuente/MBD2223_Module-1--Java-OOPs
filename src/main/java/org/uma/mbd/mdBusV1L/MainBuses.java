package org.uma.mbd.mdBusV1L.buses;

import java.io.IOException;
import java.io.PrintWriter;

public class MainBuses {
    public static void main(String [] args) {
        Servicio servicio = new Servicio("Malaga");
        try {
        	System.out.println(servicio.getCiudad());
            servicio.leeBuses("recursos/mdBusV1/buses.txt");
            Criterio cr1 = new PorLinea(21);
            servicio.guarda("recursos/mdBusV1/linea21.txt", cr1);
            System.out.println("Autobuses de la línea 21:");
            servicio.guarda(new PrintWriter(System.out,true), cr1);
            Criterio cr2 = new EnMatricula("29");
            servicio.guarda("recursos/mdBusV1/contiene29.txt", cr2);
            System.out.println("Autobuses cuya matricula contiene 29:");
            servicio.guarda(new PrintWriter(System.out,true), cr2);
        } catch (IOException e) {
            System.err.println("No existe el fichero de entrada");
        }
    }
}
