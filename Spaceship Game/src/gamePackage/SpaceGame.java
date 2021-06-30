package gamePackage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


public class SpaceGame extends Canvas implements Runnable{
	

	private static final long serialVersionUID = 6915852865565394913L;
	public static final int WIDTH = 900;
	public static final int HEIGHT = WIDTH/10 * 9;
	
	Window window;
	private Thread thread;
	private boolean runGame = false;
	private Control control;
	public SpaceGame() {
		control = new Control();
		window = new Window(WIDTH, HEIGHT, "Lets create a Space game!", this);
		this.addKeyListener(new KeyInput(control, this));
		control.addObject(new Player(400, 400, ID.Player));
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
		control.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.green);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		control.render(g);
		
		
		g.dispose();
		bs.show();
	}

	
	public static void main(String[] args) {
		new SpaceGame();
	}

}









