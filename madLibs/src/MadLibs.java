/* Name: Joshua Williams
 * Date: 9/7/16
 * Description:
 * This program takes text inputted by the user
 * and concatenates it into a mad lib.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MadLibs extends JApplet implements ActionListener{

	//declare components
	JTextField txtInput1 = new JTextField(20);
	JTextField txtInput2 = new JTextField(20);
	JTextField txtInput3 = new JTextField(20);
	JTextField txtInput4 = new JTextField(20);
	JTextField txtInput5 = new JTextField(20);
	JTextField txtInput6 = new JTextField(20);
	JTextField txtInput7 = new JTextField(20);
	JTextField txtInput8 = new JTextField(20);
	JTextField txtInput9 = new JTextField(20);
	JTextField txtInput10 = new JTextField(20);
	JTextArea txaMadLib = new JTextArea("", 5, 25);
	JButton btnAdd = new JButton("Create Mad Lib");
	JPanel mainPanel = new JPanel();
	JPanel inputPanel = new JPanel();
	JPanel outputPanel = new JPanel();
	
	//declare global variables
	String input1;
	String input2;
	String input3;
	String input4;
	String input5;
	String input6;
	String input7;
	String input8;
	String input9;
	String input10;
	String madLib;
	
	//initialization function
	public void init(){
		
		//place the components on the form
		DesignInputPanel();
		DesignOutputPanel();
		mainPanel.add(inputPanel);
		mainPanel.add(btnAdd);
		mainPanel.add(outputPanel);
		
		txtInput1.requestFocus();
		resize(500,310);
		
		//set content on panel
		setContentPane(mainPanel);
		btnAdd.addActionListener(this);
		txtInput1.addActionListener(this);
		txtInput2.addActionListener(this);
		txtInput3.addActionListener(this);
		txtInput4.addActionListener(this);
		txtInput5.addActionListener(this);
		txtInput6.addActionListener(this);
		txtInput7.addActionListener(this);
		txtInput8.addActionListener(this);
		txtInput9.addActionListener(this);
		txtInput10.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent Event)
	{
		
		//reacts to button being pushed
		input1 = txtInput1.getText();
		input2 = txtInput2.getText();
		input3 = txtInput3.getText();
		input4 = txtInput4.getText();
		input5 = txtInput5.getText();
		input6 = txtInput6.getText();
		input7 = txtInput7.getText();
		input8 = txtInput8.getText();
		input9 = txtInput9.getText();
		input10 = txtInput10.getText();
		txaMadLib.setText("");
		madLib = "The " + input1 + " " + input2 + " entered the " + input3 
				+ "\n" + input4 + " to vist a " + input5 + " " + input6 + ". "
				+ "\n\"" + input7 + ", " + input8 + ", can I interest"
				+ "\nyou in any " + input9 + " " + input10 + "?\"";
		txaMadLib.append(madLib);
		
	}

	public void DesignInputPanel(){
		
		inputPanel.setLayout(new GridLayout(0,2));
		inputPanel.add(new JLabel("Adjective:"));
		inputPanel.add(txtInput1);
		inputPanel.add(new JLabel("Noun:"));
		inputPanel.add(txtInput2);
		inputPanel.add(new JLabel("Adjective:"));
		inputPanel.add(txtInput3);
		inputPanel.add(new JLabel("Noun:"));
		inputPanel.add(txtInput4);
		inputPanel.add(new JLabel("Adjective:"));
		inputPanel.add(txtInput5);
		inputPanel.add(new JLabel("Noun:"));
		inputPanel.add(txtInput6);
		inputPanel.add(new JLabel("Command:"));
		inputPanel.add(txtInput7);
		inputPanel.add(new JLabel("Name:"));
		inputPanel.add(txtInput8);
		inputPanel.add(new JLabel("Adjective:"));
		inputPanel.add(txtInput9);
		inputPanel.add(new JLabel("Noun:"));
		inputPanel.add(txtInput10);
		
	}
	
	public void DesignOutputPanel(){
		
		outputPanel.setLayout(new GridLayout(0,1));
		outputPanel.add(txaMadLib);
		
	}
}
