package gamePackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import gamePackage.SpaceGame.State;

public class Menu extends MouseAdapter{
	private SpaceGame game;
	private Control control;
	private Player_Analysis player_analysis;
	Random r;
	
	public Menu(SpaceGame game, Control control, Player_Analysis player_analysis) {
		this.game = game;
		this.control = control;
		this.player_analysis = player_analysis;
		r = new Random();
	}
	
	public void mousePressed(MouseEvent m) {
		int mx = m.getX();
		int my = m.getY();
		if(game.gameState == State.Menu) {
			if(mouseOver(mx, my,300, 240, 300, 80)) {
				game.gameState = State.Game;
				control.addObject(new Player(450, 500, ID.Player, control));
				control.addObject(new Enemy(r.nextInt(SpaceGame.WIDTH -40), r.nextInt(SpaceGame.HEIGHT-750), ID.Enemy, control));
				control.addObject(new Enemy(r.nextInt(SpaceGame.WIDTH -40), r.nextInt(SpaceGame.HEIGHT-750), ID.Enemy, control));
				control.addObject(new Fruit(r.nextInt(SpaceGame.WIDTH -30),510, ID.Fruit, control));
			}
			if(mouseOver(mx, my,300, 350, 300, 80)) {
				game.gameState = State.Help;
			}
			if(mouseOver(mx, my, 300, 460, 300, 80)) {
				System.exit(1);
			}
		}
		
		if(game.gameState == State.Help) {
			if(mouseOver(mx, my, 210, 350, 200, 64)) {
				game.gameState = State.Menu;
				return;
			}
		}
		
		if(game.gameState == State.End) {
			game.gameState = State.Menu;
			player_analysis.setLevel(1);
			player_analysis.setScore(0);
		}
		
	}
	
	public void mouseReleased(MouseEvent m) {
		
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx < x+ width) {
			if(my> y && my< y+ height) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		if(game.gameState == State.Menu) {
			Font font = new Font("arial", 1, 60);
			Font font_2 = new Font("arial", 1, 40);
			
			g.setColor(Color.black);
			g.setFont(font);
			g.drawString("SpaceShip Game", 230, 150);
			
			g.setFont(font_2);
			
			g.drawRect(300, 240, 300, 80);
			g.setColor(Color.blue);
			g.fillRect(300, 240, 300, 80);
			g.setColor(Color.white);
			g.drawString("PLAY", 390, 295);
					
			g.drawRect(300, 350, 300, 80);
			
			g.setColor(Color.blue);
			g.fillRect(300, 350, 300, 80);
			g.setColor(Color.white);
			g.drawString("HELP", 390, 405);
			
			
			g.drawRect(300, 460, 300, 80);
			g.setColor(Color.blue);
			g.fillRect(300, 460, 300, 80);
			g.setColor(Color.white);
			g.drawString("QUIT", 390, 515);
		}
		
		else if(game.gameState == State.Help) {
			Font fnt = new Font("arial", 1, 50);
			Font fnt2 = new Font("arial", 1, 30);
			Font fnt3 = new Font("arial", 1, 20);

			g.setColor(Color.black);
			g.setFont(fnt);
			g.drawString("Help", 240, 70);
			
			g.setFont(fnt3);
			g.drawString("Use WASD or Arrows keys to move player and to doge enemies" , 50, 200);
			
			g.setFont(fnt2);
			g.drawRect(210, 350, 200, 64);
			g.drawString("Back", 270, 390);
		}
		
		
	}
}
