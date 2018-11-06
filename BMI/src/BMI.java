/* Name: Joshua Williams
 * Date: 9/9/16
 * Description: BMI Application
 * This program calculates the user's
 * Body Mass Index (BMI).
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class BMI extends JApplet implements ActionListener{

	//declare components
	JTextField txtName = new JTextField(20);
	JTextField txtHeight = new JTextField(20);
	JTextField txtWeight = new JTextField(5);
	JTextArea txaOutput = new JTextArea("", 9, 20);
	JButton btnAdd = new JButton("Calculate");
	JPanel mainPanel = new JPanel();
	JPanel inputPanel = new JPanel();
	JPanel outputPanel = new JPanel();
	
	//declare global variables
	int totalPeople = 0;
	float totalBMI = 0;
	float averageBMI = 0;
	String key = "Underweight =< 18.4\nNormal = 18.5-24.9"
			+ "\nOverweight = 25-29.9\nObesity >= 30";
	
	//this is the first method (function) called
	public void init(){
		
		//place the components on the form
		DesignInputPanel();
		DesignOutputPanel();
		mainPanel.add(inputPanel);
		mainPanel.add(btnAdd);
		mainPanel.add(outputPanel);
		
		txtName.requestFocus();
		resize(500,250);
		
		/***** VERY IMPORTANT
		 * need to set the content on the form
		 */
		setContentPane(mainPanel);
		btnAdd.addActionListener(this);
		txtName.addActionListener(this);
		txtHeight.addActionListener(this);
		txtWeight.addActionListener(this);
	
	}//end of init
	
	public void actionPerformed(ActionEvent Event){
	
		//step 1- declare local variables
		String nameString;
		float heightFloat;
		float weightFloat;
		float userBMI;
		
		try{
			
			//step 2- get information from text boxes
			nameString = txtName.getText();
			heightFloat = Float.parseFloat(txtHeight.getText());
			weightFloat = Float.parseFloat(txtWeight.getText());
		
			//step 3- calculation
			userBMI = calculateBMI(heightFloat, weightFloat);
			calculateAverage(userBMI);
			
			//step 4- output information
			DecimalFormat fmt1decimal = new DecimalFormat("#.0");
			String frmaverageBMI = fmt1decimal.format(averageBMI);
			String formattedDataString = fmt1decimal.format(userBMI);
			String outputString = nameString + "\'s BMI: " + formattedDataString 
					+ "\n\nTotal People: " + totalPeople +
					"\nAverage BMI: " + frmaverageBMI + "\n\n" + key;
			txaOutput.setText("");
			txaOutput.append(outputString);
			
		}
		catch(NumberFormatException ex){
			
			txaOutput.setText("");
			txaOutput.append("Enter numbers for\nheight and weight.");
			
		}
		
	}
	
	public void DesignInputPanel(){
		
		inputPanel.setLayout(new GridLayout(0,2));
		inputPanel.add(new JLabel("Name:"));
		inputPanel.add(txtName);
		inputPanel.add(new JLabel("Height (Inches):"));
		inputPanel.add(txtHeight);
		inputPanel.add(new JLabel("Weight (Pounds):"));
		inputPanel.add(txtWeight);
		
	}
	
	public void DesignOutputPanel(){
		
		outputPanel.setLayout(new GridLayout(0,1));
		outputPanel.add(txaOutput);
		
		txaOutput.append("Underweight =< 18.4\nNormal = 18.5-24.9"
				+ "\nOverweight = 25-29.9\nObesity >= 30");
		
	}
	
	//this calculates pay
	public float calculateBMI(float theHeight, float theWeight){
		
		float theBMI = 0;
		//convert pounds to kilograms
		theWeight *= 0.454;
		//convert inches to meters
		theHeight *= 0.0254;
		//calc BMI
		theBMI = theWeight / (theHeight * theHeight);
		return theBMI;
		
	}
	
	//calculates average
	public void calculateAverage(float theBMI){
		
		totalPeople += 1;
		totalBMI += theBMI;
		averageBMI = totalBMI / totalPeople;
		
	}
}
