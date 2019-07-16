import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Display extends Canvas implements Runnable,KeyListener{
	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;
	private boolean running = false;
	private Thread thread;
	
	//add Players
	public Paddle player1 = new Paddle(50, 0, 1);
	public Paddle player2 = new Paddle(550, 780, 2);
	public PaddleVertical player3 = new PaddleVertical(0, 80, 3);
	public PaddleVertical player4 = new PaddleVertical(780, 80, 4);
	
	//add Ball
	public Ball ball = new Ball();
	
	//add Bricks
	public Bricks bricks = new Bricks();
	
	
	//Constructor
	public Display() {
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(new Color(25, 70, 130));
		this.setFocusTraversalKeysEnabled(false);
		this.setFocusable(false);
	}
	
	
	//Update data
	public void update() {
		ball.updateBall();
		player1.updatePaddle();
		player2.updatePaddle();
		player3.updatePaddle();
		player4.updatePaddle();
		
		
		for (int i = 0; i < bricks.bricks.length; i++) {
			for (int j = 0; j < bricks.bricks[i].length; j++ ) {
				if(bricks.bricks[i][j] != null) {
					if (ball.ballRec.intersects(bricks.bricks[i][j])) {
						ball.ballDirY = -(ball.ballDirY);
						ball.ballDirX = -(ball.ballDirX);
						bricks.bricks[i][j] = null;
					}
				}
			}
		}
		
		

		if ((player1.player1Rec != null && ball.ballRec.intersects(player1.player1Rec)) || (player2.player2Rec != null && ball.ballRec.intersects(player2.player2Rec))) {
			ball.ballDirY = -(ball.ballDirY);
		}
		if ((player3.player3Rec != null && ball.ballRec.intersects(player3.player3Rec)) || (player4.player4Rec != null && ball.ballRec.intersects(player4.player4Rec))) {
			ball.ballDirX = -(ball.ballDirX);
		}
		
	}
	
	//Render(Draw) stuffs.
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, WIDTH, HEIGHT);
		//start drawing
		
		ball.drawBall(g);
		player1.drawPaddle(g);
		player2.drawPaddle(g);
		player3.drawPaddle(g);
		player4.drawPaddle(g);
		bricks.drawBricks(g);
		
		
		
		//stop drawing
		bs.show();
		g.dispose();
	}
	
	
	
	//Starter.
	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	//Stopper.
	public synchronized void stop() throws InterruptedException {
		running = false;
		thread.join();
	}
	
	//Run the thread after Starter.
	@Override
	public void run() {
		
		
		while (running) {
			update();
			try {
				thread.sleep(1);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			render();
		}
		
	}

	
	//Get key press.
	@Override
	public void keyPressed(KeyEvent e) {
		player1.handleKeyPress(e);
		player2.handleKeyPress(e);
		player3.handleKeyPress(e);
		player4.handleKeyPress(e);
		
	}
	
	//Get key release.
	@Override
	public void keyReleased(KeyEvent e) {
		player1.handleKeyRelease(e);
		player2.handleKeyRelease(e);
		player3.handleKeyRelease(e);
		player4.handleKeyRelease(e);
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//No used in this program, but implemented.
		
	}
	
	
	
}
