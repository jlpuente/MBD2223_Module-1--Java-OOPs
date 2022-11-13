package org.uma.mbd.mdUrna.urnas;
import java.util.NoSuchElementException;
import java.util.Random;

public class Urna {
    private static Random alea = null;
    private int blancas, negras;
    static public enum ColorBola {Blanca, Negra};

    public Urna(int numBlancas, int numNegras){
        if(numBlancas < 0 || numNegras < 0)
            throw new IllegalArgumentException("Número negativo de bolas.");
        blancas = numBlancas;
        negras = numNegras;
    }

    public int totalBolas(){
        return (negras + blancas);
    }

    public void ponerBlanca(){
        blancas++;
    }

    public void ponerNegra(){
        negras++;
    }

    public ColorBola extraerBola(){
        if(totalBolas() == 0)
            throw new NoSuchElementException("No quedan bolas.");
        ColorBola bolaSacada = null;
        Urna.alea = new Random();
        int n = 1 + Urna.alea.nextInt(totalBolas());
        if(n <= blancas){
            bolaSacada = ColorBola.Blanca;
            blancas--;
        }else{
            bolaSacada = ColorBola.Negra;
            negras--;
        }
        return bolaSacada;
    }

    @Override
    public String toString(){
        return "[blancas= " + blancas + "; negras= " + negras + "]";
    }
}
