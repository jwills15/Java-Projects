/* Name: Joshua Williams
 * Date: 11/2/16
 * Description: Craps Game
 * This program simulates the casino game craps.
 * Two dice are rolled, which are sent to the rules
 * class to determine if the user won or lost.
 * The user determines how many games are played,
 * and the program automatically runs that many
 * games and exports percentages of winning and losing.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class autoCraps extends JApplet implements ActionListener{

	//components
	JTextField txtTotalGames = new JTextField(5);
	JTextArea txaOutput = new JTextArea("", 3, 20);
	JButton btnPlay = new JButton("Play");
	JPanel mainPanel = new JPanel();
	JPanel inputPanel = new JPanel();
	JPanel outputPanel = new JPanel();
	
	//this is the first method (function) called
	public void init(){
		
		//place the components on the form
		DesignInputPanel();
		DesignOutputPanel();
		mainPanel.add(inputPanel);
		mainPanel.add(btnPlay);
		mainPanel.add(outputPanel);

		resize(300,100);
		
		/***** VERY IMPORTANT
		 * need to set the content on the form
		 */
		setContentPane(mainPanel);
		btnPlay.addActionListener(this);
		txtTotalGames.addActionListener(this);
	
	}//end of init
	
	public void actionPerformed(ActionEvent Event){
	
		try{
			
			//connect the classes together (instantiate the object)
			//output information
			
			playCraps gameClass = new playCraps(
								Integer.parseInt(txtTotalGames.getText()));
			double winsdbl = gameClass.getWinPercentage();
			double lossesdbl = gameClass.getLosePercentage();
			
			LocalFormat frmtClass = new LocalFormat();
			String winString = frmtClass.FormatDecimal(winsdbl, 2) + "%";
			String lossString = frmtClass.FormatDecimal(lossesdbl, 2) + "%";
			
			String outputString = "Total Games: " + 
					Integer.parseInt(txtTotalGames.getText()) + 
					"\nWin Percentage: " + winString
					+ "\nLoss Percentage: " + lossString;
			txaOutput.setText(outputString);
			
		}
		catch(NumberFormatException err){
			
			//output the message
			txaOutput.setText("Please Enter Integer");
			
		}
	}
	
	public void DesignInputPanel(){
		
		inputPanel.setLayout(new GridLayout(0,2));
		inputPanel.add(new JLabel("# of Games:     "));
		inputPanel.add(txtTotalGames);
		
	}
	
	public void DesignOutputPanel(){
		
		outputPanel.setLayout(new GridLayout(0,1));
		outputPanel.add(txaOutput);
		
	}
}
