package game.model;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.concurrent.CopyOnWriteArrayList;
import game.settings.Settings;
import game.settings.VariabiliGioco;
import game.utility.CaricatoreRisorseGioco;

public class Player {
	
	// Creazione del giocatore
	
	private int larghezza;
	private int altezza;
	private int x;
	private int y;
	BufferedImage[] img_player;
	BufferedImage img_palla;
	
	public static CopyOnWriteArrayList<AttaccoPallaEnergetica> palle_energia;
	
	public Player(BufferedImage[] img_player, BufferedImage img_palla, int x, int y, int larghezza, int altezza) {
		this.img_player = img_player;
		this.img_palla = img_palla;
		this.x = x;
		this.y = y;
		this.larghezza = larghezza;
		this.altezza = altezza;
		
		palle_energia = new CopyOnWriteArrayList<AttaccoPallaEnergetica>();
	}
	
	public void disegna(Graphics g) {
		if (VariabiliGioco.punti<3) {
			g.drawImage(img_player[0], x, y, larghezza, altezza, null);
			VariabiliGioco.trasformazione_goku=0;
		} else if (VariabiliGioco.punti>=3 && VariabiliGioco.punti<=7) {
			g.drawImage(img_player[1], x, y, larghezza, altezza, null);
			CaricatoreRisorseGioco.trasformazione.playNoLoop();
			VariabiliGioco.trasformazione_goku=1;
		} else {
			g.drawImage(img_player[2], x, y, larghezza, altezza, null);
			CaricatoreRisorseGioco.trasformazione_2.playNoLoop();
			VariabiliGioco.trasformazione_goku=2;
		}

	}
	
	
	public void attacca () {
			palle_energia.add(new AttaccoPallaEnergetica(img_palla, x+larghezza/2, y, 48, 48));

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
	
	public CopyOnWriteArrayList<AttaccoPallaEnergetica> getPalleEnergia () {
		return palle_energia;
	}
	
	public void setPalleEnergia (CopyOnWriteArrayList<AttaccoPallaEnergetica> tmp) {
		palle_energia=tmp;
	}
	
	
	public void versoDestra() {
		if ((x+larghezza+10)<=Settings.LARGHEZZA) {
			x+=Settings.VELOCITA_GIOCATORE;
		}
	}
	public void versoSinistra() {
		if (x>0) {
			x-=Settings.VELOCITA_GIOCATORE;
		}

	}	
	
	public void versoSopra() {
		if (y>0) {
			y-=Settings.VELOCITA_GIOCATORE;
		}
	}
	public void versoSotto() {
		if ((y+altezza+40)<=Settings.ALTEZZA) {
			y+=Settings.VELOCITA_GIOCATORE;
		}

	}
	


	public Rectangle limiteBordi() {
			return new Rectangle(x+141,y+45, 15, altezza-255);
	}
	

}
