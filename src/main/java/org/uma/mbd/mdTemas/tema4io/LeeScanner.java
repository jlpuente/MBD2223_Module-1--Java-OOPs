package org.uma.mbd.mdTemas.tema4io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class LeeScanner {
    public static void main(String[] args) throws IOException {
        String fichero = "recursos/mdTemas/tema4io/personas.txt";
        try (Scanner sc = new Scanner(Paths.get(fichero))) {
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}
