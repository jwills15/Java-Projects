/* Name: Joshua Williams
 * Date: 9/29/16
 * Description: Craps Game
 * This program simulates the casino game craps.
 * Two dice are rolled, which are sent to the rules
 * class to determine if the user won or lost.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrapsGame extends JApplet implements ActionListener{

	//components
	JTextArea txaOutput = new JTextArea("", 5, 10);
	JButton btnRoll = new JButton("Roll");
	JPanel mainPanel = new JPanel();
	
	//global variables
	int userRollNumber = 0;
	int userPoint = 0;
	
	//this is the first method (function) called
	public void init(){
		
		//place the components on the form
		mainPanel.add(btnRoll);
		mainPanel.add(txaOutput);

		resize(400,100);
		
		/***** VERY IMPORTANT
		 * need to set the content on the form
		 */
		setContentPane(mainPanel);
		btnRoll.addActionListener(this);
	
	}//end of init
	
	public void actionPerformed(ActionEvent Event){
	
		//connect the classes together (instantiate the object)
		//output information
		RollDice rollClass = new RollDice(userRollNumber);
		int diceOne = rollClass.getDiceOne();
		int diceTwo = rollClass.getDiceTwo();
		int diceTotal = rollClass.getDiceTotal();
		userRollNumber = rollClass.getRollNumber();
		
		Rules rulesClass = new Rules(diceTotal, userRollNumber, userPoint);
		userRollNumber = rulesClass.getRollNumber();
		userPoint = rulesClass.getUserPoint();
		String winLoss = rulesClass.getOutput();
		
		String outputPoint = "";
		if (userRollNumber == 0 && userPoint == 0){
			
			outputPoint = "N/A";
		
		}
		else{
			
			outputPoint = "" + userPoint;
		
		}
		
		String outputString = "Dice 1: " + diceOne + "\nDice 2: " + diceTwo
				+ "\nDice Total: " + diceTotal + "\nUser Point: " + outputPoint
				+ "\n" + winLoss;
		txaOutput.setText("");
		txaOutput.append(outputString);
			
	}
	
}
