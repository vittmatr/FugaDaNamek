package game.controller;

import game.model.Navicella;
import game.model.Player;
import game.model.Sfera;

public class ContattoSfera {
		
		public static boolean verificaContattoGiocatore(Player goku, Sfera sfera) {
			return goku.limiteBordi().intersects(sfera.limiteBordi());
		}

		public static boolean verificaContattoNavicella(Navicella navicella, Sfera sfera) {
			return navicella.limiteBordi().intersects(sfera.limiteBordi());
		}

		


}
