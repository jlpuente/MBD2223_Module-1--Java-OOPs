package org.uma.mbd.mdPartidos;

import org.uma.mbd.mdPartidos.partidos.*;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by pacog on 15/4/16.
 */
public class MainElecciones {
    // Elecciones de municipales 2011
    public static String [] datosVotacion = {
            "P.P.,123655",
            "P.S.O.E.,57245",
            "IULV-CA,25354",
            "UPyD,8099",
            "LOS VERDES,3197",
            "CvM - EP-And.,1514",
            "CENB,1431",
            "PACMA,1098",
            "C's,722",
            "PIRATA,718",
            "PDLPEA,534",
            "PARTICIPA,533",
            "P.C.P.E.,428",
            "A.u.N.,375",
            "FE de las JONS,301",
            "PH,279",
            "SAIn,260",
            "U.C.E.,102"};
    public static void main(String [] args) {
        try {
            EleccionesManager eleccionesM = new EleccionesManager(new Elecciones());
            eleccionesM
                    .setEntrada("recursos/mdPartidos/partidos.txt")
                    .setDatos(datosVotacion)
                    .setConsola(true);

            System.out.println("Con Dhont Simple");
            eleccionesM
                    .setSalida("recursos/mdPartidos/dhonts.txt")
                    .setCriterioSeleccion(new DHontSimple())
                    .setNumEsc(31)
                    .build();


/*
            System.out.println("\nCon Dhont filtrado al 5%");
            eleccionesM
                    .setSalida("recursos/mdPartidos/dhont.txt")
                    .setCriterioSeleccion(new DHont(5))
                    .setNumEsc(31)
                    .build();

 */
/*
            System.out.println("\nCon Proporcional");
            eleccionesM
                    .setSalida("recursos/mdPartidos/prop.txt")
                    .setCriterioSeleccion(new Proporcional())
                    .setNumEsc(31)
                    .build();
*/
        } catch (EleccionesException e) {
            System.out.println("ERROR " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR E/S "+ e.getMessage());
        }
    }
}


