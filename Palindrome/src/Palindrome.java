/* Name: Joshua Williams
 * Date: 2/6/17
 * Description: Palindrome Program
 * This program takes the user's strings
 * and determines if they are palindromes.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class Palindrome extends JApplet implements ActionListener{

	//declare components
	JTextField txtUserString = new JTextField(10);
	JTextArea txaOutput = new JTextArea("", 5, 20);
	JButton btnCheck = new JButton("Check");
	JPanel mainPanel = new JPanel();
	JPanel inputPanel = new JPanel();
	JPanel outputPanel = new JPanel();
	
	//this is the first method (function) called
	public void init(){
		
		//place the components on the form
		DesignInputPanel();
		mainPanel.add(inputPanel);
		mainPanel.add(btnCheck);
		mainPanel.add(txaOutput);
		
		resize(250,200);
		
		/***** VERY IMPORTANT
		 * need to set the content on the form
		 */
		setContentPane(mainPanel);
		btnCheck.addActionListener(this);
		txtUserString.addActionListener(this);
		
		String intro = "Enter a word or phrase and click \nthe button"
				+ " to see if it is a palindrome.";
		txaOutput.setText(intro);
	
	}//end of init
	
	public void actionPerformed(ActionEvent Event){
	

		//step 1- get information from text boxes
		String userString = txtUserString.getText();
		
		//step 2- pass the string to check class
		checkString theCheckClass = new checkString(userString);
		
		//step 3- output information
		String userEdited = theCheckClass.getEdited();
		String reverse = theCheckClass.getReverse();
		String result = theCheckClass.getPalindrome();
		
		String output = "Original: " + userEdited + "\nReversed: "
				+ reverse + "\n\n" + result;
		txaOutput.setText(output);
		
	}
	
	public void DesignInputPanel(){
		
		inputPanel.setLayout(new GridLayout(0,2));
		inputPanel.add(new JLabel("String:"));
		inputPanel.add(txtUserString);

	}
	
}
