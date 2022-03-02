package game.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import game.Main;
import game.settings.Settings;
import game.utility.BottoneHome;
import game.utility.BottoneIstruzioni;
import game.utility.Soundtrack;

public class Istruzioni {

	public static void main(String[] args) {
		JFrame f = new JFrame("Fuga da Namek");
		f.setSize(Settings.LARGHEZZA, Settings.ALTEZZA);
		FlowLayout g = null;
		PannelloIstruzioni panel = new PannelloIstruzioni(g,1);
		BottoneHome home = new BottoneHome(3);
		BottoneIstruzioni toPage2 = new BottoneIstruzioni(2);
		Soundtrack ostIstruzioni = new Soundtrack("Istruzioni.wav");
		ostIstruzioni.loop();
		home.setBounds(25, 605, 335, 95);
		toPage2.setBounds(925, 605, 335, 95);
		
		panel.add(home);
		panel.add(toPage2);
		
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
				ostIstruzioni.stop();
				Main.main(args);
			}
		});
		
		toPage2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				f.setVisible(false);
				ostIstruzioni.stop();
				Istruzioni_Page2.main(args);
			}
		});
		
		

		
	}

}
