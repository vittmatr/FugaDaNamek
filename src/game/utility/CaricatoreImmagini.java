package game.utility;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CaricatoreImmagini {
	
	// Classe per rendere più agevole l'inserimento di immagini
	
	BufferedImage image;
	
	public BufferedImage caricaImmagine (String posizione) {
		try {
			image = ImageIO.read(getClass().getResource(posizione));
		} catch (IOException e) {
			System.out.println("Immagine non caricata in posizione " + posizione);
		}
		
		return image;
	}

}
