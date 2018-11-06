
public class Calculations {
	
	//class variables
	private int diceOne, diceTwo, diceTotal;
	String percentageTwo, percentageThree, percentageFour, percentageFive, 
				percentageSix, percentageSeven, percentageEight, percentageNine, 
				percentageTen, percentageEleven, percentageTwelve;
	//static variables that keep track of things over time
	private static int totalTwo, totalThree, totalFour, totalFive, totalSix,
				totalSeven, totalEight, totalNine, totalTen, totalEleven,
				totalTwelve, totalRolls;
	
	Calculations(){
		
	}
	
	private void CalculateRoll(){
		
		totalRolls++;
		diceOne = (int)(Math.random() * 6 + 1);
		diceTwo = (int)(Math.random() * 6 + 1);
		diceTotal = diceOne + diceTwo;
		
		if (diceTotal == 2){totalTwo++;}
		else if (diceTotal == 3){totalThree++;}
		else if (diceTotal == 4){totalFour++;}
		else if (diceTotal == 5){totalFive++;}
		else if (diceTotal == 6){totalSix++;}
		else if (diceTotal == 7){totalSeven++;}
		else if (diceTotal == 8){totalEight++;}
		else if (diceTotal == 9){totalNine++;}
		else if (diceTotal == 10){totalTen++;}
		else if (diceTotal == 11){totalEleven++;}
		else if (diceTotal == 12){totalTwelve++;}
		
		LocalFormat formatClass = new LocalFormat();
		double twoDouble = (double)totalTwo / totalRolls * 100;
		percentageTwo = "Roll 2: " + 
				formatClass.FormatDecimal(twoDouble, 1) + "%\n";
		double threeDouble = (double)totalThree / totalRolls * 100;
		percentageThree = "Roll 3: " + 
				formatClass.FormatDecimal(threeDouble, 1) + "%\n";
		double fourDouble = (double)totalFour / totalRolls * 100;
		percentageFour = "Roll 4: " + 
				formatClass.FormatDecimal(fourDouble, 1) + "%\n";
		double fiveDouble = (double)totalFive / totalRolls * 100;
		percentageFive = "Roll 5: " + 
				formatClass.FormatDecimal(fiveDouble, 1) + "%\n";
		double sixDouble = (double)totalSix / totalRolls * 100;
		percentageSix = "Roll 6: " + 
				formatClass.FormatDecimal(sixDouble, 1) + "%\n";
		double sevenDouble = (double)totalSeven / totalRolls * 100;
		percentageSeven = "Roll 7: " + 
				formatClass.FormatDecimal(sevenDouble, 1) + "%\n";
		double eightDouble = (double)totalEight / totalRolls * 100;
		percentageEight = "Roll 8: " + 
				formatClass.FormatDecimal(eightDouble, 1) + "%\n";
		double nineDouble = (double)totalNine / totalRolls * 100;
		percentageNine = "Roll 9: " + 
				formatClass.FormatDecimal(nineDouble, 1) + "%\n";
		double tenDouble = (double)totalTen / totalRolls * 100;
		percentageTen = "Roll 10: " + 
				formatClass.FormatDecimal(tenDouble, 1) + "%\n";
		double elevenDouble = (double)totalEleven / totalRolls * 100;
		percentageEleven = "Roll 11: " + 
				formatClass.FormatDecimal(elevenDouble, 1) + "%\n";
		double twelveDouble = (double)totalTwelve / totalRolls * 100;
		percentageTwelve = "Roll 12: " + 
				formatClass.FormatDecimal(twoDouble, 1) + "%";
		
	}
	
	public String getOutputString(){
		
		CalculateRoll();
		String outputString = "Dice 1: " + diceOne + "\nDice 2: " + diceTwo +
				"\nDice Total: " + diceTotal + "\n\nTotal Rolls: " + totalRolls
				+ "\n" + percentageTwo + percentageThree + percentageFour +
				percentageFive + percentageSix + percentageSeven + 
				percentageEight + percentageNine + percentageTen +
				percentageEleven + percentageTwelve;
		return outputString;
	
	}
	public int getDiceTwo(){return diceTwo;}
	public int getDiceTotal(){return diceTwo;}

}
