package game.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import game.settings.Settings;

public class SfereDelDrago extends Thread{
	
	// Pioggia di oggetti bonus
	
	private int frequenza_sfere;
	private int difficulty;
	private boolean attiva_sfere;
	private CopyOnWriteArrayList<Sfera> sfere;
	BufferedImage[] img;
	Random random;
	
	public SfereDelDrago(BufferedImage[] img, int frequenza_sfere, int difficulty) {
		this.img = img;
		this.frequenza_sfere = frequenza_sfere;
		this.difficulty = difficulty;
		sfere = new CopyOnWriteArrayList<Sfera>();
		random = new Random();
	}
	
	@Override
	public void run() {
		attiva_sfere = true;
		while (attiva_sfere) {
			for (int i=0; i<frequenza_sfere; i++) {
				int index = random.nextInt(7);
				sfere.add(new Sfera(img[index], 32, 32, random.nextInt(Settings.LARGHEZZA), -32, 18));
}
			try {
				Thread.sleep(difficulty);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public CopyOnWriteArrayList<Sfera> getSfere() {
		return sfere;
	}

	public void setSfere (CopyOnWriteArrayList<Sfera> tmp) {
		sfere=tmp;
	}
	
	
	public void disegna(Graphics g) {
		for (int i=0; i<sfere.size(); i++) {
			Sfera tmp = sfere.get(i);
			tmp.disegna(g);
		}
	}

}
