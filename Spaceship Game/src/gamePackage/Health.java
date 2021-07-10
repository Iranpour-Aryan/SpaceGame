package gamePackage;

import java.awt.Color;
import java.awt.Graphics;

public class Health {
	private int level = 1;
	private int score = 0;
	public static int health = 100;
	private int greenBar = 255;
	
	
	public void tick() {
		health = (int) SpaceGame.clamp(health, 0, 200);
		greenBar = (int) SpaceGame.clamp(greenBar, 0, 255);
		greenBar = health * 2;
		score+= 1;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(15, 15, 200, 32);
		g.setColor(new Color(75, greenBar, 0));
		g.fillRect(15, 15, health * 2, 32);
		g.setColor(Color.white);
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
