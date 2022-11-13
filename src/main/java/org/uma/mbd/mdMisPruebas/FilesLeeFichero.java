package org.uma.mbd.mdMisPruebas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FilesLeeFichero {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("recursos/mdTemas/tema4io/personas.txt");
        List<String> lineas = new ArrayList<>();
        for (String linea: Files.readAllLines(path)){
            lineas.add(linea);
        }
        System.out.println(lineas);

    }

}
