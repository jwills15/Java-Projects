
/* Name: Joshua Williams
 * Date: 12/7/16
 * Description: Space Invaders
 * This program generates space invaders
 * at random locations, which the user must
 * shoot.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.*;
import javax.swing.Timer;


public class SpaceInvadersV2 extends JApplet 
							implements KeyListener, ActionListener{

	//Declare components and objects	
	JPanel mainPanel = new JPanel();
		
	int shipX = 167;
	int shipY = 167;
	int shipMoveSpeed = 3;
	Boolean shipRight = false;
	Boolean shipLeft = false;
	Boolean shipUp = false;
	Boolean shipDown = false;
	
	int bulletX = 187;
	int bulletY = 167;
	int bulletMoveSpeed = 4;
	Boolean bulletMove = false;
	int moveDirec = 1;
	int bulletDirec = 1;

	Timer myTimer = new Timer(10, this);
	
	ImageIcon shipImage = new ImageIcon("ship.png");
	ImageIcon alienImage = new ImageIcon("alien.jpg");
	
	DefineAlien Aliens[] = new DefineAlien[3];
	
	
	public void init(){
		
		setContentPane(mainPanel);
		resize(400,400);
		addKeyListener(this);	
		
		for(int i = 0; i < Aliens.length; i++){
			
			Aliens[i] = new DefineAlien();
			
		}
		//fill up array with objects properties
		for(int j = 0; j < Aliens.length; j++){
			
			int xLoc = (int)(Math.random() * 100) + 400;
			int yLoc = (int)(Math.random() * 600);
			int xspeed = 1;
			int yspeed = 1;
			System.out.println(yLoc);
			Aliens[j].setAliens(xLoc, yLoc, xspeed, yspeed, 0);
			System.out.println(Aliens[j].yPos);
		}
		
		myTimer.start();
	}
	
	public void actionPerformed(ActionEvent evt){
		
		requestFocus();
		
		if (shipX > 0 && shipLeft == true){
			
			shipX -= shipMoveSpeed;
		}
		if (shipX < getWidth() - shipImage.getIconWidth() 
						&& shipRight == true){
			
			shipX += shipMoveSpeed;
		}
		if (shipY > 0 && shipUp == true){
			
			shipY -= shipMoveSpeed;
		}
		if (shipY < getHeight() - shipImage.getIconHeight() 
						&& shipDown == true){
			
			shipY += shipMoveSpeed;
		}
		
		for (int o = 0; o < Aliens.length; o++)
		{
			Aliens[o].MoveInvader(shipX, shipY);
		}
		
		if (bulletMove){
			
			if (bulletDirec == 1)
			{
				bulletX -= bulletMoveSpeed;
			}
			else if (bulletDirec == 2)
			{
				bulletX += bulletMoveSpeed;
			}
			else if (bulletDirec == 3)
			{
				bulletY -= bulletMoveSpeed;
			}
			else if (bulletDirec == 4)
			{
				bulletY += bulletMoveSpeed;
			}
			
			if (!(bulletY > -10 && bulletY < 410 && bulletX > -10 
					&& bulletX < 410)){
				
				bulletMove = false;
				
			}
			
			Rectangle bullet = new Rectangle(bulletX, bulletY, 6, 6);
			for (int m = 0; m < Aliens.length; m++)
			{
				Rectangle alien = new Rectangle(Aliens[m].xPos, Aliens[m].yPos,
						alienImage.getIconWidth(), alienImage.getIconHeight());
	
			    if (bullet.intersects(alien)){
			    	
			    	//collision
			    	Aliens[m].xPos = (int)(Math.random() * 100) + 400;
			    	Aliens[m].yPos = (int)(Math.random() * 600);
			    	Aliens[m].hits++;
			    	bulletMove = false;
			    	
			    	if (Aliens[m].hits == 3){
			    		
			    		Aliens[m].xPos = -100;
				    	Aliens[m].yPos = -100;
				    	Aliens[m].velX = 0;
				    	Aliens[m].velY = 0;
			    		
			    	}
			    	break;
			    }
		    }
		
		}
		else{
			
			bulletX = shipX + shipImage.getIconWidth()/2 - 2;
			bulletY = shipY;
			bulletDirec = moveDirec;
			
		}
		
		repaint();
	}
	
	public void keyPressed(KeyEvent e){
			
		int key = e.getKeyCode();
		//nameTextField.setText(""+ key);
		if (key == 37){
			//left
			shipLeft = true;
			moveDirec = 1;
			
		}
		if (key == 39){
			//right
			shipRight = true;
			moveDirec = 2;
			
		}
		if (key == 38){
			//up
			shipUp = true;
			moveDirec = 3;
			
		}
		if (key == 40){
			//down
			shipDown = true;
			moveDirec = 4;
			
		}
		if (key == 32 && !bulletMove){
			//spacebar
			bulletMove = true;
		}
		
	}

	public void keyReleased(KeyEvent e){
		 
		 int key = e.getKeyCode();
		 //nameTextField.setText(""+ key);
		 if (key == 37){
			 //left
			 shipLeft = false;
		 }
		 if (key == 39){
			 //right
			 shipRight = false;
		 }
		 if (key == 38){
			 //up
			 shipUp = false;
		 }
		 if (key == 40){
			 //down
			 shipDown = false;
		 }
		 
	}
	 
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
		ig.setColor(Color.white);
		ig.fillRect(0, 0, getWidth(), getHeight());
		shipImage.paintIcon(this, ig, shipX, shipY);
		for(int n = 0; n < Aliens.length; n++)
		{
			alienImage.paintIcon(this, ig, Aliens[n].xPos, Aliens[n].yPos);
		}
		ig.setColor(Color.green);
		ig.fillRect(bulletX, bulletY, 6, 6);
		Boolean win = false;
		for (int p = 0; p < Aliens.length; p++)
		{
			if (Aliens[p].hits == 3){
			
				win = true;
			
			}
			else{
				
				win = false;
				break;
			}
		}
		if (win == true){
			
			ig.setFont(new Font("TimesRoman", Font.PLAIN, 36));
			ig.drawString("YOU WIN!", 115, 200);
			
		}
		
		// End of custom drawing code



		// Draw buffered image to screen
		g2D.drawImage(image, 0, 0, this);
	}
	public void Update(Graphics gr){
		paint(gr);
	}
	
	public void startTimer(){
		
		myTimer.start();
		
	}
	
	public void stopTimer(){
		
		myTimer.stop();
		
	}
	
}


