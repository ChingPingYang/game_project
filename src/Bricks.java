import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bricks {
	
	public int rwo = 3;
	public int column = 5; 
	

	public int brickW = 70;
	public int brickH = 40;
	
	public int gap = 45;
	
	public Rectangle[][] bricks = new Rectangle[rwo][column];

	
	public Bricks() {
		for (int i = 0; i < bricks.length; i++) {
			for (int j = 0; j < bricks[i].length; j++) {
				int brickX = 140;
				int brickY = 260;
				switch (i) {
				case 1:
					brickY += (brickH + gap);
					break;
				case 2:
					brickY += (brickH + gap) * 2;
					break;
				case 3:
					brickY += (brickH + gap) * 3;
					break;
				case 4:
					brickY += (brickH + gap) * 4;
					break;
				case 5:
					brickY += (brickH + gap) * 5;
					break;
				}
				
				switch (j) {
				case 1:
					brickX += (brickW + gap);
					break;
				case 2:
					brickX += (brickW + gap) * 2;
					break;
				case 3:
					brickX += (brickW + gap) * 3;
					break;
				case 4:
					brickX += (brickW + gap) * 4;
					break;
				case 5:
					brickX += (brickW + gap) * 5;
					break;
				}
				
				bricks[i][j] = new Rectangle(brickX, brickY, brickW, brickH);
			}
		}
	}
	
	
	
	public void drawBricks(Graphics g) {
		g.setColor(Color.RED);
		for (int i = 0; i < bricks.length; i++) {
			for (int j = 0; j < bricks[i].length; j++) {
				if(bricks[i][j] != null) {
				g.fillRect(bricks[i][j].x, bricks[i][j].y, brickW, brickH);
				}
			}
		}
		}
}
