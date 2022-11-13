package org.uma.mbd.mdTemas.tema1;

enum Semana {Lun, Mar, Mie, Jue, Vie, Sab, Dom};

class EjemploEnum {
	public static void main(String[] args) {
		 Semana s = Semana.Lun;
		 Semana t = Semana.valueOf("Mie");

		 for(Semana se : Semana.values()) {
			System.out.print(se + "  ");
		 }
	}
}
