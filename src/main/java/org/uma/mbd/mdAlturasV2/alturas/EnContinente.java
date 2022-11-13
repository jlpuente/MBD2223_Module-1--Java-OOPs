package org.uma.mbd.mdAlturasV2.alturas;

public class EnContinente implements Seleccion {

    public String texto;

    public EnContinente(String continente){
        texto = continente;
    }

    public boolean test(Pais pais){
        return texto.contains(pais.continente());
    }

}
