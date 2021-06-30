package gamePackage;

import java.awt.Graphics;
import java.util.ArrayList;


public class Control {
	ArrayList<GameObjects> object = new ArrayList<GameObjects>();
	
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
	
	
	
	public void addObject(GameObjects object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObjects object) {
		this.object.remove(object);
	}
}
