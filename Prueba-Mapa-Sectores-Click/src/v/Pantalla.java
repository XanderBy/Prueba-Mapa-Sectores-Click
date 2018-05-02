package v;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import m.MetodosMapa;

public class Pantalla extends JFrame implements Runnable {
	MetodosMapa mm=new MetodosMapa();
	private boolean corriendo= false;
	BufferStrategy bs;
	Thread thread;
	Canvas canvas;
	Graphics g;
	
	public Pantalla() {
		configuracionPantalla();
		
	}
	public void configuracionPantalla() {
		this.setTitle("Prueba Sectores Click");
		this.setSize(800, 800);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas=new Canvas();
		
		
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(true);
		add(canvas);
		
	}
	public void update() {
		
	}
	public void draw() {
		bs=canvas.getBufferStrategy();
		if(bs==null) {
			canvas.createBufferStrategy(3);
			return;
		}
		g=bs.getDrawGraphics();
		g.clearRect(0, 0, 800, 800);
		
		
		mm.dibujarMapa(g);
		
		g.dispose();
		bs.show();
	}
	public void run() {
		while(corriendo) {
			update();
			draw();
		}
	}
	public void start() {
		thread=new Thread(this);
		thread.start();
		this.corriendo=true;
		
		
	}
	public void stop() {
		
		try {
			thread.join();
			this.corriendo=false;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
