package m;

import java.awt.Graphics;

public class MetodosMapa {


	public void dibujarMapa(Graphics g) {
		int[][] Sectores = new int[10][10];
		Sector s = new Sector(80, 80, 0, 0);
		for (int i = 0; i < Sectores.length; i++) {
			for (int j = 0; j < Sectores.length; j++) {
				// System.out.println("Hola");
				s.pintarSector(g);
				s.setPosicionX(s.getPosicionX() + 80);
				if (j == 9) {
					// System.out.println("hola1");
					s.setPosicionY(s.getPosicionY() + 80);
					s.setPosicionX(0);
				}

			}
		}

	}
}
