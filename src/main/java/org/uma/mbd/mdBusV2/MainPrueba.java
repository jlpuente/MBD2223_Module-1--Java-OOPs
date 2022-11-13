package org.uma.mbd.mdBusV2;


import org.uma.mbd.mdBusV2.buses.Bus;
import org.uma.mbd.mdBusV2.buses.EnMatricula;
import org.uma.mbd.mdBusV2.buses.PorLinea;
import org.uma.mbd.mdBusV2.buses.Servicio;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Set;

public class MainPrueba {
    public static void main(String[] args) {
        try {
            Servicio emt = new Servicio("Málaga");
            emt.leeBuses("recursos/mdBusV1/buses.txt");


            Comparator<Bus> cbon = Comparator.naturalOrder();

            Set<Bus> set = emt.filtra(new PorLinea(21), cbon);

            emt.guarda(new PrintWriter(System.out, true),
                    cbon,
                    new EnMatricula("A"));

        } catch (IOException e) {
            System.err.println("Fichero no encontrado " + e.getMessage());
        }
    }
}
