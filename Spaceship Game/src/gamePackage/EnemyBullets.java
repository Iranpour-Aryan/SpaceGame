package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class EnemyBullets extends GameObjects{
	
	Control control;

	public EnemyBullets(float x, float y, ID id, Control control) {
		super(x, y, id);
		this.vel_x = 0;
		this.vel_y = 6;
		this.control = control;
	}

	@Override
	public void tick() {
		this.y += vel_y;
		
		if(this.y < 0 || this.x > SpaceGame.WIDTH) {
			control.removeObject(this);
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillOval((int) x, (int) (y), 20, 20);
		
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,20,20);
	}
	
}
