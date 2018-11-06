
public class Calculations {

	//class variables
	private int userScore1, userScore2, outof1, outof2;
	private double percentage1, percentage2, average;
	private String whichScore;
	private char grade1, grade2;
	
	//create our class constructor
	//first method to run in this class
	//the name of constructor is the same as the class name
	Calculations(int theScore1, int theScore2, int theOutof1, int theOutof2){
		
		userScore1 = theScore1;
		outof1 = theOutof1;
		userScore2 = theScore2;
		outof2 = theOutof2;
		
	}
	
	private void CalculateScore(){
		
		percentage1 = (double)userScore1 / outof1 * 100;
		percentage2 = (double)userScore2 / outof2 * 100;
		average = (percentage1 + percentage2) / 2;
		if (percentage1 > percentage2){
			
			whichScore = "You scored better on Test 1.";
			
		}
		else if (percentage1 < percentage2){
			
			whichScore = "You scored better on Test 2.";
			
		}
		else{
			
			whichScore = "You scored the same on both tests.";
			
		}
		
		if (percentage1 >= 89.5){
			
			grade1 = 'A';
		}
		else if (percentage1 >= 79.5){
			
			grade1 = 'B';
		}
		else if (percentage1 >= 69.5){
			
			grade1 = 'C';
		}
		else if (percentage1 >= 59.5){
	
			grade1 = 'D';
		}
		else{
			
			grade1 = 'F';
		}
		
		if (percentage2 >= 89.5){
			
			grade2 = 'A';
		}
		else if (percentage2 >= 79.5){
			
			grade2 = 'B';
		}
		else if (percentage2 >= 69.5){
			
			grade2 = 'C';
		}
		else if (percentage2 >= 59.5){
	
			grade2 = 'D';
		}
		else{
			
			grade2 = 'F';
		}
		
	}
	
	//allow the user to get the answers back
	public double getScore1(){
		
		CalculateScore();
		return percentage1;
		
	}
	public double getScore2(){
		
		return percentage2;
		
	}
	public double getAverage(){
		
		return average;
		
	}
	public String getWhichScore(){
		
		return whichScore;
		
	}
	public char getGrade1(){
		
		return grade1;
		
	}
	public char getGrade2(){
		
		return grade2;
		
	}
	
}
