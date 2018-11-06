
/* Name: Joshua Williams
 * Date: 11/14/16
 * Description: Checker Board
 * The user sets a length and width
 * and the program creates a checker board.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.*;
import javax.swing.Timer;


public class CheckerBoard extends JApplet implements ActionListener{

	//Declare components and objects	
	JTextField txtWidth = new JTextField(5);
	JTextField txtHeight = new JTextField(5);
	JButton btnCreate = new JButton("Create");
	JPanel inputPanel = new JPanel();
	JPanel mainPanel = new JPanel();
	
	int height = 0;
	int width = 0;
	
	public void init(){
		
		DesignInputPanel();
		mainPanel.add(inputPanel);
		mainPanel.add(btnCreate);
		resize(300,300);
		setContentPane(mainPanel);
		btnCreate.addActionListener(this);
		txtWidth.addActionListener(this);
		txtHeight.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent evt){
		
		try{
			
			width = Integer.parseInt(txtWidth.getText());
			height = Integer.parseInt(txtHeight.getText());
			repaint();
		
		}
		catch(NumberFormatException err){
			
			//output the message to the status bar
			showStatus("Please Enter Integers");
			
		}
		
	}		
	
	public void paint(Graphics g){
		
		super.paint(g);
		
		for (int i = 0; i < height; i++){
			
			int y = 50 + i * 10;
			int x = 10;
			
			if (i % 2 == 0){
				
				g.setColor(Color.red);
				
			}
			else if (i % 2 == 1){
				
				g.setColor(Color.black);
				
			}
			
			for (int n = 0; n < width; n++){
				
				g.fillRect(x, y, 10, 10);
				x += 10;
				if (g.getColor().equals(Color.black)){
					
					g.setColor(Color.red);
					
				}
				else if (g.getColor().equals(Color.red)){
					
					g.setColor(Color.black);
					
				}
				
			}
			
		}

		
	}
	public void Update(Graphics gr){
		
		paint(gr);
	}
	
	public void DesignInputPanel(){
		
		inputPanel.setLayout(new GridLayout(0,2));
		inputPanel.add(new JLabel("Width:"));
		inputPanel.add(txtWidth);
		inputPanel.add(new JLabel("Height:"));
		inputPanel.add(txtHeight);
		
	}
	
}


