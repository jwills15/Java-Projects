/* Name: Joshua Williams
 * Date: 12/1/16
 * Description: Test Score Application V2
 * This program takes the user's test scores
 * and finds the average.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class TestScoreV2 extends JApplet implements ActionListener{

	//declare components
	JTextField txtUserScore = new JTextField(5);
	JTextField txtArraySize = new JTextField(5);
	JTextArea txaOutput = new JTextArea("", 10, 20);
	JButton btnAdd = new JButton("Calculate");
	JPanel mainPanel = new JPanel();
	JPanel inputPanel = new JPanel();
	JPanel outputPanel = new JPanel();
	
	int scoresAdded = 0;
	int scoresArray[];
	char letterGradeArray[];
	
	//this is the first method (function) called
	public void init(){
		
		//place the components on the form
		DesignInputPanel();
		DesignOutputPanel();
		mainPanel.add(inputPanel);
		mainPanel.add(btnAdd);
		mainPanel.add(outputPanel);
		
		resize(300,300);
		
		/***** VERY IMPORTANT
		 * need to set the content on the form
		 */
		setContentPane(mainPanel);
		btnAdd.addActionListener(this);
		txtUserScore.addActionListener(this);
		txtArraySize.addActionListener(this);
		
		String intro = "Enter the total number of scores, \nand then begin" +
				" entering the scores, \nfrom 0-100%.";
		txaOutput.setText(intro);
	
	}//end of init
	
	public void actionPerformed(ActionEvent Event){
	

		//step 1- get information from text boxes
		try{
			
			if (scoresAdded == 0)
			{		
				int arraySize = Integer.parseInt(txtArraySize.getText());
				scoresArray = new int[arraySize];
				letterGradeArray = new char[arraySize];
			}
			scoresArray[scoresAdded] = Integer.parseInt(txtUserScore.getText());
			
			//step 3- calculation
			//connect the classes together (instantiate the object)
			Calculations theScoreClass = new Calculations(
					scoresArray[scoresAdded], scoresArray.length, scoresAdded);
			letterGradeArray[scoresAdded] = theScoreClass.getGrade();
			
			//step 4- output information
			scoresAdded++;
			
			if (scoresAdded == scoresArray.length)
			{	
				String output = "";
				
				for (int i = 0; i < scoresArray.length; i++)
				{
					output += "Score " + (i + 1) + ": " + scoresArray[i] +
							" (" + letterGradeArray[i] + ")\n";
				}
				
				output += "Grades Backwards: ";
				for (int b = scoresArray.length - 1; b >= 0; b--)
				{
					output += letterGradeArray[b];
					if (b != 0)
					{
						output += ", ";
					}
				}
				
				output += "\nAverage Score: " + theScoreClass.getAverage() +
						"\nHighest Score: " + theScoreClass.getHighest() + 
						"\nLowest Score: " + theScoreClass.getLowest();
				
				txaOutput.setText(output);
				txtArraySize.setText("");
				scoresAdded = 0;
			}
			else
			{
				txaOutput.setText("Enter another Test Score.");
			}
			txtUserScore.setText("");
		}
		catch(NumberFormatException err){
			
			//output the message
			txaOutput.setText("Please Enter Integers");
			
		}
		
	}
	
	public void DesignInputPanel(){
		
		inputPanel.setLayout(new GridLayout(0,2));
		inputPanel.add(new JLabel("Array Size:   "));
		inputPanel.add(txtArraySize);
		inputPanel.add(new JLabel("Score:   "));
		inputPanel.add(txtUserScore);

	}
	
	public void DesignOutputPanel(){
		
		outputPanel.setLayout(new GridLayout(0,1));
		outputPanel.add(txaOutput);
		
	}
	
}
