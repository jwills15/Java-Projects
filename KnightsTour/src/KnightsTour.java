
/* Name: Joshua Williams
 * Date: 1/18/17
 * Description: Knight Tour
 * This program randomly moves a knight around a chess
 * board and tries to hit all the squares.
 */

import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.text.*;
import javax.swing.Timer;


public class KnightsTour extends JApplet implements ActionListener{

	//Declare components and objects	
	JPanel mainPanel = new JPanel();
	
	int row = 1;
	int column = 1;
	int moveNumber = 1;
	
	Timer myTimer = new Timer(500, this);
	
	ImageIcon knightImage = new ImageIcon("knight.jpg");
	
	DefineKnight KnightArray[][] = new DefineKnight[8][8];
	
	public void init(){
		
		resize(360,369);
		setContentPane(mainPanel);
		
		for(int i = 0; i < 8; i++){
			
			for(int m = 0; m < 8; m++){
				
				KnightArray[i][m] = new DefineKnight();
			
			}
			
		}
		for(int i = 0; i < 8; i++){
			
			for(int m = 0; m < 8; m++){
				
				int width = 40;
				int height = 40;
				int x = 20 + i * width;
				int y = 20 + m * height;
				int number = 0;
				Boolean knightOn = false;
				KnightArray[i][m].setKnight(width,height,x,y,number,knightOn);
			
			}
			
		}
		
		KnightArray[1][1].number = 1;
		KnightArray[1][1].knightOn = true;
		
		myTimer.start();

	}
	
	public void actionPerformed(ActionEvent evt){
		
		requestFocus();
		
		Boolean move = false;
		moveNumber += 1;
		int avoidCrash = 1;
		
		do{
			
			avoidCrash += 1;
			int direction = (int)(Math.random() * 8);
			
			if (row + 2 < 8 && column + 1 < 8 &&
					KnightArray[row + 2][column + 1].number == 0 && 
					direction == 0){
				
				KnightArray[row][column].knightOn = false;
				row += 2;
				column += 1;
				KnightArray[row][column].knightOn = true;
				KnightArray[row][column].number = moveNumber;
				move = true;
				
			}
			else if (row + 2 < 8 && column - 1 >= 0 &&
					KnightArray[row + 2][column - 1].number == 0 && 
					direction == 1){
				
				KnightArray[row][column].knightOn = false;
				row += 2;
				column -= 1;
				KnightArray[row][column].knightOn = true;
				KnightArray[row][column].number = moveNumber;
				move = true;
				
			}
			else if (row - 2 >= 0 && column + 1 < 8 &&
					KnightArray[row - 2][column + 1].number == 0 && 
					direction == 2){
				
				KnightArray[row][column].knightOn = false;
				row -= 2;
				column += 1;
				KnightArray[row][column].knightOn = true;
				KnightArray[row][column].number = moveNumber;
				move = true;
				
			}
			else if (row - 2 >= 0 && column - 1 >= 0 &&
					KnightArray[row - 2][column - 1].number == 0 && 
					direction == 3){
				
				KnightArray[row][column].knightOn = false;
				row -= 2;
				column -= 1;
				KnightArray[row][column].knightOn = true;
				KnightArray[row][column].number = moveNumber;
				move = true;
				
			}
			else if (row + 1 < 8 && column + 2 < 8 &&
					KnightArray[row + 1][column + 2].number == 0 && 
					direction == 4){
				
				KnightArray[row][column].knightOn = false;
				row += 1;
				column += 2;
				KnightArray[row][column].knightOn = true;
				KnightArray[row][column].number = moveNumber;
				move = true;
				
			}
			else if (row + 1 < 8 && column - 2 >= 0 &&
					KnightArray[row + 1][column - 2].number == 0 && 
					direction == 5){
				
				KnightArray[row][column].knightOn = false;
				row += 1;
				column -= 2;
				KnightArray[row][column].knightOn = true;
				KnightArray[row][column].number = moveNumber;
				move = true;
				
			}
			else if (row - 1 >= 0 && column + 2 < 8 &&
					KnightArray[row - 1][column + 2].number == 0 && 
					direction == 6){
				
				KnightArray[row][column].knightOn = false;
				row -= 1;
				column += 2;
				KnightArray[row][column].knightOn = true;
				KnightArray[row][column].number = moveNumber;
				move = true;
				
			}
			else if (row - 1 >= 0 && column - 2 >= 0 &&
					KnightArray[row - 1][column - 2].number == 0 && 
					direction == 7){
				
				KnightArray[row][column].knightOn = false;
				row -= 1;
				column -= 2;
				KnightArray[row][column].knightOn = true;
				KnightArray[row][column].number = moveNumber;
				move = true;
				
			}
			
			if (avoidCrash == 1000){
				myTimer.stop();
			}
			
		}while(move == false && avoidCrash < 1000);
		
		repaint();
		
	}		
	
	public void paint(Graphics g){
		
		super.paint(g);
		
		for (int i = 0; i < 8; i++){
			
			for (int n = 0; n < 8; n++){
				
				if ((i + n) % 2 == 0){
					
					g.setColor(Color.red);
					g.fillRect(KnightArray[n][i].x, KnightArray[n][i].y, 
							KnightArray[n][i].width, KnightArray[n][i].height);
					
				}
				else if ((i + n) % 2 == 1){
					
					g.setColor(Color.black);
					g.fillRect(KnightArray[n][i].x, KnightArray[n][i].y, 
							KnightArray[n][i].width, KnightArray[n][i].height);
					
				}
				
				if (KnightArray[n][i].knightOn == true){
					
					knightImage.paintIcon(this, g, KnightArray[n][i].x, 
										KnightArray[n][i].y);
					
				}
				else if (KnightArray[n][i].number != 0){
					
					if (g.getColor() == Color.red){
						
						g.setColor(Color.black);
						
					}
					else if (g.getColor() == Color.black){
						
						g.setColor(Color.red);
						
					}
					g.setFont(new Font("TimesRoman", Font.PLAIN, 36));
					g.drawString(""+KnightArray[n][i].number, 
								KnightArray[n][i].x+2, KnightArray[n][i].y+30);
					
				}
				
			}
			
		}

		
	}
	public void Update(Graphics gr){
		
		paint(gr);
	}
	
}


