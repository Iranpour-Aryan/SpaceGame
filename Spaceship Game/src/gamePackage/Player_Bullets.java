package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player_Bullets extends GameObjects{
	
	Control control;

	public Player_Bullets(float x, float y, ID id, Control control) {
		super(x, y, id);
		this.control = control;
		vel_y = 7;
		vel_x = 0;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,20,20);
	}

	
	public void tick() {
		this.y -= vel_y;
		
		if(this.y > SpaceGame.HEIGHT) {
			control.removeObject(this);
		}
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval((int) x, (int) (y), 20, 20);
	}
	
}
