package org.uma.mbd.mdMasterMindL.masterMind;

import java.util.ArrayList;
import java.util.List;

public class MasterMindMemoria extends MasterMind{

    private List<Movimiento> movimientos;

    public MasterMindMemoria(){
        super();
        movimientos = new ArrayList<>();
    }

    public MasterMindMemoria(String cs){
        super(cs);
        movimientos = new ArrayList<>();
    }

    public MasterMindMemoria(int tam){
        super(tam);
        movimientos = new ArrayList<>();
    }

    private boolean intentoRepetido(String intento){
        boolean repetido = false;
        int pos = 0;
        while(!repetido && pos < movimientos.size()){
            if (movimientos.get(pos).intento().equals(intento))
                repetido = true;
            pos++;
        }
        return repetido;
    }

    @Override
    public Movimiento intento(String cifras){
        if (intentoRepetido(cifras))
            throw new MasterMindException("Se ha repetido ese movimiento.");
        Movimiento m = super.intento(cifras);
        movimientos.add(m);
        return m;
    }

    public List<Movimiento> movimientos(){
        return movimientos;
    }
}
