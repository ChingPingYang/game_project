import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class PaddleVertical {
	public int paddleX = 0;
	public int paddleY = 0;
	public int paddleW = 20;
	public int paddleH = 100;
	private boolean up = false;
	private boolean down = false;
	private int player;
	
	public int player3Switch = 1;
	public int player4Switch = 1;
	
	//add virtual followers
	public Rectangle player3Rec;
	public Rectangle player4Rec;
	
	public PaddleVertical(int x, int y, int player) {
		paddleX = x;
		paddleY = y;
		this.player = player;
	}
	
	
	
	public void updatePaddle() {
		if(up) {
			if(paddleY >= 0) {
				paddleY -= 1;
			}
		}
		if(down) {
			if(paddleY <= Display.HEIGHT-paddleH) {
				paddleY += 1;
			}
		}
		
		player3Rec = new Rectangle(paddleX, paddleY, 20, 100);
		player4Rec = new Rectangle(paddleX, paddleY, 20, 100);
		
		if (Ball.ballX == 0) {
			player3Switch = 0;
		} else if (Ball.ballX == Display.WIDTH - 30) {
			player4Switch = 0;
		}
		
		if (player3Switch == 0) { player3Rec = null; }
		if (player4Switch == 0) { player4Rec = null; }
		
	}
	
	public void drawPaddle(Graphics g) {
		if (player == 3 && player3Rec != null) {
			g.setColor(new Color(255, 255, 0));
			g.fillRect(paddleX, paddleY, paddleW, paddleH);
		} else if (player == 4 && player4Rec != null){		
			g.setColor(new Color(255, 255, 0));
			g.fillRect(paddleX, paddleY, paddleW, paddleH);
		}
	}
	
	public void handleKeyPress(KeyEvent e) {
		int c = e.getKeyCode();
		if (player == 3) {
			if (c == KeyEvent.VK_Q) {
				up = true;
			}
			if (c == KeyEvent.VK_A) {
				down = true;
			}
		} else if(player == 4){
			if (c == KeyEvent.VK_O) {
				up = true;
			}
			if (c == KeyEvent.VK_L) {
				down = true;
			}
		}
		
		
	}
	
	public void handleKeyRelease(KeyEvent e) {
		int c = e.getKeyCode();
		if (player == 3) {
			if (c == KeyEvent.VK_Q) {
				up = false;
			}
			if (c == KeyEvent.VK_A) {
				down = false;
			}
		} else if(player == 4){
			if (c == KeyEvent.VK_O) {
				up = false;
			}
			if (c == KeyEvent.VK_L) {
				down = false;
			}
		}
	}
	
}
