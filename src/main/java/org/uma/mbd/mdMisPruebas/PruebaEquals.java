package org.uma.mbd.mdMisPruebas;

public class PruebaEquals {

    public static void main(String[] args) {

        String s = "1234ABC";
        String s2 = "1234abc";
        System.out.println(s.equalsIgnoreCase(s2));

    }

}
