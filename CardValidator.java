/**
* This class excepts a string variable and tests to see if it meets the 
* requirements of Luhn's Algorithm, also known as the CheckSum. 
*
* !CITATION Luhn Algorithm: https://www.journaldev.com/1443/java-credit-card-validation-luhn-algorithm-java
* !CITATION: Arrays: https://www.youtube.com/watch?v=o2ARur9hs9M 
*/

public class CardValidator 
{
	public static boolean cardValidate(String cardInput)
	{
		/***************
        * Ch. 7 Arrays *
        ***************/
		// Create an int array the size of the given string
		int[] cardInt = new int[cardInput.length()];
		
		// Load the array with integers that are parsed from the string.
		/**************
        * Ch. 2 Ch. 4 *
        **************/
		for (int x = 0; x < cardInput.length(); x++) 
			
		{
			cardInt[x] = Integer.parseInt(cardInput.substring(x, x + 1));
		}
		// Starting from the right, double each other digit, if greater than 9 mod 10
		// to remainder
		for (int x = cardInt.length - 2; x >= 0; x = x - 2)
		{
			int tempValue = cardInt[x];
			tempValue = tempValue * 2;
			if (tempValue > 9)
			{
				tempValue = tempValue % 10 + 1;
			}
			cardInt[x] = tempValue;
		}
		// add up the digits
		int total = 0;
		for (int x = 0; x < cardInt.length; x++)
		{
			total += cardInt[x];
		}
		// If # is a multiple of 10, it's valid
		if (total % 10 == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	
	}
}