package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player_Bullets extends GameObjects{

	public Player_Bullets(float x, float y, ID id) {
		super(x, y, id);
		vel_y = 3;
		vel_x = 0;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,30,30);
	}

	
	public void tick() {
		this.y += vel_y;
		this.x += vel_x;
	}

	
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.drawOval((int) x, (int) (y), 30, 30);
	}
	
}
