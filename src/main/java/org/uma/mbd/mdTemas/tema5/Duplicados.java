package org.uma.mbd.mdTemas.tema5;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Duplicados {
	public static void main(String[] args) {
		Set<String> s = new HashSet<>();
		for (String arg :  args) { 
			if (!s.add(arg)) {
				System.out.println("duplicado: " + arg);
			}
		}
		System.out.println(
			s.size() + " palabras detectadas: " + s);


		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			String pal = it.next();
			System.out.println(pal);
			if (pal.equals("db")) {
				it.remove();
			}
		}

		System.out.println(s);
		for (String pal : s) {
			System.out.println(pal);
			if (pal.equals("bb")) {
				s.remove(pal);
			}

		}

	}
}
