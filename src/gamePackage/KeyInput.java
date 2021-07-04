package gamePackage;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Control control;
	private boolean[] keyDown = new boolean[3];
	
	SpaceGame game;
	
	public KeyInput(Control control, SpaceGame game) {
		this.control = control;
		
		this.game  = game;
		
		
		keyDown[0] = false;
		keyDown[1] = false;
		keyDown[2] = false;
	}
	
	public void keyPressed(KeyEvent k) {
		int key = k.getKeyCode();
		
		for(int i = 0; i < control.object.size(); i++) {
			GameObjects temp = control.object.get(i);
			if(temp.getID() == ID.Player) {
				// key events for player 1
				
				if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					temp.setVelX(5);
					keyDown[0] = true;
				}
				if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
					temp.setVelX(-5);
					keyDown[1] = true;
				}
			}	
		}
		for(int i = 0; i < control.object.size(); i++) {
			GameObjects temp = control.object.get(i);
			if(temp.getID() == ID.Player_Bullets) {
				if(key == KeyEvent.VK_SPACE) {
					temp.setVelY(7);
					keyDown[2] = true;
				}
			}
		}
		
		
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
		
	}
	
	public void keyReleased(KeyEvent k) {
		int key = k.getKeyCode();
		for(int i = 0; i < control.object.size(); i++) {
			GameObjects temp = control.object.get(i);
			if(temp.getID() == ID.Player) {
				// key events for player 1
				
				
				if(key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
					//temp.setVelX(0);
					keyDown[0] = false;
				}
				if(key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
					//temp.setVelX(0);
					keyDown[1] = false;
				}

				if(!keyDown[0] && !keyDown[1]) {
					temp.setVelX(0);
				}
			}
			
		}
		for(int i = 0; i < control.object.size(); i++) {
			GameObjects temp = control.object.get(i);
			if(temp.getID() == ID.Player_Bullets) {
				if(key == KeyEvent.VK_SPACE) {
					temp.setVelY(7);
					keyDown[2] = false;
				}
			}
		}
	}
}
