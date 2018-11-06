import java.awt.Rectangle;

public class Enemy 
{
	int hitpoints, hits, width = 40, hpWidth = 40, hpHeight = 8;
	double X, Y, speed, hpX, hpY;
	boolean alive = false;
	
	Enemy(double gameLevel, int sideX, int rightX, int sideY, int bottomY)
	{
		alive = true;
		
		int type = (int)(Math.random()*2);
		if (type == 0)
		{
			//slow but high hit points
			hitpoints = (int) (gameLevel + 1);
			speed = gameLevel / 8 + .75;
		}
		else if (type == 1)
		{
			//fast but low hit points
			hitpoints = (int) (gameLevel / 2 + 1);
			speed = gameLevel / 4 + 1.25;
		}
				
				
		int whichOpening = (int)(Math.random()*4);
		if(whichOpening == 0)
		{
			//top
			X = sideX;
			Y = -width;
			hpX = X;
			hpY = Y + width/2 - hpHeight/2;
		}
		else if(whichOpening == 1)
		{
			//left
			X = -width;
			Y = sideY;
			hpX = X;
			hpY = Y + width/2 - hpHeight/2;
		}
		else if(whichOpening == 2)
		{
			//right
			X = rightX;
			Y = sideY;
			hpX = X;
			hpY = Y + width/2 - hpHeight/2;
		}
		else if(whichOpening == 3)
		{
			//bottom
			X = sideX;
			Y = bottomY;
			hpX = X;
			hpY = Y + width/2 - hpHeight/2;
		}
	}
	
	public Rectangle getEnemy()
	{
		return new Rectangle((int)X, (int)Y, width, width);
	}
	public Rectangle getHPbar()
	{
		return new Rectangle((int)hpX, (int)hpY, hpWidth, hpHeight/2);
	}
	public boolean getAlive(){return alive;}
	public void move(double targetX, double targetY)
	{
		double distanceX = (X + width/2) - targetX;
		double distanceY = (Y + width/2) - targetY;
		double moveSpeed = speed;
		if (Math.abs(distanceX) > 1.5 && Math.abs(distanceY) > 1.5)
		{
			moveSpeed = speed / Math.sqrt(2);
		}
		
		if (Y > 50 && Y < 560)
		{
			if (distanceX > 1.5)
			{
				X -= moveSpeed;
			}
			else if (distanceX < -1.5)
			{
				X += moveSpeed;
			}
		}
		
		if (X > 25 && X < 635)
		{
			if (distanceY > 1.5)
			{
				Y -= moveSpeed;
			}
			else if (distanceY < -1.5)
			{
				Y += moveSpeed;
			}
		}
		hpX = X;
		hpY = Y + width/2 - hpHeight/2;
	}
	public int bulletHit()
	{
		hits++;
		hpWidth -= width / hitpoints;
		if(hits == hitpoints)
		{
			return dead();
		}
		return 0;
	}
	public int dead()
	{
		X = -100;
		Y = -100;
		hpX = -100;
		hpY = -100;
		alive = false;
		return 1;
	}
}
