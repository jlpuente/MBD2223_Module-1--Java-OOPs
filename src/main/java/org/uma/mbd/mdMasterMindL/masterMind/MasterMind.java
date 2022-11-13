package org.uma.mbd.mdMasterMindL.masterMind;

import java.util.Random;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class MasterMind {

    public static final int TAMANO_POR_DEFECTO = 4;
    private static Random alea;
    protected String combinacionSecreta;
    private int longitud; // para método getLongitud()

    public MasterMind(){
        this(TAMANO_POR_DEFECTO);
    }

    public MasterMind (String combinacionSecreta){
        if (Integer.parseInt(combinacionSecreta) < 0 || combinacionSecreta.length() > 10)
            throw new MasterMindException("El número de cifras es mayor que 10.");
        this.combinacionSecreta = combinacionSecreta;
        longitud = combinacionSecreta.length();
    }

    public MasterMind(int tam){
        generaCombinacionSecreta(tam);
        longitud = combinacionSecreta.length();
    }

    private void generaCombinacionSecreta(int tam){

        MasterMind.alea = new Random();
        int intSecreto;
        String strSecreto = new String();
        combinacionSecreta = new String();
        int c = 0;
        String regex;
        Pattern p;
        Matcher m;
        while (c < tam){
            intSecreto = MasterMind.alea.nextInt(9);
            strSecreto = String.valueOf(intSecreto);
            regex = strSecreto + "+";
            p = Pattern.compile(regex);
            m = p.matcher(combinacionSecreta);
            if (!m.find()){
                combinacionSecreta += strSecreto;
                c++;
            }
        }
    }

    public int getLongitud(){
        return longitud;
    }

    public String getSecreto(){
        return combinacionSecreta;
    }

    private int getCifrasColocadas(String cifras){
        int n = 0;
        for(int i = 0; i < getLongitud(); i++)
            if (cifras.charAt(i) == combinacionSecreta.charAt(i))
                n++;
        return n;
    }

    private int getCifrasDescolocadas(String cifras){
        int n = 0;
        for(int i = 0; i < getLongitud(); i++) {
            if (combinacionSecreta.contains(String.valueOf(cifras.charAt(i)))
                    && combinacionSecreta.indexOf(cifras.charAt(i)) != i)
                n++;
        }
        return n;
    }

    public Movimiento intento(String cifras){
        if (!validaCombinacion(cifras))
            throw new MasterMindException("La cadena de cifras no es válida.");
        int numColocadas = getCifrasColocadas(cifras);
        int numDescolocadas = getCifrasDescolocadas(cifras);
        return new Movimiento(cifras, numColocadas, numDescolocadas);
    }

    private boolean contieneCifrasRepetidas(String cifras){
        boolean estaRepetido = false;
        String digito = String.valueOf(cifras.charAt(0));
        int i = 1;
        while (!estaRepetido && i < cifras.length()){
            if(cifras.substring(i).contains(digito))
                estaRepetido = true;
            digito = String.valueOf(cifras.charAt(i));
            i++;
        }
        return estaRepetido;
    }

    public boolean validaCombinacion(String cifras){
        boolean valida = true;
        if (cifras.length() != combinacionSecreta.length()
                || !cifras.matches("\\d{4}")
                || contieneCifrasRepetidas(cifras))
            valida = false;
        return valida;
    }

}
