package gamePackage;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy1 extends GameObjects{

	public Enemy1(float x, float y, ID id) {
		super(x, y, id);
		vel_y = 3;
	}

	
	public void tick() {
		if(this.y < 150) {
			this.y += vel_y;
		}
		else {
			this.vel_y = 0;
			this.vel_x = 3;
		}
		
		if(this.x <= 0 || this.x >= SpaceGame.WIDTH -40) {
			vel_x *= -1;
		}
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((int) x,(int) y, 40, 40);
	}
	
	
	
}
