package game.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import game.Main;
import game.settings.Settings;
import game.settings.VariabiliGioco;
import game.utility.BottoneHome;
import game.utility.BottoneLivelli;
import game.utility.Soundtrack;

public class SelezionaLivello {
	
	public static void main(String[] args) {
		JFrame f = new JFrame("SELEZIONA LIVELLO");
		f.setSize(Settings.LARGHEZZA, Settings.ALTEZZA);
		FlowLayout g = null;
		PannelloLivello panel = new PannelloLivello(g);
		BottoneHome home = new BottoneHome(4);
		BottoneLivelli liv1 = new BottoneLivelli(2);
		BottoneLivelli liv2 = new BottoneLivelli(3);
		BottoneLivelli liv3 = new BottoneLivelli(4);
		BottoneLivelli liv4 = new BottoneLivelli(5);
		Soundtrack ostLivelli = new Soundtrack("SelezioneLivello.wav");
		ostLivelli.play();
		
		home.setBounds(1015, 605, 230, 85);
		liv1.setBounds(815, 115, 230, 95);
		liv2.setBounds(815, 235, 230, 95);
		liv3.setBounds(815, 355, 230, 95);
		liv4.setBounds(815, 475, 230, 95);

	
		panel.add(home);
		panel.add(liv1);
		panel.add(liv2);
		panel.add(liv3);
		panel.add(liv4);
		panel.setSize(300,150);
		panel.setOpaque(false);
		f.add(panel);
		panel.setBackground(null);
		panel.setLocation(500,400);


		f.setVisible(true);
		f.setResizable(false);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				ostLivelli.stop();
				Main.main(args);
				
			}
		});
		
		liv1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VariabiliGioco.VELOCITA_OGGETTO =5;
				
			}
		});
		
		liv2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VariabiliGioco.VELOCITA_OGGETTO =10;
				
			}
		});

		liv3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VariabiliGioco.VELOCITA_OGGETTO =12;
				
			}
		});

		liv4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VariabiliGioco.VELOCITA_OGGETTO =15;
				
			}
		});



	}

}



