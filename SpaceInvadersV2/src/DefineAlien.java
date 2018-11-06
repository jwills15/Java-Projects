
public class DefineAlien {
	
	int xPos;
	int yPos;
	int velX;
	int velY;
	int hits;
	
	public void setAliens(int x, int y, int vX, int vY, int theHits){
		
		xPos = x;
		yPos = y;
		velX = vX;
		velY = vY;
		hits = theHits;
		
	}
	
	public void MoveInvader(int shipX, int shipY)
	{
		
		if (xPos < shipX)
		{
			xPos += velX;
		}
		else if (xPos > shipX)
		{
			xPos -= velX;
		}
		if (yPos < shipY)
		{
			yPos += velY;
		}
		else if (yPos > shipY)
		{
			yPos -= velY;
		}
		
	}
	
}
