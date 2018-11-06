
public class Calculations {

	//class variables
	private int score, size, whichScore;
	private char grade;
	
	private static int average, highest, lowest;
	
	//create our class constructor
	//first method to run in this class
	//the name of constructor is the same as the class name
	Calculations(int theScore, int theSize, int theWhichScore){
		
		score = theScore;
		size = theSize;
		whichScore = theWhichScore;
		
	}
	
	private void CalculateGrade(){
		
		if (whichScore == 0)
		{
			average = 0;
			highest = 0;
			lowest = 100;
		}
		average += score;
		
		if (score > highest)
		{	
			highest = score;
		}
		if (score < lowest)
		{
			lowest = score;
		}
		
		if (score >= 90){
			
			grade = 'A';
		}
		else if (score >= 80){
			
			grade = 'B';
		}
		else if (score >= 70){
			
			grade = 'C';
		}
		else if (score >= 60){
	
			grade = 'D';
		}
		else{
			
			grade = 'F';
		}
		
	}
	
	private void CalculateAverage(){
		
		average = average/size;
		
	}
	
	//allow the user to get the answers back
	public char getGrade(){
		
		CalculateGrade();
		return grade;
		
	}
	public int getAverage(){
		
		CalculateAverage();
		return average;
		
	}
	public int getHighest(){
		
		return highest;
	}
	public int getLowest(){
		
		return lowest;
	}
	
}
