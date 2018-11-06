/* Name: Joshua Williams
 * Date: 3/6/17
 * Description: Fruit Sort
 * This program has the user input fruits and vegetables, and the program
 * sorts them with a variety of methods. The user can then search within
 * the array for a specific fruit or vegetable.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class FruitSort extends JApplet implements ActionListener
{
	//declare components
	JTextField txtFruitArraySize = new JTextField(10);
	JTextField txtFruit = new JTextField(10);
	JTextField txtVegArraySize = new JTextField(10);
	JTextField txtVeg = new JTextField(10);
	JTextArea txaOutput = new JTextArea("", 10, 20);
	JButton btnAdd = new JButton("Add");
	JTextField txtSearchFor = new JTextField(10);
	JButton btnSearch = new JButton("Search");
	JTextArea txaSearch = new JTextArea("", 1, 20);
	JPanel mainPanel = new JPanel();
	JPanel inputPanel = new JPanel();
	JPanel searchPanel = new JPanel();
	//declare variables
	int fruitAdded = 0;
	String fruitArray[];
	int vegAdded = 0;
	String vegArray[];
	String mergeArray[];
	
	//initialization method
	public void init()
	{	
		//place the components on the form
		DesignInputPanel();
		DesignSearchPanel();
		mainPanel.add(inputPanel);
		mainPanel.add(btnAdd);
		mainPanel.add(txaOutput);
		mainPanel.add(searchPanel);
		mainPanel.add(btnSearch);
		mainPanel.add(txaSearch);
		
		resize(250,500);
		
		// VERY IMPORTANT need to set the content on the form //
		setContentPane(mainPanel);
		btnAdd.addActionListener(this);
		btnSearch.addActionListener(this);
		txtFruitArraySize.addActionListener(this);
		txtFruit.addActionListener(this);
		txtVegArraySize.addActionListener(this);
		txtVeg.addActionListener(this);
		txtSearchFor.addActionListener(this);
		
		//sets intro strings for text areas
		String intro = "Enter the total number of strings, \nand then begin" +
				" entering the strings.";
		txaOutput.setText(intro);
		String search = "Complete the inputs before searching.";
		txaSearch.setText(search);
		txtSearchFor.setEditable(false);
	
	}//end of init
	
	public void actionPerformed(ActionEvent Event)
	{
		//checks which button is pressed
		if (Event.getSource() == btnAdd)
		{
			//prevents errors
			try
			{
				//first run, creates array sizes
				if (fruitAdded == 0 && vegAdded == 0)
				{		
					fruitArray = new String[Integer.parseInt(
									txtFruitArraySize.getText())];
					txtFruitArraySize.setEditable(false);
					vegArray = new String[Integer.parseInt(
									txtVegArraySize.getText())];
					txtVegArraySize.setEditable(false);
					
					txtSearchFor.setEditable(false);
					txaSearch.setText("Complete the inputs before searching.");
				}
				
				//adds elements to array
				if (fruitAdded < fruitArray.length)
				{
					fruitArray[fruitAdded] = txtFruit.getText();
					fruitAdded++;
				}
				if (vegAdded < vegArray.length)
				{
					vegArray[vegAdded] = txtVeg.getText();
					vegAdded++;
				}
				
				//output information
				if (vegAdded==vegArray.length && fruitAdded==fruitArray.length)
				{	
					//sorts the original arrays with selection sort
					SelectionSort selectSort = new SelectionSort();
					selectSort.slctSort(fruitArray);
					selectSort.slctSort(vegArray);
					
					mergeArray = new String[fruitArray.length + vegArray.length];
					//copies fruits and vegetables into new array
					System.arraycopy(fruitArray, 0, mergeArray, 0, 
										fruitArray.length);
					System.arraycopy(vegArray, 0, mergeArray, 
										fruitArray.length, vegArray.length);
					//sorts merged array with merge sort
					MergeSort mergeSort = new MergeSort();
					mergeSort.mrgSort(mergeArray);
					
					//creates string that will be outputted
					String output = "";
					//adds fruits to the output
					output += "Fruits:\n";
					for (int i = 0; i < fruitArray.length; i++)
					{
						output += fruitArray[i] + "\n";
					}
					//adds vegetables to output
					output += "\nVegetables:\n";
					for (int l = 0; l < vegArray.length; l++)
					{
						output += vegArray[l] + "\n";
					}
					//adds merged array to output
					output += "\nMerged:";
					for (int q = 0; q < mergeArray.length; q++)
					{
						output += "\n" + mergeArray[q];
					}
					
					//resets everything
					txaOutput.setText(output);
					txtFruitArraySize.setText("");
					txtVegArraySize.setText("");
					fruitAdded = 0;
					vegAdded = 0;
					txtFruit.setEditable(true);
					txtVeg.setEditable(true);
					txtFruitArraySize.setEditable(true);
					txtVegArraySize.setEditable(true);
					//allows search to be performed
					txtSearchFor.setEditable(true);
					txaSearch.setText("Search for a fruit or vegetable.");
				}
				else
				{
					if (vegAdded == vegArray.length)
					{
						//stops from adding more vegetables
						txaOutput.setText("Enter another fruit.");
						txtVeg.setEditable(false);
					}
					else if (fruitAdded == fruitArray.length)
					{
						//stops from adding more fruit
						txaOutput.setText("Enter another vegetable.");
						txtFruit.setEditable(false);
					}
					else
					{
						txaOutput.setText("Enter another fruit and vegetable.");
					}
				}
				//resets so that user can enter new one
				txtFruit.setText("");
				txtVeg.setText("");
			}
			catch(NumberFormatException|NullPointerException er)
			{	
				//output the error message
				txaOutput.setText("Please enter integers for array size"
						+ " and\nstrings for the fruits and vegetables.");
				
			}
		}
		else if (Event.getSource() == btnSearch)
		{
			try
			{
				BinarySearch binarySearch = new BinarySearch();
				boolean found = binarySearch.binaryFind(mergeArray, 
											txtSearchFor.getText());
				if (found)
				{
					txaSearch.setText("\"" + txtSearchFor.getText() + 
							"\" was found.");
				}
				else
				{
					mergeArray = new String[mergeArray.length + 1];
					//copies fruits and vegetables into new array
					System.arraycopy(fruitArray, 0, mergeArray, 0, 
										fruitArray.length);
					System.arraycopy(vegArray, 0, mergeArray, 
										fruitArray.length, vegArray.length);
					mergeArray[mergeArray.length - 1] = txtSearchFor.getText();
					//sorts merged array with merge sort
					MergeSort mergeSort = new MergeSort();
					mergeSort.mrgSort(mergeArray);
					
					//creates string that will be outputted
					String output = "";
					//adds fruits to the output
					output += "Fruits:\n";
					for (int i = 0; i < fruitArray.length; i++)
					{
						output += fruitArray[i] + "\n";
					}
					//adds vegetables to output
					output += "\nVegetables:\n";
					for (int l = 0; l < vegArray.length; l++)
					{
						output += vegArray[l] + "\n";
					}
					//adds merged array to output
					output += "\nMerged:";
					for (int q = 0; q < mergeArray.length; q++)
					{
						output += "\n" + mergeArray[q];
					}
					txaOutput.setText(output);
					txaSearch.setText("\"" + txtSearchFor.getText() + 
							"\" was not found and was added.");
				}
			}
			catch(NullPointerException err)
			{
				if (txtSearchFor.isEditable())
				{
					txaSearch.setText("Please enter a string.");
				}
				else
				{
					txaSearch.setText("Complete the inputs before searching.");
				}
			}
		}
		
	}
	
	public void DesignInputPanel()
	{	
		inputPanel.setLayout(new GridLayout(0,2));
		inputPanel.add(new JLabel("# of Fruit:"));
		inputPanel.add(txtFruitArraySize);
		inputPanel.add(new JLabel("Add Fruit:"));
		inputPanel.add(txtFruit);
		inputPanel.add(new JLabel("# of Vegetables:"));
		inputPanel.add(txtVegArraySize);
		inputPanel.add(new JLabel("Add Vegetables:"));
		inputPanel.add(txtVeg);
	}
	
	public void DesignSearchPanel()
	{	
		searchPanel.setLayout(new GridLayout(0,2));
		searchPanel.add(new JLabel("Search:"));
		searchPanel.add(txtSearchFor);
	}
}
