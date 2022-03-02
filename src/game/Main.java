package game;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import game.settings.Settings;
import game.settings.VariabiliGioco;
import game.utility.BottoneExit;
import game.utility.BottoneIstruzioni;
import game.utility.BottoneLivelli;
import game.utility.BottoneStart;
import game.utility.Soundtrack;
import game.view.Game;
import game.view.Istruzioni;
import game.view.PannelloIntroduttivo;
import game.view.SelezionaLivello;

public class Main{
	
	public static void main(String[] args) {
		JFrame f = new JFrame("ProgettoIGPE_Matranga");
		f.setSize(Settings.LARGHEZZA, Settings.ALTEZZA);
		FlowLayout g = null;
		PannelloIntroduttivo panel = new PannelloIntroduttivo(g);
		BottoneStart newGame = new BottoneStart();
		BottoneLivelli level = new BottoneLivelli(1);
		BottoneExit exit = new BottoneExit();
		BottoneIstruzioni istruzioni = new BottoneIstruzioni(1);
		Soundtrack ostIntro = new Soundtrack ("Intro.wav");
		ostIntro.loop();
		newGame.setBounds(510, 325, 236, 56);
		level.setBounds(510, 425, 235, 57);
		istruzioni.setBounds(510, 525, 234, 56); 
		exit.setBounds(510, 625, 235, 55);

		panel.add(newGame);
		panel.add(level);
		panel.add(exit);
		panel.add(istruzioni);
		panel.setOpaque(false);
		f.add(panel);
		panel.setBackground(null);


		f.setVisible(true);
		f.setResizable(false);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		newGame.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				ostIntro.stop();
				VariabiliGioco.GAMEOVER = false;
				VariabiliGioco.vita=100;
				VariabiliGioco.punti=0;
				VariabiliGioco.punti_bonus=0;
				Game.main(args);
				
			}
		});
		
		level.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				ostIntro.stop();
				SelezionaLivello.main(args);
			}
		});
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		
		istruzioni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				ostIntro.stop();
				Istruzioni.main(args);
				
			}
		});
		
	}

}


