package org.uma.mbd.mdTemas.tema5;

import org.uma.mbd.mdTemas.tema5.clases.SatString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FrecuenciasMOd {
	public static void main(String[] args) {
		Map<String, List<Integer>> frecs = new TreeMap<>(new SatString().reversed());
		int i = 0;
		for (String arg : args) {
			//List<Integer> lista = frecs.computeIfAbsent(arg, k -> new ArrayList<>()); // Esto es lo mismo q el for
			List<Integer> lista = frecs.get(arg);
			if (lista == null) {
				lista = new ArrayList<>();
				frecs.put(arg, lista);
			}
			// PD: Seguro que lista esta asociado a arg en frecs
			lista.add(i);
			i++;
		}

		System.out.println(frecs);

	}	
}
