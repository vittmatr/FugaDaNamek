package game.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Sfera extends Thread {
	
	// Creazione dell'oggetto bonus da raccogliere
	
	private int larghezza;
	private int altezza;
	private int x;
	private int y;
	private int speed;
	private boolean play;
	BufferedImage img;
	
	public Sfera(BufferedImage img, int larghezza, int altezza, int x, int y, int speed) {
		this.img = img;
		this.larghezza = larghezza;
		this.altezza = altezza;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.play=true;
		this.start();
	}
	
	@Override
	public void run() {
		play = true;
		while (play) {
			refresh();
			
			try {
				Thread.sleep(40);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void refresh() {
		y+=speed;
		
	}
	
	public void disegna(Graphics g) {
		g.drawImage(img, x, y, larghezza, altezza, null);
	}

	public int getLarghezza() {
		return larghezza;
	}

	public void setLarghezza(int larghezza) {
		this.larghezza = larghezza;
	}

	public int getAltezza() {
		return altezza;
	}

	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Rectangle limiteBordi() {
		return new Rectangle(x,y,larghezza,altezza);
	}
	

}