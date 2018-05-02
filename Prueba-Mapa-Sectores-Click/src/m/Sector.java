package m;

import java.awt.Color;
import java.awt.Graphics;

public class Sector {
	//Atributos
	private int alto;
	private int ancho;
	private int posicionX;
	private int posicionY;
	private static final Color colorSinPulsar= Color.red;
	private static final Color colorPulsado=Color.blue;
	private boolean pulsado=false;
	private static int numero=0;
	private int numero2=numero;
	
	//Constructores-----------------------------------------------------------------
	public Sector(int alto, int ancho, int posicionX, int posicionY) {
		this.alto=alto;
		this.ancho=ancho;
		this.posicionX=posicionX;
		this.posicionY=posicionX;
		this.numero++;
		System.out.println("Uno mas");
	}
	//Metodos-----------------------------------------------------------------------
	public void CambiarColor() {
		if(pulsado) this.getColorPulsado();
		else this.getColorSinPulsar();
	}
	public void pintarSector(Graphics g) {
		g.drawRect(getPosicionX(), getPosicionY(), getAncho(), getAlto());
	}
	//Getters/Setters---------------------------------------------------------------
	public boolean isPulsado() {
		return pulsado;
	}
	public void setPulsado(boolean pulsado) {
		this.pulsado = pulsado;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getPosicionX() {
		return posicionX;
	}
	public void setPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}
	public int getPosicionY() {
		return posicionY;
	}
	public void setPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}
	public Color getColorSinPulsar() {
		return colorSinPulsar;
	}
	public Color getColorPulsado() {
		return colorPulsado;
	}
}
