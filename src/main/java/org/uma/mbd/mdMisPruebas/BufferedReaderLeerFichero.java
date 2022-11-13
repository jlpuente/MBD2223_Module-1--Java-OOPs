package org.uma.mbd.mdMisPruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedReaderLeerFichero {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("recursos/mdTemas/tema4io/personas.txt");
        try(BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            String linea = br.readLine();
            while(linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
        }
    }
}
