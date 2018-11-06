
public class UserBullets 
{
	private int bulletDiameter;
	private double bulletX, bulletY, speedX, speedY;
	
	UserBullets(int d, double x, double y, double vX, double vY)
	{
		bulletDiameter = d;
		bulletX = x;
		bulletY = y;
		speedX = vX;
		speedY = vY;
	}
	
	public void MoveBullet()
	{
		bulletX += speedX;
		bulletY += speedY;
	}
	
	public double getBulletX(){return bulletX;}
	public double getBulletY(){return bulletY;}
	public int getBulletD(){return bulletDiameter;}
}
