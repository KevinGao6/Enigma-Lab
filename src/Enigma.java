/**
 * 
 * @author ezramuratoglu, Kevin Gao
 *
 */
public class Enigma extends Cryptogram 
{
	private char[] lookupTable;
	
	public Enigma(int n)
	{
		
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
		
		
	}
	
	/**
	 * Private helper method that counts the number of occurrences for each of the letters a - z and saves these counts in an array
	 * @param text
	 * @return
	 */
	private int[] countLetters(String text)
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
