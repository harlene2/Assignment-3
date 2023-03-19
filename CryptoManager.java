/*
 * Class: CMSC203 
 * Instructor: Tanveen
 * Description: Encrypt and decrypt
 * Due: 3/18/2023
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Harlene Kaur
*/

public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String text) {
		throw new RuntimeException("method not implemented");
		boolean bound;
		bound = false;
		for (int i= 0; i < text.length(); i++)
		{
			if (text.charAt(i) >= LOWER_BOUND && text.charAt(i) <= UPPER_BOUND)
			{
				bound = true;
			}
		}
		return bound;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		throw new RuntimeException("method not implemented");
		String encryptedTxt = " ";
		if (isStringInBounds(plainText))
		{
			for (int i=0; i < plainText.length(); i++)
			{
				char userChar = plainText.charAt(i);
				int encryptedChar = ((int)userChar + key);
				while (encryptedChar > UPPER_BOUND)
				{
					encryptedChar -= RANGE;
				}
				encryptedTxt += (char)encryptedChar;
			}
		}
		return encryptedTxt;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		throw new RuntimeException("method not implemented");
		int bellasoStrLen = bellasoStr.length();
		String encryptedTxt = " ";
		for(int i = 0; i < plainText.length(); i++)
		{
			char userChar = plainText.charAt(i);
			int encryptedCharint = ((int)userChar+(int)bellasoStr.charAt(i%bellasoStrLen));
			while (encryptedCharint > (int)UPPER_BOUND)
			{
				encryptedCharint -= RANGE;
			}
			encryptedTxt += (char)encryptedCharint;
		}
		return encryptedTxt;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		throw new RuntimeException("method not implemented");
		String decryptedTxt = " ";
		for(int i = 0; i < encryptedText.length(); i++)
		{
			char userChar = encrypterText.charAt(i);
			int decryptedChar = ((int)userChar-key);
			while (decryptedChar < LOWER_BOUND)
			{
				decryptedChar += RANGE;
			}
			decryptedTxt += (char)decryptedChar;
		}
		return decryptedTxt;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		throw new RuntimeException("method not implemented");
		String decryptedTxt = " ";
		int bellasoStrLen = bellasoStr.length();
		for (int i = 0; i < encryptedText.length(); i++)
		{
			char userChar = encryptedText.charAt(i);
			int decryptedChar = ((int)userChar -(int)bellasoStr.charAt(i%bellasoStrLen));
			while (decryptedChar < (int)LOWER_BOUND)
			{
				decryptedChar += RANGE;
			}
			decryptedTxt += (char)decryptedChar;
		}
		return decryptedTxt;
	}
}