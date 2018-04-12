/**
 * 
 * @author ezramuratoglu, Kevin Gao
 *
 */
public class Enigma  
{
	//Char array which holds the user's guesses for what each code character corresponds to
	private char[] lookupTable;

	/**
	 * Constructor that initializes lookupTable to a character array with n elements and sets each element to '-'
	 * 
	 * @param n should be the number of letters in the alphabet
	 */
	public Enigma(int n)
	{
		//Initialize instance variable
		lookupTable = new char[n];
		
		//Set each element in the loopupTable to '-'
		for(int i = 0; i < n; i++)
			lookupTable[i] = '-';
	}

	/**
	 * Sets the i-th element of the look-up table to ch
	 * @param i
	 * @param ch
	 */
	public void setSubstitution(int i, char ch)
	{
		lookupTable[i] = ch;
	}

	/**
	 * decodes all the letters in text according to the current lookup table. Leaves all characters
	 * that are not letters unchanged and preserves the upper/lower case of letters. Returns the 
	 * decoded String which should be the same length as text.
	 * @param text
	 * @return
	 */
	public String decode(String text)
	{
		String result = "";

		//Boolean to preserve case of each char
		boolean isUpperCase;

		//Variable to prevent redundant method calls
		int numericValueOfA = Character.getNumericValue('A');

		//Loop through text
		for(int i = 0; i < text.length(); i++)
		{
			char character = text.charAt(i);

			isUpperCase = Character.isUpperCase(character);

			//Get corresponding index of lookupTable
			int index = Character.getNumericValue(Character.toUpperCase(character)) - numericValueOfA;

			//IndexOutOfBounds 
			if (index < 0 || index >= lookupTable.length)
				result += character;

			else
			{
				char toAppend = lookupTable[index];

				//Add appropriate character, preserving the correct case
				if(toAppend == '-')
					result += character;
				else if(isUpperCase)
					result += Character.toUpperCase(toAppend);
				else 
					result += Character.toLowerCase(toAppend);
			}
		}
		return result;
	}

	/**
	 * Returns computer-generated hints for each letter in the encrypted text.
	 * @param text
	 * @param lettersByFrequency
	 */
	public String getHints(String text, String lettersByFrequency)
	{		
		//String of hints for each letter to return
		String hints = "--------------------------";
		
		//Get counts for each letter
		int[] counts = countLetters(text);

		//Integer to keep track of the number of elements that satisfy the inner if
		int rand = 0;

		//For each element counts[i] in the letter counts array
		for (int i = 0; i < counts.length; i ++)
		{
			//Find the number of elements counts[r] such that counts[r] < counts[i] or counts[r] == counts[i] and r < i
			for (int r = 0; r < counts.length; r ++)
			{	
				if (counts[r] < counts[i] || counts[r] == counts[i] && r < i)
					rand ++;
			}

			//Hints[i] should be set to lettersByFrequency.charAt(rand)
			hints = hints.substring(0, rand) + lettersByFrequency.charAt(rand) + hints.substring(rand + 1);
		
			//Reset the count
			rand = 0;
		}

		return hints;
	}

	/**
	 * Private helper method that counts the number of occurrences for each of the letters a - z and saves these counts in an array
	 * @param text
	 * @return an array with counts of the occurrences for each of the letters a-z
	 */
	private static int[] countLetters(String text)
	{
		//Integer array to return
		int[] counts = new int[26];

		//Variable to prevent redundant method calls
		int numericValueOfA = Character.getNumericValue('A');

		//Loop through the array
		for(int i = 0; i < text.length(); i++)
		{
			//Add each character to the corresponding index in the array
			int index = Character.getNumericValue(Character.toUpperCase(text.charAt(i))) - numericValueOfA;
			if (index >= 0 && index < counts.length)
				counts[index] += 1;
		}

		return counts;
	}


}