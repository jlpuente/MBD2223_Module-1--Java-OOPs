package org.uma.mbd.mdTren.trenes;

import java.util.ArrayList;
import java.util.List;

public class Tren {

    private List<Vagon> vagones;
    private int capacidadComun, numVagones;

    public Tren(int numVagones, int capacidadComun){
        this.capacidadComun = capacidadComun;
        this.numVagones = numVagones;
        vagones = new ArrayList<>();
        for(int i = 0; i < numVagones; i++){
            vagones.add(new Vagon(capacidadComun));
        }
    }

    public void carga(int ton){
        // Recorrer tren mientras queden toneladas que cargar y queden vagones por cargar
        int pos = 0;
        while(ton > 0 && pos < vagones.size()){
            if (vagones.get(pos).getCarga() < capacidadComun)
                ton = vagones.get(pos).carga(ton);
            pos++;
        }
        // Si hemos examinado todos los vagones y todavia quedan toneladas por cargar
        if (pos == vagones.size() && ton > 0){
            // Mientras queden toneladas por cargar, crear nuevo vagon y cargar
            while(ton > 0){
                vagones.add(pos, new Vagon(capacidadComun));
                ton = vagones.get(pos).carga(ton);
                pos++;
            }
        }
    }

    public void gasta(int ton){
        // Recorrer el tren hasta que no queden toneladas que descargar y queden vagones por gastar
        int pos = 0;
        while(ton > 0 && pos < vagones.size()){
            if (vagones.get(pos).getCarga() > 0)
                ton = vagones.get(pos).descarga(ton);
            pos++;
        }
        // Si hemos agotado el carbón contenido en los vagones, no es posible seguir gastando
        if(pos == vagones.size() && ton > 0)
            throw new IllegalArgumentException("Insuficiente carbón: el tren no dispone de tal cantidad de carbón para gastar.");
    }

    public void optimiza(){
        // Recorrer tren en busca de vagones vacíos que eliminar
        for(int i = 0; i < vagones.size(); i++){
            if (vagones.get(i).getCarga() == 0)
                vagones.remove(i);
        }
    }

    @Override
    public String toString() {
        String stringVagones = "";
        for (int i = 0; i < vagones.size(); i++){
            stringVagones += vagones.get(i).toString();
            if(i < (vagones.size() - 1))
                stringVagones += ", ";
        }
        return "Tren[" + stringVagones + "]";
    }
}
