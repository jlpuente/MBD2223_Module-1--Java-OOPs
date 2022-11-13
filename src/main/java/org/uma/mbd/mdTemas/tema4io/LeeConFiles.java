package org.uma.mbd.mdTemas.tema4io;

import java.io.IOException;
import java.nio.file.*;
public class LeeConFiles {
    public static void main(String[] args) throws IOException {
        String fichero = "recursos/mdTemas/tema4io/personas.txt";
        for (String linea: Files.readAllLines(Paths.get(fichero)))
            System.out.println(linea);
    }
}
