
public class BinarySearch
{
	/* Uses Binary Search to look for target in an array a, sorted in
	 * ascending order. If found, returns the index of the matching
	 * element; otherwise returns -1.
	*/
	public boolean binaryFind(String[] a, String target)
		// <T> indicates that this method works for an array of
		// comparable objects of any type T. Comparable<? Super T>
		// ensures that the method will work not only for a class T
		// that implements Comparable<T> but also for any subclass
		// of such a class.
	{
		int left = 0, right = a.length - 1;
		
		while (left <= right)
		{
			// Take the index of the middle element between
			// "left" and "right":

			int middle = (left + right) / 2;

			// Compare this element to the target value
			// and adjust the search range accordingly:
			int diff = a[middle].compareToIgnoreCase(target);
			
			if (diff < 0) // target > a[middle]
				left = middle + 1;
			else if (diff > 0) // target < a[middle]
				right = middle - 1;
			else // target is equal to a[middle]
				return true;
		}

		return false;
	}
}
