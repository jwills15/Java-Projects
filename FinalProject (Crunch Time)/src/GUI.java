
/* Name: Joshua Williams
 * Date: 
 * Description: 
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;



public class GUI extends JFrame implements KeyListener, ActionListener
{
	static GUI a;
	public static void main(String[] args)
	{
		//new GameFrame();
		
	    a = new MenuFrame();
	}
	
	public GUI()
	{
		setSize(900,626);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	    setLayout(null);
	    setTitle("GUI");
	    setResizable(false);
	    setVisible(true);
		addKeyListener(this);
		try {
		     ClassLoader cl = this.getClass().getClassLoader();
		     ImageIcon programIcon = new ImageIcon(cl.getResource("gameIcon.png"));
		     setIconImage(programIcon.getImage());
		  } catch (Exception whoJackedMyIcon) {
		     System.out.println("Could not load program icon.");
		  }
	}
	
	public void actionPerformed(ActionEvent evt){}
	public void keyPressed(KeyEvent e){}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	
	
	
}


