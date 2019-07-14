import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Paddle {
	public int paddleX = 0;
	public int paddleY = 0;
	public int paddleW = 100;
	public int paddleH = 20;
	private boolean left = false;
	private boolean right = false;
	private int player;
//	public Ball ball = new Ball();
	
	public int player1Switch = 1;
	public int player2Switch = 1;
	
	//add virtual followers
	public Rectangle player1Rec;
	public Rectangle player2Rec;
	
	public Paddle(int x, int y, int player) {
		paddleX = x;
		paddleY = y;
		this.player = player;
	}
		
	public void updatePaddle() {
		if(left) {
			if(paddleX >= 0) {
				paddleX -= 1;
			}
		}
		if(right) {
			if(paddleX <= Display.WIDTH-paddleW) {
				paddleX += 1;
			}
		}
		
		player1Rec = new Rectangle(paddleX, paddleY, 100, 20);
		player2Rec = new Rectangle(paddleX, paddleY, 100, 20);
		
		
		if (Ball.ballY == 0) {
			player1Switch = 0;
		} else if (Ball.ballY == Display.HEIGHT - 30) {
			player2Switch = 0;
		}
	
		if (player1Switch == 0) { player1Rec = null; }
		if (player2Switch == 0) { player2Rec = null; }
		
	}
	
	public void drawPaddle(Graphics g) {
		if (player == 1 && player1Rec != null ) {
			g.setColor(new Color(255, 255, 0));
			g.fillRect(paddleX, paddleY, paddleW, paddleH);			
		} else if (player == 2 && player2Rec != null ) {
			g.setColor(new Color(255, 255, 0));
			g.fillRect(paddleX, paddleY, paddleW, paddleH);
		}
	}
	
	
	public void handleKeyPress(KeyEvent e) {
		int c = e.getKeyCode();
		if (player == 1) {
			if (c == KeyEvent.VK_C) {
				left = true;
			}
			if (c == KeyEvent.VK_V) {
				right = true;
			}
		} else if(player == 2){
			if (c == KeyEvent.VK_N) {
				left = true;
			}
			if (c == KeyEvent.VK_M) {
				right = true;
			}
		}
		
		
	}
	
	
	public void handleKeyRelease(KeyEvent e) {
		int c = e.getKeyCode();
		if(player == 1) {
			if (c == KeyEvent.VK_C) {
				left = false;
			}
			if (c == KeyEvent.VK_V) {
				right = false;
			}
		} else if(player == 2){
			if (c == KeyEvent.VK_N) {
					left = false;
			}
			if (c == KeyEvent.VK_M) {
					right = false;
			}
			}
	}
	
}
