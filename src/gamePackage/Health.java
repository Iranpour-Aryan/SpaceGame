package gamePackage;

import java.awt.Color;
import java.awt.Graphics;

public class Health {
	private int level = 1;
	private int score = 0;
	public static int health = 200;
	private int greenBar = 300;
	
	
	public void tick() {
		health = (int) SpaceGame.clamp(health, 0, 200);
		greenBar = (int) SpaceGame.clamp(greenBar, 0, 300);
		greenBar = health * 3;
		score+= 1;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(15, 15, 200, 32);
		
		g.setColor(Color.black);
		g.drawRect(15, 15, 200, 32);
		
		g.setColor(Color.black);
		g.drawRect(400, 15, 100, 30);
		g.setColor(Color.black);
		g.drawRect(600, 15, 100, 30);
		
		g.drawString("Score: " + score, 620, 30);
		g.drawString("Level: " + level, 420, 30);
	}
	
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public int getLevel() {
		return level;
	}


}
