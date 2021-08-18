package gamePackage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;


public class SpaceGame extends Canvas implements Runnable{
	

	private static final long serialVersionUID = 6915852865565394913L;
	public static final int WIDTH = 900;
	public static final int HEIGHT = WIDTH/10 * 9;
	
	Window window;
	private Thread thread;
	Random r;
	private Player player;
	private Player_Analysis pA;
	private boolean runGame = false;
	private Control control;
	private Menu menu;
	public static boolean paused = false;
	private ObjectSpawner spawn;
	
	public enum State{
		Menu,
		Game,
		Help,
		End
	}
	
	public static State gameState = State.Menu;
	
	
	public SpaceGame() {
		control = new Control(this);
		pA = new Player_Analysis();
		window = new Window(WIDTH, HEIGHT, "Lets create a Space game!", this);
		r = new Random();
		player = new Player(450, 500, ID.Player, control);
		this.addKeyListener(new KeyInput(control, this, player));
		menu = new Menu(this, control, pA, player);
		this.addMouseListener(menu);
		
		if(gameState == State.Game) {
			control.addObject(player);
			control.addObject(new Enemy(r.nextInt(SpaceGame.WIDTH -40), r.nextInt(SpaceGame.HEIGHT-750), ID.Enemy, control));
			control.addObject(new Enemy(r.nextInt(SpaceGame.WIDTH -40), r.nextInt(SpaceGame.HEIGHT-750), ID.Enemy, control));
			control.addObject(new Fruit(r.nextInt(SpaceGame.WIDTH -30),510, ID.Fruit, control));
		}
				
		spawn = new ObjectSpawner(control, pA, this);
	}
	
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		runGame = true;
	}
	
	public synchronized void stop() {
		try {
			  //  Block of code to try
			thread.join();
			runGame = false;
			}
			catch(Exception e) {
			  //  Block of code to handle errors
				e.printStackTrace();
			}
	}
	
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountofTicks = 60.0;
		double ns = 1000000000 / amountofTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(runGame) {
			long now = System.nanoTime();
			delta += (now- lastTime) / ns;
			lastTime = now;
			while(delta>= 1) {
				tick();
				delta--;
			}
			if(runGame) {
				render();
			}
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	
	private void tick() {
		if(gameState == State.Game) {
			if (!paused){
				pA.tick();
				control.tick();
				spawn.tick();
				if(pA.health <= 0) {
					pA.health = 100;
					gameState = State.End;
					control.clearEnemy();
				}
			}
		}
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.yellow);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		control.render(g);
		
		if(gameState == State.Game) {
			pA.render(g);
		}
		
		else if(gameState == State.Menu || gameState == State.Help || gameState == State.End){
			menu.render(g);
		}
		
		if(paused) {
			g.setColor(Color.black);
			g.drawString("PAUSED", 400, 300);
		}
		
		g.dispose();
		bs.show();
	}
	
	public static float clamp(float var,float min, float max) {
		if(var <= min) {
			var = min;
		}
		else if(var >= max) {
			var = max;
		}
		else {
			return var;
		}
		return var;
	}

	
	public static void main(String[] args) {
		new SpaceGame();
	}

}









