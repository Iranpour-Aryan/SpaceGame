package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player extends GameObjects{
	private Control control;
	public Player(int x, int y, ID id, Control control) {
		super(x, y, id);
		this.control = control;
	}

	
	public void tick() {
		x += vel_x;
		y += vel_y;
		
		x = SpaceGame.clamp(x, 0, SpaceGame.WIDTH-79);
		
		// clamp method is used to ensure our player does not leave the screen.
		collision();
	}

	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int)x, (int)y, 64, 64);
	}


	@Override
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,64,64);
	}
	
	public void collision() {
		for(int i= 0; i < control.object.size(); i++) {
			GameObjects gameObj = this.control.object.get(i);
			if(gameObj.getID() == ID.EnemyBullets) {
				if(getBounds().intersects(gameObj.getBounds())) {
					Player_Analysis.health --;
				}
			}
		}
	}
	
	

}
