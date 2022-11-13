package org.uma.mbd.mdRectas.rectas;

public class Recta {

    private Punto pto;
    private Vector direccion;

    public Recta(Punto p1, Punto p2){
        direccion = new Vector(p1, p2);
        pto = p1; // pto = p2;
    }

    public Recta(Vector direccion, Punto pto) {
        this.direccion = direccion;
        this.pto = pto;
    }

    /*
     Método privado propio para obtener el vector director de una recta cuando se recibe como parametro
     Uso en método interseccionCon(Recta r)
     */
    private Vector getDireccion(){
        return direccion;
    }

    /*
     Método privado propio para obtener el punto por el que pasa una recta cuando se recibe como parametro
     Uso en método interseccionCon(Recta r)
     */
    private Punto getPunto(){
        return pto;
    }

    private static double determinante(double a_11, double a_12, double a_21, double a_22){
        return a_11 * a_22 - a_12 * a_21;
    }

    public double distanciaDesde(Punto p){
        Recta rectaPerpendicular = perpendicularPor(p);
        Punto ptoInterseccion = interseccionCon(rectaPerpendicular);
        return p.distancia(ptoInterseccion);
    }

    private Implicita implicita (){
        return new Implicita(-direccion.getComponenteY(),
                direccion.getComponenteX(),
                -direccion.getComponenteX() * pto.getY() + direccion.getComponenteY() * pto.getX());
    }

    public Punto interseccionCon(Recta recta){
        if(paralelaA(recta)){
           throw new IllegalArgumentException("Las rectas son paralelas y no se cortan en ningún punto.");
        }

        Implicita misCoeficientes = implicita();
        Implicita susCoeficientes = new Recta(recta.getDireccion(), recta.getPunto()).implicita();

        double denominador;
        denominador = Recta.determinante(misCoeficientes.a(), misCoeficientes.b(), susCoeficientes.a(), susCoeficientes.b());
        System.out.println(denominador);

        if(denominador == 0)
            throw new ArithmeticException("El denominador es igual a 0 y no existe punto de corte.");

        return new Punto(Recta.determinante(-misCoeficientes.c(),
                misCoeficientes.b(), -susCoeficientes.c(), susCoeficientes.b()) / denominador,
                Recta.determinante(misCoeficientes.a(),
                        -misCoeficientes.c(), susCoeficientes.a(), -susCoeficientes.c()) / denominador);
    }

    public boolean paralelaA(Recta r){
        return direccion.paraleloA(r.getDireccion());
    }

    public Recta paralelaPor(Punto p){
        return new Recta(direccion, p);
    }

    public boolean pasaPor(Punto p){
        return direccion.paraleloA(new Vector(p, pto));
    }

    public Recta perpendicularPor(Punto p){
        return new Recta(direccion.ortogonal(), p);
    }

    @Override
    public String toString(){
        return "R(" + direccion + "," + pto + ")";
    }

}
