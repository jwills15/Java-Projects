public class Sequential 
{
	//class variables
	private int numSearches, times, randomArray[];
	private double average;
	
	//class constructor
	Sequential(int theTimes, int theArray[])
	{
		times = theTimes;
		randomArray = theArray;
	}
	
	private void findNum()
	{
		int searchesPerformed = times;
		for (int i = 0; i < times; i++)
		{
			int targetNum = (int)(Math.random() * 5000 + 1);//sets target
			
			for (int m = 0; m < randomArray.length; m++)
			{
				if (randomArray[m] == targetNum)
				{
					numSearches += m + 1;
					break;
				}
				else if (m == randomArray.length - 1)
				{
					searchesPerformed--;//exempts times when number is not found
				}
			}
		}
		//calculates average times to find number
		average = (double)numSearches / searchesPerformed;
	}
	
	//allow the user to get the answers back
	public Double getAverage()
	{	
		findNum();
		return average;	
	}
}
