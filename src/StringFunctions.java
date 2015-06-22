import java.util.ArrayList;
import java.util.HashMap;

public class StringFunctions {

	public static void main(String[] args) {
		String name1 = "reee";
		String name2 = "eere";
		
		boolean isAnagram = checkAnagram(name1, name2);
		if(isAnagram)
		{
			System.out.println(name1 + " and " + name2 + " are anagrams.");
			
		}
		else
		{
			System.out.println(name1 + " and " + name2 + " are not anagrams.");	
		}
		
		ArrayList stringPermutations = permutate(name1);
		System.out.print("Permutations for string: ");
		System.out.print(name1);
		System.out.print("\n");
		for (int i = 0; i < stringPermutations.size(); i++) {
			System.out.print(stringPermutations.get(i));
			System.out.print("\n");
		}

	}
	
	//This function checks to see if the two strings are anagrams of each other or not	
	public static boolean checkAnagram(String str1, String str2)
	{
		//strings cannot be anagrams if their lengths differ, so return false
		if(str1.length() != str2.length())
		{
			return false;
		}
		
		boolean isAnagram = true; // variable to hold true bool value if anagrams, else false
		
		//hashmap for each strins to record frequencies
		HashMap<Character, Integer> letterMap1 = new HashMap<>();
		HashMap<Character, Integer> letterMap2 = new HashMap<>();
		
		//record the frequency of each character in str1
		for (int i = 0; i < str1.length(); i++)
		{
			char c = str1.charAt(i);
				if(letterMap1.containsKey(c))
				{
				int frequency = letterMap1.get(c);
				letterMap1.put(c, frequency + 1);
				}
				else
				{
					letterMap1.put(c, 1);
				}
		}
		
		//record the frequency of each character in str2
		for (int i = 0; i < str2.length(); i++)
		{
			char c = str2.charAt(i);
			if(letterMap2.containsKey(c))
			{
				int frequency = letterMap2.get(c);
				letterMap2.put(c, frequency + 1);
			}
			else
			{
				letterMap2.put(c, 1);
			}
		}
		
		//check if the frequencies of letters in hash map of each string are same
		for (char c: letterMap1.keySet())
		{
			int freq = letterMap1.get(c);
			if(freq != letterMap2.get(c))
			{
				isAnagram = false;
				break;
			}
		}		
		
		return isAnagram;//returns true if anagrams, else false
	}
	
	/*This function returns permutations of a string */
	
	public static ArrayList permutate(String str) {
		//String[] permStr = new String[10];
		int stringLength = str.length();
		String permStr;
		
		ArrayList permutationsList = new ArrayList();
		
		// str is 1 character long
		if (str.length() == 1) {
			//permStr[0] = str;
			permutationsList.add(str);
		} 
		
		//str in 2 character long. Example str = "tn"
		else if (str.length() == 2) {
			//permStr[0] = str;
			int len = stringLength;
			char[] charArray = str.toCharArray();
			char[] temp = new char[2];
			for (int i = 0; i < len; i++) {
				temp[i] = charArray[len - 1 - i];
			}
			permutationsList.add(str);
			permutationsList.add(String.valueOf(temp));
		} 
		
		//str is more than 2 characters long. Example str = "abc" or "tnk"
		else {
			// for each letter in the string, get the rest of the chars permutation and join with it
			int len = stringLength;

			for (int n = 0; n < len; n++) {
				String firstChar = String.valueOf(str.charAt(n));
				String restChars = str.substring(0, n) + str.substring(n + 1);
				ArrayList permutatedString = permutate(restChars);
				for (int i = 0; i < factorial((len - 1)); i++) {
					//permStr[i] = firstChar + permutatedString[i];
					permStr = firstChar + permutatedString.get(i);;
					//pStr[n][i] = firstChar + permutatedString[i];
					permutationsList.add(permStr);
				}

			}
		}
		
		if (stringLength > 2) {
			for (int n = 0; n < stringLength; n++) {
				//System.out.println(Arrays.toString(pStr[n]));
			}
		}
		
		for (int i = 0; i < permutationsList.size(); i ++)
		{
			//System.out.print(permutationsList.get(i));
			//System.out.print("\n");
		}

		return permutationsList;
	}
	
	/* This function returns factorial of an interger */
	public static int factorial(int num)
	{
		int factorial = num;
		
		for (int i = num-1; i > 0; i--)
		{
			factorial = factorial * i;
		}
		
		return factorial;
	}
}

