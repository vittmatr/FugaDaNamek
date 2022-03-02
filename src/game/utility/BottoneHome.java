package game.utility;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BottoneHome extends JButton {

	private static final long serialVersionUID = 1L;
	
// Utilizzo un indice per gestire le diverse immagini per tornare alla sezione home
	
	public BottoneHome (int indice) {
		super("");
		Dimension dim = new Dimension(300,80);
		this.setPreferredSize(dim);
		if (indice==1)
			this.setIcon(new ImageIcon(getClass().getResource("/img/inizio_1.png")));
		else if (indice==2)
			this.setIcon(new ImageIcon(getClass().getResource("/img/home_istruzioni1.png")));
		else if (indice==3)
			this.setIcon(new ImageIcon(getClass().getResource("/img/home_istruzioni2.png")));
		else if (indice==4)
			this.setIcon(new ImageIcon(getClass().getResource("/img/home_livelli.png")));
		else if (indice==5)
			this.setIcon(new ImageIcon(getClass().getResource("/img/home_gioco.png")));
		this.setLocation(300, 300);

	}
	

	
}
