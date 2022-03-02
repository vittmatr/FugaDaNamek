package game.utility;

import java.awt.image.BufferedImage;
import game.model.Navicella;
import game.model.Player;
import game.view.Score;

public class CaricatoreRisorseGioco {
	
	
	public static Score score;
	public static Navicella navicella;
	public static Player player;
	
	public static BufferedImage sfondo = null;
	public static BufferedImage asteroide_img = null;
	public static BufferedImage asteroide_img_48 = null;
	public static BufferedImage [] sfera_img = new BufferedImage[7];
	public static BufferedImage [] player_img = new BufferedImage[3];
	public static BufferedImage pallaEnergetica_img = null;
	public static BufferedImage [] navicella_img = new BufferedImage[6];
	public static BufferedImage game_over = null;

	public static Soundtrack impatto_asteroide;
	public static Soundtrack impatto_navetta;
	public static Soundtrack raccogli_sfera;
	public static Soundtrack trasformazione;
	public static Soundtrack trasformazione_2;
	public static Soundtrack ost_gioco;

	
	
	public static void caricaRisorse() {
		CaricatoreImmagini loader = new CaricatoreImmagini();
		sfondo = loader.caricaImmagine("/img/namek.png");
		asteroide_img = loader.caricaImmagine("/img/asteroide32.png");
		asteroide_img_48 = loader.caricaImmagine("/img/asteroide48.png");
		navicella_img [0] = loader.caricaImmagine("/img/navicellaDestra.png");
		navicella_img [1] = loader.caricaImmagine("/img/navicellaSinistra.png");
		navicella_img [2] = loader.caricaImmagine("/img/navicellaDestraDanneggiata.png");
		navicella_img [3] = loader.caricaImmagine("/img/navicellaSinistraDanneggiata.png");
		navicella_img [4] = loader.caricaImmagine("/img/navicellaDestraMoltoDanneggiata.png");
		navicella_img [5] = loader.caricaImmagine("/img/navicellaSinistraMoltoDanneggiata.png");
		player_img [0] = loader.caricaImmagine("/img/GokuNormale.png");
		player_img [1] = loader.caricaImmagine("/img/Gokuss2.png");
		player_img [2] = loader.caricaImmagine("/img/Gokuss3.png");
		pallaEnergetica_img = loader.caricaImmagine("/img/pallaEnergetica.png");
		sfera_img [0]= loader.caricaImmagine("/img/sfera1.png");
		sfera_img [1]= loader.caricaImmagine("/img/sfera2.png");
		sfera_img [2]= loader.caricaImmagine("/img/sfera3.png");
		sfera_img [3]= loader.caricaImmagine("/img/sfera4.png");
		sfera_img [4]= loader.caricaImmagine("/img/sfera5.png");
		sfera_img [5]= loader.caricaImmagine("/img/sfera6.png");
		sfera_img [6]= loader.caricaImmagine("/img/sfera7.png");
		game_over = loader.caricaImmagine("/img/gameover.png");

		impatto_asteroide = new Soundtrack("ImpattoAsteroide.wav");
		impatto_navetta = new Soundtrack("ImpattoNavetta.wav");
		raccogli_sfera = new Soundtrack("Sfera.wav");
		trasformazione = new Soundtrack("Trasformazione_1.wav");
		trasformazione_2 = new Soundtrack("Trasformazione_2.wav");
		ost_gioco = new Soundtrack("Gioco.wav");
		
		score = new Score(navicella, player);
		player = new Player(CaricatoreRisorseGioco.player_img,CaricatoreRisorseGioco.pallaEnergetica_img,0,400, 170,271);
		navicella = new Navicella(CaricatoreRisorseGioco.navicella_img, 100, 100, 100, 600);
		navicella.start();

	}
	
	
}
