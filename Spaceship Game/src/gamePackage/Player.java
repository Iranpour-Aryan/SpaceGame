package gamePackage;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObjects{

	public Player(int x, int y, ID id) {
		super(x, y, id);
	}

	
	public void tick() {
		x += vel_x;
		y += vel_y;
		
		x = SpaceGame.clamp(x, 0, SpaceGame.WIDTH-79);
		
		// clamp method is used to ensure our player does not leave the screen.
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.fillOval((int)x, (int)y, 64, 64);
	}

}
