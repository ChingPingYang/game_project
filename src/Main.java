import java.awt.*;
import javax.swing.*;
public class Main {

	public static JFrame frame;
	public static Display display;
	public static void main(String[] args) {
		frame = new JFrame();
		display = new Display();
		
		frame.add(display);
		//add ^ first
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(display);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		display.start();
		//start the game^
	}

}
