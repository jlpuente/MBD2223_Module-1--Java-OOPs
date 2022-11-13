package org.uma.mbd.mdTemas.tema4io;

import java.io.IOException;

public class MainSPersona {

	public static void main(String [] args) throws IOException {
		SPersona sp = new SPersona();
		sp.leePersonas("recursos/mdTemas/tema4io/personas.txt");
		System.out.println(sp.getPersonas());
	}
}
