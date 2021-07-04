package gamePackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Enemy extends GameObjects{
	
	private Control control;
	private int timer = 40;
	private int timer2 = 30;
	Random r = new Random();
	
	public Enemy(int x, int y, ID id, Control control) {
		super(x, y, id);
		this.control = control;
		this.vel_x = 0;
		this.vel_y = 3;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x,(int)y,40,40);
	}

	
	public void tick() {
		this.x += this.vel_x;
		this.y += this.vel_y;
		
		if(timer <= 0) {
			this.vel_y = 0;
		}
		
		else {
			timer--;
		}
		
		if(timer <= 0) {
			timer2--;
		}
		if(timer2<= 0) {
			if(this.vel_x == 0) {
				this.vel_x = 4;
			}
		}
			
		if(this.x <= 0 || this.x >=SpaceGame.WIDTH -40) {
			this.vel_x *= -1;
		}
	}
		

	
	public void render(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect((int)x,(int) y, 40, 40);
	}

}
