/**
 * Aplicación que crea un objeto de la clase Mesa, compuesto por dos objetos de la clase Jarra,
 * y realiza las operaciones necesarias para dejar en cualquiera de ellas 1 L de agua.
 */

package org.uma.mbd.mdJarras;

import org.uma.mbd.mdJarras.jarras.Jarra;
import org.uma.mbd.mdJarras.jarras.Mesa;

public class PruebaMesa {

    public static void main(String[] args) {

        Mesa m = new Mesa(5, 7);

        m.llenarA();
        m.vuelcaASobreB();
        m.llenarA();
        m.vuelcaASobreB();
        m.vaciarB();
        m.vuelcaASobreB();
        m.llenarA();
        m.vuelcaASobreB();

        System.out.println(m.toString());

    }
}
