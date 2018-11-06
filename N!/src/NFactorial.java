/* Name: Joshua Williams
 * Date: 10/24/16
 * Description: N!
 * This program takes the user's integer
 * and adds up the even and odd numbers,
 * while also performing a factorial.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class NFactorial extends JApplet implements ActionListener{

	//declare components
	JTextField txtUserNumber = new JTextField(5);
	JTextArea txaSum = new JTextArea("", 15, 10);
	JTextArea txaOdd = new JTextArea("", 15, 10);
	JTextArea txaFactorial = new JTextArea("", 15, 10);
	JButton btnAdd = new JButton("Calculate");
	JPanel mainPanel = new JPanel();
	JPanel inputPanel = new JPanel();
	JPanel outputPanel = new JPanel();
	
	//this is the first method (function) called
	public void init(){
		
		//place the components on the form
		DesignInputPanel();
		DesignOutputPanel();
		mainPanel.add(inputPanel);
		mainPanel.add(btnAdd);
		mainPanel.add(outputPanel);
		
		resize(400,300);
		
		/***** VERY IMPORTANT
		 * need to set the content on the form
		 */
		setContentPane(mainPanel);
		btnAdd.addActionListener(this);
		txtUserNumber.addActionListener(this);
	
	}//end of init
	
	public void actionPerformed(ActionEvent Event){
	
		//step 1- declare local variables
		String strSum;
		String strOdd;
		String strFactorial;
		int userNumber = 0;
		
		//step 2- get information from text boxes
		try{
			
			userNumber = Integer.parseInt(txtUserNumber.getText());
			
			//step 3- calculation
			//connect the classes together (instantiate the object)
			Calculations theFactorialClass = new Calculations(userNumber);
			
			strSum = theFactorialClass.getSum();
			strOdd = theFactorialClass.getOdd();
			strFactorial = theFactorialClass.getFactorial();
			
			//step 4- output information
			txaSum.setText(strSum);
			txaOdd.setText(strOdd);
			txaFactorial.setText(strFactorial);
		
		}
		catch(NumberFormatException err){
			
			//output the message
			txaOdd.setText("Please Enter Integers");
			txaSum.setText("");
			txaFactorial.setText("");
			
		}
		
	}
	
	public void DesignInputPanel(){
		
		inputPanel.setLayout(new GridLayout(0,2));
		inputPanel.add(new JLabel("Integer:  "));
		inputPanel.add(txtUserNumber);
		
	}
	
	public void DesignOutputPanel(){
		
		outputPanel.setLayout(new GridLayout(0,3));
		outputPanel.add(txaSum);
		txaSum.append("Sum");
		outputPanel.add(txaOdd);
		txaOdd.append("Odd");
		outputPanel.add(txaFactorial);
		txaFactorial.append("Factorial");
		
	}
	
}
