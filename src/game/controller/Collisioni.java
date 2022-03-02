package game.controller;

import game.model.Asteroide;
import game.model.Navicella;
import game.model.Player;

public class Collisioni {
	
	public static boolean verificaContattoGiocatore(Player goku, Asteroide asteroide) {
		return goku.limiteBordi().intersects(asteroide.limiteBordi());
	}

	public static boolean verificaContattoNavicella(Navicella navicella, Asteroide asteroide) {
		return navicella.limiteBordi().intersects(asteroide.limiteBordi());
	}

	
}
