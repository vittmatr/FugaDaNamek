package game.model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import game.settings.Settings;
import game.settings.VariabiliGioco;

public class Asteroidi extends Thread{
	// Creo una classe che rappresenta la pioggia di meteoriti
	
	private int num_asteroidi;
	private int difficulty;
	private boolean tempesta_attiva;
	private CopyOnWriteArrayList<Asteroide> asteroidi; // utilizzo struttura thread safe
	BufferedImage img;
	Random random;
	
	public Asteroidi(BufferedImage img, int num_asteroidi, int difficulty) {
		this.img = img;
		this.num_asteroidi = num_asteroidi;
		this.difficulty = difficulty;
		asteroidi = new CopyOnWriteArrayList<Asteroide>();
		random = new Random();
	}
	
	@Override
	public void run() {
		tempesta_attiva = true;
		while (tempesta_attiva) {
			for (int i=0; i<num_asteroidi-1; i++) {
				asteroidi.add(new Asteroide(img, 32, 32, random.nextInt(Settings.LARGHEZZA), 45, random.nextInt(VariabiliGioco.VELOCITA_OGGETTO)+1));
			}
			try {
				Thread.sleep(difficulty);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public CopyOnWriteArrayList<Asteroide> getAsteroidi() {
		return asteroidi;
	}

	public void setArray(CopyOnWriteArrayList<Asteroide> tmp) {
		asteroidi=tmp;
	}
	
	
	public void disegna(Graphics g) {
		for (int i=0; i<asteroidi.size(); i++) {
			Asteroide tmp = asteroidi.get(i);
			tmp.disegna(g);
		}
	}

}
