package game.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.RoundingMode;
import game.model.Navicella;
import game.model.Player;
import game.settings.VariabiliGioco;
import game.utility.CaricatoreImmagini;

public class Score{


	private BufferedImage cuore;
	
	Font font = new Font ("ArcadeClassic", Font.BOLD, 50);
	
	
	public Score(Navicella navicella, Player player) {
		CaricatoreImmagini loader = new CaricatoreImmagini();
		cuore = loader.caricaImmagine("/img/cuore.png");
		font = new Font ("ArcadeClassic", Font.BOLD, 50);


	}
	
	
	public void disegna(Graphics g) {
		int x = 190;
		int add = 48;
		
		
		try {
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("Vita : ", 55, 42);
			
			if (VariabiliGioco.vita>0)
				g.drawImage(cuore, x, 3, 48, 48, null);
			if (VariabiliGioco.vita>25)
				g.drawImage(cuore, x+add, 3, 48, 48, null);
			if (VariabiliGioco.vita>50)
				g.drawImage(cuore, x+(2*add), 3, 48, 48, null);
			if (VariabiliGioco.vita>75)
				g.drawImage(cuore, x+(3*add), 3, 48, 48, null);
			
			BigDecimal score_arrotondato = new BigDecimal(VariabiliGioco.punti).setScale(3, RoundingMode.HALF_UP);
			double score = score_arrotondato.doubleValue();
			
			g.drawString("PUNTI: "+score, 920, 42);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

}
