package org.uma.mbd.mdBusV2.buses;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.*;

public class Servicio {

    private String ciudad;
    private Set<Bus> buses;

    public Servicio(String ciudad){
        this.ciudad = ciudad;
        buses = new TreeSet<>();
    }

    public String getCiudad() {
        return ciudad;
    }

    public Set<Bus> getBuses() {
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
                    System.err.println("Error en línea " + linea + ": el dato no es del tipo esperado.");
                }catch (NoSuchElementException ee){
                    System.err.println("Error en línea " + linea + ": faltan datos.");
                }
            }
        }

    }

    public Set<Bus> filtra(Criterio c, Comparator<Bus> cb){
        Set<Bus> set = new TreeSet<>(cb);
        for (Bus bus: buses){
            if (c.esSeleccionable(bus))
                set.add(bus); // Los buses que cumplen el criterio dado se añaden ordenadamente
        }
        return set;
    }

    public void guarda(String file, Comparator<Bus> cb, Criterio c) throws FileNotFoundException{

        File path = new File(file);

        try(PrintWriter pw = new PrintWriter(path)){
            guarda(pw, cb, c);
        }

    }

    public void guarda(PrintWriter pw, Comparator<Bus> cb, Criterio c){

        Set<Bus> cjto = filtra(c, cb);
        for (Bus bus: cjto)
            pw.println(bus);

    }

}
