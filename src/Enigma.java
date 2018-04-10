/**
 * 
 * @author ezramuratoglu, Kevin Gao
 *
 */
public class Enigma  
{
	private char[] lookupTable;

	/**
	 * Constructor that initializes lookupTable to a character array with n elements and sets each element to '-'
	 * 
	 * @param n should be the number of letters in the alphabet
	 */
	public Enigma(int n)
	{
		lookupTable = new char[n];
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
				
				//Add appropriate character, preserving Uppercase
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
		int[] frequencies = countLetters(text);
		String result = "";

		int index = 0;
		int largest = Integer.MIN_VALUE;

		return result;
	}

	/**
	 * Private helper method that counts the number of occurrences for each of the letters a - z and saves these counts in an array
	 * @param text
	 * @return
	 */
	private static int[] countLetters(String text)
	{
		int[] counts = new int[26];

		for(int i = 0; i < text.length(); i++)
		{
			int j = (int)(text.charAt(i)) - 65;
			counts[j] = counts[j] ++;
		}

		return counts;
	}


}
