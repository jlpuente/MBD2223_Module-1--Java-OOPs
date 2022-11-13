package org.uma.mbd.mdEstadistica;
import java.util.Random;

public class MainEstadistica {
    public static final int TAMANO_PRUEBA = 100000;
    private static Random alea = new Random();

    public static void main(String[] args) {

        Estadistica est = new Estadistica();
        for(int i = 0; i < TAMANO_PRUEBA; i++){
            est.agrega(alea.nextGaussian());
        }
        System.out.println("Media " + est.media());
        System.out.println("DesvTip = " + est.desviacionTipica());

    }
}
