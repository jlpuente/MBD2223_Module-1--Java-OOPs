/**
 * Aplicación que crea dos objetos de la clase Jarra, una con capacidad 5 L y otra con capacidad 7 L,
 * y realiza las operaciones necesarias para dejar en cualquiera de ellas 1 L de agua.
 */

package org.uma.mbd.mdJarras;

import org.uma.mbd.mdJarras.jarras.Jarra;

public class PruebaJarra {

    public static void main(String[] args) { // psvm + TAB

        Jarra j1 = new Jarra(5);
        Jarra j2 = new Jarra(7);

        j1.llenar();
        j2.llenarDesde(j1);
        j1.llenar();
        j2.llenarDesde(j1);
        j2.vaciar();
        j2.llenarDesde(j1);
        j1.llenar();
        j2.llenarDesde(j1);

        System.out.println(j1); // Jarra con 1 L
        System.out.println(j2);

    }

}
