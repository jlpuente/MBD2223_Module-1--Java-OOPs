package org.uma.mbd.mdMisPruebas;

import java.util.Scanner;

public class ScannerAnalizadorSimple {

    public static void main(String[] args) {

        String datos = "Juan García,23.Pedro González:15.Luisa López-19.Ana Marín Cortés-28";
        try(Scanner sc = new Scanner(datos)){
            sc.useDelimiter("[.]");
            while (sc.hasNext()){
                String linea = sc.next();
                try(Scanner scLinea = new Scanner(linea)){
                    scLinea.useDelimiter("[,:-]");
                    while (scLinea.hasNext()){
                        String nombre = scLinea.next();
                        System.out.print(nombre);
                        int edad = scLinea.nextInt();
                        System.out.println("\t\t" + edad);
                    }
                    scLinea.close();
                }
            }
            sc.close();
        }
    }

}
