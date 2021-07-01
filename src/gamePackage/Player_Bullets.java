package gamePackage;

import java.awt.Graphics;

public class Player_Bullets extends GameObjects{

	public Player_Bullets(float x, float y, ID id) {
		super(x, y, id);
		vel_y = 3;
	}

	
	public void tick() {
		this.y += this.vel_y;
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}
