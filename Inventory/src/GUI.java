
/* Name: Joshua Williams
 * Date: 3/21/17
 * Description: pg 271, question 3, a/b
 * 
 *   **Edited**
 * Date: 3/30/17
 * Description: Added quality control class.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI extends JApplet implements ActionListener{

	//declare components
	JTextField txtName = new JTextField(10);
	JTextField txtPrice = new JTextField(10);
	JTextField txtQuantity = new JTextField(10);
	JTextField txtCustomerSatisfaction = new JTextField(10);
	JTextField txtProductQuality = new JTextField(10);
	JTextArea txaOutput = new JTextArea("", 12, 25);
	JButton btnAdd = new JButton("Add");
	JPanel mainPanel = new JPanel();
	JPanel inputPanel = new JPanel();
	JPanel outputPanel = new JPanel();
	
	//declare global variables
	Inventory hardware = new Inventory();
	
	//this is the first method (function) called
	public void init(){
		
		//place the components on the form
		DesignInputPanel();
		DesignOutputPanel();
		mainPanel.add(inputPanel);
		mainPanel.add(btnAdd);
		mainPanel.add(outputPanel);
		
		txtName.requestFocus();
		resize(300,350);
		
		/***** VERY IMPORTANT
		 * need to set the content on the form
		 */
		setContentPane(mainPanel);
		btnAdd.addActionListener(this);
		txtName.addActionListener(this);
		txtPrice.addActionListener(this);
		txtQuantity.addActionListener(this);
		txtCustomerSatisfaction.addActionListener(this);
		txtProductQuality.addActionListener(this);
	
	}//end of init
	
	public void actionPerformed(ActionEvent Event)
	{
		hardware.addNewProduct(txtName.getText(), 
					Double.parseDouble(txtPrice.getText()), 
					Integer.parseInt(txtQuantity.getText()),
					Integer.parseInt(txtCustomerSatisfaction.getText()),
					Integer.parseInt(txtProductQuality.getText()));
		String output = hardware.displayProducts();
		txaOutput.setText(output);
		ArrayList<String> orders = hardware.mustOrder();
		ArrayList<String> reviews = hardware.lowRatings();
		txaOutput.append("\nMust Order:\n" + orders + "\n\nLow Reviews:\n" + reviews);
	}
	
	public void DesignInputPanel()
	{	
		inputPanel.setLayout(new GridLayout(0,2));
		inputPanel.add(new JLabel("Product Name:"));
		inputPanel.add(txtName);
		inputPanel.add(new JLabel("Product Price:"));
		inputPanel.add(txtPrice);
		inputPanel.add(new JLabel("Product Quantity:"));
		inputPanel.add(txtQuantity);
		inputPanel.add(new JLabel("Customer Satisfaction: "));
		inputPanel.add(txtCustomerSatisfaction);
		inputPanel.add(new JLabel("Product Quality:"));
		inputPanel.add(txtProductQuality);
	}
	
	public void DesignOutputPanel()
	{
		outputPanel.setLayout(new GridLayout(0,1));
		outputPanel.add(txaOutput);
		
		txaOutput.setText("");
	}
}
