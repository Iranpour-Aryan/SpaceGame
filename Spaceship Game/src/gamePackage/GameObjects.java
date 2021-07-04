package gamePackage;

import java.awt.Graphics;


public abstract class GameObjects {
	protected float x;
	protected float y;
	protected ID id;
	protected float vel_x;
	protected float vel_y;
	
	public GameObjects(float x, float y, ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g);
	

	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getX() {
		return this.x;
	}
	
	public float getY() {
		return this.y;
	}
	
	public void setID(ID id) {
		this.id = id;
	}
	
	public ID getID() {
		return this.id;
	}
	
	public void setVelX(float velX) {
		this.vel_x = velX;
	}
	
	public void setVelY(float velY) {
		this.vel_y = velY;
	}
	
	public float getVelX() {
		return this.vel_x;
	}
	
	public float getVelY() {
		return this.vel_y;
	}
	

}
