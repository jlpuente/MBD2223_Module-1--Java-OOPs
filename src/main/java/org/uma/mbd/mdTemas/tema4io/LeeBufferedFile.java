package org.uma.mbd.mdTemas.tema4io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LeeBufferedFile {
    public static void main(String[] args) throws IOException {
        String fichero = "recursos/mdTemas/tema4io/personas.txt";
        try (BufferedReader br =Files.newBufferedReader(Paths.get(fichero))) {
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
        }
    }
}

