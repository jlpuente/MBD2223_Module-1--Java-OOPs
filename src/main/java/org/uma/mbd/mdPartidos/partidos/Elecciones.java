package org.uma.mbd.mdPartidos.partidos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Elecciones {

    private List<Partido> partidos;

    public Elecciones(){
        partidos = new ArrayList<>();
    }

    static private Partido stringToPartido(String dato){
        Partido p = null;
        try {
            String[] partes = dato.split("[,]+");
            p = new Partido(partes[0], Integer.parseInt(partes[1]));
        }catch (EleccionesException e){
            System.err.println("when adding a party from String data.");
        }
        return p;
    }

    public void leeDatos(String[] datos){
        for (String dato: datos){
            partidos.add(stringToPartido(dato));
        }
    }

    public void leeDatos(String nombreFichero) throws IOException{

        Path path = Paths.get(nombreFichero);
        List<String> lineas = Files.readAllLines(path);
        leeDatos(lineas.toArray(new String[0]));

    }

    public Map<Partido, Integer> generaResultados(CriterioSeleccion cs, int numEsc){

        return cs.ejecuta(partidos, numEsc);

    }

    public void presentaResultados(String nombreFichero, Map<Partido, Integer> map) throws FileNotFoundException {

        try(PrintWriter pw = new PrintWriter(nombreFichero)){
            presentaResultados(pw, map);
        }catch (FileNotFoundException e){
            System.err.println("Error: path file is incorrect.");
        }

    }

    public void presentaResultados(PrintWriter pw, Map<Partido, Integer> m){

        for (Partido p: partidos){
            int ne = m.getOrDefault(p, 0);
            pw.print(p);
            if (ne == 0)
                pw.println(", Sin representación");
            else if(ne > 0)
                pw.println(", " + m.get(p));
        }

    }

}
