
public class MergeSort
{
	private String[] temp;
	
	// Sorts a[0], ..., a[size-1] in ascending order
	// using the Mergesort algorithm.
	public void mrgSort(String[] a)
	{
		int n = a.length;
		temp = new String[n];
		recursiveMrgSort(a, 0, n-1);
	}
	
	// Recursive helper method: sorts a[from], ..., a[to]
	private void recursiveMrgSort(String[] a, int from, int to)
	{
		if (to - from < 2)  // Base case: 1 or 2 elements
		{
			if (to > from && a[to].compareToIgnoreCase(a[from]) < 0)
			{
				// swap a[to] and a[from]
				String aTemp = a[to];
				a[to] = a[from];
				a[from] = aTemp;
			}
		}
		else  // Recursive case
		{
			int middle = (from + to) / 2;
			recursiveMrgSort(a, from, middle);
			recursiveMrgSort(a, middle + 1, to);
			merge(a, from, middle, to);
		}
	}

	// Merges a[from] ... a[middle] and a[middle+1] ... a[to]
	// into one sorted array a[from] ... a[to]
	private void merge(String[] a, int from, int middle, int to)
	{
		int i = from, j = middle + 1, k = from;

		// While both arrays have elements left unprocessed:
		while (i <= middle && j <= to)
		{
			if (a[i].compareToIgnoreCase(a[j]) < 0)
			{
				temp[k] = a[i];  // or simply temp[k] = a[i++];
				i++;
			}
			else
			{
				temp[k] = a[j];
				j++;
			}
			k++;
		}
		
		// Copy the tail of the first half, if any, into temp:
		while (i <= middle)
		{
			temp[k] = a[i];
			i++;
			k++;
		}

		// Copy the tail of the second half, if any, into temp:
		while (j <= to)
		{
			temp[k] = a[j];
			j++;
			k++;
		}

		// Copy temp back into a
		for (k = from; k <= to; k++)
			a[k] = temp[k];

	}
}
