package org.uma.mbd.mdAmigoInvisible;

import org.uma.mbd.mdAmigoInvisible.amigos.AmigoException;
import org.uma.mbd.mdAmigoInvisible.amigos.ClubManager;
import org.uma.mbd.mdAmigoInvisible.amigos.ClubPareja;

import java.io.IOException;

public class Main {
	public static void main(String [] args) {
//		ClubManager clubM = new ClubManager(new Club());
		ClubManager clubM = new ClubManager(new ClubPareja());
		try {
			clubM
//				.setEntrada("recursos/mdAmigoInvisible/socios.txt", "[ ,-;]+")
				.setEntrada("recursos/mdAmigoInvisible/socios.txt", "[ ,;]+")
				.setConsola(true)
// 				.setSalida("recursos/mdAmigoInvisible/salida.txt")
				.build();
		} catch (IOException e) {
			System.out.println("Error en la entrada/salida de datos");
		} catch (AmigoException e) {
			System.out.println("Error: " + e.getMessage());			
		}
	}
}
