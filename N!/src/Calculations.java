
public class Calculations {

	private int userNumber, oddInt, sumInt, factorialInt;
	private String sumStr, oddStr, factorialStr;
	
	Calculations(int theUserNumber){
		
		userNumber = theUserNumber;
		
	}
	
	private void runFactorial(){
		
		sumInt = 0;
		oddInt = 0;
		factorialInt = 1;
		
		sumStr = "Sum\n\n";
		oddStr = "Odd\n\n";
		factorialStr = "Factorial\n\n";
		
		for(int i = 1; i <= userNumber; i++){
			
			sumInt += i;
			sumStr += i + "\n";
			
			if (i % 2 != 0){
				oddInt += i;
				oddStr += i + "\n";
			}
			
			factorialInt *= i;
			factorialStr += factorialInt + "\n";
			
		}
		
	}
	
	public String getSum(){
		
		runFactorial();
		return sumStr + "\nSum: " + sumInt;
		
	}
	public String getOdd(){
		
		return oddStr + "\nOdd: " + oddInt;
		
	}
	public String getFactorial(){
		
		return factorialStr + "\nFactorial: " + factorialInt;
		
	}
	
}
