package org.uma.mbd.mdTemas.tema4;

import java.util.Scanner;

public class MainSt {
	public static void main(String [] args) {
		try (Scanner sc = new Scanner("hola   a ; todos. como-estas")) {
			// Separadores: espacio . , ; -    una o más veces (+)
			sc.useDelimiter("[ .,;-]+");
			while (sc.hasNext()) {
				String palabra = sc.next();
				System.out.println(palabra);
			}
		}
	}
}
