import java.util.Scanner; // Needed to read input of keyboard.
import java.util.*; // Needed to preform tocharArray method.
/**
* This is the Project RightCard. User may choose from two options.
* To check if an entered credit/debit card number is actually valid. Or 
* to generate ten random valid credit/debit card numbers.
*/

public class RightCard
{
	public static void main(String [] args)
	{
		menu(); /* The main menu of this program is run externally as a static method 
		           so that it may be called upon when needed.*/
	}
	
	
	/** Main menu method. *********
                          * Ch. 6 *
                          ********/
						  
	public static void menu()
	{
		
		int mainOption, // Used to test switch statement.
		    total = 0; //
		String cardInput, // User entered card or to send string to CardValidator.
		       randomCard, // Accumulator for while loop.
			   rand = "0"; // Empty string to hold CardGenerator.
		boolean cardCheck; // variable to hold returned CardValidator boolean.
		
		
		// Create Scanner object for keyboard input.
		Scanner keyboard = new Scanner(System.in); 
		
		// Main view (Options view)
		System.out.println();
		System.out.println("************************************");
		System.out.println("*Choose from the following options.*");
		System.out.println("************************************");
		System.out.println();
		System.out.println("*********************************************");
		System.out.println("*Enter 1 to validate a 16 digit card number.*");
		System.out.println("*Enter 2 to generate 10 valid card numbers. *");
		System.out.println("*********************************************");
		System.out.println();
		mainOption = keyboard.nextInt();
		keyboard.nextLine(); // Consumption.
		
		// Decision structure for mainOption.
		/********
        * Ch. 4 *
        ********/
		
		switch (mainOption)
		{
			// Send a 16 digit string to static cardValidate method.
			case 1:
				System.out.println("Enter a 16 credit card number: ");
				cardInput = keyboard.nextLine();
				char[] cA = cardInput.toCharArray(); // Array to print card in desired format. 
						  /**
						  * !CITATION: https://www.geeksforgeeks.org/convert-a-string-to-character-array-in-java/
						  */
				
				cardCheck = CardValidator.cardValidate(cardInput);
				if(cardCheck)
				{
					System.out.println();
					System.out.println("**************************************************************");
					System.out.println("*" + cA[0] + cA[1] + cA[2] + cA[3] + "-" +
									cA[4] + cA[5] + cA[6] + cA[7] + "-" +
									cA[8] + cA[9] + cA[10] + cA[11] + "-" +
									cA[12] + cA[13] + cA[14] + cA[15] +
								" is a valid credit/debit card number.*");
					System.out.println("*************************************************************");
					nowWhat();
					
				}
				else
				{
					System.out.println();
					System.out.println("**************************************************************");
					System.out.println("*" + cA[0] + cA[1] + cA[2] + cA[3] + "-" +
									cA[4] + cA[5] + cA[6] + cA[7] + "-" +
									cA[8] + cA[9] + cA[10] + cA[11] + "-" +
									cA[12] + cA[13] + cA[14] + cA[15] +
								" is not a valid credit/debit card number.*");
					System.out.println("**************************************************************");
					nowWhat();
				}
				
				break;
				
			// Generate 10 valid card numbers.
			/********
            * Ch. 5 *
            ********/
			
			case 2:
				while(total < 10)
				{
					checkRandom(); 
					total++; // Add 1 to accumulator.
					         // Not done until a card is returned as valid and printed.
				}
				nowWhat();
				break;
			
			default: // Exception handling.
				System.out.println("That was not one of the given options. Please try again.");
				menu();
		}
	}
	
	/**
	* This static method asks the user if they want to quit or return to the main menu.
	*/
		public static void nowWhat()
		{
			int choice;
			
			// Create Scanner object for keyboard input.
			Scanner keyboard = new Scanner(System.in);
			
			System.out.println();
			System.out.println("***************************************************************");
			System.out.println("*Enter 1 to return to the main menu and 2 to exit the program.*");
			System.out.println("***************************************************************");
			System.out.println();
			choice = keyboard.nextInt();
			keyboard.nextLine();
			
			switch(choice)
			{
				case 1:
					menu(); // Returns to main menu.
					break;
				
				case 2:
					System.out.println();
					System.out.println("*****************");
					System.out.println("*Now exiting... *");
					System.out.println("*****************");
					System.out.println();
					System.exit(0); // Terminates program.
					break;
				
				default: // Exception handling. Terminates program.
					System.out.println("That is not a valid choice, exiting the program. ");
					System.exit(0);
			}
			
		}
		
		/**
		* Static method to get random card number and send to CardValidator.
		* If it is valid, print. Otherwise start over until it returns true.
		*/
		
		public static void checkRandom()
		{
			boolean cardCheck; // Holds returned value of CardValidator.
			String cardInput, // Holds generated card, sent to Validator for testing.
				   r = "0"; // Send to generator. Must be initialized to argue.
			cardInput = CardGenerator.generate(r);
			char[] cA = cardInput.toCharArray(); // Array to print card in desired format.
			cardCheck = CardValidator.cardValidate(cardInput);
			
			if(cardCheck)
			{
				System.out.println();
				System.out.println("" + cA[0] + cA[1] + cA[2] + cA[3] + "-" +
									cA[4] + cA[5] + cA[6] + cA[7] + "-" +
									cA[8] + cA[9] + cA[10] + cA[11] + "-" +
									cA[12] + cA[13] + cA[14] + cA[15] +
								" is a valid credit/debit card number");
				System.out.println();
				// CVVs that are not encrypted by the providing bank consist of the 4th,8th, and 12th number in the card.
				// Show all possible combos.
				
				System.out.println("Possible cvv numbers include:");
				System.out.println("" + cA[3] + cA[7] + cA[11]);
				System.out.println("" + cA[3] + cA [11] +cA[7]);
				System.out.println("" + cA[7] + cA[3] + cA[11]);
				System.out.println("" + cA[7] + cA[11] + cA[3]);
				System.out.println("" + cA[11] + cA[3] + cA[7]);
				System.out.println("" + cA[11] + cA[7] + cA[3]);
				System.out.println("!WARNING! These are non-encrypted options. Less than 8.33% chance of success.");
				System.out.println("***********************************"+ 
				"******************************************");
			}
			else
			{
				checkRandom();
			}
		}
}