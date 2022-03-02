package game.utility;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BottoneLivelli extends JButton{

	private static final long serialVersionUID = 1L;
	
	// Utilizzo l'indice per gestire le immagini relative alla selezione dei livelli

	public BottoneLivelli (int indice) {
		super("");
		Dimension dim = new Dimension(235,57);
		this.setPreferredSize(dim);
		if (indice==1)
			this.setIcon(new ImageIcon(getClass().getResource("/img/livello_1.png")));
		else if (indice==2)
			this.setIcon(new ImageIcon(getClass().getResource("/img/liv_1.png")));
		else if (indice==3)
			this.setIcon(new ImageIcon(getClass().getResource("/img/liv_2.png")));
		else if (indice==4)
			this.setIcon(new ImageIcon(getClass().getResource("/img/liv_3.png")));
		else if (indice==5)
			this.setIcon(new ImageIcon(getClass().getResource("/img/liv_4.png")));
		this.setLocation(300, 300);

	}
	

	
}
