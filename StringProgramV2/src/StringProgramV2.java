
/* Name: Joshua Williams
 * Date: 1/31/17
 * Description: String Program V2
 * The programs uses String methods to output
 * strings in a variety of ways.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.*;
import javax.swing.Timer;

public class StringProgramV2 extends JApplet implements ActionListener{

	//Declare components and objects	
	JButton btnOutput = new JButton("Output");
	JPanel mainPanel = new JPanel();
	JTextArea txaOutput = new JTextArea("", 10, 40);
	
	public void init(){
		
		mainPanel.add(btnOutput);
		mainPanel.add(txaOutput);
		resize(500,220);
		setContentPane(mainPanel);
		btnOutput.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent evt){
		
		String poem1 = "	Tell me not, in mournful numbers "; //use a tab
		String poem2 = "Life is but an empty dream! ";
		String poem3 = "For the soul is dead that slumbers, ";
		String poem4 = "And things are not what they seem.";
		
		String output = poem1.toUpperCase() + '\n' + poem1.toLowerCase()
					+ "\nThe length of poem1 is " + poem1.length() + '\n'
					+ poem1.trim() + '\n' + poem1.concat(poem2) + '\n'
					+ poem1.substring(14, 33) + '\n' + poem1.substring(6, 12)
					+ "\nStudents sigh" + poem1.substring(13, 33);
		txaOutput.setText(output);
		
	}		
	
}
