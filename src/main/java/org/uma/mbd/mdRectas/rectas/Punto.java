package org.uma.mbd.mdRectas.rectas;
import java.lang.Math;

public class Punto {
    private double x, y;

    public Punto(){
        x = 0;
        y = 0;
    }

    public Punto(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double distancia(Punto p){
        return Math.sqrt(Math.pow(x - p.x, 2) + Math.pow(y - p.y, 2));
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    @Override
    public String toString(){
        return "P(" + x + "," + y + ")";
    }

    public void trasladar(double x, double y){
        setX(this.x + x);
        setY(this.y + y);
    }
}
