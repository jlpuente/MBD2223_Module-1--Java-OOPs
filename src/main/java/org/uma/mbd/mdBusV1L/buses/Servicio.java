package org.uma.mbd.mdBusV1L.buses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class Servicio {

    private String ciudad;
    private List<Bus> buses;

    public Servicio(String ciudad){
        this.ciudad = ciudad;
        buses = new ArrayList<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void leeBuses(String file) throws IOException {

        Path p = Path.of(file);
        try(Scanner sc = new Scanner(p)){
            while(sc.hasNextLine()){ // compruba si existe algo que leer hasta "\n"
                String linea = sc.nextLine(); // lee línea y salta de línea
                try(Scanner scLinea = new Scanner(linea)) {
                    scLinea.useDelimiter(","); // exactamente una coma
                    int codBus = scLinea.nextInt();
                    String matricula = scLinea.next();
                    int codLinea = scLinea.nextInt();
                    Bus bus = new Bus(codBus, matricula);
                    bus.setCodLinea(codLinea);
                    buses.add(bus);
                }catch (InputMismatchException e){
                    System.err.println("Error en línea " + linea + ": el dato es del tipo esperado.");
                }catch (NoSuchElementException ee){
                    System.err.println("Error en línea " + linea + ": faltan datos.");
                }
            }
        }

    }

    public List<Bus> filtra(Criterio criterio){
        List<Bus> lista = new ArrayList<>();
        for (Bus bus: buses){
            if (criterio.esSeleccionable(bus))
                lista.add(bus);
        }
        return lista;
    }

    public void guarda(String file, Criterio criterio) throws FileNotFoundException{

        File path = new File(file);

        try(PrintWriter pw = new PrintWriter(path)){
            guarda(pw, criterio);
        }

    }

    public void guarda(PrintWriter pw, Criterio criterio){

        List<Bus> lista = filtra(criterio);
        for (Bus bus: lista)
            pw.println(bus);

    }

}
