
/* Name: Joshua Williams
 * Date: 2/20/17
 * Description: Binary Search
 * This program uses sequential search and
 * binary search to find a target value.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;

public class BinarySearch extends JApplet implements ActionListener{

	//declare components
	JTextArea txaOutput = new JTextArea("", 5, 20);
	JButton btnSearch = new JButton("Search");
	JPanel mainPanel = new JPanel();
	
	//create variables needed
	int testSize = 5000;
	int randomNumArray[] = new int[5000];
	
	
	//this is the first method (function) called
	public void init()
	{	
		//place the components on the form
		mainPanel.add(btnSearch);
		mainPanel.add(txaOutput);
		
		resize(300,150);
		
		/***** VERY IMPORTANT
		 * need to set the content on the form
		 */
		setContentPane(mainPanel);
		btnSearch.addActionListener(this);
		
		String intro = "Click the search button to perform"
				+ "\nsequential and binary searches.";
		txaOutput.setText(intro);

	}
	
	public void actionPerformed(ActionEvent Event)
	{
		//create the random array of numbers
		for (int i = 0; i < 5000; i++)
		{
			randomNumArray[i] = (int)(Math.random() * 5000 + 1);
		}
		
		//use the sequential search and find the average
		Sequential theSequentialSearch = new Sequential(testSize, randomNumArray);
		double seqAverage = theSequentialSearch.getAverage();
		
		//use the binary search and find the average
		Binary theBinarySearch = new Binary();
		Arrays.sort(randomNumArray);//sorts array, necessary for binary search
		int totalSearches = 0;
		int searchesPerformed = testSize;
		for (int m = 0; m < testSize; m++)
		{
			//sets a target and performs search
			int target = (int)(Math.random() * 5000 + 1);
			int searches = theBinarySearch.find(randomNumArray, target);
			if (searches == -1)
			{
				//exempts searches when number is not found
				searchesPerformed--;
				searches = 0;
			}
			
			totalSearches += searches;
		}
		double binaryAverage = (double)totalSearches / searchesPerformed;
			
		//output the message
		txaOutput.setText("Sequential Search Average:\n" + seqAverage + 
				"\n\nBinary Search Average:\n" + binaryAverage);
	}
	
}
