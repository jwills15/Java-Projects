import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
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
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Timer;

public class GameFrame extends GUI
{
	//Declare components and objects	
	
	//game variables
	int score = 0;
	int highscore = 0;
	int level = 1;
	int hits = 0;
	int alreadyKilled = 0;
	int lives = 3;
	boolean GameOver = false;
	
	//user variables
	//"C" = circle, "S" = square
	final double userCStartX = 330.0;
	double userCX = userCStartX;
	final double userCStartY = 305.0;
	double userCY = userCStartY;
	final int userCDiameter = 30;
	double userSX = 350.0;
	double userSY = 325.0;
	final int userSLength = 15;
	int userMoveSpeed = 3;
	double userShootAngle = 0.0;
	
	//user moving variables
	Boolean userRight = false;
	Boolean userLeft = false;
	Boolean userUp = false;
	Boolean userDown = false;
	Boolean userFiring = false;
	
	//user bullets
	ArrayList<UserBullets> bullets = new ArrayList<>();
	int bulletShootSpeed = 64;
	final int bulletDiameter = 6;
	final double bulletSpeed = 5.0;
	
	//enemies
	Enemy[] enemies = new Enemy[25];
	int enemySpawnSpeed = 100;
	int enemiesSpawned = 0;
	
	//drawing variables
	final int scoresPanelWidth = 200;
	final int topTitleHeight = 26;
	Rectangle top = new Rectangle(0,26,getWidth() - scoresPanelWidth, 30);
	Rectangle left = new Rectangle(0,26,30, getHeight());
	Rectangle right = new Rectangle(getWidth()-scoresPanelWidth-30,0,30,getHeight());
	Rectangle bottom = new Rectangle(0,getHeight()-30,getWidth()-scoresPanelWidth,30);
	int openingWidth = 50;
	Rectangle openingTop = new Rectangle((getWidth()-scoresPanelWidth)/2-openingWidth/2,26,openingWidth,30);
	Rectangle openingLeft = new Rectangle(0,(getHeight()-26)/2-openingWidth/2+26,30, openingWidth);
	Rectangle openingRight = new Rectangle(getWidth()-scoresPanelWidth-30,(getHeight()-26)/2-openingWidth/2+26,30,openingWidth);
	Rectangle openingBottom = new Rectangle((getWidth()-scoresPanelWidth)/2-openingWidth/2,getHeight()-30,openingWidth,30);
	
	//timer variables
	Timer myTimer = new Timer(10, this);
	int userShootCount = bulletShootSpeed - 1;
	int enemySpawnCount = 0;
	int gameOverCount = 0;
	
	public GameFrame()
	{
		super();
		setSize(900,626);
		setTitle("Crunch Time");
		
		//sets user in the middle of the game panel
		userCX = (getWidth() - scoresPanelWidth) / 2 - userCDiameter / 2;
		userCY = (getHeight() - topTitleHeight) / 2 - userCDiameter / 2 + topTitleHeight;
		
		//gets the high score
		BufferedReader file;
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
		
		//starts the timer to run the game
		myTimer.start();
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		requestFocus();
		
		if(GameOver)
		{
			gameOverCount++;
			if (gameOverCount == 400)
			{
				if (score > highscore)
				{
					FileWriter fstream;
					try 
					{
						BufferedWriter output = new BufferedWriter(new FileWriter("highscore.txt", false));
				        output.write(""+score);
				        System.out.println(score);
				        output.close();
					} 
					catch (IOException e) 
					{
						//Auto-generated catch block
						e.printStackTrace();
					}
				}
				myTimer.stop();
				a.dispose();
				a = new MenuFrame();
			}
		}
		else
		{
			MoveUser();
			FindDirectionShoot(MouseInfo.getPointerInfo().getLocation());
			
			if (userFiring)
			{
				userShootCount++;
			}
			if (userShootCount == bulletShootSpeed)
			{
				userShootCount = 0;
				FireBullet(MouseInfo.getPointerInfo().getLocation());
			}
			MoveBullets();
			
			enemySpawnCount++;
			if (enemySpawnSpeed == enemySpawnCount && enemiesSpawned < enemies.length - alreadyKilled)
			{
				SpawnEnemy(enemiesSpawned);
				enemiesSpawned++;
				enemySpawnCount = 0;
			}
			
			for(int m = 0; m < enemies.length; m++)
			{
				if (enemies[m] != null && enemies[m].getAlive())
				{
					enemies[m].move(userCX+userCDiameter/2, userCY+userCDiameter/2);
				}
			}
			CheckHitUser();
			
			if(hits == enemies.length)
			{
				NextLevel();
			}
		}
		repaint();
	}
	
	public void keyPressed(KeyEvent e)
	{			
		int key = e.getKeyCode();

		if (key == 65)
		{
			//left (a)
			userLeft = true;
		}
		if (key == 68)
		{
			//right (d)
			userRight = true;
		}
		if (key == 87)
		{
			//up (w)
			userUp = true;
		}
		if (key == 83)
		{
			//down (s)
			userDown = true;
		}
		if (key == 32)
		{
			//spacebar
			userFiring = true;
		}
				
	}

	public void keyReleased(KeyEvent e)
	{	
		int key = e.getKeyCode();
		//nameTextField.setText(""+ key);
		if (key == 65)
		{
			//left (a)
			userLeft = false;
		}
		if (key == 68)
		{
			//right (d)
			userRight = false;
		}
		if (key == 87)
		{
			//up (w)
			userUp = false;
		}
		if (key == 83)
		{
			//down (s)
			userDown = false;
		}
		if(key==32)
		{
			//spacebar
			userFiring = false;
			userShootCount = bulletShootSpeed * 4/5;
		}
	}
	public void keyTyped(KeyEvent e){}
	
	public void paint(Graphics g)
	{
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
		ig.fillRect(0, 0, getWidth() - scoresPanelWidth, getHeight());
		
		
		ig.setColor(Color.gray);
		ig.fill(top);
		ig.fill(bottom);
		ig.fill(left);
		ig.fill(right);
		ig.setColor(Color.white);
		ig.fill(openingTop);
		ig.fill(openingLeft);
		ig.fill(openingRight);
		ig.fill(openingBottom);
		ig.setColor(Color.green);
		Shape circle = new Ellipse2D.Double(userCX, userCY, userCDiameter, userCDiameter);
		ig.fill(circle);
		Shape userRect = DrawRotatedRect();
		ig.fill(userRect);
		for(UserBullets allBullets: bullets)
		{
			ig.fillOval((int)allBullets.getBulletX(), (int)allBullets.getBulletY(), bulletDiameter, bulletDiameter);
		}
		for (Enemy allEnemies : enemies)
		{
			if (allEnemies != null)
			{
				ig.setColor(Color.red);
				ig.fill(allEnemies.getEnemy());
				ig.setColor(Color.blue);
				ig.fill(allEnemies.getHPbar());
			}
		}
		
		ig.setColor(Color.black);
		ig.fillRect(getWidth() - scoresPanelWidth, 0, getWidth(), getHeight());
		ig.setColor(Color.green);
		ig.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		ig.drawString("Level:", getWidth() - scoresPanelWidth + 10, getHeight()/2 - 100);
		ig.drawString(Integer.toString(level), getWidth() - scoresPanelWidth + 100, getHeight()/2 - 100);
		ig.drawString("Lives:", getWidth() - scoresPanelWidth + 10, getHeight()/2 - 50);
		ig.drawString(Integer.toString(lives), getWidth() - scoresPanelWidth + 100, getHeight()/2 - 50);
		ig.drawString("Score:", getWidth() - scoresPanelWidth + 10, getHeight()/2);
		ig.drawString(Integer.toString(score), getWidth() - scoresPanelWidth + 100, getHeight()/2);
		ig.drawString("High Score:", getWidth() - scoresPanelWidth + 10, getHeight()/2+50);
		if (score > highscore)
		{
			ig.drawString(Integer.toString(score), getWidth() - scoresPanelWidth + 50, getHeight()/2+80);
		}
		else
		{
			ig.drawString(Integer.toString(highscore), getWidth() - scoresPanelWidth + 50, getHeight()/2+80);
		}
		
		if(GameOver)
		{
			ig.setColor(Color.black);
			ig.setFont(new Font("TimesRoman", Font.PLAIN, 60));
			ig.drawString("Game Over",  220, getHeight()/2);
		}
		// End of custom drawing code

		// Draw buffered image to screen
		g2D.drawImage(image, 0, 0, this);
	}
	
	public void Update(Graphics gr){paint(gr);}
	
	public void startTimer(){myTimer.start();}
	
	public void stopTimer(){myTimer.stop();}
	
	public void MoveUser()
	{
		if ((userLeft &&  userUp) || (userLeft && userDown) || 
				(userRight && userUp) || (userRight && userDown))
		{
			userMoveSpeed = 2;
		}
		else
		{
			userMoveSpeed = 3;
		}
		
		double tempX = userCX, tempY = userCY;
		if (userLeft == true)
		{
			tempX -= userMoveSpeed;
		}
		if (userRight == true)
		{
			tempX += userMoveSpeed;
		}
		
		Shape circleMoveX = new Ellipse2D.Double(tempX, tempY, userCDiameter, userCDiameter);
		if (!circleMoveX.intersects(bottom) && !circleMoveX.intersects(top) &&
				!circleMoveX.intersects(left) && !circleMoveX.intersects(right))
		{
			userCX = tempX;
			userCY = tempY;
		}
		else
		{
			tempX = userCX;
			tempY = userCY;
		}
		
		if (userUp == true)
		{
			tempY -= userMoveSpeed;
		}
		if (userDown == true)
		{
			tempY += userMoveSpeed;
		}
		
		Shape circleMoveY = new Ellipse2D.Double(tempX, tempY, userCDiameter, userCDiameter);
		if (!circleMoveY.intersects(bottom) && !circleMoveY.intersects(top) &&
				!circleMoveY.intersects(left) && !circleMoveY.intersects(right))
		{
			userCX = tempX;
			userCY = tempY;
		}
		
	}
	
	public void MoveBullets()
	{
		for(int i = 0; i < bullets.size(); i++)
		{
			bullets.get(i).MoveBullet();
			if (bullets.get(i).getBulletX() > getWidth() - scoresPanelWidth ||
					bullets.get(i).getBulletX() < 0 || bullets.get(i).getBulletY() < 0 ||
					bullets.get(i).getBulletY() > getHeight())
			{
				bullets.remove(bullets.get(i));
				i--;
				break;
			}
			Shape circle = new Ellipse2D.Double(bullets.get(i).getBulletX(), bullets.get(i).getBulletY(), bullets.get(i).getBulletD(), bullets.get(i).getBulletD());
			for(int m = 0; m < enemies.length; m++)
			{
				if(enemies[m] != null && enemies[m].getAlive() && circle.intersects(enemies[m].getEnemy()))
				{
					int temp = enemies[m].bulletHit();
					hits += temp;
					if (temp == 1)
					{
						score += level * 50 + 50;
					}
					bullets.remove(bullets.get(i));
					i--;
					break;
				}
			}
		}
	}
	
	public void FindDirectionShoot(Point a)
	{
		double mouseX = a.getX() - (userCX + userCDiameter/2);
		double mouseY = a.getY() - (userCY + userCDiameter/2);
		userShootAngle = Math.atan(mouseY/mouseX);
		if(mouseX >= 0)
		{
			userSX = userCX + userCDiameter/2 + userCDiameter/2 * Math.cos(userShootAngle);
			if(mouseY >= 0)
			{
				userSY = userCY + userCDiameter/2 + userCDiameter/2 * Math.sin(userShootAngle);
			}
			else if(mouseY < 0)
			{
				userSY = userCY + userCDiameter/2 - userCDiameter/2 * Math.sin(userShootAngle + Math.PI);
			}
		}
		else if(mouseX < 0)
		{
			userSX = userCX + userCDiameter/2 + userCDiameter/2 * Math.cos(userShootAngle + Math.PI);
			if(mouseY >= 0)
			{
				userSY = userCY + userCDiameter/2 - userCDiameter/2 * Math.sin(userShootAngle);
			}
			else if(mouseY < 0)
			{
				userSY = userCY + userCDiameter/2 + userCDiameter/2 * Math.sin(userShootAngle + Math.PI);
			}
		}
	}
	
	public Shape DrawRotatedRect()
	{
		// create rect centred on the point we want to rotate it about
		Rectangle2D rect = new Rectangle2D.Double(-userSLength/2, -userSLength/2., userSLength, userSLength);

		AffineTransform transform = new AffineTransform();
		transform.translate(userSX, userSY); 
		transform.rotate(userShootAngle);
		
		Shape rotatedRect = transform.createTransformedShape(rect);

		return rotatedRect;
	}
	
	public void FireBullet(Point a)
	{
		double mouseX = a.getX() - (userCX + userCDiameter/2);
		int LoR = 1;
		int UoD = 1;
		if (mouseX < 0)
		{
			LoR = -1;
			UoD = -1;
		}
		
		bullets.add(new UserBullets(bulletDiameter, userSX, userSY,
					LoR*bulletSpeed*Math.cos(userShootAngle), 
					UoD*bulletSpeed*Math.sin(userShootAngle)));
	}
	
	public void SpawnEnemy(int whichEnemy)
	{
		enemies[whichEnemy] = new Enemy(level,
					(getWidth()-scoresPanelWidth)/2-openingWidth/2+5,
					getWidth()-scoresPanelWidth,
					(getHeight()-26)/2-openingWidth/2+26+5,
					getHeight());
	}

	public void CheckHitUser()
	{
		for(int m = 0; m < enemies.length; m++)
		{
			if (enemies[m] != null && enemies[m].getAlive())
			{
				Shape circle = new Ellipse2D.Double(userCX, userCY, userCDiameter, userCDiameter);
				Rectangle enemyHB = enemies[m].getEnemy();
				enemyHB.setSize((int)(40*0.8), (int)(40*0.8));
				enemyHB.setLocation(enemyHB.x+(40-enemyHB.width)/2, enemyHB.y+(40-enemyHB.height)/2);
				if(circle.intersects(enemyHB))
				{
					UserHit();
					break;
				}
			}
		}
	}
	
	public void UserHit()
	{
		try 
		{
			Thread.sleep(1000);
		} 
		catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
		lives--;
		if (lives > 0)
		{
			for(int p = 0; p < enemies.length; p++)
			{
				enemies[p] = null;
			}
			alreadyKilled = hits;
			enemiesSpawned = 0;
			enemySpawnCount = 0;
			while(bullets.size() > 0)
			{
				bullets.remove(bullets.get(0));
			}
			userCX = userCStartX;
			userCY = userCStartY;
		}
		else
		{
			GameOver = true;
		}
	}
	
	public void NextLevel()
	{
		hits = 0;
		enemiesSpawned = 0;
		alreadyKilled = 0;
		enemySpawnCount = 0;
		level++;
		if(bulletShootSpeed > 4 && level < 3 || level % 4 == 0)
		{
			bulletShootSpeed /= 2;
		}
		if (level % 3 == 0)
		{
			lives += 1;
		}
		if(enemySpawnSpeed > 50)
		{
			enemySpawnSpeed -= 5;
		}

		for(int m = 0; m < enemies.length; m++)
		{
			enemies[m] = null;
		}
		
		try 
		{
			Thread.sleep(1000);
		} 
		catch(InterruptedException ex) 
		{
			Thread.currentThread().interrupt();
		}
	}
}
