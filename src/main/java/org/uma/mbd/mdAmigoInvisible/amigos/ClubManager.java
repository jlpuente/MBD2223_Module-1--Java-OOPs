package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class ClubManager {

    private String fEntrada;
    private String fSalida;
    private String delim;
    private boolean consola;
    private Club club;

    public ClubManager(Club club){
        this.club = club;
    }

    public ClubManager setEntrada (String fEntrada, String delim){
        this.fEntrada = fEntrada;
        this.delim = delim;
        return this;
    }

    public ClubManager setSalida(String fSalida){
        this.fSalida = fSalida;
        return this;
    }

    public ClubManager setConsola(boolean consola){
        this.consola = consola;
        return this;
    }

    private void verify(){
        if (fEntrada == null || fSalida == null && !consola)
            throw new AmigoException("Error: falta el fichero de entrada o la salida no está configurada.");
    }

    public void build() throws IOException, FileNotFoundException {
        verify();
        club.lee(fEntrada, delim);
        club.hacerAmigos();
        if (fSalida == null && consola) {
            club.presentaAmigos(new PrintWriter(System.out, true));
        }else if (fSalida != null && !consola)
            club.presentaAmigos(fSalida);
        else if (fSalida != null && consola) {
            club.presentaAmigos(fSalida);
            club.presentaAmigos(new PrintWriter(System.out, true));
        }
    }

}
