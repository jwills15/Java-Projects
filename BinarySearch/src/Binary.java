public class Binary
{
	
	public int find(int[] numArray, int target) 
	{
		//makes sure the array has values in it
		if (numArray.length == 0) 
		{
			return -1;
		}
		//sets variables needed
		int low = 0, high = numArray.length-1, tries = 0;
		
		//makes sure that search is within array
		while(low <= high) 
		{
			//keeps track of how many attempts
			tries += 1;
			//searches in middle of array
			int middle = (low+high)/2;
			
			if (target > numArray[middle])
			{
				//target is larger, search upper half
				low = middle + 1;
			} 
			else if (target < numArray[middle])
			{
				//target is lower, search lower half
				high = middle - 1;
			}
			else 
			{ 
				//number found
				return tries;
			}
		}
		return -1;
	}
}