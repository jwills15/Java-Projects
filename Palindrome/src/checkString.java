
public class checkString {
	
	private String userString, reversedString, palindrome;
	
	checkString(String theString)
	{
		userString = theString;
		userString = userString.replaceAll("\\W", "");
		userString = userString.toLowerCase();
		reversedString = new StringBuilder(userString).reverse().toString();
	}
	
	private void checkPalindrome()
	{
		if (reversedString.equals(userString))
		{
			palindrome = "The string is a palindrome.";
		}
		else
		{
			palindrome = "The string is not a palindrome.";
		}
	}
	
	public String getEdited()
	{
		return userString;
	}
	public String getReverse()
	{
		return reversedString;
	}
	public String getPalindrome()
	{
		checkPalindrome();
		return palindrome;
	}
}
