/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {

		str1 = preProcess(str1);
		str2 = preProcess(str2);

		if (str1.length() != str2.length()) return false;
		
		char[] arr2 = new char[str2.length()];

		for (int i = 0; i < str2.length(); i++)
			arr2[i] = str2.charAt(i); // copying the second string to an array


		for (int i = 0; i < str1.length(); i++){

			int counter = 1;

			for (int j = 0; j < arr2.length; j++){

				if (arr2[j] == str1.charAt(i)) {

					arr2[j] = 0; // doing this to cancel out already used charcters

					break;
				}
				
				else { //this statement will return false, if every character has went though the loop without having found a match
					counter++;

					if (counter > str1.length()) return false; 
				}
			}
		}			
	return true;

	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		
		String strNew = "";

		for (int i = 0; i < str.length(); i++){

			int ascii = str.charAt(i);

			if (96 < ascii && ascii < 123) {
				strNew = strNew + str.charAt(i);
			}
			else if (64 < ascii && ascii < 91) {
				strNew = strNew + (char) (str.charAt(i) + 32);
			}

		}
		return strNew;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {

		char[] arr = new char[str.length()];

		int length = str.length(); // this length will be changed for the Math.random to work

		int lenght2 = str.length(); // this one remains the same throuthout the Code

		String Anagram = "";

		int slot;
		
		for (int i = 0; i < lenght2; i++)
			arr[i] = str.charAt(i); // copying the string to an array

		for (int i = 0; i < lenght2; i++){

			int chooser = (int) (Math.random() * length);

			length--;

			Anagram += str.charAt(chooser);

				for (slot = 0; slot < arr.length; slot++) {
  					if (arr[slot] == str.charAt(chooser)) {
     					arr[slot] = 0;
     					break;
  					}
				}

			str = ""; // resetting the string after every repitition so we can rebuild it without the chosen letter

			for (int j = 0; j < lenght2; j++ ){

				if (arr[j] != 0) str += arr[j];
		}
	}
	return Anagram;

	} 
}