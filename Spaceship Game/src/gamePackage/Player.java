package gamePackage;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObjects{

	public Player(int x, int y, ID id) {
		super(x, y, id);
	}

	
	public void tick() {
		x += velX;
		y += velY;
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillOval((int)x, (int)y, 64, 64);
	}

}
