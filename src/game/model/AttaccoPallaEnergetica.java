package game.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class AttaccoPallaEnergetica extends Thread{
	// Insieme delle palle sparate dal giocatore
	
	int larghezza;
	int altezza;
	int x;
	int y;
	BufferedImage img;
	private boolean play;
	private int speed=12;
	
	public AttaccoPallaEnergetica (BufferedImage img, int x, int y, int larghezza, int altezza) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.larghezza = larghezza;
		this.altezza = altezza;
		
		start();
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
			this.y-=speed;
	}
	
	public void disegna(Graphics g) {
		g.drawImage(img, x, y, larghezza, altezza, null);

	}

	
	 
		public int getX () {
			return x;
		}
		
		public int getY () {
			return y;
		}
		
		public int getLarghezza () {
			return larghezza;
		}
		
		public int getAltezza () {
			return altezza;
		}


		public Rectangle limiteBordi() {
			return new Rectangle(x+76,y+98, larghezza+80, altezza+90);

		}
		
	
	
}
