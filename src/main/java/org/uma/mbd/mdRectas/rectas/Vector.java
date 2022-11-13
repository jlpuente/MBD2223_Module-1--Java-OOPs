package org.uma.mbd.mdRectas.rectas;

public class Vector {

    private Punto extremo;

    public Vector(Punto p){
        extremo = p;
    }

    public Vector(Punto origen, Punto extremo){
        this.extremo = new Punto(extremo.getX() - origen.getX(), extremo.getY() - origen.getY());
    }

    public Vector(double x, double y){
        extremo = new Punto(x,y);
    }

    public Punto extremoDesde(Punto org){
        Punto p = new Punto(extremo.getX(), extremo.getY());
        p.trasladar(org.getX(), org.getY());
        return p;
    }

    public double getComponenteX(){
        return extremo.getX();
    }

    public double getComponenteY(){
        return extremo.getY();
    }

    public double modulo(){
        return extremo.distancia(new Punto());
    }

    public Vector ortogonal(){
        if(extremo.getY() == 0) // El cero no puede tener signo negativo
            return new Vector(extremo.getY(), extremo.getX());
        else
            return new Vector(-extremo.getY(), extremo.getX());
    }

    public boolean paraleloA(Vector v){
        return extremo.getX() * v.getComponenteY() == extremo.getY() * v.getComponenteX();
    }

    @Override
    public String toString(){
        return "V(" + extremo.getX() + "," + extremo.getY() + ")";
    }
}
