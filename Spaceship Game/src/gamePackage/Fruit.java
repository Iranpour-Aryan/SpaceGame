package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Fruit extends GameObjects{
	 Control control;
	public Fruit(float x, float y, ID id, Control control) {
		super(x, y, id);
		this.control = control;
		
	}

	
	public void tick() {
		this.x += vel_x;
		this.y += vel_y;
		
		collision();
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.pink);
		g.fillOval((int) x,(int) y, 30, 30);
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle((int) x,(int) y, 30, 30);
	}
	
	public void collision() {
		for(int i= 0; i < control.object.size(); i++) {
			GameObjects gameObj = this.control.object.get(i);
			if(gameObj.getID() == ID.Player) {
				if(Player_Analysis.health <= 250) {
					if(getBounds().intersects(gameObj.getBounds())) {
						Player_Analysis.health += 20;
						control.removeObject(this);
					}
				}
			}
		}
	}

}
