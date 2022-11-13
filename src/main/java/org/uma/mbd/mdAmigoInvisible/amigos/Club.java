package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Club {

    protected List<Persona> socios;

    public Club(){
        socios = new ArrayList<>();
    }

    public void lee(String fEntrada, String delim) throws IOException{

        Path path = Paths.get(fEntrada);
        try(BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            String linea = br.readLine();
            while (linea != null){
                leeSocios(linea, delim); // delim es "[ -,;]+" en ClubManager o "[ ,;]+" en ClubPareja
                linea = br.readLine();
            }
        }

    }

    public void leeSocios(String linea, String delim){

        try(Scanner scLinea = new Scanner(linea)){
            scLinea.useDelimiter(delim);
            while (scLinea.hasNext()){
                String nombre = scLinea.next();
                creaSocioDesdeString(nombre);
            }
        }

    }

    protected void creaSocioDesdeString(String nombre){
        socios.add(new Persona(nombre));
    }

    protected void hacerAmigos(){

        int n = socios.size();
        List<Integer> posAmigos = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            posAmigos.add(i, i);

        while (hayCoincidencias(posAmigos));

        for (int i = 0; i < n; i++){
            int pos = posAmigos.get(i);
            Persona amigo = socios.get(pos);
            socios.get(i).setAmigo(amigo);
        }

    }


    private boolean hayCoincidencias (List<Integer> l){
        boolean coinciden = false;
        Collections.shuffle(l);
        int pos = 0;
        while (!coinciden && pos < l.size()){
            if (pos == l.get(pos))
                coinciden = true;
            else
                pos++;
        }
        return coinciden;
    }

    public void presentaAmigos(String fSalida) throws FileNotFoundException {

        Collections.sort(socios); // Ordena la lista según el orden natural establecido en la clase Persona
        File file = new File(fSalida);
        try(PrintWriter pw = new PrintWriter(file)){
            presentaAmigos(pw);
        }

    }

    public void presentaAmigos(PrintWriter pw){
        for (Persona p: socios)
            pw.println(p);
    }

}
