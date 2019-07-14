import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {

	public static int ballX = 200;
	public static int ballY = 300;
	public int ballDirX = 1;
	public int ballDirY = 1;
	
	//add virtual followers
	public Rectangle ballRec;
	
	
	public void updateBall() {
		if (ballX >= Display.WIDTH - 30 || ballX <= 0 ) {
			ballDirX = -ballDirX;
		}
		if (ballY >= Display.HEIGHT - 30 || ballY <= 0 ) {
			ballDirY = -ballDirY;
		}
		ballX += ballDirX;
		ballY += ballDirY;
		
		ballRec = new Rectangle(ballX, ballY, 30, 30);
	}
	
	public void drawBall(Graphics g) {
		g.setColor(new Color(191, 191, 191));
		g.fillOval(ballX, ballY, 30, 30);
	}
	
	
	
	
}
