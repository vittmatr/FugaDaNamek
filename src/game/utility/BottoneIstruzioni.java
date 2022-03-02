package game.utility;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BottoneIstruzioni extends JButton{

	private static final long serialVersionUID = 1L;
	
	// Utilizzo un indice per il cambio di pagina delle istruzioni
	
	public BottoneIstruzioni (int indice) {
		super("");
		Dimension dim = new Dimension(234,56);
		this.setPreferredSize(dim);
		if (indice==1)
			this.setIcon(new ImageIcon(getClass().getResource("/img/istruzioni_1.png")));
		else if (indice==2)
			this.setIcon(new ImageIcon(getClass().getResource("/img/toPage2.png")));
		this.setLocation(300, 300);
	}
	

	
}
