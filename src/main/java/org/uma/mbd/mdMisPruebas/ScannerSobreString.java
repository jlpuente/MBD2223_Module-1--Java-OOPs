package org.uma.mbd.mdMisPruebas;

import java.util.Scanner;

public class ScannerSobreString {

    public static void main(String[] args) {

        try(Scanner sc = new Scanner("hola a ; todos. como-estas")){
            sc.useDelimiter("[ ;.-]+");
            while (sc.hasNext()){
                String leido = sc.next();
                System.out.println(leido);
            }
        }

    }

}
