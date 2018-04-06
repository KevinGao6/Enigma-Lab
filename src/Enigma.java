/**
 * 
 * @author ezramuratoglu, Kevin Gao
 *
 */
public class Enigma extends Cryptogram 
{
	private char[] lookupTable;
	
	/**
	 * constructor
	 * @param n should be the number of letters in the alphabet
	 */
	public Enigma(int n)
	{
		lookupTable = new char[n];
	}
	
	/**
	 * sets the i-th element of the look-up table to ch
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
		boolean isUpperCase;
		String result = "";
		for(int i = 0; i < text.length(); i++)
		{
			char character = text.charAt(i);
			isUpperCase = Character.isUpperCase(character);
			int index = -1;
			
			//find index in lookupTable
			for(int x = 0; x < lookupTable.length; x++)
				if(lookupTable[x] == character)
					index = x;

			if(index != -1)
				if(isUpperCase)
					result += Character.toUpperCase(lookupTable[index]);
				else 
					result += Character.toLowerCase(lookupTable[index]);
			else
				result += character;
			
		}
		return result;
	}
	
	/**
	 * returns computer-generated hints for each letter in the encrypted text.
	 * @param text
	 * @param lettersByFrequency
	 */
	public getHints(String text, String lettersByFrequency)
	{
		
	}
	
	private int[] countLetters(String text)
	{
		
	}
	
	
}
