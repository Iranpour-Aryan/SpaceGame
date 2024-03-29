package gamePackage;

import java.awt.Graphics;
import java.util.ArrayList;



public class Control {
	ArrayList<GameObjects> object = new ArrayList<GameObjects>();
	
	SpaceGame game;
	
	public Control(SpaceGame game) {
		this.game = game;
	}
	
	public void tick() {
		for(int i = 0; i < object.size(); i++) {
			GameObjects obj = object.get(i);
			
			obj.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < object.size(); i++) {
			GameObjects obj = object.get(i);
			
			obj.render(g);
		}
	}
	
	public void clearEnemy() {
		for(int i = 0; i < object.size(); i++) {
			GameObjects tempObject = object.get(i);
			
			if(tempObject.getID() != ID.Player) {
				object.clear();
			}
		}
	}
	
	public void clearPlayer() {
		for(int i = 0; i < object.size(); i++) {
			GameObjects tempObject = object.get(i);
			
			if(tempObject.getID() == ID.Player) {
				object.clear();
			}
		}
	}
	
	
	public void addObject(GameObjects object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObjects object) {
		this.object.remove(object);
	}
}
