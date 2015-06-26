import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.util.Random;
import java.awt.event.*;
import java.lang.Math;
import java.io.IOException;

class Display extends JPanel {
	JFrame frame = new JFrame();
	Dimension screenSize;
	int width, height;

	boolean loop;

	public Display() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		width = (int) screenSize.getWidth();
		height = (int) screenSize.getHeight();

		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setPreferredSize(screenSize);
		frame.setSize(width, height);
		frame.setVisible(true);

		setBackground(Color.BLACK);
		setPreferredSize(screenSize);
		setSize(width, height);
		setVisible(true);

		//The gme starts here
		loop = true;
		gameLoop();	
	}


	public void gameLoop() {
		//Initiates variables that are used exclusively in making the game loop run
		long then = System.nanoTime();
		long lastFpsTime = 0;
		int fps = 0;

		//Shooting for 60 refreshes per second
		final int TARGET_FPS = 60;
		final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

		while(loop == true) {
			long now = System.nanoTime();

			long updateLength = now - then;

			then = now;

			double delta = updateLength / ((double)OPTIMAL_TIME);

			lastFpsTime += updateLength;
			fps++;

			//Every second, start counting frames again
			if(lastFpsTime >= 1000000000) {
				System.out.println("FPS = " + fps);
				lastFpsTime = 0;
				fps = 0;
			}
	
			input(delta);
			advance(delta);
			this.repaint();
				
			//Waits for the rest of the 1/60 of a second, as to not update too quickly
			try{
				Thread.sleep( (then-System.nanoTime() + OPTIMAL_TIME) / 1000000);
			} catch (RuntimeException e) {
			
			} catch (InterruptedException e) {

			}
		}
	}

	public void input(double dt) {
		
	}

	public void advance(double dt) {
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		FontMetrics metrics;

		render(g);
	}

	public void render(Graphics g) {
		
	}
}