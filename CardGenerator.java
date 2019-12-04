import java.util.concurrent.ThreadLocalRandom; // Used to set parameters of random long.

/**
* This class creates a random long variable, 
* changes it to a string, then returns the string.
*/
public class CardGenerator
{
	/********
    * Ch. 6 *
    ********/
	public static String generate(String randomCard)
	{
		/********
        * Ch. 2 *
        ********/
		long min = 1000000000000000L; // Sets the minimum parameter.
		long max = 9999999999999999L; // Sets the Maximum parameter.
		
		long d = ThreadLocalRandom.current() .nextLong(min, max);
		
		String c2 = Long.toString(d); // method for changing long to string
		return c2; 	/********
					* Ch. 3 *
					********/
	}	
}