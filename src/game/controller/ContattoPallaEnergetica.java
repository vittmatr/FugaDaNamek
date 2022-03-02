package game.controller;


import game.model.Asteroide;
import game.model.AttaccoPallaEnergetica;

public class ContattoPallaEnergetica {
	
	public static boolean verificaContattoAsteroide(AttaccoPallaEnergetica palla_energetica, Asteroide asteroide) {
		return palla_energetica.limiteBordi().intersects(asteroide.limiteBordi());
	}

	


}
