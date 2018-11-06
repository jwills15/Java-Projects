/* Name: Joshua Williams
 * Date: 10/17/16
 * Description: Test Score Application
 * This program takes the user's test scores
 * and outputs the letter grade, as well as
 * the average and which was better.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class TestScoreProject extends JApplet implements ActionListener{

	//declare components
	JTextField txtUserScore1 = new JTextField(5);
	JTextField txtOutof1 = new JTextField(5);
	JTextField txtUserScore2 = new JTextField(5);
	JTextField txtOutof2 = new JTextField(5);
	JTextArea txaPayroll = new JTextArea("", 4, 20);
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
		
		resize(300,160);
		
		/***** VERY IMPORTANT
		 * need to set the content on the form
		 */
		setContentPane(mainPanel);
		btnAdd.addActionListener(this);
		txtUserScore1.addActionListener(this);
		txtOutof1.addActionListener(this);
		txtUserScore2.addActionListener(this);
		txtOutof2.addActionListener(this);
	
	}//end of init
	
	public void actionPerformed(ActionEvent Event){
	
		//step 1- declare local variables
		int userPoints1;
		int userPoints2;
		int outof1;
		int outof2;
		
		//step 2- get information from text boxes
		try{
			
			userPoints1 = Integer.parseInt(txtUserScore1.getText());
			userPoints2 = Integer.parseInt(txtUserScore2.getText());
			outof1 = Integer.parseInt(txtOutof1.getText());
			outof2 = Integer.parseInt(txtOutof2.getText());
			
			//step 3- calculation
			//connect the classes together (instantiate the object)
			Calculations theScoreClass = new Calculations(userPoints1, 
						userPoints2, outof1, outof2);
			
			double score1 = theScoreClass.getScore1();
			double score2 = theScoreClass.getScore2();
			double average = theScoreClass.getAverage();
			
			String higher = theScoreClass.getWhichScore();
			
			char grade1 = theScoreClass.getGrade1();
			char grade2 = theScoreClass.getGrade2();
			
			//step 4- output information
			String output;
			LocalFormat frmLocal = new LocalFormat();
			String fmtScore1 = frmLocal.FormatDecimal(score1, 1) + "%";
			String fmtScore2 = frmLocal.FormatDecimal(score2, 1) + "%";
			String fmtAverage = "Your average score was "
					+ frmLocal.FormatDecimal(average, 1) + "%.";
			output = "Test 1 Score: " + fmtScore1 + " (" + grade1
					+ ")\nTest 2 Score: " + fmtScore2 + " (" + grade2 +
					")\n" + fmtAverage + "\n" + higher;
			txaPayroll.setText("");
			txaPayroll.append(output);
		
		}
		catch(NumberFormatException err){
			
			//output the message
			txaPayroll.setText("Please Enter Integers");
			
		}
		
	}
	
	public void DesignInputPanel(){
		
		inputPanel.setLayout(new GridLayout(0,2));
		inputPanel.add(new JLabel("Test 1 Correct:  "));
		inputPanel.add(txtUserScore1);
		inputPanel.add(new JLabel("Test 1 Out of:  "));
		inputPanel.add(txtOutof1);
		inputPanel.add(new JLabel("Test 2 Correct:  "));
		inputPanel.add(txtUserScore2);
		inputPanel.add(new JLabel("Test 2 Out of:  "));
		inputPanel.add(txtOutof2);
		
	}
	
	public void DesignOutputPanel(){
		
		outputPanel.setLayout(new GridLayout(0,1));
		outputPanel.add(txaPayroll);
		
	}
	
}
