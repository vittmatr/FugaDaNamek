package game.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import game.Main;
import game.settings.Settings;
import game.utility.BottoneHome;
import game.utility.CaricatoreRisorseGioco;

public class Game {

	public static void main(String[] args) {
		
		PannelloGioco panel = new PannelloGioco();

		JFrame finestra = new JFrame("Fuga da Namek");
		Dimension dimensione = new Dimension (Settings.LARGHEZZA, Settings.ALTEZZA);
		
		finestra.setPreferredSize(dimensione);
		finestra.setMaximumSize(dimensione);
		finestra.setMinimumSize(dimensione);
		finestra.setResizable(false);
		finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BottoneHome home = new BottoneHome(5);
		CaricatoreRisorseGioco.ost_gioco.loop();
		
		home.setBounds(570, 5, 196, 44); 
		finestra.add(home);
		
		finestra.add(panel);
		finestra.pack();
		
		finestra.setVisible(true);
		
		
		Thread thread = new Thread (panel);
		thread.start();
		
		home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finestra.setVisible(false);
				CaricatoreRisorseGioco.ost_gioco.stop();
				Main.main(args);
				
			}
		});
		

	}

}
