package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.Objects;

public record Pareja(Persona uno, Persona otro) {

    @Override
    public boolean equals(Object o){
        return (o instanceof Pareja p)
                && ((p.uno == uno && p.otro == otro) || (p.otro == uno && p.uno == otro));
    }

    @Override
    public int hashCode(){
        return Objects.hash(uno, otro);
    }

}
