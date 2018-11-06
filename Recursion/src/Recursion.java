/* Name: Joshua Williams
 * Date: 2/13/17
 * Description: Recursion
 * This program uses recursion to perform a variety of tasks.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recursion extends JApplet implements ActionListener
{
	//declare components
	JTextField txtDivide = new JTextField(5);
	JTextField txtOddNum = new JTextField(5);
	JTextField txtGCFnum1 = new JTextField(5);
	JTextField txtGCFnum2 = new JTextField(5);
	JTextArea txaOutput = new JTextArea("", 10, 20);
	JButton btnCalculate = new JButton("Calculate");
	JPanel mainPanel = new JPanel();
	JPanel inputPanel = new JPanel();
	JPanel outputPanel = new JPanel();
	
	//this is the first method (function) called
	public void init()
	{
		//place the components on the form
		DesignInputPanel();
		mainPanel.add(inputPanel);
		mainPanel.add(btnCalculate);
		mainPanel.add(txaOutput);
		
		resize(250,300);
		
		/***** VERY IMPORTANT
		 * need to set the content on the form
		 */
		setContentPane(mainPanel);
		btnCalculate.addActionListener(this);
		txtDivide.addActionListener(this);
		txtOddNum.addActionListener(this);
		txtGCFnum1.addActionListener(this);
		txtGCFnum2.addActionListener(this);
		
		String intro = "Enter integers into each text box.";
		txaOutput.setText(intro);
	
	}//end of init
	
	public void actionPerformed(ActionEvent Event)
	{
		try
		{
			String division = divideRecur(Double.parseDouble(txtDivide.getText()));
			String oddNumbers = oddNumRecur(Integer.parseInt(txtOddNum.getText()), 1);
			int GCFnum1 = Integer.parseInt(txtGCFnum1.getText());
			int GCFnum2 = Integer.parseInt(txtGCFnum2.getText());
			String GCF = GCFrecur(GCFnum1, GCFnum2);
			String output = "Dividing by 3: \n" + division + "\n\nOdd Numbers:\n"
					+ oddNumbers + "\n\nGCF of " + GCFnum1 + " & " + GCFnum2 +
					":\n" + GCF;
			txaOutput.setText(output);
		}
		catch(NumberFormatException ex)
		{	
			txaOutput.setText("Enter integers into each text box.");	
		}
		
	}
	
	public void DesignInputPanel()
	{
		inputPanel.setLayout(new GridLayout(0,2));
		inputPanel.add(new JLabel("Divide by 3:"));
		inputPanel.add(txtDivide);
		inputPanel.add(new JLabel("Odd Numbers:     "));
		inputPanel.add(txtOddNum);
		inputPanel.add(new JLabel("GCF 1:"));
		inputPanel.add(txtGCFnum1);
		inputPanel.add(new JLabel("GCF 2:"));
		inputPanel.add(txtGCFnum2);
	}
	
	public String divideRecur(double number)
	{
		if(number < 1)
		{
			return ""+number;
		}
		else
	    {
			return number + "\n" + divideRecur(number/3);
	    }
	}
	
	public String oddNumRecur(int number, int oddNum)
	{
		if(number == 1)
		{
			return ""+oddNum;
		}
		else
	    {
			return oddNum + "   " + oddNumRecur(number-1,oddNum+2);
	    }
	}
	
	public String GCFrecur(int num1, int num2)
	{
		if(num1 == 0 || num2 == 0) 
		{
			return ""+(num1+num2);
		}
		else
		{
			return GCFrecur(num2,num1%num2);
		}
	}	
}
