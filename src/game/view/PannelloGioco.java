package game.view;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import game.controller.Collisioni;
import game.controller.ContattoPallaEnergetica;
import game.controller.ContattoSfera;
import game.controller.PlayerListener;
import game.model.Asteroide;
import game.model.Asteroidi;
import game.model.AttaccoPallaEnergetica;
import game.model.Player;
import game.model.Sfera;
import game.model.SfereDelDrago;
import game.settings.Settings;
import game.settings.VariabiliGioco;
import game.utility.CaricatoreRisorseGioco;

public class PannelloGioco extends Canvas implements Runnable {


	private static final long serialVersionUID = 1L;
	
	private Asteroidi attacco_asteroidi;
	private SfereDelDrago sfere_del_drago;
	public static Graphics g = null;
	
	private PlayerListener player_listener;
	
	

	public PannelloGioco () {
		CaricatoreRisorseGioco.caricaRisorse();
		startGame();
	}
	


	private void disegna() {
		
		BufferStrategy buffer = this.getBufferStrategy();
		
		if (buffer == null) {
			createBufferStrategy(2);
			return;
		}
		
		g = buffer.getDrawGraphics();


		if (!VariabiliGioco.GAMEOVER) {
			g.drawImage(CaricatoreRisorseGioco.sfondo, 0, 0, Settings.LARGHEZZA, Settings.ALTEZZA, this);
			
			CaricatoreRisorseGioco.navicella.disegna(g);
			CaricatoreRisorseGioco.player.disegna(g);
			attacco_asteroidi.disegna(g);
			sfere_del_drago.disegna(g);
			
			CaricatoreRisorseGioco.score.disegna(g);

			
			
		for (AttaccoPallaEnergetica i: Player.palle_energia) {
			i.disegna(g);
		}
		
		
		} else
			g.drawImage(CaricatoreRisorseGioco.game_over, 0, 0, Settings.LARGHEZZA, Settings.ALTEZZA, this);
		
		g.dispose();		
		buffer.show();


	}




	private void refreshAsteroidi() {
		CopyOnWriteArrayList<Asteroide> asteroidi = attacco_asteroidi.getAsteroidi();
		Iterator<Asteroide> iter = asteroidi.iterator();


		CopyOnWriteArrayList<AttaccoPallaEnergetica> palleEnergia = CaricatoreRisorseGioco.player.getPalleEnergia();
		Iterator<AttaccoPallaEnergetica> iteratorePalle = palleEnergia.iterator();
		
		
		while (iter.hasNext()) {
			try {
				Asteroide asteroide = iter.next();

				if (iteratorePalle.hasNext()) {
					AttaccoPallaEnergetica palla = iteratorePalle.next();
					if (ContattoPallaEnergetica.verificaContattoAsteroide(palla, asteroide)) {
						asteroidi.remove(asteroide);
						palleEnergia.remove(palla);
						CaricatoreRisorseGioco.impatto_asteroide.play();
						
							if (VariabiliGioco.trasformazione_goku==2) {
								VariabiliGioco.punti +=0.1;
								VariabiliGioco.punti_bonus +=0.1;
							} else if (VariabiliGioco.trasformazione_goku==1) {
									VariabiliGioco.punti +=0.01;
									VariabiliGioco.punti_bonus +=0.01;
							} else {
								VariabiliGioco.punti +=0.001;
								VariabiliGioco.punti_bonus +=0.001;
							}
						
						break;
					}
					
				}

				if (Collisioni.verificaContattoGiocatore(CaricatoreRisorseGioco.player, asteroide)) {
					asteroidi.remove(asteroide);
					CaricatoreRisorseGioco.impatto_asteroide.play();
						if (VariabiliGioco.trasformazione_goku==2) {
							VariabiliGioco.punti +=0.1;
							VariabiliGioco.punti_bonus +=0.1;
						} else if (VariabiliGioco.trasformazione_goku==1) {
								VariabiliGioco.punti +=0.01;
								VariabiliGioco.punti_bonus +=0.01;
						} else {
							VariabiliGioco.punti +=0.001;
							VariabiliGioco.punti_bonus +=0.001;
						}
					break;
				} 
				 
				
				else if (Collisioni.verificaContattoNavicella(CaricatoreRisorseGioco.navicella, asteroide)) {
					asteroidi.remove(asteroide);
					CaricatoreRisorseGioco.impatto_navetta.play();
					VariabiliGioco.vita -= 5;
					break;
				}
				
				
				if (VariabiliGioco.vita<=0) {
					VariabiliGioco.GAMEOVER=true;
					VariabiliGioco.play=false;
				} 

				if (VariabiliGioco.punti_bonus>=2.5) {
					VariabiliGioco.punti_bonus =0;
					VariabiliGioco.vita = 100;
				}
				
			
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		}
	}
	
	
	private void refreshSfere() {

		CopyOnWriteArrayList<Sfera> sfere = sfere_del_drago.getSfere();
		Iterator<Sfera> iter = sfere.iterator();

		
		while (iter.hasNext()) {
			try {
				Sfera sfera = iter.next();
				if (ContattoSfera.verificaContattoGiocatore(CaricatoreRisorseGioco.player, sfera)) {
					sfere.remove(sfera);
					CaricatoreRisorseGioco.raccogli_sfera.play();
					if (VariabiliGioco.trasformazione_goku==2) {
						VariabiliGioco.punti +=2.0;
						VariabiliGioco.punti_bonus +=2.0;
					} else if (VariabiliGioco.trasformazione_goku==1) {
							VariabiliGioco.punti +=1.5;
							VariabiliGioco.punti_bonus +=1.5;
					} else {
						VariabiliGioco.punti +=1.0;
						VariabiliGioco.punti_bonus +=1.0;
					}

					break;
				}
				
				else if (ContattoSfera.verificaContattoNavicella(CaricatoreRisorseGioco.navicella, sfera)) {
					sfere.remove(sfera);
					CaricatoreRisorseGioco.raccogli_sfera.play();
					VariabiliGioco.punti -= 0.5;
					break;
				}
				
				
				if (VariabiliGioco.punti_bonus>=2.5) {
					VariabiliGioco.punti_bonus =0;
					VariabiliGioco.vita = 100;
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
}
	

	@Override
	public void run() {
		VariabiliGioco.play = true;
		while (true) {
			
			if (VariabiliGioco.play) {
				refreshAsteroidi(); 
				refreshSfere();
		}
			disegna();

		}
		
	}
	

	private void startGame() {
		player_listener = new PlayerListener(CaricatoreRisorseGioco.player, g);
		attacco_asteroidi = new Asteroidi(CaricatoreRisorseGioco.asteroide_img, 4, 600);
		attacco_asteroidi.start();	
		sfere_del_drago = new SfereDelDrago(CaricatoreRisorseGioco.sfera_img, 1, 9300);
		sfere_del_drago.start();
		this.addKeyListener(player_listener);
		this.addMouseMotionListener(player_listener);

	}





}
