package org.uma.mbd.mdUrna.urnas;
import java.lang.Integer;

public class EjUrna {
    public static void main(String[] args) {
        Urna urna = new Urna(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        Urna.ColorBola cb1 = null;
        Urna.ColorBola cb2 = null;
        while(urna.totalBolas() > 1){
            cb1 = urna.extraerBola();
            cb2 = urna.extraerBola();
            if(cb1.equals(cb2))
                urna.ponerBlanca();
            else
                urna.ponerNegra();
        }

        System.out.println(urna.extraerBola());

    }
}
