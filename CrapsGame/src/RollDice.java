
public class RollDice {

	private int diceOne, diceTwo, diceTotal, rollNumber;
	
	RollDice(int theRollNumber){
		
		rollNumber = theRollNumber;
		userRolls();
		
	}
	
	private void userRolls(){
		
		rollNumber++;
		diceOne = (int)(Math.random() * 6 + 1);
		diceTwo = (int)(Math.random() * 6 + 1);
		diceTotal = diceOne + diceTwo;
		
	}
	
	public int getDiceOne(){
		
		return diceOne;
		
	}
	public int getDiceTwo(){
		
		return diceTwo;
		
	}
	public int getDiceTotal(){
		
		return diceTotal;
		
	}
	public int getRollNumber(){
		
		return rollNumber;
		
	}
	
}
