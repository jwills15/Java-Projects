
public class playCraps {

	private int totalPlays, wins, losses;
	
	playCraps(int theTotalPlays){
		
		totalPlays = theTotalPlays;
		playGame();
		
	}
	
	private void playGame(){
		
		for (int i = 0; i < totalPlays; i++){
			
			boolean gameOver = false;
			int rollNumber = 1;
			int userPoint = 0;
			
			while (gameOver == false){
				
				int diceOne = (int)(Math.random() * 6 + 1);
				int diceTwo = (int)(Math.random() * 6 + 1);
				int diceTotal = diceOne + diceTwo;
				
				if (rollNumber == 1){
					
					if (diceTotal == 7 || diceTotal == 11){
						
						wins += 1;
						gameOver = true;
						
					}
					else if (diceTotal == 2 || diceTotal == 3 || diceTotal == 12){
						
						losses += 1;
						gameOver = true;
						
					}
					else{
						
						userPoint = diceTotal;
						rollNumber += 1;
						
					}
				}
				else if (rollNumber > 1){
					
					if (diceTotal == userPoint){
						
						wins += 1;
						gameOver = true;
						
					}
					else if (diceTotal == 7){
						
						losses += 1;
						gameOver = true;
						
					}
					else{
						
						rollNumber += 1;
						
					}
				}
			}
		}
	}
	
	public double getWinPercentage(){
		
		return (double)wins / (double)totalPlays * 100;
		
	}
	public double getLosePercentage(){
		
		return (double)losses / (double)totalPlays * 100;
		
	}

}
