
public class Rules {

	private int diceTotal, rollNumber, userPoint;
	private String output;
	
	Rules(int theDiceTotal, int theRollNumber, int theUserPoint){
		
		diceTotal = theDiceTotal;
		rollNumber = theRollNumber;
		userPoint = theUserPoint;
		applyRules();
		
	}
	
	private void applyRules(){
		
		if (rollNumber == 1){
			
			userPoint = 0;
			
			if (diceTotal == 7 || diceTotal == 11){
				
				output = "You win!";
				rollNumber = 0;
				
			}
			else if (diceTotal == 2 || diceTotal == 3 || diceTotal == 12){
				
				output = "You lose!";
				rollNumber = 0;
				
			}
			else{
				
				output = "Roll again.";
				userPoint = diceTotal;
				
			}
		}
		else if (rollNumber > 1){
			
			if (diceTotal == userPoint){
				
				output = "You win!";
				rollNumber = 0;
				
			}
			else if (diceTotal == 7){
				
				output = "You lose!";
				rollNumber = 0;
				
			}
			else{
				
				output = "Roll again.";
			
			}	
		}
	}
	
	public int getRollNumber(){
		
		return rollNumber;
		
	}
	public int getUserPoint(){
		
		return userPoint;
		
	}
	public String getOutput(){
		
		return output;
		
	}
}
