package game.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

import game.settings.Settings;
import game.settings.VariabiliGioco;

public class Navicella extends Thread{
	//Creo l'oggetto del gioco che si muoverà e che bisognerà "proteggere"
	
	private int larghezza;
	private int altezza;
	private boolean play;
	BufferedImage [] img;
	private int x;
	private int y;
	private int speed = 2;
	public int vita;

	
	public Navicella(BufferedImage[] img, int larghezza, int altezza, int x, int y) {
		this.larghezza = larghezza;
		this.altezza = altezza;
		play = true;
		this.img = img;
		this.x = x;
		this.y = y;
		this.vita  = VariabiliGioco.vita;
	}


	@Override
    public void run() {
        play = true;
        while(play) {
            aggiorna();
            
                try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
          
        }
    }
    
	
	public void aggiorna(){
		
		Random max = new Random();

		if (this.x <= 60)
			 speed = max.nextInt(VariabiliGioco.VELOCITA_OGGETTO)+1;
		
		if (this.x >= Settings.LARGHEZZA-this.larghezza-60) {
			 speed = max.nextInt(VariabiliGioco.VELOCITA_OGGETTO)+1;
			 speed*=-1;
		}
		
		x+=speed;
		

		
	}
	
	
	public void disegna (Graphics g) {
		if (speed>0)
			disegnaDestra(g);
		else
			disegnaSinistra(g);
	}
	
	public void disegnaDestra (Graphics g) {
		if (VariabiliGioco.vita>75)
			g.drawImage(img[0], x, y, larghezza, altezza, null);
		else if (VariabiliGioco.vita>40)
			g.drawImage(img[2], x, y, larghezza, altezza, null);
		else
			g.drawImage(img[4], x, y, larghezza, altezza, null);

	}

	public void disegnaSinistra (Graphics g) {
		if (VariabiliGioco.vita>75)
			g.drawImage(img[1], x, y, larghezza, altezza, null);
		else if (VariabiliGioco.vita>40)
			g.drawImage(img[3], x, y, larghezza, altezza, null);
		else
			g.drawImage(img[5], x, y, larghezza, altezza, null);
	}


	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setLarghezza(int larghezza) {
		this.larghezza = larghezza;
	}

	
	public void setAltezza(int altezza) {
		this.altezza = altezza;
	}

	public boolean status() {
		return play;
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
		return new Rectangle (x,y,larghezza, altezza);
	}
	
	

}