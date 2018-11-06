/* Name: Joshua Williams
 * Date: 9/29/16
 * Description: Dice Program
 * This program simulates two dice being rolled.
 * The program keeps track of the percentages
 * of each value.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DiceProgram extends JApplet implements ActionListener{

	//components
	JTextArea txaOutput = new JTextArea("", 16, 10);
	JButton btnRoll = new JButton("Roll");
	JPanel mainPanel = new JPanel();
	
	//this is the first method (function) called
	public void init(){
		
		//place the components on the form
		mainPanel.add(btnRoll);
		mainPanel.add(txaOutput);

		resize(400,300);
		
		/***** VERY IMPORTANT
		 * need to set the content on the form
		 */
		setContentPane(mainPanel);
		btnRoll.addActionListener(this);
	
	}//end of init
	
	public void actionPerformed(ActionEvent Event){
	
		//connect the classes together (instantiate the object)
		//output information
		Calculations rollClass = new Calculations();
		String outputString = rollClass.getOutputString();
		txaOutput.setText("");
		txaOutput.append(outputString);
			
	}
	
}
