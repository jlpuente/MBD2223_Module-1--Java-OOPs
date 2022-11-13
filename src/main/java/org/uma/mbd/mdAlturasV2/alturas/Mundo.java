package org.uma.mbd.mdAlturasV2.alturas;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Mundo {

    private List<Pais> paises;

    public Mundo(){
        paises = new ArrayList<>();
    }

    public List<Pais> getPaises(){
        return paises;
    }

    public void leePaises(String file) throws IOException{

        Path p = Path.of(file);
        try(Scanner sc = new Scanner(p)){
            while(sc.hasNextLine()){ // usa "\n" como delimitador
                String linea = sc.nextLine();
                try(Scanner scLinea = new Scanner(linea)){
                    scLinea.useDelimiter(","); // La coma es el delimitador
                    scLinea.useLocale(Locale.ENGLISH); // Para método nextDouble(): "alturas.txt" usa punto decimal
                    while (scLinea.hasNext()){
                        String nombre = scLinea.next();
                        String continente = scLinea.next();
                        double altura = scLinea.nextDouble();
                        paises.add(new Pais(nombre, continente, altura));
                    }
                }
            }
        }

    }

    public List<Pais> selecciona(Seleccion sel){
        List<Pais> lista = new ArrayList<>();
        for (Pais p: paises){
            if (sel.test(p))
                lista.add(p);
        }
        return lista;
    }
}