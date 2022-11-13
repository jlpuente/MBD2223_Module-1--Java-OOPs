package org.uma.mbd.mdBusV1L.buses;

import java.io.IOException;
import java.util.List;

public class MainPrueba {
    public static void main(String[] args) throws IOException {
        Servicio servicio = new Servicio("Málaga");
        servicio.leeBuses("src/main/java/org/uma/mbd/mdBusV1L/buses.txt");

        System.out.println(servicio.getCiudad());
        List<Bus> buses = servicio.getBuses();
        for (Bus bus: buses)
            System.out.println(bus);
    }
}
