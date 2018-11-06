/* Name: Joshua Williams
 * Date: 9/26/16
 * Description: Car Rental V3
 * This program calculates the charge
 * that the user must pay for a car rental, 
 * while using multiple classes and including
 * radio buttons for multiple cars and check
 * boxes for additional features.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CarRental2 extends JApplet implements ActionListener{

	//declare components
	JTextField txtName = new JTextField(20);
	JTextField txtStreet = new JTextField(20);
	JTextField txtCity = new JTextField(20);
	JTextField txtState = new JTextField(20);
	JTextField txtZip = new JTextField(20);
	JTextField txtBegin = new JTextField(10);
	JTextField txtEnd = new JTextField(10);
	JTextField txtDays = new JTextField(10);
	JTextArea txaOutput = new JTextArea("", 11, 20);
	JButton btnAdd = new JButton("Calculate");
	JPanel mainPanel = new JPanel();
	JPanel inputPanel = new JPanel();
	JPanel outputPanel = new JPanel();
	
	JRadioButton radCar1 = new JRadioButton("Honda Accord ($15/day & $0.12/mile)");
	JRadioButton radCar2 = new JRadioButton("Ford F-150 ($20/day & $0.15/mile)");
	JRadioButton radCar3 = new JRadioButton("Tesla Model S ($25/day & $0.20/mile)");
	ButtonGroup CarButtonGroup = new ButtonGroup();
	JCheckBox chkLeather = new JCheckBox("Leather Seats (+$2/day)");
	JCheckBox chkBose = new JCheckBox("Bose Sound System (+$3/day)");
	
	//this is the first method (function) called
	public void init(){
		
		//place the components on the form
		DesignInputPanel();
		DesignOutputPanel();
		mainPanel.add(inputPanel);
		mainPanel.add(btnAdd);
		mainPanel.add(outputPanel);
		
		txtName.requestFocus();
		resize(500,500);
		
		/***** VERY IMPORTANT
		 * need to set the content on the form
		 */
		setContentPane(mainPanel);
		btnAdd.addActionListener(this);
		txtName.addActionListener(this);
		txtStreet.addActionListener(this);
		txtCity.addActionListener(this);
		txtState.addActionListener(this);
		txtZip.addActionListener(this);
		txtBegin.addActionListener(this);
		txtEnd.addActionListener(this);
		txtDays.addActionListener(this);
	
	}//end of init
	
	public void actionPerformed(ActionEvent Event){
	
		//step 1- declare local variables
		String nameString;
		String streetString;
		String cityString;
		String stateString;
		String zipString;
		double begindouble;
		double enddouble;
		double daysdouble;
		double finalPrice;
		double payPerDay = 0;
		double payPerMile = 0;
		
		try{
			
			//step 2- get information from text boxes
			nameString = txtName.getText();
			streetString = txtStreet.getText();
			cityString = txtCity.getText();
			stateString = txtState.getText();
			zipString = txtZip.getText();
			begindouble = Double.parseDouble(txtBegin.getText());
			enddouble = Double.parseDouble(txtEnd.getText());
			double totalMilesdouble = enddouble - begindouble;
			daysdouble = Double.parseDouble(txtDays.getText());
		
			if (totalMilesdouble < 0){
				
				txaOutput.setText("");
				txaOutput.append("Beginning odometer must be \nsmaller "
						+ "than ending odometer.");
			
			}
			else{
				
				//find cost of car per day and extra charges
				if (radCar1.isSelected()){
					
					payPerDay = 15;
					payPerMile = .12;
					
				}
				else if (radCar2.isSelected()){
					
					payPerDay = 20;
					payPerMile = .15;
					
				}
				else if (radCar3.isSelected()){
					
					payPerDay = 25;
					payPerMile = .2;
					
				}
				
				if (chkLeather.isSelected()){
					
					payPerDay += 2;
					
				}
				if (chkBose.isSelected()){
					
					payPerDay += 3;
					
				}
				
				//connect the classes together (instantiate the object)
				Calculations theCostClass = new Calculations(begindouble, enddouble,  daysdouble, payPerDay, payPerMile);
				
				double dblCost = theCostClass.getCost();
				
				int totalPeople = theCostClass.getTotalCars();
				double totalSales = theCostClass.getTotalSales();
				double averageSale = theCostClass.getAverageSale();
				
				//step 4- output information
				LocalFormat frmLocal = new LocalFormat();
				String frmtPrice = frmLocal.FormatCurrency(dblCost);
				String frmtTotal = frmLocal.FormatCurrency(totalSales);
				String frmtAverage = frmLocal.FormatCurrency(averageSale);
				String frmtTotalMiles = frmLocal.FormatDecimal(totalMilesdouble, 1);
				String outputString = nameString + "\n" + streetString + "\n" +
							cityString + ", " + stateString + " " + zipString +
							"\n\nMiles Driven: " + frmtTotalMiles +
							"\nTotal Charge: " + frmtPrice + "\n\nStore Totals\n"
							+ "Total Cars Rented: " + totalPeople + 
							"\nTotal Charges: " + frmtTotal + "\nAverage Charge: "
							+ frmtAverage;
				txaOutput.setText("");
				txaOutput.append(outputString);
				
			}
			
		}
		catch(NumberFormatException ex){
			
			txaOutput.setText("");
			txaOutput.append("Enter text for the first 4 inputs "
					+ "and\nenter numbers for the last 4 inputs.");
			
		}
		
	}
	
	public void DesignInputPanel(){
		
		inputPanel.setLayout(new GridLayout(0,2));
		inputPanel.add(new JLabel("Name:"));
		inputPanel.add(txtName);
		inputPanel.add(new JLabel("Street:"));
		inputPanel.add(txtStreet);
		inputPanel.add(new JLabel("City:"));
		inputPanel.add(txtCity);
		inputPanel.add(new JLabel("State:"));
		inputPanel.add(txtState);
		inputPanel.add(new JLabel("Zip Code:"));
		inputPanel.add(txtZip);
		inputPanel.add(new JLabel("Beginning Odometer:"));
		inputPanel.add(txtBegin);
		inputPanel.add(new JLabel("Ending Odometer:"));
		inputPanel.add(txtEnd);
		inputPanel.add(new JLabel("Number of Days:"));
		inputPanel.add(txtDays);
		inputPanel.add(radCar1);
		inputPanel.add(radCar2);
		inputPanel.add(radCar3);
		CarButtonGroup.add(radCar1);
		CarButtonGroup.add(radCar2);
		CarButtonGroup.add(radCar3);
		inputPanel.add(chkLeather);
		inputPanel.add(chkBose);
		
	}
	
	public void DesignOutputPanel(){
		
		outputPanel.setLayout(new GridLayout(0,1));
		outputPanel.add(txaOutput);
		
	}

}
