package v;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import m.MetodosMapa;
import m.Sector;

public class Pantalla extends JFrame implements Runnable, MouseListener{
	//MetodosMapa mm=new MetodosMapa();
	Sector s=new Sector(80, 80, 400, 400);
	private boolean corriendo= false;
	BufferStrategy bs;
	Thread thread;
	Canvas canvas;
	Graphics g;
	Sector sector;
	
	public Pantalla() {
		configuracionPantalla();
		addMouseListener(this);
	}
	public void configuracionPantalla() {
		this.setTitle("Prueba Sectores Click");
		this.setSize(800, 800);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas=new Canvas();
		//eventos=new Eventos();
		
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		canvas.setFocusable(true);
		add(canvas);
		
		//canvas.addMouseListener(eventos);
		
	}
	public void update() {
		//eventos.update();
	}
	public void draw() {
		bs=canvas.getBufferStrategy();
		if(bs==null) {
			canvas.createBufferStrategy(3);
			return;
		}
		g=bs.getDrawGraphics();
		g.clearRect(0, 0, 800, 800);
		
		s.pintarSector(g);
		//mm.dibujarMapa(g);
		
		g.dispose();
		bs.show();
	}
	public void run() {
		while(corriendo) {
			this.update();
			this.draw();
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
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		// TODO Auto-generated method stub
		if(1== e.getButton()) {
			System.out.println(s.getPosicionX());
			System.out.println("hola");
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
