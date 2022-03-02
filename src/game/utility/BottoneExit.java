package game.utility;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class BottoneExit extends JButton{

	private static final long serialVersionUID = 1L;
	

	public BottoneExit () {
		super("");
		Dimension dim = new Dimension(235,55);
		this.setPreferredSize(dim);
		this.setIcon(new ImageIcon(getClass().getResource("/img/esci_1.png")));
		this.setLocation(300, 300);

	}
	

	
}
