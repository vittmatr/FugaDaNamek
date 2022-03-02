package game.utility;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BottoneStart extends JButton{

	private static final long serialVersionUID = 1L;
	

	public BottoneStart () {
		super("");
		Dimension dim = new Dimension(236,56);
		this.setPreferredSize(dim);
		this.setIcon(new ImageIcon(getClass().getResource("/img/inizio_1.png")));
		this.setLocation(300, 300);
	}
	

	
}
