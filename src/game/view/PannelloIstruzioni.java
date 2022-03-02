package game.view;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import game.settings.Settings;
import game.utility.CaricatoreImmagini;

public class PannelloIstruzioni extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private BufferedImage sfondo;
	private int indice;
	
	public PannelloIstruzioni(FlowLayout g, int indice) {
		super(g);
		this.indice = indice;
		caricaRirsorse();
	}
	
	private void caricaRirsorse() {
		CaricatoreImmagini loader = new CaricatoreImmagini();
		if (indice==1)
			sfondo = loader.caricaImmagine("/img/Istruzioni_inizio.png");
		else if (indice==2)
			sfondo = loader.caricaImmagine("/img/Istruzioni_2.png");

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(sfondo, 0, 0, Settings.LARGHEZZA, Settings.ALTEZZA, this);


	}


}