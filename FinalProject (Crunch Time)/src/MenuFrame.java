import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Timer;

public class MenuFrame extends GUI
{
	//Declare components and objects	
	Timer myTimer = new Timer(10, this);
	
	public MenuFrame()
	{
		super();
		setSize(600,626);
		setTitle("Menu");
		myTimer.start();
	}
	public void actionPerformed(ActionEvent evt)
	{	
		requestFocus();
		myTimer.stop();
		repaint();
	}
	
	public void keyPressed(KeyEvent e)
	{			
		int key = e.getKeyCode();
		if (key == 32)
		{
			//spacebar
			a.dispose();
			a = new GameFrame();
		}
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	
	public void paint(Graphics g){
		// Convert g into a Graphics2D to allow for advanced drawing
		Graphics2D g2D = (Graphics2D) g;

		// Create our BufferedImage that we will draw to
		BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
		// Create Graphics2D object to draw with
		Graphics2D ig = image.createGraphics();

		// Leave this next line to enable Anti-Aliasing (edge smoothing)
		ig.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);



		// Your custom drawing code goes here (replace g with ig)
		ig.setColor(Color.gray);
		ig.fillRect(0, 0, getWidth(), getHeight());
		ig.setColor(Color.green);
		ig.setFont(new Font("Comic Sans MS", Font.PLAIN, 72));
		ig.drawString("Crunch", 50, 200);
		ig.drawString("Time", 85, 300);
		ig.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		ig.drawString("Start", 118, 460);

		Rectangle2D rect = new Rectangle2D.Double(-20/2, -20/2., 15, 15);
		AffineTransform transform = new AffineTransform();
		transform.translate(90, 451); 
		transform.rotate(Math.toRadians(45));
		Shape rotatedRect = transform.createTransformedShape(rect);
		ig.fill(rotatedRect);
		transform = new AffineTransform();
		rect = new Rectangle2D.Double(-20/2, -20/2., 10, 10);
		transform.translate(90, 444); 
		transform.rotate(Math.toRadians(45));
		rotatedRect = transform.createTransformedShape(rect);
		ig.fill(rotatedRect);
		transform = new AffineTransform();
		rect = new Rectangle2D.Double(-20/2, -20/2., 10, 10);
		transform.translate(90, 466); 
		transform.rotate(Math.toRadians(45));
		rotatedRect = transform.createTransformedShape(rect);
		ig.fill(rotatedRect);
		transform = new AffineTransform();
		rect = new Rectangle2D.Double(-20/2, -20/2., 10, 10);
		transform.translate(80, 455); 
		transform.rotate(Math.toRadians(45));
		rotatedRect = transform.createTransformedShape(rect);
		ig.fill(rotatedRect);
		transform = new AffineTransform();
		rect = new Rectangle2D.Double(-20/2, -20/2., 10, 10);
		transform.translate(100, 455); 
		transform.rotate(Math.toRadians(45));
		rotatedRect = transform.createTransformedShape(rect);
		ig.fill(rotatedRect);
		
		rect = new Rectangle2D.Double(-20/2, -20/2., 15, 15);
		transform = new AffineTransform();
		transform.translate(240, 451); 
		transform.rotate(Math.toRadians(45));
		rotatedRect = transform.createTransformedShape(rect);
		ig.fill(rotatedRect);
		transform = new AffineTransform();
		rect = new Rectangle2D.Double(-20/2, -20/2., 10, 10);
		transform.translate(240, 444); 
		transform.rotate(Math.toRadians(45));
		rotatedRect = transform.createTransformedShape(rect);
		ig.fill(rotatedRect);
		transform = new AffineTransform();
		rect = new Rectangle2D.Double(-20/2, -20/2., 10, 10);
		transform.translate(240, 466); 
		transform.rotate(Math.toRadians(45));
		rotatedRect = transform.createTransformedShape(rect);
		ig.fill(rotatedRect);
		transform = new AffineTransform();
		rect = new Rectangle2D.Double(-20/2, -20/2., 10, 10);
		transform.translate(230, 455); 
		transform.rotate(Math.toRadians(45));
		rotatedRect = transform.createTransformedShape(rect);
		ig.fill(rotatedRect);
		transform = new AffineTransform();
		rect = new Rectangle2D.Double(-20/2, -20/2., 10, 10);
		transform.translate(250, 455); 
		transform.rotate(Math.toRadians(45));
		rotatedRect = transform.createTransformedShape(rect);
		ig.fill(rotatedRect);
		ig.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		ig.drawString("Press Space to Start", 50, 600);
		
		ig.setColor(Color.black);
		ig.fillRect(330, 0, getWidth(), getHeight());
		ig.setColor(Color.white);
		ig.setFont(new Font("Comic Sans MS", Font.PLAIN, 36));
		ig.drawString("W", 358, 120);
		ig.drawString("A", 358, 170);
		ig.drawString("S", 358, 220);
		ig.drawString("D", 358, 270);
		ig.drawString("Space", 358, 320);
		ig.drawString("Aim", 358, 370);
		ig.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
		ig.drawString("Controls:", 358, 70);
		ig.drawString("Up", 415, 118);
		ig.drawString("Left", 415, 168);
		ig.drawString("Down", 415, 218);
		ig.drawString("Right", 415, 268);
		ig.drawString("Shoot", 485, 318);
		ig.drawString("Mouse", 455, 368);
		
		ig.drawString("High Score:", 358, 438);
		BufferedReader file;
		int highscore=0;
		try 
		{
			file = new BufferedReader(new FileReader("highscore.txt"));
			highscore = Integer.parseInt(file.readLine());
			file.close();
		} 
		catch (FileNotFoundException e) 
		{
			//Auto-generated catch block
			e.printStackTrace();
		} 
		catch (NumberFormatException e) 
		{
			//Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			//Auto-generated catch block
			e.printStackTrace();
		}
		ig.drawString(""+highscore, 385, 478);
		
		ig.drawString("Joshua Williams", 375, 578);
		ig.drawString("June 2017", 410, 608);
		// End of custom drawing code

		// Draw buffered image to screen
		g2D.drawImage(image, 0, 0, this);
	}
	public void Update(Graphics gr){paint(gr);}
	
	public void startTimer(){myTimer.start();}
	public void stopTimer(){myTimer.stop();}
}
