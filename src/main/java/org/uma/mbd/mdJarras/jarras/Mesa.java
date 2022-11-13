package org.uma.mbd.mdJarras.jarras;

public class Mesa {

    Jarra j1, j2;

    public Mesa(int c1, int c2){
        j1 = new Jarra(c1);
        j2 = new Jarra(c2);
    }

    public void llenarA(){
        j1.llenar();
    }

    public void llenarB(){
        j2.llenar();
    }

    public void vaciarA(){
        j1.vaciar();
    }

    public void vaciarB(){
        j2.vaciar();
    }

    public void vuelcaASobreB(){
        j2.llenarDesde(j1);
    }

    public void vuelcaBSobreA(){
        j1.llenarDesde(j2);
    }

    public int getContenidoA(){
        return j1.getContenido();
    }

    public int getContenidoB(){
        return j2.getContenido();
    }

    public int getCapacidadA(){
        return j1.getCapacidad();
    }

    public int getCapacidadB(){
        return j2.getCapacidad();
    }

    public int getContenido(){
        return getContenidoA() + getContenidoB();
    }

    @Override
    public String toString(){
        return "JarraA(" + getCapacidadA() + ", " + getContenidoA() + ")\n" +
                "JarraB(" + getCapacidadB() + ", " + getContenidoB() + ")";
    }

}
