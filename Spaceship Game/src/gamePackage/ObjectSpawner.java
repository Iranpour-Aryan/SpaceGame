package gamePackage;

import java.awt.Graphics;
import java.util.Random;

public class ObjectSpawner {
	
	private Control control;
	private Health health;
	private SpaceGame game;
	Random r;
	
	private int score;
	
	public ObjectSpawner(Control control, Health health, SpaceGame game) {
		this.control = control;
		this.health = health;
		this.game = game;
		r = new Random();
	}
	
	public void tick() {
		score ++;
		
		if(score >= 200) {
			score = 0;
			health.setLevel(health.getLevel() + 1);			
			for(int i = 0; i < health.getLevel(); i++) {
				control.addObject(new Enemy(r.nextInt(SpaceGame.WIDTH -40), r.nextInt(SpaceGame.HEIGHT-750), ID.Enemy, control));
				if(r.nextInt(15) == 1) {
					control.addObject(new Fruit(r.nextInt(SpaceGame.WIDTH -30),510, ID.Fruit, control));
				}
			}
		}
	}
	
	public void render(Graphics g) {
		
	}
}
