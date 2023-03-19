/*
 * Class: CMSC203 
 * Instructor: Tanveer
 * Description: Encrypt and decrypt
 * Due: 3/18/2023
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
 * Print your Name here: Harlene Kaur
 */

public class CryptoManager {

	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param text a string to be checked, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) < LOWER_BOUND || text.charAt(i) > UPPER_BOUND) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character "offset" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		if (!isStringInBounds(plainText)) {
			throw new IllegalArgumentException("The input string contains characters outside the allowable bounds.");
		}
		String encryptedText = "";
		for (int i = 0; i < plainText.length(); i++) {
			char c = plainText.charAt(i);
			int shifted = (c - LOWER_BOUND + key) % RANGE + LOWER_BOUND;
			encryptedText += (char) shifted;
		}
		return encryptedText;
	}

	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption(String plainText, String bellasoStr) {
		if (!isStringInBounds(plainText) || !isStringInBounds(bellasoStr)) {
			throw new IllegalArgumentException("The input string contains characters outside the allowable bounds.");
		}
		String encryptedText = "";
		int bellasoStrLen = bellasoStr.length();
		for (int i = 0; i < plainText.length(); i++) {
			char c = plainText.charAt(i);
			char keyChar = bellasoStr.charAt(i % bellasoStrLen);
			int shifted = (c + keyChar) % RANGE + LOWER_BOUND;
			encryptedText += (char) shifted;
		}
		return encryptedText;
	}

	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character "offset" characters before it.
	 * This is the inverse* function of the caesarEncryption function.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the decrypted string
	 */
	public static String caesarDecryption(String encryptedText, int key) {
		if (!isStringInBounds(encryptedText)) {
			throw new IllegalArgumentException("The input string contains characters outside the allowable bounds.");
		}
		String decryptedText = "";
		for (int i = 0; i < encryptedText.length(); i++) {
			char c = encryptedText.charAt(i);
			int shifted = (c - LOWER_BOUND - key + RANGE) % RANGE + LOWER_BOUND;
			decryptedText += (char) shifted;
		}
		return decryptedText;
	}
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced 
	 * by the character corresponding to the ASCII value of the corresponding character in bellasoStr, 
	 * which is repeated to correspond to the length of plainText.
	 * This is the inverse function of the bellasoEncryption function.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		if (!isStringInBounds(encryptedText) || !isStringInBounds(bellasoStr)) {
			throw new IllegalArgumentException("The input string contains characters outside the allowable bounds.");
		}
		String decryptedText = "";
		int bellasoStrLen = bellasoStr.length();
		for (int i = 0; i < encryptedText.length(); i++) {
			char c = encryptedText.charAt(i);
			char keyChar = bellasoStr.charAt(i % bellasoStrLen);
			int shifted = (c - keyChar + RANGE) % RANGE + LOWER_BOUND;
			decryptedText += (char) shifted;
		}
		return decryptedText;
	}
}
