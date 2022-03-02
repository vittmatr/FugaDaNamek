package game.controller;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import game.model.Player;
import game.settings.Settings;
import game.settings.VariabiliGioco;
import game.view.PannelloGioco;

public class PlayerListener implements KeyListener, MouseMotionListener{
	


	Player player = null;
	Graphics g = null;
	
	public PlayerListener(Player player, Graphics g) {
		this.player = player;
		this.g = g;
	} 



	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				player.versoSinistra();
				break;
			case KeyEvent.VK_RIGHT:
				player.versoDestra();
				break;
			case KeyEvent.VK_UP:
				player.versoSopra();
				break;
			case KeyEvent.VK_DOWN:
				player.versoSotto();
				break;
			case KeyEvent.VK_SPACE:
					player.attacca();
		
				
			case KeyEvent.VK_A:
				player.versoSinistra();
				break;
			case KeyEvent.VK_D:
				player.versoDestra();
				break;
			case KeyEvent.VK_W:
				player.versoSopra();
				break;
			case KeyEvent.VK_S:
				player.versoSotto();
				break;
			case KeyEvent.VK_R:
				VariabiliGioco.GAMEOVER = false;
				VariabiliGioco.play = true;
				VariabiliGioco.vita = 100;
				VariabiliGioco.punti = 0;
				break;
			default:
				return;
		}
		
		player.disegna(PannelloGioco.g);

	}


	@Override
	public void mouseMoved(MouseEvent e) {
		int pointX = (e.getPoint().x)-(player.getLarghezza()/2);
		int pointY = (e.getPoint().y)-(player.getLarghezza()/2);
		
		if (pointX>-80 && pointX+player.getLarghezza()-13<=Settings.LARGHEZZA)
			player.setX(pointX);
		
		if (pointY>-20 && pointY+player.getAltezza()-20<=Settings.ALTEZZA)
			player.setY(pointY);
		
		
	}
	

	@Override
	public void keyReleased(KeyEvent e) {}
			
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		
//		int pointX = (e.getPoint().x)-(player.getLarghezza()/2);
//		int pointY = (e.getPoint().y)-(player.getLarghezza()/2);
//		
//		if (pointX>-80 && pointX+player.getLarghezza()-13<=Settings.LARGHEZZA)
//			player.setX(pointX);
//		
//		if (pointY>-20 && pointY+player.getAltezza()-20<=Settings.ALTEZZA)
//			player.setY(pointY);
		
	}


}
